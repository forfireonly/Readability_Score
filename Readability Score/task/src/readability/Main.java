package readability;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import java.util.Scanner;


public class Main {

    static String[] ages = {"6", "7", "9", "10", "11", "12", "13", "14", "15", "16",
            "17", "18", "24", "24+"};

    public static void ari(int numberOfCharacters, int wordsNumber, int sentencesNumber) {
        double score = 4.71 * numberOfCharacters / wordsNumber + 0.5 * wordsNumber / sentencesNumber - 21.43;
        int index = (int) (Math.ceil(score) - 1);
        if (index >= 14) {
            index = 13;
        }
        System.out.println("Automated Readability Index: " + score + "(about " + ages[index] +" year olds).");
    }

    public static void fk(int wordsNumber, int sentencesNumber, int numberOfSyllables) {
        double score = 0.39 * wordsNumber / sentencesNumber + 11.8 * numberOfSyllables / wordsNumber - 15.59;
        int index = (int) (Math.round(score) - 1);
        System.out.println("Flesch–Kincaid readability tests: " + score + "(about " + ages[index] +" year olds).");
    }

    public static void smg(int numberOfPolysyllables, int sentencesNumber) {
        double score = 1.043 * Math.sqrt((double)numberOfPolysyllables * 30 / (double)sentencesNumber) + 3.1291;
        int index = (int) (Math.floor(score) - 1);
        System.out.println("Simple Measure of Gobbledygook: " + score + "(about " + ages[index] +" year olds).");
    }

    public static void cl(int sentencesNumber, int wordsNumber, int numberOfCharacters) {
        double s = (double)(sentencesNumber/ wordsNumber) * 100;
        double l = (double) (numberOfCharacters / wordsNumber) * 100;

        double score= 0.0588 * l -  0.296 * s - 15.8;
        int index = (int) (Math.ceil(score) - 1);
        if (index >= 14) {
            index = 13;
        }
        System.out.println("Coleman–Liau index: " + score + "(about " + ages[index] +" year olds).");
    }

    public static void main(String[] args) throws IOException {
        File file = new File(args[0]);
        StringBuilder text = new StringBuilder();
        try (Scanner scn = new Scanner(file)){
            while (scn.hasNext()) {
                text.append(scn.nextLine());
            }
        } catch (FileNotFoundException e) {
            System.out.print("File not found");
        }
        System.out.println("The text is:" +"\n"  + text);
        System.out.println();
        System.out.println();
        String[] words = text.toString().split("[,.!\\s]+");
        String[] wordsForCharacters = text.toString().split(" ");
        int wordsNumber = words.length;
        System.out.println("Words: " + wordsNumber);
        String[] sentences = text.toString().split("[.?!]");
        int sentencesNumber = sentences.length;
        System.out.println("Sentences: " + sentencesNumber);
        int numberOfCharacters = 0;
        int numberOfSyllables = 0;
        int numberOfPolysyllables = 0;

        for (String word : wordsForCharacters) {
            numberOfCharacters += word.length();
        }

        for (String word : words) {
            //numberOfCharacters += word.length();
            String[] wordLetters = word.split("");
            int polysyllableCounter = 0;

            for (int i = 0; i < wordLetters.length; i++) {

                if (wordLetters[i].matches("[aeiouyAEIOUY]")) {
                    numberOfSyllables++;
                    polysyllableCounter++;
                }
                if (i == wordLetters.length - 1) {
                    if (wordLetters[i].matches("[eE]")) {
                        numberOfSyllables--;
                        polysyllableCounter--;
                    }
                }
                if (i + 1 < wordLetters.length) {
                    if (wordLetters[i].matches("[aeiouyAEIOUY]") && wordLetters[i + 1].matches("[aeiouyAEIOUY]")) {
                        numberOfSyllables--;
                        polysyllableCounter--;
                    }
                }


            }
            if (polysyllableCounter > 2) {
                numberOfPolysyllables++;
            };
            if (polysyllableCounter == 0) {
                numberOfSyllables++;
            }

        }
        System.out.println("Characters: " + numberOfCharacters);
        System.out.println("Syllables: " + numberOfSyllables);
        System.out.println("Polysyllables: " + numberOfPolysyllables);



        System.out.println("Enter the score you want to calculate (ARI, FK, SMOG, CL, all): ");

        Scanner scn = new Scanner(System.in);
        String choice = scn.nextLine();

        switch (choice){
            case "ARI":
                ari(numberOfCharacters, wordsNumber, sentencesNumber);
                break;
            case "FK":
                fk(wordsNumber, sentencesNumber, numberOfSyllables);
                break;
            case "SMOG":
                smg(numberOfPolysyllables, sentencesNumber);
                break;
            case "CL":
                cl(sentencesNumber, wordsNumber, numberOfCharacters);
                break;
            case "all":
                ari(numberOfCharacters, wordsNumber, sentencesNumber);
                fk(wordsNumber, sentencesNumber, numberOfSyllables);
                smg(numberOfPolysyllables, sentencesNumber);
                cl(sentencesNumber, wordsNumber, numberOfCharacters);
                break;
            default:
        }
    }

}