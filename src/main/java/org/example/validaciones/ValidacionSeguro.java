package org.example.validaciones;

import org.example.modelos.Seguro;
import org.example.utilidades.ConvertirFechas;
import org.example.utilidades.Mensajes;
import org.example.utilidades.Utilidad;

import java.time.LocalDate;

public class ValidacionSeguro {

    Utilidad utilidad=new Utilidad();


    public ValidacionSeguro() {
    }

    public Boolean validarNombreAsegurado(String nombreAsegurado) throws Exception{

        if (nombreAsegurado.length()>20){
            throw new Exception(Mensajes.NOMBRESASEGURADO_MAXIMO.getMensaje());

        }
        String expresionRegular = "^[a-zA-Z ]+$";
        if (!this.utilidad.buscarCoincidencia(expresionRegular,nombreAsegurado)){
            throw new Exception(Mensajes.NOMBREASEGURADO_DIFERENTE.getMensaje());


        }
        return true;


    }
    public Boolean validarEdadAsegurado(Integer edadAsegurado)throws Exception{
        if (edadAsegurado<0){
            throw new Exception(Mensajes.EDADASEGURADO_NEGATIVO.getMensaje());
        }
        if (edadAsegurado>90){
            throw new Exception(Mensajes.EDADASEGURADO_MAXIMO.getMensaje());
        }
        return true;
    }
    public Boolean validarMontoCobertura(Double montoCobertura)throws Exception{
        if (montoCobertura>=1500.0){
            throw new Exception(Mensajes.MONTOCOBERTURA_MAYOR.getMensaje());
        }

        return true;

    }
    public Boolean validarFechaInicioCobertura(String fechaInicioCobertura) throws Exception {
        String expresionRegular = "^(0[1-9]|[12][0-9]|3[01])/(0[1-9]|1[0-2])/\\d{4}$";

        if (!this.utilidad.buscarCoincidencia(expresionRegular, fechaInicioCobertura)) {
            throw new Exception(Mensajes.FECHAINICIOCOBERTURA_MALA.getMensaje());
        }

        LocalDate localDate = null;
        try {
            localDate = ConvertirFechas.convertirString(fechaInicioCobertura);
        } catch (Exception e) {
            throw new Exception(Mensajes.FECHAINICIOCOBERTURA_MALA.getMensaje());
        }

        return true;
    }




    public Boolean ValidarBeneficiario(String beneficiario) throws Exception {
        if (beneficiario.length() > 50) {
            throw new Exception(Mensajes.BENEFICIARIO_MAXIMO.getMensaje());
        }
        String expresionRegular = "^[a-zA-Z]+$"; // Permite solo letras mayúsculas y minúsculas
        if (!this.utilidad.buscarCoincidencia(expresionRegular, beneficiario)) {
            throw new Exception(Mensajes.BENEFICIARIO_DIFERENTE.getMensaje());
        }
        return true;
    }

}

