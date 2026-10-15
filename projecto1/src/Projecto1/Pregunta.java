package Projecto1;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author maxim
 */
public abstract class Pregunta {
    protected String text;
    protected int peso;

    public Pregunta(String text, int peso) {
        this.text = text;
        this.peso = peso;
    }

    public String getText() {
        return text;
    }

    public int getPeso() {
        return peso;
    }

    public void setPeso(int peso) {
        if (peso > 0) {
            this.peso = peso;
        }
    }

    public abstract boolean buscar();
}
