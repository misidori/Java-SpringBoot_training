package it.src.exercises.esercizi_array;

public class Ex04MostFrequent extends Array {
    public static Boolean valorePiuFrequente(boolean[] array)
    {
        int counterTrue = 0;
        int counterFalse = 0;

        for (int i = 0; i < array.length; i++)
        {
            if (array[i] == true)
                counterTrue++;
            else
                counterFalse++;
        }
        if (counterTrue > counterFalse)
            return (true);
        else if (counterFalse > counterTrue)
            return (false);
        else
            return (null);
    }

    public static void main(String[] args)
    {
        boolean[] array1 = { false, true, false, true, true };
        boolean[] array2 = { false, true, false };
        boolean[] array3 = { false, true, false, true };
        boolean[] array4 = { };

        System.out.println(valorePiuFrequente(array1));
        System.out.println(valorePiuFrequente(array2));
        System.out.println(valorePiuFrequente(array3));
        System.out.println(valorePiuFrequente(array4));
    }
}
