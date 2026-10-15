package Projecto1;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
import java.util.Scanner;
/**
 *
 * @author maxim
 */
public class Selec_Mul_Pregunta extends Pregunta {
    private String[] opciones;
    private int respuestaCorrecta;
    

    public Selec_Mul_Pregunta(String text, String[] opciones,int respuestaCorrecta,int peso) {
        super(text, peso);
        this.opciones = opciones;
        this.respuestaCorrecta = respuestaCorrecta;
        
        
    }

    @Override
    public boolean buscar() {
        Scanner teclado = new Scanner(System.in);
        String respuesta;
        
        System.out.println("\n" + getText());
        
        for (int i = 0; i < opciones.length; i++) {
            char letra = (char) ('a'+ i);
            System.out.println(letra + ") " + opciones[i]);
        }
        
        while(true){
            System.out.print("Ingrese una alternativa: ");
            respuesta = teclado.nextLine();
            
            if (respuesta.length() == 1) {
                char letra = respuesta.toLowerCase().charAt(0);
                int posicion = letra - 'a';
                
                if (posicion >= 0 && posicion < opciones.length) {
                    if (posicion == respuestaCorrecta) {
                        System.out.println("Correcto!");
                        return true;
                    }
                    else {
                        System.out.println("Incorrecto!");
                        System.out.println("Respuesta correcta: "
                                + opciones[respuestaCorrecta]);
                        return false;
                    }
                    
                }
            }
            System.out.println("Alternativa no valida. Intente otra vez.");
        }
    }
}
