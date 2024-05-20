package it.src.exercises.esercizi_array;

public class Ex11SommaZero extends Array {
    public static int[] trovaCoppiaSommaZero(int[] array)
    {
        int j;

        for (int i = 0; i < array.length; i++)
        {
            j = 0;
            while (j < array.length)
            {
                if (array[i] + array[j] == 0)
                {
                    int[]   newArray = new int[2];
                    newArray[0] = array[i];
                    newArray[1] = array[j];
                    return (newArray);
                }
                j++;
            }
        }
        int[]   newArray = new int[0];
        return (newArray);
    }

    public static void trovaStampa(int[] array)
    {
        int[]   newArray = trovaCoppiaSommaZero(array);

        printArray(array, array.length);
        System.out.print("Risultato: ");
        printArray(newArray, newArray.length);
    }

    public static void main(String[] args)
    {
        int[]   array1 = { 5, -2, 9, -7 };
        int[]   array2 = { 6, -4, 4, -3, 5 };
        int[]   array3 = { -9, 7, -6, -8, 6, -7 };

        trovaStampa(array1);
        trovaStampa(array2);
        trovaStampa(array3);
    }
}
