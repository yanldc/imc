package com.example.imc.validator;

import com.example.imc.exception.InvalidHeightException;
import com.example.imc.exception.InvalidWeightException;
import com.example.imc.exception.DivisionByZeroLikeException;

public class ImcValidator {

    public static void validar(double peso, double altura) {
        if (altura <= 0) {
            throw new DivisionByZeroLikeException("Altura não pode ser zero ou negativa!");
        }
        if (altura < 0.5 || altura > 2.5) {
            throw new InvalidHeightException("Altura fora do intervalo plausível (0.5m - 2.5m).");
        }
        if (peso <= 0) {
            throw new InvalidWeightException("Peso não pode ser zero ou negativo!");
        }
        if (peso < 2 || peso > 400) {
            throw new InvalidWeightException("Peso fora do intervalo plausível (2kg - 400kg).");
        }
    }
}
