package it.src.exercises.esercizi_base.array;

public class Ex16IndexMaxInt {

    private int[]   myArray;
    private int     temp;

    Ex16IndexMaxInt(int[] myArray)
    {
        this.myArray = myArray;
        temp = this.myArray[0];
    }

    public int  getIndexMaxInt()
    {
        int index = 0;
        int max_index = 0;

        for (int element : myArray) {
            if (element > temp) {
                temp = element;
                max_index = index;
            }
            index++;
        }
        return (max_index);
    }

    public static void main(String[] args)
    {
        int         len_args = args.length;
        int[]       inputArray = new int[len_args];
        int         i = 0;

        System.out.print("You inserted these numbers: ");
        for (String stringArgs : args)
        {
            inputArray[i] = Integer.parseInt(stringArgs);
            System.out.print(inputArray[i] + " ");
            i++;
        }
        System.out.println();
        Ex16IndexMaxInt myArray = new Ex16IndexMaxInt(inputArray);
        int             index = 0;

        index = myArray.getIndexMaxInt();
        System.out.println("You can find the biggest at the position n. " + (index + 1));
    }
}
