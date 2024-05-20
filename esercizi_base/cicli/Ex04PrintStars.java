package it.src.exercises.esercizi_base.cicli;

public class Ex04PrintStars {
    public static void main(String[] args)
    {
        int len_str = 6;
        int n_raws = 6;
        int i = 0;
        int j;

        while (i < n_raws)
        {
            j = 0;
            while (j < len_str)
            {
                System.out.print("*");
                j++;
            }
            System.out.println();
            len_str--;
            i++;
        }
    }
}