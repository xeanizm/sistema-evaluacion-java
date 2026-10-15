package Projecto1;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author maxim
 */
public class Exam {
    
    private Pregunta[] preguntas;
    private int cantidad;
    
    public Exam() {
        preguntas = new Pregunta[10];
        cantidad = 0;
    }
    public void agregaPregunta(Pregunta pregunta) {
        if (cantidad < 10) {
            preguntas[cantidad] = pregunta;
            cantidad++;
            
        }
        else {
            System.out.println("El examen ya tiene 10 preguntas.");
        }
        
        
    }
    public void mostrarPreguntas() {

        if (cantidad == 0) {
            System.out.println("No hay preguntas.");
            return;
        }
        for (int i = 0; i < cantidad; i++) {
            System.out.println((i + 1) + ". "
                    + preguntas[i].getText()
                    + " | Peso: " + preguntas[i].getPeso());
        }
        
    }
    public void eliminarPregunta(int numero) {

        if (numero < 1 || numero > cantidad) {
            System.out.println("Numero de pregunta no valido.");
            return;
        }
        for (int i = numero - 1; i < cantidad - 1; i++) {
            preguntas[i] = preguntas[i + 1];
        }
        cantidad--;
        preguntas[cantidad] = null;
        System.out.println("Pregunta eliminada.");
        
        
    }
    public int darExam() {
        if (cantidad == 0) {
            System.out.println("No hay preguntas para responder.");
            return 0;
        }
        int puntos = 0;
        int total = 0;
        int correctas = 0;
        
        System.out.println("\n===== INICIO DEL EXAMEN =====");
        
        for (int i = 0; i < cantidad; i++) {
            
            System.out.println("\nPregunta " + (i + 1)+ " de " + cantidad);
            total += preguntas[i].getPeso();
            
            if (preguntas[i].buscar()) {
                puntos += preguntas[i].getPeso();
                correctas++;
            }
        }
        int porcentaje = (int) Math.round(puntos * 100.0 / total);
        
        System.out.println("\n===== RESULTADOS =====");
        System.out.println("Preguntas correctas: " + correctas + "/" + cantidad);
        System.out.println("Puntos obtenidos: " + puntos + "/" + total);
        System.out.println("Porcentaje: " + porcentaje + "%");
        
        return porcentaje;
    }
}
