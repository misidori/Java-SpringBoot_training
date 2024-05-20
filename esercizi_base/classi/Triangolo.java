package it.src.exercises.esercizi_base.classi;

public class Triangolo extends Figura {
    private int height;
    private int length;

    public int getArea()
    {
        return ((length * height) / 2);
    }

    public int getPerimiter()
    {
        return ((2 * length) + height);
    }
}
