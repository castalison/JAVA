/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sistemaparqueo;

/**
 *
 * @author aliso
 */
public class Espacio {
    public String estado; // "L" = Libre, "O" = Ocupado, "D" = Discapacitado, "E" = Entrenador
    public String idSocio;// ID del socio que ocupa el espacio

    // se usa constructor y se crea el espacio con un estado inicial 
    public Espacio(String estado) {
        this.estado = estado;
        this.idSocio = ""; // sin socio asignado
    }

    // getter y setters para obtener y poder cambiar el estado del espacio

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getIdSocio() {
        return idSocio;
    }

    public void setIdSocio(String idSocio) {
        this.idSocio = idSocio;
    }

    // devuelve true si el espacio está disponible para ocupar 
    public boolean estaLibre() {
        return estado.equals("L") || estado.equals("D") || estado.equals("E");
    }

    // devuelve el símbolo que representa el espacio (L, O, D, E)
    @Override
    public String toString() {
        return estado;
    }
}

