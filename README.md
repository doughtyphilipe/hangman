# Hangman Game

Hangman is a simple Java game made for practice purposes.

# Preview

![gif](https://github.com/doughtyphilipe/hangman/blob/main/hangman.gif)

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
