package com.example;

import java.io.FileInputStream;
import java.io.InputStream;

import opennlp.tools.tokenize.Tokenizer;
import opennlp.tools.tokenize.TokenizerME;
import opennlp.tools.tokenize.TokenizerModel;

public class TokenizerExample {
    public static void main(String[] args) {
        try {
            // Load the tokenizer model
            InputStream modelIn = new FileInputStream("models/en-token.bin");
            TokenizerModel model = new TokenizerModel(modelIn);
            
            // Initialize the tokenizer
            Tokenizer tokenizer = new TokenizerME(model);
            
            // Sample sentence
            String sentence = "Hello, this is a test sentence.";
            
            // Tokenize the sentence
            String[] tokens = tokenizer.tokenize(sentence);
            
            // Print the tokens
            for (String token : tokens) {
                System.out.println(token);
            }
            
            // Close the model input stream
            modelIn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
