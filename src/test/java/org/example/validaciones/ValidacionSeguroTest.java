package org.example.validaciones;

import org.example.utilidades.Mensajes;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ValidacionSeguroTest {

    ValidacionSeguro validacionSeguro;

    @BeforeEach
    public void setup() {
        this.validacionSeguro = new ValidacionSeguro();
    }

    @Test
    void validarNombreAseguradoBueno() {
        String nombreAsegurado = "Sebastian";
        Assertions.assertDoesNotThrow(() -> validacionSeguro.validarNombreAsegurado(nombreAsegurado));
    }

    @Test
    void validarNombreAseguradoIncorrectoTipoCaracteres() {
        String nombrePrueba = "Sebas32";
        Exception resultado = Assertions.assertThrows(Exception.class, () -> validacionSeguro.validarNombreAsegurado(nombrePrueba));
        Assertions.assertEquals(Mensajes.NOMBREASEGURADO_DIFERENTE.getMensaje(), resultado.getMessage());
    }

    @Test
    void validarNombreAseguradoIncorrectoLargo() {
        String nombrePruebaDos = "1234567890098765432345";
        Exception resultado = Assertions.assertThrows(Exception.class, () -> validacionSeguro.validarNombreAsegurado(nombrePruebaDos));
        Assertions.assertEquals(Mensajes.NOMBRESASEGURADO_MAXIMO.getMensaje(), resultado.getMessage());
    }

    @Test
    void validarEdadAseguradoBueno() {
        Integer edad = 34;
        Assertions.assertDoesNotThrow(() -> validacionSeguro.validarEdadAsegurado(edad));
    }

    @Test
    void validarEdadAseguradoNegativo() {
        Integer edad = -10;
        Exception resultado = Assertions.assertThrows(Exception.class, () -> validacionSeguro.validarEdadAsegurado(edad));
        Assertions.assertEquals(Mensajes.EDADASEGURADO_NEGATIVO.getMensaje(), resultado.getMessage());
    }

    @Test
    void validarEdadAseguradoMayor() {
        Integer edad = 91;
        Exception resultado = Assertions.assertThrows(Exception.class, () -> validacionSeguro.validarEdadAsegurado(edad));
        Assertions.assertEquals(Mensajes.EDADASEGURADO_MAXIMO.getMensaje(), resultado.getMessage());
    }

    @Test
    void validarMontoCoberturaBueno() {
        Double montoCobertura = 1000.0;
        Assertions.assertDoesNotThrow(() -> validacionSeguro.validarMontoCobertura(montoCobertura));
    }

    @Test
    void validarMontoCoberturaMayor() {
        Double montoCobertura = 2000.0;
        Exception resultado = Assertions.assertThrows(Exception.class, () -> validacionSeguro.validarMontoCobertura(montoCobertura));
        Assertions.assertEquals(Mensajes.MONTOCOBERTURA_MAYOR.getMensaje(), resultado.getMessage());
    }

    @Test
    void validarFechaInicioCoberturaBueno() {
        String fechaInicioCobertura = "01/12/2023";
        Assertions.assertDoesNotThrow(() -> validacionSeguro.validarFechaInicioCobertura(fechaInicioCobertura));
    }

    @Test
    void validarFechaInicioCoberturaMala() {
        String fechaInicioCobertura = "2021/02/12";
        Exception resultado = Assertions.assertThrows(Exception.class, () -> validacionSeguro.validarFechaInicioCobertura(fechaInicioCobertura));
        Assertions.assertEquals(Mensajes.FECHAINICIOCOBERTURA_MALA.getMensaje(), resultado.getMessage());
    }

    @Test
    void validarBeneficiarioBueno() {
        String beneficiarioBueno = "Juan";
        Assertions.assertDoesNotThrow(() -> validacionSeguro.ValidarBeneficiario(beneficiarioBueno));
    }


    @Test
    void validarBeneficiarioLargo() {
        String beneficiario = "Este es un beneficiario con un nombre muy largo que supera los 50 caracteres";
        Exception resultado = Assertions.assertThrows(Exception.class, () -> validacionSeguro.ValidarBeneficiario(beneficiario));
        Assertions.assertEquals(Mensajes.BENEFICIARIO_MAXIMO.getMensaje(), resultado.getMessage());
    }

    @Test
    void validarBeneficiarioCaracteres() {
        String beneficiario = "Beneficiario123";
        Exception resultado = Assertions.assertThrows(Exception.class, () -> validacionSeguro.ValidarBeneficiario(beneficiario));
        Assertions.assertEquals(Mensajes.BENEFICIARIO_DIFERENTE.getMensaje(), resultado.getMessage());
    }
}
