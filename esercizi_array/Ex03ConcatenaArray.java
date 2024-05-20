package it.src.exercises.esercizi_array;

public class Ex03ConcatenaArray extends Array {
    public static int[] concatenaArray(int[] array1, int[] array2)
    {
        int[]   newArray = new int[array1.length + array2.length];
        int     i = 0;
        int     j = 0;

        while (i < array1.length)
        {
            newArray[i] = array1[i];
            i++;
        }

        while (j < array2.length)
        {
            newArray[i] = array2[j];
            i++;
            j++;
        }

        return (newArray);
    }

    public static void concatenaStampa(int[] array1, int[] array2)
    {
        int[]   arrayConcat;

        System.out.print("array1: ");
        printArray(array1, array1.length);
        System.out.print("array2: ");
        printArray(array2, array2.length);
        System.out.print("result: ");
        arrayConcat = concatenaArray(array1, array2);
        printArray(arrayConcat, arrayConcat.length);
    }

    public static void main(String[] args)
    {
        int[]   array1 = { 12, 7 };
        int[]   array2 = { };
        int[]   array3 = { 10, 5, 16 };

        concatenaStampa(array1, array2);
        concatenaStampa(array1, array3);
        concatenaStampa(array2, array3);
    }
}
