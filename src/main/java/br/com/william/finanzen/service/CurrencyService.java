package br.com.william.finanzen.service;

import java.io.IOException;
import java.math.BigDecimal;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

import br.com.william.finanzen.dto.CurrencyDTO;
import br.com.william.finanzen.exception.IntegrationException;

/**
 * 
 */
public class CurrencyService {
    
    private static final String API_URI = "https://economia.awesomeapi.com.br/last/USD-BRL";
    private final HttpClient httpClient;
    private final Gson gson;

    public CurrencyService(){

        // Iniciando HttpClient com timeOut de 10 segundos para resiliencia de código
        this.httpClient = HttpClient.newBuilder()
            .connectTimeout(Duration.ofSeconds(10))
            .build();

        this.gson = new Gson();
    }

    public BigDecimal getCurrentyUSDRate(){
        try {
            
            // Montando a requisição
            // Uso de URI.create() para controle de exceção
            HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(API_URI))
                .GET()
                .build();

            // Enviando requisição e recebeendo a resposta como uma string
            HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());

            // Lançando exceção caso a requisição não tenha sido bem sucedida.
            if(response.statusCode() != 200 ){
                throw new IntegrationException("Falha ao consultar API. Código: " + response.statusCode());
            }

            JsonObject jsonObject = gson.fromJson(response.body(), JsonObject.class);

            // Lançando exceção caso não tenha o "galho" USDBRL no JSON
            if(!jsonObject.has("USDBRL")){
                throw new IntegrationException("JSON inválido: campo 'USDBRL' não encontrado.");
            }

            // Transformando o JSON no dto, que vai receber somente o campo "bid", ignorando o resto
            CurrencyDTO dto = gson.fromJson(jsonObject.get("USDBRL"), CurrencyDTO.class);

            return new BigDecimal(dto.bid());

            
        } catch (IOException | InterruptedException | NumberFormatException e) {
            if(e instanceof InterruptedException){
                Thread.currentThread().interrupt();
            }
            throw new IntegrationException("Erro na integração, com serviço de câmbio", e);
        }
    }
}
