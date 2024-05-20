package it.src.exercises.esercizi_base.math;

public class Ex14SquareRoot {
    public static final String RESET = "\u001B[0m";
    public static final String RED = "\u001B[31m";

    public static void main(String[] args)
    {
        if (args.length < 1)
        {
            System.out.println(RED + "Too few args" + RESET);
            return ;
        }
        else if (args.length > 1)
        {
            System.out.println(RED + "Too many args" + RESET);
            return ;
        }

        double number;

        try
        {
            number = Double.parseDouble(args[0]);
        }
        catch (NumberFormatException e)
        {
            System.out.println(RED + "Error: the argument is not a valid number");
            return ;
        }
        System.out.println("The inserted parameter is: " + number);
        System.out.println("Its square foot is: " + Math.sqrt(number));
    }
}
