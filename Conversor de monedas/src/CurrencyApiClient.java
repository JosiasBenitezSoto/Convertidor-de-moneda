import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import com.google.gson.Gson;
import com.google.gson.JsonObject;

public class CurrencyApiClient {
    private static final String API_URL = "https://v6.exchangerate-api.com/v6/86b68aecd2097aa1718bc224/latest/";

    public double getConversionRate(String fromCurrency, String toCurrency) {
        double rate = -1;
        try {
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(API_URL + fromCurrency))
                    .build();
            HttpClient client = HttpClient.newHttpClient();
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            if (response.statusCode() == 200) {
                String responseBody = response.body();
                Gson gson = new Gson();
                JsonObject jsonObject = gson.fromJson(responseBody, JsonObject.class);
                rate = jsonObject.getAsJsonObject("conversion_rates").get(toCurrency).getAsDouble();
            } else {
                System.out.println("Error en la conexión: " + response.statusCode());
            }
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
        return rate;
    }
}

