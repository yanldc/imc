package com.example.imc.controller;

import org.springframework.web.bind.annotation.*;
import com.example.imc.dto.ImcResponseDTO;
import com.example.imc.service.ImcService;

@RestController
@RequestMapping("/imc")
public class ImcController {

    private final ImcService imcService;

    public ImcController(ImcService imcService) {
        this.imcService = imcService;
    }

    // Exemplo: GET /imc?peso=70&altura=1.75
    @GetMapping
    public ImcResponseDTO calcularImc(
            @RequestParam double peso,
            @RequestParam double altura) {
        return imcService.calcularImc(peso, altura);
    }

    // Exemplo: GET /imc/classificacao?peso=70&altura=1.75
    @GetMapping("/classificacao")
    public String obterClassificacao(
            @RequestParam double peso,
            @RequestParam double altura) {
        ImcResponseDTO dto = imcService.calcularImc(peso, altura);
        return "Seu IMC é " + String.format("%.2f", dto.getImc()) + " → " + dto.getClassificacao();
    }
}
