package it.src.exercises.esercizi_base.array;

public class Ex15MaxInt
{
    private int[]   myArray;
    private int     temp;

    Ex15MaxInt(int[] myArray)
    {
        this.myArray = myArray;
        temp = this.myArray[0];
    }

    int getMaxInt(int[] myArray)
    {
        for (int element : myArray)
        {
            if (element > temp)
                temp = element;
        }
        return (temp);
    }

    public static void main(String[] args)
    {
        int         max_int;
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
        Ex15MaxInt  myArrayMain = new Ex15MaxInt(inputArray);

        max_int = myArrayMain.getMaxInt(myArrayMain.myArray);
        System.out.println("The biggest number is " + max_int);
    }
}
