import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;


import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class Main {

    private static final String GITLAB_API_BASE_URL = "https://gitlab.com/api/v4";
    private static final String PERSONAL_ACCESS_TOKEN = "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";

    public static void main(String[] args) {
        HttpClient httpClient = HttpClient.newHttpClient();

        // Example: Get information about the authenticated user
        String apiUrl = GITLAB_API_BASE_URL + "/user";
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(apiUrl))
                .header("PRIVATE-TOKEN", PERSONAL_ACCESS_TOKEN)
                .build();

        try {
            HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());

            if (response.statusCode() == 200) {
                System.out.println("Response: " + response.body());
            } else {
                System.err.println("Error: " + response.statusCode() + ", " + response.body());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
