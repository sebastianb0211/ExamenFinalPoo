package org.example.utilidades;

public enum Mensajes {
    NOMBREASEGURADO_DIFERENTE("Error ya que solo se permiten letras"),
    NOMBRESASEGURADO_MAXIMO("El numero de caracteres no es correcto debe estar entre 0 y 20"),
    EDADASEGURADO_NEGATIVO("el nombre no coincide"),
    EDADASEGURADO_MAXIMO("como eres mayor de 90 años contactese a este numero 312356656"),
    MONTOCOBERTURA_MAYOR("no se permite ya que el monto ingresado es mayor que 1500 millones"),
    FECHAINICIOCOBERTURA_MALA("la fecha ingresada no corresponde con lo requerido"),
    BENEFICIARIO_MAXIMO("el nombre tiene caracteres mayor al solicitado"),
    BENEFICIARIO_DIFERENTE("el nombre del beneficiario no es posible");

    private String mensaje;

    Mensajes(String mensaje) {
        this.mensaje = mensaje;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }
}
