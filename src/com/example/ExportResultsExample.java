package com.example;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.FileInputStream;
import java.io.InputStream;

import opennlp.tools.namefind.NameFinderME;
import opennlp.tools.namefind.TokenNameFinderModel;
import opennlp.tools.util.Span;

public class ExportResultsExample {
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
            
            // Prepare results for exporting
            StringBuilder resultBuilder = new StringBuilder();
            for (Span name : names) {
                resultBuilder.append("Name: ").append(name.toString()).append(", Entity: ")
                             .append(String.join(" ", java.util.Arrays.copyOfRange(sentence, name.getStart(), name.getEnd())))
                             .append("\n");
            }
            
            // Export results to a file
            File file = new File("results.txt");
            try (PrintWriter out = new PrintWriter(new FileWriter(file))) {
                out.print(resultBuilder.toString());
            }
            
            // Close the model input stream
            modelIn.close();
            
            System.out.println("Results exported to results.txt");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
