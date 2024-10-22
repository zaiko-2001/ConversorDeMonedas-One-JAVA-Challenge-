import com.google.gson.Gson;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConsultaConversion {
    public Conversion crearConversion(String base_code, String target_code, double cantidad) { // Cambio aquí de int a double
        String apiKey = "a1bb88dea4af7c4801f3af93";
        URI direccion = URI.create("https://v6.exchangerate-api.com/v6/"
                + apiKey + "/pair/" + base_code + "/"
                + target_code + "/" + cantidad);

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(direccion).build();

        try {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            ConversionResponse conversionResponse = new Gson().fromJson(response.body(), ConversionResponse.class);
            double conversion_result = conversionResponse.conversion_result;

            // Retornar el record Conversion con los valores de la conversión
            return new Conversion(base_code, target_code, conversion_result);
        } catch (Exception e) {
            throw new RuntimeException("No se logró la conversión: " + e.getMessage());
        }
    }

    // Clase auxiliar para mapear la respuesta de la API
    private class ConversionResponse {
        double conversion_result;
    }
}
