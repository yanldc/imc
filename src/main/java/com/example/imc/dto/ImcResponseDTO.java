package com.example.imc.dto;

public class ImcResponseDTO {
    private double imc;
    private String classificacao;

    public ImcResponseDTO(double imc, String classificacao) {
        this.imc = imc;
        this.classificacao = classificacao;
    }

    public double getImc() {
        return imc;
    }

    public String getClassificacao() {
        return classificacao;
    }
}
