package it.src.exercises.esercizi_array;

public class Ex06Compact extends Array {

    public static int[] compattaPariDispari(int[] array)
    {
        int[]   newArray = new int[array.length];
        int     i = 0;
        int     j = 0;
        int     counterEvenNumbers = 0;

        while (i < array.length)
        {
            if (array[i] % 2 == 0)
            {
                newArray[j] = array[i];
                j++;
            }
            i++;
        }
        i = 0;
        while (i < array.length)
        {
            if (array[i] % 2 != 0)
            {
                newArray[j] = array[i];
                j++;
            }
            i++;
        }
        return (newArray);
    }

    public static void compattaStampa(int[] array)
    {
        int[]   newArray;

        System.out.print("Original array: ");
        printArray(array, array.length);
        newArray = compattaPariDispari(array);
        System.out.print("After compattaPariDispari(): ");
        printArray(newArray, newArray.length);
    }

    public static void main(String[] args)
    {
        int[]   array1 = { 9, 5, 4, 8, 2 };
        int[]   array2 = { 3, 2, 7, 9, 4, 8, 5 };

        compattaStampa(array1);
        compattaStampa(array2);
    }
}
