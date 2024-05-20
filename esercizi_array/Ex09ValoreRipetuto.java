package it.src.exercises.esercizi_array;

public class Ex09ValoreRipetuto extends Array {
    public static Integer trovaValoreRipetuto(int[] array)
    {
        if (array.length == 0)
            return (null);

        int j = 0;

        for (int i = 0; i < array.length; i++)
        {
            j = 0;
            while (j < array.length)
            {
                if (array[i] == array[j] && i != j)
                    return (array[i]);
                j++;
            }
        }
        return (null);
    }

    public static void trovaStampa(int[] array)
    {
        System.out.print("Array: ");
        printArray(array, array.length);
        if (trovaValoreRipetuto(array) != null)
            System.out.println(GREEN + "Il primo numero che si ripete almeno due volte è " + trovaValoreRipetuto (array) + RESET);
        else
            System.out.println(RED + "Non ci sono numeri che si ripetono, oppure l'array è vuoto" + RESET);
    }

    public static void main(String[] args)
    {
        int[]   array1 = { 4, 8, 2, 1, 9 };
        int[]   array2 = { 3, 4, 9, 5, 4, 7 };
        int[]   array3 = { 8, 5, 1, 6, 1, 3, 6, 1 };

        trovaStampa(array1);
        trovaStampa(array2);
        trovaStampa(array3);
    }
}
