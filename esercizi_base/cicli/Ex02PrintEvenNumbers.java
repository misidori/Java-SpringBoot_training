package it.src.exercises.esercizi_base.cicli;

public class Ex02PrintEvenNumbers {
    public static void main(String[] args)
    {
        for (int i = 20; i > 0; --i)
        {
            if ((i % 2) == 0)
                System.out.println(i);
        }
    }
}