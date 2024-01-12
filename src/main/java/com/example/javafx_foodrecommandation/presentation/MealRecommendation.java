package com.example.javafx_foodrecommandation.presentation;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.HashMap;
import java.util.Map;

public class MealRecommendation {

    public static void main(String[] args) {
        // Assume userChoices is a map containing the user's selections
        Map<String, String> userChoices = new HashMap<>();
        userChoices.put("cuisine", "Italian");
        userChoices.put("flavor", "Spicy");
        userChoices.put("diet", "Vegetarian");
        userChoices.put("mealType", "Quick and easy");
        userChoices.put("ingredients", "Limited ingredients available");
        userChoices.put("preparationTime", "Less than 30 minutes");
        userChoices.put("mealTiming", "Dinner");
        userChoices.put("allergies", "No allergies");

        // Convert user choices into a prompt string
        StringBuilder promptBuilder = new StringBuilder();
        promptBuilder.append(String.format("Recommend a %s %s dish that is %s and suitable for %s diet. ",
                userChoices.get("mealType"), userChoices.get("cuisine"), userChoices.get("flavor").toLowerCase(),
                userChoices.get("diet")));

        if (userChoices.get("ingredients").equals("Limited ingredients available")) {
            promptBuilder.append("I have limited ingredients available, so please consider that. ");
        }

        if (!userChoices.get("preparationTime").equals("No time limit, I enjoy cooking")) {
            promptBuilder.append(String.format("I'm looking for a recipe that takes %s. ", userChoices.get("preparationTime").toLowerCase()));
        }

        promptBuilder.append(String.format("This is for %s and should not contain %s.",
                userChoices.get("mealTiming").toLowerCase(), userChoices.get("allergies").toLowerCase()));

        // Now, 'prompt' contains a string that you can use
        String prompt = promptBuilder.toString();

        // Use OpenAI API for meal recommendation
        String openAiApiKey = "YOUR_OPENAI_API_KEY";
        String openAiApiUrl = "https://api.openai.com/v1/engines/davinci/completions";  // Adjust URL based on OpenAI API version

        // Set up the prompt and parameters
        String promptForOpenAI = prompt;
        int maxTokens = 150;  // Adjust based on your requirements

        // Make a request to OpenAI API
        String response = makeOpenAiApiRequest(openAiApiUrl, openAiApiKey, promptForOpenAI, maxTokens);

        // Process the OpenAI response
        processOpenAiResponse(response);
    }

    private static String makeOpenAiApiRequest(String apiUrl, String apiKey, String prompt, int maxTokens) {
        try {
            HttpClient httpClient = HttpClient.newHttpClient();

            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(apiUrl))
                    .header("Content-Type", "application/json")
                    .header("Authorization", "Bearer " + apiKey)
                    .POST(HttpRequest.BodyPublishers.ofString(
                            "{\"prompt\": \"" + prompt + "\", \"max_tokens\": " + maxTokens + "}"))
                    .build();

            HttpResponse<String> httpResponse = httpClient.send(request, HttpResponse.BodyHandlers.ofString());

            return httpResponse.body();
        } catch (Exception e) {
            e.printStackTrace();  // Replace with appropriate logging
            return null;
        }
    }

    private static void processOpenAiResponse(String response) {
        // Add logic to process the OpenAI response (e.g., extract meal recommendation)
        System.out.println("OpenAI Response:\n" + response);
    }
}
