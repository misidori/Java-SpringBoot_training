package it.src.exercises.esercizi_array;

public class Ex01Rotation extends Array {
    public static void ruotaAvanti(int[] array)
    {
        int temp;
        int sizeArray = array.length;

        temp = array[sizeArray - 1];
        for (int i = sizeArray - 1; i > 0; i--)
        {
            array[i] = array[i - 1];
        }
        array[0] = temp;
    }

    public static void routaStampa(int[] array)
    {
        System.out.println("Original array:");
        printArray(array, array.length);
        ruotaAvanti(array);
        System.out.println("After rotation:");
        printArray(array, array.length);
    }

    public static void main(String[] args)
    {
        int[] array1 = { 4, 9 };
        int[] array2 = { 4, 9, 3 };
        int[] array3 = { 4, 9, 3, 7 };

        routaStampa(array1);
        routaStampa(array2);
        routaStampa(array3);
    }
}
