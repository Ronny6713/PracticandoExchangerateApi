package com.alura.ExchangesRateApi;

import com.google.gson.Gson;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class SeleccionMoneda {
    Exchanges seleccionarMoneda(String moneda) {

        URI direccion = URI.create("https://v6.exchangerate-api.com/v6/3a9b9a5e790730e486c19cfe/" + moneda);
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(direccion)
                .build();

        HttpResponse<String> response;

        try {
            response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }
        return new Gson().fromJson(response.body(), Exchanges.class);
    }
}
