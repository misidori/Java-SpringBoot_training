package it.src.exercises.esercizi_array;

public class Array {
    public static final String RESET = "\u001B[0m";
    public static final String RED = "\u001B[31m";
    public static final String GREEN = "\u001B[32m";
    public static final String YELLOW = "\u001B[33m";
    public static void printArray(int[] array, int size)
    {
        System.out.print("{ ");
        for (int i = 0; i < size; i++)
        {
            if (i != (size - 1))
                System.out.print(array[i] + ", ");
            else
                System.out.print(array[i] + " ");
        }
        System.out.println("} ");
    }

    public static int trovaMassimo(int[] array)
    {
        int temp = array[0];
        for (int i = 0; i < array.length; i++)
        {
            if (array[i] > temp)
                temp = array[i];
        }
        return (temp);
    }

    public static int trovaMinimo(int[] array)
    {
        int temp = array[0];

        for (int i = 1; i < array.length; i++)
        {
            if (array[i] < temp)
                temp = array[i];
        }
        return (temp);
    }
}
