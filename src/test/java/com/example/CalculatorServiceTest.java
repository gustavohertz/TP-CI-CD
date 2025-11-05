package com.example;


import org.example.CalculatorService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorServiceTest {

    private CalculatorService service;

    @BeforeEach
    void setUp() {
        // Inicializa uma nova instância do serviço antes de cada teste
        service = new CalculatorService();
    }

    @Test
    @DisplayName("Deve somar dois números corretamente")
    void deveSomarCorretamente() {
        assertEquals(15, service.add(10, 5), "10 + 5 deve ser 15");
        assertEquals(0, service.add(5, -5), "5 + (-5) deve ser 0");
    }

    @Test
    @DisplayName("Deve subtrair dois números corretamente")
    void deveSubtrairCorretamente() {
        assertEquals(5, service.subtract(10, 5), "10 - 5 deve ser 5");
        assertEquals(10, service.subtract(5, -5), "5 - (-5) deve ser 10");
    }

    @Test
    @DisplayName("Deve multiplicar dois números corretamente")
    void deveMultiplicarCorretamente() {
        assertEquals(50, service.multiply(10, 5), "10 * 5 deve ser 50");
        assertEquals(0, service.multiply(10, 0), "10 * 0 deve ser 0");
    }

    @Test
    @DisplayName("Deve dividir dois números corretamente")
    void deveDividirCorretamente() {
        assertEquals(2, service.divide(10, 5), "10 / 5 deve ser 2");
    }

    @Test
    @DisplayName("Deve lançar exceção ao dividir por zero")
    void deveLancarExcecaoAoDividirPorZero() {
        // Verifica se a exceção IllegalArgumentException é lançada
        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> service.divide(10, 0)
        );

        // Verifica a mensagem da exceção
        assertEquals("Não é possível dividir por zero.", exception.getMessage());
    }
}
