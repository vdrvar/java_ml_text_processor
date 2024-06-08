package com.example;

import java.io.FileInputStream;
import java.io.InputStream;

import opennlp.tools.postag.POSModel;
import opennlp.tools.postag.POSTaggerME;

public class POSTaggingExample {
    public static void main(String[] args) {
        try {
            // Load the part-of-speech model
            InputStream modelIn = new FileInputStream("models/en-pos-maxent.bin");
            POSModel model = new POSModel(modelIn);
            
            // Initialize the part-of-speech tagger
            POSTaggerME posTagger = new POSTaggerME(model);
            
            // Sample sentence
            String[] sentence = new String[] { "Hello", ",", "this", "is", "a", "test", "sentence", "." };
            
            // Tag the sentence
            String[] tags = posTagger.tag(sentence);
            
            // Print the tokens and their tags
            for (int i = 0; i < sentence.length; i++) {
                System.out.println(sentence[i] + " - " + tags[i]);
            }
            
            // Close the model input stream
            modelIn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
