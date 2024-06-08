package com.example;

import java.io.FileInputStream;
import java.io.InputStream;

import opennlp.tools.namefind.NameFinderME;
import opennlp.tools.namefind.TokenNameFinderModel;
import opennlp.tools.util.Span;

public class NERExample {
    public static void main(String[] args) {
        try {
            // Load the named entity recognition model
            InputStream modelIn = new FileInputStream("models/en-ner-person.bin");
            TokenNameFinderModel model = new TokenNameFinderModel(modelIn);
            
            // Initialize the name finder
            NameFinderME nameFinder = new NameFinderME(model);
            
            // Sample sentence
            String[] sentence = new String[] { "John", "Smith", "is", "a", "software", "engineer", "at", "Acme", "Corp", "." };
            
            // Find the names in the sentence
            Span[] names = nameFinder.find(sentence);
            
            // Print the names and their spans
            for (Span name : names) {
                System.out.println("Name: " + name.toString() + ", Entity: " + String.join(" ", java.util.Arrays.copyOfRange(sentence, name.getStart(), name.getEnd())));
            }
            
            // Close the model input stream
            modelIn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
