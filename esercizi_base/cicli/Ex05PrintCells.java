package it.src.exercises.esercizi_base.cicli;

import javax.sound.midi.Soundbank;
import java.sql.SQLOutput;

public class Ex05PrintCells {
    public static void main(String[] args)
    {
        int n_raws = 6;
        int i = 1;
        int j;

        while (i <= n_raws)
        {
            j = 1;
            while (j <= i)
            {
                System.out.print("#");
                j++;
            }
            if (i != n_raws)
                System.out.println();
            i++;
        }
    }
}

