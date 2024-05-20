package it.src.exercises.esercizi_base.classi;

public class Rettangolo extends Figura {
    Rettangolo() {}
    Rettangolo(int height, int length) {
        this.height = height;
        this.length = length;
    }

    private int height;
    private int length;

    public int getArea() {
        return (height * length);
    }

    public int getPerimeter() {
        return ((2 * height) + (2 * length));
    }
}
