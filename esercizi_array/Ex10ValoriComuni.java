package it.src.exercises.esercizi_array;

public class Ex10ValoriComuni extends Array {
    public static int[] restringiArray(int[] array) {
        int     counter = 0;
        int[]   newArray;

        for (int i = 0; i < array.length; i++)
        {
            boolean isDuplicate = false;
            for (int j = 0; j < i; j++)
            {
                if (array[i] == array[j])
                {
                    isDuplicate = true;
                    break;
                }
            }
            if (!isDuplicate)
                counter++;
        }

        newArray = new int[counter];
        int newIndex = 0;

        for (int i = 0; i < array.length; i++)
        {
            boolean isDuplicate = false;
            for (int j = 0; j < i; j++)
            {
                if (array[i] == array[j])
                {
                    isDuplicate = true;
                    break;
                }
            }
            if (!isDuplicate)
                newArray[newIndex++] = array[i];
        }

        return (newArray);
    }

    public static int contaValoriComuni(int[] array1, int[] array2)
    {
        int flag = 0;
        int counter = 0;

        for (int i = 0; i < array1.length; i++)
        {
            for (int j = 0; j < array2.length; j++)
            {
                if (array1[i] == array2[j] && flag == 0)
                {
                    counter++;
                    flag = 1;
                }
            }
            flag = 0;
        }
        return (counter);
    }

    public static void contaStampa(int[] array1, int[] array2)
    {
        System.out.print("Array1: ");
        printArray(array1, array1.length);
        System.out.print("Array2: ");
        printArray(array2, array2.length);

        int[] newArray1 = restringiArray(array1);
        int[] newArray2 = restringiArray(array2);

        System.out.println("Valori in comune tra i 2 array: " + contaValoriComuni(newArray1, newArray2));
    }

    public static void main(String[] args)
    {
        int[]   array1_1 = { 4, 7, 12, 7, 5 };
        int[]   array1_2 = { 9, 3, 2, 11, 3 };

        int[]   array2_1 = { 2, 13, 6, 2, 6 };
        int[]   array2_2 = { 1, 5, 7, 2, 9 };

        int[]   array3_1 = { 6, 10, 4, 3, 4 };
        int[]   array3_2 = { 4, 8, 10, 5, 10 };

        contaStampa(array1_1, array1_2);
        contaStampa(array2_1, array2_2);
        contaStampa(array3_1, array3_2);
    }
}
