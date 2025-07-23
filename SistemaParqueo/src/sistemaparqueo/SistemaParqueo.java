/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package sistemaparqueo;

import javax.swing.JOptionPane;

/**
 *
 * @author aliso
 */
public class SistemaParqueo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // crear los niveles
        NivelParqueo g1 = new NivelParqueo(4, 5, "G1");
        NivelParqueo g2 = new NivelParqueo(5, 5, "G2");
        NivelParqueo g3 = new NivelParqueo(6, 5, "G3");

        boolean continuar = true;

        while (continuar) {
            String opcion = JOptionPane.showInputDialog(
                "Sistema de Parqueo\n\n"
                + "1. Asignar espacio\n"
                + "2. Liberar espacio\n"
                + "3. Ver estado de los niveles\n"
                + "4. Salir\n\n"
                + "Seleccione una opción:"
            );

            if (opcion == null) break; // Si cierra la ventana

            switch (opcion) {
                case "1":
                    asignarEspacio(g1, g2, g3);
                    break;

                case "2":
                    liberarEspacio(g1, g2, g3);
                    break;

                case "3":
                    mostrarNiveles(g1, g2, g3);
                    break;

                case "4":
                    continuar = false;
                    break;

                default:
                    JOptionPane.showMessageDialog(null, "Opción inválida");
            }
        }
    }

    static void asignarEspacio(NivelParqueo g1, NivelParqueo g2, NivelParqueo g3) {
        String id = JOptionPane.showInputDialog("Ingrese el ID del socio:");
        if (id == null) return;

        String tipo = JOptionPane.showInputDialog("¿Tipo de socio?\n1. Normal\n2. Discapacitado\n3. Entrenador:");
        if (tipo == null) return;

        boolean esDiscapacitado = tipo.equals("2");
        boolean esEntrenador = tipo.equals("3");

        String nivel = JOptionPane.showInputDialog("Seleccione nivel:\nG1, G2 o G3");
        if (nivel == null) return;

        boolean asignado = false;

        if (nivel.equalsIgnoreCase("G1")) {
            asignado = g1.asignarEspacio(id, esDiscapacitado, esEntrenador);
        } else if (nivel.equalsIgnoreCase("G2")) {
            asignado = g2.asignarEspacio(id, esDiscapacitado, esEntrenador);
        } else if (nivel.equalsIgnoreCase("G3")) {
            asignado = g3.asignarEspacio(id, esDiscapacitado, esEntrenador);
        } else {
            JOptionPane.showMessageDialog(null, "Nivel no válido");
            return;
        }

        if (asignado) {
            JOptionPane.showMessageDialog(null, "Espacio asignado correctamente.");
        } else {
            JOptionPane.showMessageDialog(null, "No se encontró un espacio disponible.");
        }
    }

    static void liberarEspacio(NivelParqueo g1, NivelParqueo g2, NivelParqueo g3) {
        String id = JOptionPane.showInputDialog("Ingrese el ID del socio a liberar:");
        if (id == null) return;

        boolean liberado = g1.liberarEspacio(id) || g2.liberarEspacio(id) || g3.liberarEspacio(id);

        if (liberado) {
            JOptionPane.showMessageDialog(null, "Espacio liberado correctamente.");
        } else {
            JOptionPane.showMessageDialog(null, "No se encontró ningún espacio ocupado con ese ID.");
        }
    }

    static void mostrarNiveles(NivelParqueo g1, NivelParqueo g2, NivelParqueo g3) {
        String texto = g1.mostrarNivel() + "\n" + g2.mostrarNivel() + "\n" + g3.mostrarNivel();
        JOptionPane.showMessageDialog(null, texto);
    }
}

