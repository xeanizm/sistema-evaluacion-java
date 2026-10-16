package Projecto1;
import java.util.Scanner;

public class Resp_Cortas_Preguntas extends Pregunta {
     private String respuestaCorrecta;

    public Resp_Cortas_Preguntas(String text, String respuestaCorrecta, int peso) {
        super(text, peso);
        this.respuestaCorrecta = respuestaCorrecta;
    }

    @Override
    public boolean buscar() {

        Scanner teclado = new Scanner(System.in);

        System.out.println("\n" + getText());
        System.out.print("Respuesta: ");

        String respuesta = teclado.nextLine();

        if (respuesta.trim().equalsIgnoreCase(respuestaCorrecta.trim())) {
            System.out.println("Correcto!");
            return true;
        } else {
            System.out.println("Incorrecto!");
            System.out.println("Respuesta correcta: " + respuestaCorrecta);
            return false;
        }
    }
    
 
}
