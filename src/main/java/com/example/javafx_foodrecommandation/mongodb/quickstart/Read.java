package com.example.javafx_foodrecommandation.mongodb.quickstart;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

public class Read {

    public static void main(String[] args) {
        try (MongoClient mongoClient = MongoClients.create(System.getProperty("mongodb.uri"))) {
            MongoDatabase MealsByCategory = mongoClient.getDatabase("MealsByCategory");
            MongoCollection<Document> Categories = MealsByCategory.getCollection("Categories");

            Document Category1 = Categories.find().first();
        }
    }
}