package it.src.exercises.esercizi_array;

public class Ex05CheckOrder extends Array {
    public static int verificaOrdinamento(int[] array)
    {
        int x = 1;
        int y = 1;
        int lastIndex = array.length - 1;

        while (lastIndex > 0)
        {
            if (array[lastIndex] <= array[lastIndex - 1])
                x++;
            if (array[lastIndex] >= array[lastIndex - 1])
                y++;
            lastIndex--;
        }
        if (x == y)
            return (0);
        else if (x == array.length)
            return (-1);
        else if (y == array.length)
            return (1);
        else
            return (0);
    }

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
        System.out.print("} ");
    }

    public static void printResultChecker(int result)
    {
        if (result == -1)
            System.out.println("Descrescente");
        else if (result == 0)
            System.out.println("Indefinito");
        else
            System.out.println("Crescente");
    }

    public static void checkStamp(int[] array)
    {
        int result;

        printArray(array, array.length);
        result = verificaOrdinamento(array);
        printResultChecker(result);
    }

    public static void main(String[] args)
    {
        int[]   array1 = { 7, 7 };
        int[]   array2 = { 3, 5, 5, 8, 10 };
        int[]   array3 = { 16, 16, 11, 9, 9, 6 };
        int[]   array4 = { 3, 5, 6, 4, 8 };

        checkStamp(array1);
        checkStamp(array2);
        checkStamp(array3);
        checkStamp(array4);
    }
}
