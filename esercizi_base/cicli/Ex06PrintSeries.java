package it.src.exercises.esercizi_base.cicli;

public class Ex06PrintSeries {
    public static void main (String[] args)
    {
/*
        int x = 1;
        int i;
        int n_crescent = 2;
        int n_decreasing;

        while (x <= 6)
        {
            i = 1;
            n_decreasing = 7;
            n_decreasing -= x;
            while (i < n_crescent && n_crescent <= 7)
            {
                System.out.print(i);
                i++;
            }
            n_crescent++;
            System.out.print("    ");
            while (n_decreasing > 0)
            {
                System.out.print(n_decreasing);
                n_decreasing--;
            }
            System.out.println();
            x++;
        }
*/
        int x = 7654321;
        int i = 1;
        int j;
        int n_decreasing;


        while (i <= 6)
        {
            j = 1;
            n_decreasing = 7;
            n_decreasing -= x;
            while (j < 7)
            {
                System.out.print(j);
                if (j == i)
                {
                    System.out.print("    ");
                    x = x % (int)Math.pow(10, (int)Math.log10(x));
                    System.out.println(x);

                    break ;
                }
                j++;
            }
            i++;
        }
    }
}