package com.tuforo.conversor.principal;

import com.tuforo.conversor.service.ClienteHttp;
import com.tuforo.conversor.service.ConvertirMoneda;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        ClienteHttp clienteHttp = new ClienteHttp();
        ConvertirMoneda convertirMoneda = new ConvertirMoneda(clienteHttp);

        int opcion = 0;

        while (opcion != 3) {
            System.out.println("*************************************************");
            System.out.println("Sea bienvenido/a al Conversor de Monedas");
            System.out.println("Menú de opciones:");
            System.out.println("1) Convertir moneda");
            System.out.println("2) Mostrar códigos de monedas más comunes");
            System.out.println("3) Salir");
            System.out.println("*************************************************");
            System.out.print("Elija una opción válida: ");

            try {
                opcion = teclado.nextInt();
                teclado.nextLine(); // Limpiar el buffer del scanner

                switch (opcion) {
                    case 1:
                        System.out.print("Ingrese el código de la moneda de origen (ej. USD): ");
                        String monedaOrigen = teclado.nextLine().toUpperCase();

                        System.out.print("Ingrese el código de la moneda de destino (ej. EUR): ");
                        String monedaDestino = teclado.nextLine().toUpperCase();

                        System.out.print("Ingrese la cantidad a convertir: ");
                        double cantidad = teclado.nextDouble();
                        teclado.nextLine(); // Limpiar el buffer

                        try {
                            double resultado = convertirMoneda.convertir(monedaOrigen, monedaDestino, cantidad);
                            System.out.printf("El valor de %.2f [%s] corresponde al valor final de: %.2f [%s]%n",
                                    cantidad, monedaOrigen, resultado, monedaDestino);
                        } catch (RuntimeException e) {
                            System.out.println("Error durante la conversión: " + e.getMessage());
                            System.out.println(
                                    "Por favor verifique que los códigos de país sean válidos y que cuenta con conexión a internet.");
                        }
                        System.out.println();
                        break;

                    case 2:
                        System.out.println("\n--- Códigos de monedas más comunes ---");
                        System.out.println("USD - Dólar estadounidense");
                        System.out.println("EUR - Euro");
                        System.out.println("BRL - Real brasileño");
                        System.out.println("COP - Peso colombiano");
                        System.out.println("MXN - Peso mexicano");
                        System.out.println("ARS - Peso argentino");
                        System.out.println("CLP - Peso chileno");
                        System.out.println("--------------------------------------\n");
                        break;

                    case 3:
                        System.out.println("Saliendo del programa, ¡hasta luego!");
                        break;

                    default:
                        System.out.println("Opción no válida. Por favor, intente nuevamente.\n");
                        break;
                }
            } catch (InputMismatchException e) {
                System.out.println("Entrada inválida. Por favor ingrese un número del menú.\n");
                teclado.nextLine(); // Limpiar el buffer después del error
            }
        }

        teclado.close();
    }
}
