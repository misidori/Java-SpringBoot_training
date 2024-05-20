package it.src.exercises.esercizi_array;

public class Ex07MaxIndex extends Array {
    public static int[] trovaPosizioniMassimo(int[] array)
    {
        int max;
        int countMax = 0;

        max = trovaMassimo(array);
        for (int i = 0; i < array.length; i++)
        {
            if (array[i] == max)
                countMax++;
        }

        int[]   arrayMaxIndex = new int[countMax];
        int     j = 0;

        for (int i = 0; i < array.length; i++)
        {
            if (array[i] == max)
            {
                arrayMaxIndex[j] = i;
                j++;
            }
        }
        return (arrayMaxIndex);
    }

    public static void trovaStampa(int[] array)
    {
        int[]   arrayPosizioniMassimo;

        System.out.print("Original array: ");
        printArray(array, array.length);
        arrayPosizioniMassimo = trovaPosizioniMassimo(array);
        System.out.print("After arrayPosizioniMassimo(): ");
        printArray(arrayPosizioniMassimo, arrayPosizioniMassimo.length);
    }

    public static void main(String[] args)
    {
        int[]   array1 = { 4, 2, 6, 5 };
        int[]   array2 = { 2, 9, 4, 3, 9, 5 };
        int[]   array3 = { 7, 2, 7, 5, 1, 7 };

        trovaStampa(array1);
        trovaStampa(array2);
        trovaStampa(array3);
    }
}
