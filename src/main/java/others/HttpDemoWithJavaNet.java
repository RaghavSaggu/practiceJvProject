package others;

import com.google.gson.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URL;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;

/*
 * Complete the 'getPhoneNumbers' function below.
 *
 * The function is expected to return a STRING.
 * The function accepts following parameters:
 *  1. STRING country
 *  2. STRING phoneNumber
 * Base URL for copy/paste: https://jsonmock.hackerrank.com/api/countries?name=country
 */
class Result {

    public static String getResponseWithHttpUrlConnection(String targetUrl) {
        String responseStr = null;
        try {
            URL url = new URL(targetUrl);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.setDoInput(true);
            connection.setDoOutput(true);
            connection.setReadTimeout(60000);
            connection.setConnectTimeout(60000);
            BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String input;
            StringBuilder response = new StringBuilder();
            while((input = in.readLine()) != null) {
                response.append(input);
            }
            in.close();
            responseStr = response.toString();
        }  catch(IOException | JsonSyntaxException exception) {
            System.out.println("Something went wrong");
        } catch(Exception exception) {
            System.out.println("Something went wrong");
        }
        return responseStr;
    }

    public static String getResponseWithHttpClient(String targetUrl) {
        String responseStr = null;
        try {
            HttpClient httpClient = HttpClient.newBuilder()
                    .version(HttpClient.Version.HTTP_2)
                    .connectTimeout(Duration.ofSeconds(10))
                    .build();
            HttpRequest httpRequest = HttpRequest.newBuilder()
                    .GET()
                    .uri(URI.create(targetUrl))
                    .build();
            HttpResponse<String> httpResponse = httpClient.send(httpRequest, HttpResponse.BodyHandlers.ofString());
//            System.out.println("Status Code: " + httpResponse.statusCode() +"\n" + "Headers: " + httpResponse.headers().allValues("Content-Type") + "\n" + "Body: " + httpResponse.body());
            responseStr = httpResponse.body();
        }  catch(IOException | JsonSyntaxException exception) {
            System.out.println("Something went wrong");
        } catch(Exception exception) {
            System.out.println("Something went wrong");
        }
        return responseStr;
    }

    public static String getOutput(String country, String phoneNumber) {
        String responseStr = null;
        try {
            String targetUrl = "https://jsonmock.hackerrank.com/api/countries?name=" + country;
            String response;
            response = getResponseWithHttpUrlConnection(targetUrl);
//            response = getResponseWithHttpClient(targetUrl);
            responseStr = processRepsonse(response);
        } catch(Exception exception) {
            System.out.println("Something went wrong");
        }
        return "+" + responseStr + " " + phoneNumber;
    }

    public static String processRepsonse(String response) {
        String responseStr = null;
        try {
            // System.out.println(responseStr);
            JsonObject jsonResponse = new Gson().fromJson(response, JsonObject.class);
            if(jsonResponse.has("data") && JsonNull.INSTANCE != jsonResponse.get("data")) {
                JsonArray jsonElementsData = jsonResponse.getAsJsonArray("data");
                for (int i = 0; i < jsonElementsData.size() && (responseStr == null || responseStr.length() == 0); i++) {
                    JsonObject jsonData = jsonElementsData.get(i).getAsJsonObject();
                    if(jsonData.has("callingCodes")) {
                        JsonArray jsonElementsCallingCodes = jsonData.getAsJsonArray("callingCodes");
                        for(int j = 0; j < jsonElementsCallingCodes.size(); j++) {
                            responseStr = jsonElementsCallingCodes.get(j).getAsString();
                            if(responseStr != null && responseStr.length() > 0)
                                break;
                        }
                    }
                }
            }
        } catch (Exception e) {
            System.out.println("Something went wrong while processing response");
        }
        return responseStr;
    }
}

public class HttpDemoWithJavaNet {
    public static void main(String[] args) throws IOException {
        String country = "INDIA";
        String phoneNumber = "9023542800";

        String result = Result.getOutput(country, phoneNumber);
        System.out.println(result);
    }
}