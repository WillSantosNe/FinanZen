package br.com.william.finanzen;

import br.com.william.finanzen.dto.CotacaoDTO;
import br.com.william.finanzen.exception.ErroConsultaCambioException;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

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

            // Filtrando o tipo de moeda pela URL
            String url = "https://economia.awesomeapi.com.br/last/" + moeda + "-BRL";

            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(url))
                    .GET()
                    .build();

            System.out.println("Consultando API: " + url);

            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            if (response.statusCode() == 200) {
                String json = response.body();
                Gson gson = new Gson();

                // Transformando JSON String em um objeto JsonObject
                JsonObject rootObject = JsonParser.parseString(json).getAsJsonObject();

                // Obtendo a chave dinâmica (chave do JSON)
                if (rootObject.isEmpty()) {
                    throw new ErroConsultaCambioException("Moeda não encontrada ou resposta inválida.");
                }
                String dynamicKey = rootObject.keySet().iterator().next();

                // Obtendo o objeto de dentro da chave (valores da moeda)
                JsonObject currencyObject = rootObject.getAsJsonObject(dynamicKey);

                // Transformando o JSON em um DTO.
                CotacaoDTO cotacao = gson.fromJson(currencyObject, CotacaoDTO.class);

                System.out.println("\n--- Dados Processados ---");
                System.out.printf("Moeda: %s%n", dynamicKey);
                System.out.printf("Valor: %s%n", cotacao.valor());
                System.out.printf("Data: %s%n", cotacao.dataHora());

            } else {
                throw new ErroConsultaCambioException("Falha ao buscar cotação. Verifique a moeda.");
            }

        } catch (IOException | InterruptedException e) {
            throw new ErroConsultaCambioException("Erro de conexão: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }
}
