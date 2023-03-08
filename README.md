# Hangman Game

Hangman is a simple Java game made for practice purposes.

# Preview

First display the user sees



![first](https://github.com/doughtyphilipe/hangman/blob/main/Hangman1.PNG)

Last display the user sees, in case of missing the letters "t", "o" and "a".



![second](https://github.com/doughtyphilipe/hangman/blob/main/Hangman2.PNG)

## Usage
This code is used to define our Placeholders in Hangman, we define it at first and then add the correct words, if the users guesses them correctly.

```java            
public static String[] createPlaceholder (String word){
String [] placeholder = new String [word.length()];
       
 for (int i = 0; i < word.length(); i++){
    placeholder[i] = "_";
 }
        
return placeholder;        
}

```
