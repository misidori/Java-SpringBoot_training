package it.src.exercises.esercizi_base.math;

public class Ex12ContinuaFino {
    public static void main(String[] args)
    {
        int i;

        do
        {
            i = (int) (Math.random() * 15 + 1);
            System.out.println(i);
        }
        while ((i % 3) != 0);
    }
}
