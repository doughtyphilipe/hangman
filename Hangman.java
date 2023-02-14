import java.util.Scanner;

public class Hangman{
    static Scanner scan = new Scanner(System.in);

    public static String[] words = {"ant", "baboon", "badger", "bat", "bear", "beaver", "camel",
    "cat", "clam", "cobra", "cougar", "coyote", "crow", "deer",
    "dog", "donkey", "duck", "eagle", "ferret", "fox", "frog", "goat",
    "goose", "hawk", "lion", "lizard", "llama", "mole", "monkey", "moose",
    "mouse", "mule", "newt", "otter", "owl", "panda", "parrot", "pigeon", 
    "python", "rabbit", "ram", "rat", "raven","rhino", "salmon", "seal",
    "shark", "sheep", "skunk", "sloth", "snake", "spider", "stork", "swan",
    "tiger", "toad", "trout", "turkey", "turtle", "weasel", "whale", "wolf",
    "wombat", "zebra"};

    public static String[] gallows = {"+---+\n" +
    "|   |\n" +
    "    |\n" +
    "    |\n" +
    "    |\n" +
    "    |\n" +
    "=========\n",

    "+---+\n" +
    "|   |\n" +
    "O   |\n" +
    "    |\n" +
    "    |\n" +
    "    |\n" +
    "=========\n",

    "+---+\n" +
    "|   |\n" +
    "O   |\n" +
    "|   |\n" +
    "    |\n" +
    "    |\n" +
    "=========\n",

    " +---+\n" +
    " |   |\n" +
    " O   |\n" +
    "/|   |\n" +
    "     |\n" +
    "     |\n" +
    " =========\n",

    " +---+\n" +
    " |   |\n" +
    " O   |\n" +
    "/|\\  |\n" + //if you were wondering, the only way to print '\' is with a trailing escape character, which also happens to be '\'
    "     |\n" +
    "     |\n" +
    " =========\n",

    " +---+\n" +
    " |   |\n" +
    " O   |\n" +
    "/|\\  |\n" +
    "/    |\n" +
    "     |\n" +
    " =========\n",

    " +---+\n" +
    " |   |\n" +
    " O   |\n" +
    "/|\\  |\n" + 
    "/ \\  |\n" +
    "     |\n" +
    " =========\n"};

    public static void main(String[] args) {
        String word = randomWord(words);
        //prints out generated word, for testing purposes        
        //System.out.println(word);  

        
        //main loop!
        //int guessNumber = 0;        
        int mistakeNumber = 0;
        String guess = " ";
        String misses = "";

        String[] placeholder = createPlaceholder(word);        
        
        while (mistakeNumber < 6){

            //show the gallows!
            printGallows(mistakeNumber);

            //print words and placeholders
            System.out.println("Word: ");
            printPlaceholder(placeholder);
            System.out.print("\n");

            System.out.println("Misses: ");
            System.out.print(misses);
            System.out.print("\n");
            System.out.print("\n");

            System.out.println("Guess: ");
            guess = scan.nextLine();
            System.out.print("\n");            
            

            if (checkGuess(word,guess) == false){
                // if the user makes a mistake
                mistakeNumber++;           
                misses += guess;
            } else {  // if the user guesses correctly
                placeholder = updatePlaceholder(placeholder, word, guess);                
            }

            
            if (mistakeNumber == 6) { // if the user guesses 6 times the game is ended and the following message is generated
                System.out.println("RIP!");
                System.out.println("The word was: "+ word);
            } 

            //check if user won and print out GOOD WORK and the generated word in case
            if (checkWin(placeholder, word) == true) {
                System.out.println("GOOD WORK!");
                System.out.print("\n");
                System.out.println("Word: ");
                printPlaceholder(placeholder);
                System.out.print("\n");
                break;
            }

            //check if word has duplicates and then store them and then call them
        }
        
        scan.close();
    }

    public static String randomWord(String[] words){
        //generates a random word
        double totalWords = words.length;

        double number = Math.random()*totalWords;
        int randomNumber = (int)number;

        String randomWord = words[randomNumber];
        
        return randomWord;
    }

    public static void printGallows(int mistakeNumber){
    //prints out the gallows depending on the number of mistakes
    System.out.println(gallows[mistakeNumber]);
    }

    public static String[] createPlaceholder (String word){
    //create a String array depending on the length of the generated word
        String [] placeholder = new String [word.length()];
        
        for (int i = 0; i < word.length(); i++){
            placeholder[i] = "_";
        }
        
        return placeholder;        
    }

    public static void printPlaceholder (String[] placeholder){             
    //print out generated placeholders
        for (int i =0; i < placeholder.length; i++) {
            System.out.print(placeholder[i]);
            if (i!= (placeholder.length)-1) {
                System.out.print(" ");
            }            
        }
        System.out.println("\n");
    }


    public static String[] updatePlaceholder(String[] placeholder, String word, String guess){
        //approach using Strings
        // int guessIndex = word.indexOf(guess);
        // if (checkGuess(word,guess) == true){
        //     placeholder[guessIndex] = guess; 
        //     return placeholder;   
        // } else {
        //     return placeholder;
        // }

        //approach using Char
        char guessChar = guess.charAt(0);
        for (int j = 0 ; j < word.length(); j++) {
            if (word.charAt(j) == guessChar) {
                placeholder[j] = guess;
            }
        }     
        return placeholder;
    }

    public static boolean checkGuess(String word, String guess){
    //check if user guessed correctly
        int index = word.indexOf(guess);

        if (index == - 1){
            return false;
        } else {
            return true;
        }

    }

    public static boolean checkWin (String[] placeholder, String word) {
    //checks if user won the match
        boolean test = false;

        String endString = "";
        for (int i =0; i < placeholder.length; i++) {
            endString += placeholder[i];

            if (endString.equals(word)){
                test = true;
            }
        }
        return test;        
    }

}






