package com.example.imc.service;

import org.springframework.stereotype.Service;
import com.example.imc.dto.ImcResponseDTO;
import com.example.imc.validator.ImcValidator;

@Service
public class ImcService {

    public ImcResponseDTO calcularImc(double peso, double altura) {
        ImcValidator.validar(peso, altura);

        double imc = peso / (altura * altura);
        String classificacao = classificarImc(imc);

        return new ImcResponseDTO(imc, classificacao);
    }

    private String classificarImc(double imc) {
        if (imc < 18.5)
            return "Abaixo do peso";
        else if (imc < 24.9)
            return "Peso normal";
        else if (imc < 29.9)
            return "Sobrepeso";
        else if (imc < 34.9)
            return "Obesidade grau I";
        else if (imc < 39.9)
            return "Obesidade grau II";
        else
            return "Obesidade grau III (mórbida)";
    }
}
