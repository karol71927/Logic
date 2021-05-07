package com.karol;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String phrase = "I love to work in global logic!";
        phrase = scanner.nextLine();
        phrase = phrase.toLowerCase();

        String letters = "LOGIC";
        letters = scanner.nextLine();
        letters = letters.toLowerCase();

        String[] words = phrase.split(" ");         //split phrase to string arrays
        ArrayList<Word> wordArrayList = new ArrayList<>();
        for(String word : words){
            word = word.replaceAll("[^\\w]","");    //replace special characters
            wordArrayList.add(new Word(word));            //convert Strings to Words
        }

        int amount = 0;         //amount of logic letters
        int totalAmount = 0;    //amount of all letters
        for(Word word : wordArrayList){
            word.countLetters(letters);
            amount += word.getLogicLetters();
            totalAmount += word.getLength();
        }

        addWords(wordArrayList);    //if there is word containing same letters combination and has same length then
                                    //add them for example {l,5} has 2 letters and {l,5} has 1 letter then make {l,5}
                                    //with 3 letters

        //lambda to compare Words by amount of logic letters
        Comparator<Word> compareByLogicLetters = (o1, o2) -> {
            Integer i1 = o1.getLogicLetters();
            Integer i2 = o2.getLogicLetters();
            return i1.compareTo(i2);
        };
        wordArrayList.sort(compareByLogicLetters);

        //printing words ang frequency
        for(Word word : wordArrayList){
            System.out.print("{" + word.getLetters() + ", " + word.getLength() + "} = " +
                divide(word.getLogicLetters(),amount) + " (" + word.getLogicLetters() + "/" + amount + ")\n");
        }
        //printing total frequency
        System.out.println("Total frequency: " + divide(amount,totalAmount) + " (" + amount + "/" + totalAmount + ")");
    }

    public static double divide(int i1, int i2){    //function returns double which is result of dividing i1 by i2
                                                    //rounded to 2 decimals
        double scale = Math.pow(10, 2);
        double value = (double) i1 / i2;
        return Math.round(value * scale) / scale;
    }

    public static void addWords(ArrayList<Word> words){     //function which makes changes in list if there are words
                                                            //with same logic letters and same length
        for(int i = 0; i < words.size(); i++){
            for (int j = i + 1; j < words.size(); j++){
                Word word = words.get(j);
                Word word2 = words.get(i);
                if(word.getLetters().equals(word2.getLetters()) && word.getLength() == word2.getLength()) {
                    words.remove(word);     //remove word at j position
                    word2.setLogicLetters(word.getLogicLetters() + word2.getLogicLetters());
                    words.set(i, word2);    //add amount of logic letters to word at i position
                }
            }
        }
    }
}
