package it.src.exercises.esercizi_base.math;

public class Ex13InitArray {
    public static void main(String[] args)
    {
        int[]   array = new int[10];
        double  sign;

        for (int i = 0; i < 10; i++)
        {
            sign = Math.random();
            if (sign < 0.5)
                sign = -1;
            else
                sign = 1;
            array[i] = (int) ((Math.random() * 20 + 1) * sign);
            System.out.println(array[i]);
        }
    }
}
