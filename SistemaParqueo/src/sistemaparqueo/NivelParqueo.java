/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sistemaparqueo;

/**
 *
 * @author aliso
 */
public class NivelParqueo {
    public Espacio[][] espacios;  // matriz con todos los espacios 
    public String nombreNivel;    // nombre del nivel 

    // crea la matriz de espacios e inicializa los que estan reservados
    public NivelParqueo(int filas, int columnas, String nombreNivel) {
        this.nombreNivel = nombreNivel;
        espacios = new Espacio[filas][columnas];

        // inicializa todos los espacios como libres
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                espacios[i][j] = new Espacio("L");
            }
        }

        // asigna los espacios reservados
        reservarDiscapacitados(3); // 3 espacios para los discapacitados
        reservarEntrenadores(2);   // 2 espacios para entrenadores
    }

    // este metodo es para marcar espacios para discapacitados
    private void reservarDiscapacitados(int cantidad) {
        int cont = 0;
        for (int i = 0; i < espacios.length && cont < cantidad; i++) {
            for (int j = 0; j < espacios[0].length && cont < cantidad; j++) {
                espacios[i][j].setEstado("D");
                cont++;
            }
        }
    }

    // se usa para marcar espacios para entrenadores
    private void reservarEntrenadores(int cantidad) {
        int cont = 0;
        for (int i = espacios.length - 1; i >= 0 && cont < cantidad; i--) {
            for (int j = espacios[0].length - 1; j >= 0 && cont < cantidad; j--) {
                if (espacios[i][j].getEstado().equals("L")) {
                    espacios[i][j].setEstado("E");
                    cont++;
                }
            }
        }
    }

    // devuelve el estado visual del nivel 
    public String mostrarNivel() {
        String resultado = "Nivel " + nombreNivel + ":\n";
        for (int i = 0; i < espacios.length; i++) {
            for (int j = 0; j < espacios[0].length; j++) {
                resultado += espacios[i][j] + " ";
            }
            resultado += "\n";
        }
        return resultado;
    }

    //  asignacion de un espacio a un socio, sabiendo si es discapacitado o entrenador
    public boolean asignarEspacio(String idSocio, boolean esDiscapacitado, boolean esEntrenador) {
        for (int i = 0; i < espacios.length; i++) {
            for (int j = 0; j < espacios[0].length; j++) {
                String tipo = espacios[i][j].getEstado();

                // espacio normal
                if (tipo.equals("L") && espacios[i][j].estaLibre()) {
                    espacios[i][j].setEstado("O");
                    espacios[i][j].setIdSocio(idSocio);
                    return true;
                }

                // espacio de discapacitado 
                if (tipo.equals("D") && esDiscapacitado && espacios[i][j].estaLibre()) {
                    espacios[i][j].setEstado("O");
                    espacios[i][j].setIdSocio(idSocio);
                    return true;
                }

                // espacio de entrenador 
                if (tipo.equals("E") && esEntrenador && espacios[i][j].estaLibre()) {
                    espacios[i][j].setEstado("O");
                    espacios[i][j].setIdSocio(idSocio);
                    return true;
                }
            }
        }
        return false; // si no se encontró un espacio valido
    }

    // libera un espacio que tiene un ID específico
    public boolean liberarEspacio(String idSocio) {
        for (int i = 0; i < espacios.length; i++) {
            for (int j = 0; j < espacios[0].length; j++) {
                if (espacios[i][j].getIdSocio().equals(idSocio)) {
                    espacios[i][j].setEstado("L");
                    espacios[i][j].setIdSocio("");
                    return true;
                }
            }
        }
        return false;
    }
}

    

