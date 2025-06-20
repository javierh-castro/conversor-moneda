import com.google.gson.Gson;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConsultarMoneda {
    public Moneda buscarMoneda(String siglaDeMoneda) {
//        String moneda = "USD";
        URI direccion = URI.create("https://v6.exchangerate-api.com/v6/14e40ec96de34095fd510d29/latest/" + siglaDeMoneda);
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(direccion)
                .build();
        try {
            HttpResponse<String> response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());
            return new Gson().fromJson(response.body(), Moneda.class);
        } catch (Exception e){
//            System.out.println("Este es el error: " + e.getMessage());
            throw new RuntimeException("No encontré esa película." + e.getMessage());
        }
    }
}
