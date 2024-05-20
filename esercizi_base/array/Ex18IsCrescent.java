package it.src.exercises.esercizi_base.array;

public class Ex18IsCrescent {
    public boolean isCrescent(int[] array)
    {
        int i = 0;

        while (i + 1 < array.length)
        {
            if ((array[i] > array[i + 1]))
                return (false);
            i++;
        }
        return (true);
    }

    public int  getIndexMaxInt(int[] myArray)
    {
        int temp;
        int index = 0;
        int max_index = 0;
        temp = myArray[0];

        for (int element : myArray) {
            if (element > temp) {
                temp = element;
                max_index = index;
            }
            index++;
        }
        return (max_index);
    }

    public int mostRecurrent(int[] array)
    {
        int maxOccurrence = 0;
        int mostRecurrentNumber = 0;

        for (int i = 0; i < array.length; i++)
        {
            int counter_occurrences = 1;

            for (int j = i + 1; j < array.length; j++)
            {
                if (array[i] == array[j])
                {
                    counter_occurrences++;
                }
            }

            if (counter_occurrences > maxOccurrence)
            {
                maxOccurrence = counter_occurrences;
                mostRecurrentNumber = array[i];
            }
        }
        return (mostRecurrentNumber);
    }

    public static void main(String[] args)
    {
        int[]   array_1 = {22, 33, 44, 55};
        int[]   array_2 = {1, 2, 3, 5, 4, 6, 7};
        int[]   array_3 = {1, 4, 1, 33, 98, 1, 4, 2, 1};
        int     recurrent_number;
        boolean array_1_crescent;
        boolean array_2_crescent;
        Ex18IsCrescent  checker = new Ex18IsCrescent();

        array_1_crescent = checker.isCrescent(array_1);
        array_2_crescent = checker.isCrescent(array_2);

        if (array_1_crescent)
            System.out.println("array_1 is crescent");
        else
            System.out.println("array_1 is not crescent");
        if (array_2_crescent)
            System.out.println("array_2 is crescent");
        else
            System.out.println("array_2 is not crescent");

        recurrent_number = checker.mostRecurrent(array_3);
        System.out.println("The most recurrent number in array_3 is " + recurrent_number);
    }
}
