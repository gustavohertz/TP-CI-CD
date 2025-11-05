package org.example;

import io.javalin.Javalin;
import io.javalin.http.BadRequestResponse;

public class Main {

    private static final CalculatorService service = new CalculatorService();

    public static void main(String[] args) {
        Javalin app = Javalin.create().start(7070);
        System.out.println("Servidor DevCalc iniciado em http://localhost:7070");

        // Endpoint GET /add
        app.get("/add", ctx -> {
            try {
                double a = Double.parseDouble(ctx.queryParam("a"));
                double b = Double.parseDouble(ctx.queryParam("b"));
                double result = service.add(a, b);
                ctx.result(String.valueOf(result));
            } catch (NumberFormatException e) {
                throw new BadRequestResponse("Parâmetros 'a' e 'b' devem ser números válidos.");
            }
        });

        // Endpoint GET /subtract
        app.get("/subtract", ctx -> {
            try {
                double a = Double.parseDouble(ctx.queryParam("a"));
                double b = Double.parseDouble(ctx.queryParam("b"));
                double result = service.subtract(a, b);
                ctx.result(String.valueOf(result));
            } catch (NumberFormatException e) {
                throw new BadRequestResponse("Parâmetros 'a' e 'b' devem ser números válidos.");
            }
        });

        // Endpoint GET /multiply
        app.get("/multiply", ctx -> {
            try {
                double a = Double.parseDouble(ctx.queryParam("a"));
                double b = Double.parseDouble(ctx.queryParam("b"));
                double result = service.multiply(a, b);
                ctx.result(String.valueOf(result));
            } catch (NumberFormatException e) {
                throw new BadRequestResponse("Parâmetros 'a' e 'b' devem ser números válidos.");
            }
        });

        // Endpoint GET /divide
        app.get("/divide", ctx -> {
            try {
                double a = Double.parseDouble(ctx.queryParam("a"));
                double b = Double.parseDouble(ctx.queryParam("b"));
                double result = service.divide(a, b);
                ctx.result(String.valueOf(result));
            } catch (NumberFormatException e) {
                throw new BadRequestResponse("Parâmetros 'a' e 'b' devem ser números válidos.");
            } catch (IllegalArgumentException e) {
                // Captura a exceção de divisão por zero do service
                throw new BadRequestResponse(e.getMessage());
            }
        });
    }
}
