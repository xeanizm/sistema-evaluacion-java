/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Projecto1;

/**
 *
 * @author maxim
 */
public class RegistroNotas {
    
    private String[] nombres = new String[100];
    private int[] porcentajes = new int[100];
    private double[] notas = new double[100];
    
    private int cantidad = 0;
    
    public void guardarNota(String nombre, int porcentaje) {
        if (cantidad >= 100) {
            System.out.println("Registro lleno.");
            return;
        }
        double nota;
        
        if (porcentaje < 60) {
            nota = 1.0 + porcentaje * 3.0 / 60;
        }
        else {
            nota = 4.0 + (porcentaje - 60) * 3.0 / 40;
        }
        nota = Math.round(nota * 10.0) / 10.0;
        
        nombres[cantidad] = nombre;
        porcentajes[cantidad] = porcentaje;
        notas[cantidad] = nota;
        
        cantidad++;
        
        System.out.println("Nota guardada correctamente.");

        
        
    }
    
    public void mostrarNotas() {

        if (cantidad == 0) {
            System.out.println("No hay estudiantes registrados.");
            return;
        }
        
        System.out.println("\n===== NOTAS DE ESTUDIANTES =====");

        for (int i = 0; i < cantidad; i++) {

            System.out.println("\nEstudiante: " + nombres[i]);
            System.out.println("Porcentaje: " + porcentajes[i] + "%");
            System.out.println("Nota: " + notas[i]);
        }
    }
    
    
    
    
    
}
