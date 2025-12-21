package br.com.william.finanzen.dto;

import com.google.gson.annotations.SerializedName;

public record CotacaoDTO(@SerializedName("bid") String valor, @SerializedName("create_date") String dataHora) {
}
