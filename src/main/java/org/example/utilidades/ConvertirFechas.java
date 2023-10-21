package org.example.utilidades;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class ConvertirFechas {
    public static LocalDate convertirString(String dateString) {

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        try {

            LocalDate date = LocalDate.parse(dateString, formatter);
            return date;
        } catch (Exception error) {
            System.out.println("No se pudo realizar el parse de la cadena a LocalDate: " + error.getMessage());
            return null;
        }
    }

}
