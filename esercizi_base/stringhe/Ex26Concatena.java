package it.src.exercises.esercizi_base.stringhe;

public class Ex26Concatena {
    public static final String RESET = "\u001B[0m";
    public static final String RED = "\u001B[31m";

    public static void main(String[] args)
    {
        String  longString = new String();
        if (args.length == 3)
        {
            for (int i = 0; i < 3; i++)
            {
                longString = longString.concat(args[i]);
            }
            System.out.println(longString);
        }
        else
        {
            System.out.println(RED + "Error: You inserted " + args.length + " parameters. The program accepts only 3 parameters" + RESET);
        }
    }
}
