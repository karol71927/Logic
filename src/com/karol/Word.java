package com.karol;

public class Word {
    private int length;         //length of the word
    private String word;        //word
    private int logicLetters;   //amount of logic letters for example global has 4 logic letters
    private String letters;     //logic letters for example global has log

    public Word(String word) {
        this.word = word;
        this.length = word.length();
        this.logicLetters = 0;
        this.letters = "";
    }

    public int countLetters(String letters){    //function counts how many letters are in word and which of them are
                                                //in this word
        for(int i = 0; i < letters.length(); i++){
            for(int j = 0; j < word.length(); j++) {
                if (word.charAt(j) == letters.charAt(i)) {
                    if(!this.letters.contains(String.valueOf(word.charAt(j)))) {
                        this.letters += word.charAt(j);
                    }
                    this.logicLetters++;
                }
            }
        }
        return logicLetters;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public int getLogicLetters() {
        return logicLetters;
    }

    public void setLogicLetters(int logicLetters) {
        this.logicLetters = logicLetters;
    }

    public String getLetters() {
        return letters;
    }

    public void setLetters(String letters) {
        this.letters = letters;
    }

    @Override
    public String toString() {
        return "Word{" +
                "length=" + length +
                ", word='" + word + '\'' +
                ", logicLetters=" + logicLetters +
                ", letters='" + letters + '\'' +
                '}';
    }
}
