package it.src.exercises.esercizi_base.array;

public class Ex20StampaZizZag {
    public void printZigZag(int[] array)
    {
        int     i = 0;
        int     j = array.length - 1;
        while (i < array.length / 2)
        {
            System.out.println(array[i]);
            System.out.println(array[j]);
            i++;
            j--;
        }
    }

    public double  average(int[] array)
    {
        double total = 0;
        int i = 0;

        while (i < array.length)
        {
            total += array[i];
            i++;
        }
        return (total / array.length);
    }

    public static void main(String[] args)
    {
        Ex20StampaZizZag    ex = new Ex20StampaZizZag();
        int[]               array = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};

        ex.printZigZag(array);
        System.out.println("The average of the numbers of the array is: " + ex.average(array));
    }
}
