package it.src.exercises.esercizi_base.stringhe;

public class Ex24ContaLettera {
    public int contaLettera(char c, String str)
    {
        int counter = 0;

        for (char ch : str.toCharArray())
        {
            if (ch == c)
                counter++;
        }
        return (counter);
    }

    public static void main(String[] args)
    {
        Ex24ContaLettera counter = new Ex24ContaLettera();

        System.out.println(counter.contaLettera('m', "Ciao mamma"));
    }
}
