package it.src.exercises.esercizi_base.cicli;

public class Ex03TimesTen {
    public static void main (String[] args)
    {
        int number = 0;

        try
        {
            number = Integer.parseInt(args[0]);
        }
        catch (NumberFormatException ex)
        {
            System.out.println("Number not valid");
            System.exit(1);
        }

        for (int i = 1; i <= 10; i++)
        {
            System.out.println(number * i);
        }
    }
}