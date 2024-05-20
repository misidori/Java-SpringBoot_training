package it.src.exercises.esercizi_array;

public class Ex12Eliminazione extends Array {
    public static int[] eliminaMinimoMassimo(int[] array)
    {
        int minimo = trovaMinimo(array);
        int massimo = trovaMassimo(array);
        int counter = 0;

        for (int i = 0; i < array.length; i++)
        {
            if (array[i] == minimo || array[i] == massimo)
                counter++;
        }

        int[]   newArray = new int[array.length - counter];
        int     j = 0;

        for (int i = 0; i < array.length; i++)
        {
            if (array[i] != minimo && array[i] != massimo)
            {
                newArray[j] = array[i];
                j++;
            }
        }
        return (newArray);
    }

    public static void eliminaStampa(int[] array)
    {
        int[]   newArray = eliminaMinimoMassimo(array);

        System.out.print("Array originale: ");
        printArray(array, array.length);
        System.out.print("Il nuovo array senza i valori mimino e massimo: ");
        printArray(newArray, newArray.length);
    }

    public static void main(String[] args)
    {
        int[]   array1 = { 8, 16, 5, 6, 12, 5, 10, 5, 16, 9 };
        int[]   array2 = { 3, 10, 4, 10, 8, 5, 2 };
        int[]   array3 = { 3, 8, 6, 3, 6, 3, 3, 8 };

        eliminaStampa(array1);
        eliminaStampa(array2);
        eliminaStampa(array3);
    }
}
