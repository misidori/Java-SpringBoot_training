package it.src.exercises.esercizi_base.array;

public class Ex19MediaMultipliDiTre {
    private int[]   myArray;
    private int     temp;

    Ex19MediaMultipliDiTre(int[] myArray)
    {
        this.myArray = myArray;
        temp = this.myArray[0];
    }

    public double media_multipli_di_tre(int[] array)
    {
        double totale_multipli_di_tre = 0;
        double counter_multipli_di_tre = 0;
        int     i = 0;

        while (i < array.length)
        {
            if (array[i] % 3 == 0)
            {
                totale_multipli_di_tre += array[i];
                counter_multipli_di_tre++;
            }
            i++;
        }
        if (totale_multipli_di_tre == 0)
            return (0);
        return (totale_multipli_di_tre / counter_multipli_di_tre);
    }

    public static void main(String[] args)
    {
        int     len_args = args.length;
        int[]   inputArray = new int[len_args];
        double  average = 0;
        int     i = 0;

        System.out.print("Hai inserito i seguenti numeri: ");
        for (String stringArgs : args)
        {
            inputArray[i] = Integer.parseInt(stringArgs);
            System.out.print(inputArray[i] + " ");
            i++;
        }
        System.out.println();
        Ex19MediaMultipliDiTre  myArrayMain = new Ex19MediaMultipliDiTre(inputArray);

        average = myArrayMain.media_multipli_di_tre(myArrayMain.myArray);
        if (average == 0)
            System.out.println("Non ci sono numeri multipli di 3 nell'array");
        else
            System.out.println("La media dei numeri multipli di 3 presenti nell'array è " + average);
    }
}
