import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
//javac GeminiApiKeyCheck.java
//java GeminiApiKeyCheck AIzaSyAal_j3jQFp4jliP7-KG5Hn8wlmbf5LwQM

public class GeminiApiKeyCheck {
    public static void main(String[] args) {
        // Use the first argument as the key if provided
        String apiKey = (args.length >= 1) ? args[0] : System.getenv("GEMINI_API_KEY");

        if (apiKey == null || apiKey.trim().isEmpty()) {
            System.err.println("Error: Please pass your API key as an argument.");
            System.exit(1);
        }

        try {
            // Path and key are separated by the '?' character
            String urlString = "https://googleapis.com" + apiKey;
            URL url = new URL(urlString);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("POST");
            conn.setRequestProperty("Content-Type", "application/json");
            conn.setDoOutput(true);

            String jsonInputString = "{\"contents\": [{\"parts\":[{\"text\": \"Explain AI in one sentence.\"}]}]}";

            try (OutputStream os = conn.getOutputStream()) {
                byte[] input = jsonInputString.getBytes("utf-8");
                os.write(input, 0, input.length);
            }

            int code = conn.getResponseCode();
            System.out.println("HTTP Status: " + code);

            BufferedReader br = new BufferedReader(new InputStreamReader(
                    (code >= 200 && code < 300) ? conn.getInputStream() : conn.getErrorStream(), "utf-8"));

            StringBuilder response = new StringBuilder();
            String responseLine;
            while ((responseLine = br.readLine()) != null) {
                response.append(responseLine.trim());
            }
            System.out.println("Response: " + response.toString());

        } catch (Exception e) {
            System.err.println("Network Error: Could not connect to Google APIs. Check your internet connection.");
            e.printStackTrace();
        }
    }
}
