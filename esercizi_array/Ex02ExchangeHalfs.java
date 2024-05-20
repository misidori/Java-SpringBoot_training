package it.src.exercises.esercizi_array;

public class Ex02ExchangeHalfs extends Array {
    public static void scambiaMeta(int[] array)
    {
        int arrayLength = array.length;
        int half = arrayLength / 2;
        int temp;

        for (int i = 0; i < half; i++)
        {
            temp = array[i];
            array[i] = array[i + half + (arrayLength % 2)];
            array[i + half + (arrayLength % 2)] = temp;
        }
    }

    public static void scambiaStampa(int[] array)
    {
        System.out.println("Original array:");
        printArray(array, array.length);
        scambiaMeta(array);
        System.out.println("After the exchange:");
        printArray(array, array.length);

    }

    public static void main(String[] args) {
        int[] array1 = { 2, 3, 4, 7, 8, 9 };
        int[] array2 = { 4, 2, 6, 5, 3, 3, 9 };

        scambiaStampa(array1);
        scambiaStampa(array2);
    }
}
