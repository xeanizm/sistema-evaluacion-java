package Projecto1;
import java.util.Scanner;
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author maxim
 */
public class TFpregunta extends Pregunta{
     private boolean respuestaCorrecta;

    public TFpregunta(String text, int peso, boolean respuestaCorrecta) {
        super(text, peso);
        this.respuestaCorrecta = respuestaCorrecta;
    }

   

    @Override
    public boolean buscar() {
        Scanner teclado = new Scanner(System.in);
        String respuesta;
        
        System.out.println("\n" + getText());
        
        while (true) {
            System.out.print("Ingrese V o F: ");
            respuesta = teclado.nextLine();
            
            if (respuesta.equalsIgnoreCase("V")) {
                
                if (respuestaCorrecta == true) {
                    System.out.println("Correcto!");
                    return true;
                
                }
                else{
                    System.out.println("Incorrecto!");
                    return false;
                    
                }
            }
            else if (respuesta.equalsIgnoreCase("F")) {
                if (respuestaCorrecta == false) {
                    System.out.println("Correcto!");
                    return true;
                }
                else {
                    System.out.println("Incorrecto!");
                    return false;
                }
                
            }
            else {
                System.out.println("Error. Solo puede ingresar V o F.");
            }
        }
    }
}
