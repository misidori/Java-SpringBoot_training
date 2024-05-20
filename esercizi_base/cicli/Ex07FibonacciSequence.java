package it.src.exercises.esercizi_base.cicli;

public class Ex07FibonacciSequence {
    public static void main(String[] args)
    {
        long    a = 0;
        long    b = 1;
        long    next;
        int     i = 1;

        while (i <= 100)
        {
            if (i != 100)
                System.out.println(i + ")\t" + a);
            else
                System.out.println(i + ")\t" + a);

            next = a + b;
            a = b;
            b = next;
            i++;
        }
    }
}