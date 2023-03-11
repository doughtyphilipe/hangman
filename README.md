# Hangman Game

Hangman is a simple Java game made for practice purposes.

# Preview

![hangman](https://user-images.githubusercontent.com/123315352/224512283-ee6c32c4-bb92-4c2d-bd1c-9794b01a5e0e.gif)


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
