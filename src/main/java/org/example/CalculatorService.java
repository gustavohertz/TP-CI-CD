package org.example;

public class CalculatorService {

    /**
     * Soma dois números.
     * @param a Primeiro número.
     * @param b Segundo número.
     * @return A soma de a e b.
     */
    public double add(double a, double b) {
        return a + b;
    }

    /**
     * Subtrai o segundo número do primeiro.
     * @param a Primeiro número (minuendo).
     * @param b Segundo número (subtraendo).
     * @return A diferença de a e b.
     */
    public double subtract(double a, double b) {
        return a - b;
    }

    /**
     * Multiplica dois números.
     * @param a Primeiro número.
     * @param b Segundo número.
     * @return O produto de a e b.
     */
    public double multiply(double a, double b) {
        return a * b;
    }

    /**
     * Divide o primeiro número pelo segundo.
     * @param a Primeiro número (dividendo).
     * @param b Segundo número (divisor).
     * @return O quociente de a e b.
     * @throws IllegalArgumentException Se o divisor (b) for zero.
     */
    public double divide(double a, double b) {
        if (b == 0) {
            throw new IllegalArgumentException("Não é possível dividir por zero.");
        }
        return a / b;
    }
}
