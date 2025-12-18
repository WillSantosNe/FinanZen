package br.com.william.finanzen;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;

public class TesteIntegracaoCambio {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.println("Digite a moeda para cotação (ex: USD, EUR): ");
            String moeda = scanner.nextLine().trim().toUpperCase();

            // Validação simples
            if (moeda.isEmpty()) {
                System.out.println("Por favor, digite um código de moeda válido.");
                return;
            }

            String url = "https://economia.awesomeapi.com.br/last/" + moeda + "-BRL";

            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(url))
                    .GET()
                    .build();

            System.out.println("Consultando API: " + url);

            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            if (response.statusCode() == 200) {
                System.out.println("--- Resposta da API (JSON) ---");
                System.out.println(response.body());
            } else {
                System.out.println("Erro na consulta. Código HTTP: " + response.statusCode());
                System.out.println("Corpo: " + response.body());
            }

        } catch (IOException | InterruptedException e) {
            System.out.println("Erro de conexão ou interrupção durante a chamada da API.");
            System.out.println("Detalhes: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }
}
