package com.alura.ExchangesRateApi;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main (String[] args) {
        Scanner teclado = new Scanner(System.in);
        SeleccionMoneda seleccion = new SeleccionMoneda();
        DecimalFormat df = new DecimalFormat("#.00");
        String resultado;
        String tipoDeMoneda ;
        double dineroUsuario;
        String monedaApi;
        String continuar = "1";


        while (continuar.equals("1")) {
            Exchanges monedassi = seleccion.seleccionarMoneda("latest/usd");

            ArrayList<String> keys = new ArrayList<>(monedassi.conversion_rates().keySet());
            imprimirKeys(keys);
            System.out.println("Ingresa el numero de la  Moneda que quieres convertir?:");

            int decision = (int) teclado.nextDouble();
            if (decision < keys.size()) {
                tipoDeMoneda = keys.get(decision);
                System.out.println("Cantidad de " + tipoDeMoneda + " Que deseas convertir: ");
                dineroUsuario = teclado.nextDouble();
                imprimirKeys(keys);
                System.out.println("A que moneda desea convertir sus " + tipoDeMoneda + "?");
                decision = (int) teclado.nextDouble();
                monedaApi = keys.get(decision);
                System.out.println(monedaApi);
                monedassi = seleccion.seleccionarMoneda("pair/"+tipoDeMoneda+"/"+monedaApi);
                System.out.println(dineroUsuario + " "+tipoDeMoneda + " es igual a: " + dineroUsuario * monedassi.conversion_rate() +" " + monedassi.target_code());
                System.out.println("""
                       Para Continuar Presione 1
                       Para Salir Precione 9
                       """);
                continuar = String.valueOf(teclado.nextInt());
            }else {
                System.out.println("opcion no valida");
            }
        }
    }

    private static void imprimirKeys(ArrayList<String> keys){
        int columnas = 17; // Imprimir y organizar en Columnas la lista
        for (int i = 0; i < keys.size(); i++) {
            System.out.print("[" + i + ". " + keys.get(i) + "] \t");
            if ((i + 1) % columnas == 0) {
                System.out.println();
            }
        }
        if (keys.size() % columnas != 0) {
            System.out.println();
        }
    }
}

