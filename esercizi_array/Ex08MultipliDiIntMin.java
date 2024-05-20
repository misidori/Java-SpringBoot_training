package it.src.exercises.esercizi_array;

public class Ex08MultipliDiIntMin extends Array {
    public static boolean verificaTuttiMultipliMinimo(int[] array)
    {
        if (array.length == 0)
            return (false);
        int minimo = trovaMinimo(array);

        for (int i = 0; i < array.length; i++)
        {
            if (array[i] % minimo != 0)
                return (false);
        }
        return (true);
    }

    public static void trovaStampa(int[] array)
    {
        System.out.print("Array: ");
        printArray(array, array.length);
        if (verificaTuttiMultipliMinimo(array) == true)
            System.out.println(GREEN + "I numeri sono tutti multipli di " + trovaMinimo (array) + RESET);
        else
            System.out.println(RED + "I numeri non sono tutti multipli di " + trovaMinimo (array) + RESET);
    }

    public static void main(String[] args)
    {
        int[]   array1 = { 6, 3, 13, 18, 9 };
        int[]   array2 = { 14, 35, 7, 63, 50 };
        int[]   array3 = { 15, 45, 100, 5, 60 };

        trovaStampa(array1);
        trovaStampa(array2);
        trovaStampa(array3);
    }
}
