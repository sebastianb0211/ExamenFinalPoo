package org.example;

import org.example.modelos.Seguro;
import org.example.utilidades.ConvertirFechas;
import org.example.utilidades.Utilidad;

import java.time.LocalDate;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner entradaTeclado =new Scanner(System.in);

        Seguro seguro=new Seguro();

        seguro.calcularPrima();

        System.out.println("Digita el id del usuario");
        seguro.setNombreAsegurado(entradaTeclado.next());




    }
}