/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Projecto1;
import java.util.Scanner;
/**
 *
 * @author maxim
 */
public class ExamenDemo {
    
    public static void main(String args[]){
        
        Scanner teclado = new Scanner(System.in);
        Exam examen = new Exam();
        RegistroNotas registro = new RegistroNotas();
        
        // Preguntas iniciales de verdadero y falso
        examen.agregaPregunta(new TFpregunta("Java es un lenguaje de programacion.", 1, true));
        examen.agregaPregunta(new TFpregunta("Una variable int almacena textos.", 1, false));
        examen.agregaPregunta(new TFpregunta("Un ciclo for permite repetir instrucciones.",1 ,true ));
        
        // Preguntas iniciales de seleccion multiple
        
        String[] opciones1 = {"int", "String", "boolean"};
        examen.agregaPregunta(new Selec_Mul_Pregunta("Que tipo de dato almacena numeros enteros?",opciones1, 0, 2));
        
        String[] opciones2 = {"while", "print", "class"};
        examen.agregaPregunta(new Selec_Mul_Pregunta("Que instruccion permite repetir un bloque?",opciones2, 0, 2));
        
        String[] opciones3 = {"Scanner", "System", "String"};
        examen.agregaPregunta(new Selec_Mul_Pregunta("Que clase permite leer datos del teclado?",opciones3, 0, 2));
        
        // Preguntas iniciales de respuesta corta
        
        examen.agregaPregunta(new Resp_Cortas_Preguntas("Que palabra se utiliza para crear una clase?", "class", 1));
        examen.agregaPregunta(new Resp_Cortas_Preguntas("Que palabra permite heredar de otra clase?","extends", 1));
        examen.agregaPregunta(new Resp_Cortas_Preguntas("Que tipo de dato representa verdadero o falso?","boolean", 1));
        
        int opcion = 0;
        
        while (opcion != 5) {
            System.out.println("\n===== SISTEMA DE EXAMENES =====");
            System.out.println("1. Realizar examen");
            System.out.println("2. Ver preguntas");
            System.out.println("3. Agregar pregunta");
            System.out.println("4. Eliminar pregunta");
            System.out.println("5. Ver notas de estudiantes");
            System.out.println("6. Salir");
            System.out.print("Seleccione una opcion: ");
            
            String entrada = teclado.nextLine();
            
            try {
                opcion = Integer.parseInt(entrada);
            } 
            catch (NumberFormatException e) {
                System.out.println("Debe ingresar un numero.");
                continue;
            }
            switch (opcion){
                
                case 1:
                    System.out.print("Ingrese nombre del estudiante: ");
                    String nombre = teclado.nextLine();
                    if (nombre.trim().isEmpty()) {
                        System.out.println("El nombre no puede estar vacio.");
                        break;
                    }
                    int porcentaje = examen.darExam();
                    registro.guardarNota(nombre, porcentaje);
                    
                    break;
                    
                case 2:
                    examen.mostrarPreguntas();
                    break;
                    
                case 3:

                    System.out.println("\nTIPOS DE PREGUNTA");
                    System.out.println("1. Verdadero o falso");
                    System.out.println("2. Seleccion multiple");
                    System.out.println("3. Respuesta corta");
                    System.out.print("Seleccione tipo: ");
                    
                    int tipo;
                     try {
                        tipo = Integer.parseInt(teclado.nextLine());
                    }
                    catch (NumberFormatException e) {
                        System.out.println("Tipo no valido.");
                        break;
                    }
                    if (tipo < 1 || tipo > 3) {
                        System.out.println("Tipo no valido.");
                        break;
                    }
                    
                    System.out.print("Escriba la pregunta: ");
                    String texto = teclado.nextLine();
                    
                    if (texto.trim().isEmpty()) {
                        System.out.println("La pregunta no puede estar vacia.");
                        break;
                    }
                    System.out.print("Ingrese el peso: ");
                    int peso;
                    try {
                        peso = Integer.parseInt(teclado.nextLine());
                    }
                    catch (NumberFormatException e) {
                        System.out.println("Peso no valido.");
                        break;
                    }
                    if (peso <= 0) {
                        System.out.println("El peso debe ser positivo.");
                        break;
                    }
                    if (tipo == 1) {
                        String respuesta;
                        while (true) {
                            System.out.print("Respuesta correcta (V/F): ");
                            respuesta = teclado.nextLine();

                            if (respuesta.equalsIgnoreCase("V")|| respuesta.equalsIgnoreCase("F")) {
                                break;
                            }
                            System.out.println("Solo ingrese V o F.");
                            
                        }
                        boolean correcta = respuesta.equalsIgnoreCase("V");
                        examen.agregaPregunta(new TFpregunta(texto, peso, correcta));
                    }
                    else if (tipo == 2) {
                       System.out.print("Cantidad de alternativas (2 a 5): ");
                       int cantidad;
                       
                        try {
                            cantidad = Integer.parseInt(teclado.nextLine());
                        }
                        catch (NumberFormatException e) {
                            System.out.println("Cantidad no valida.");
                            break;
                        }
                        if (cantidad < 2 || cantidad > 5) {
                            System.out.println("Debe ingresar entre 2 y 5.");
                            break;
                        }
                        String[] opciones = new String[cantidad];
                        
                        for (int i = 0; i < cantidad; i++) {
                            System.out.print("Alternativa "+ (char) ('a' + i) + ": ");opciones[i] = teclado.nextLine();
                        }
                        System.out.print("Numero de respuesta correcta (1 a "+ cantidad + "): ");

                        int correcta;
                        try {
                            correcta = Integer.parseInt(teclado.nextLine());
                        }
                        catch (NumberFormatException e) {
                            System.out.println("Respuesta no valida.");
                            break;
                        }
                        if (correcta < 1 || correcta > cantidad) {
                            System.out.println("Respuesta fuera de rango.");
                            break;
                        }
                        examen.agregaPregunta(new Selec_Mul_Pregunta(texto, opciones, correcta - 1, peso));
                    }
                    else {

                        System.out.print("Respuesta correcta: ");
                        String correcta = teclado.nextLine();

                        if (correcta.trim().isEmpty()) {
                            System.out.println("Respuesta vacia.");
                            break;
                        }
                        examen.agregaPregunta(new Resp_Cortas_Preguntas(texto, correcta, peso));
                        
                    }
                    break;
                
                    
                case 4:
                    examen.mostrarPreguntas();
                    System.out.print("Numero de pregunta a eliminar: ");
                    try {
                        int numero = Integer.parseInt(teclado.nextLine());
                        examen.eliminarPregunta(numero);
                    }
                    catch (NumberFormatException e) {
                        System.out.println("Debe ingresar un numero.");
                    }
                    break;
                case 5:
                    registro.mostrarNotas();
                    break;
                    
                    
                case 6:
                    System.out.println("Gracias por utilizar el sistema.");
                    break;
                
                default:
                    System.out.println("Opcion no valida.");
                    
                    
                    
                 
            }
        }
        teclado.close();
           
    }
    
}
