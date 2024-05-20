package it.src.exercises.esercizi_base.array;

import java.util.Scanner;

public class Ex17BooleanContains {
    public boolean contains(int e, int[] array)
    {
        for (int element : array)
        {
            if (e == element)
                return (true);
        }
        return (false);
    }

    //public boolean contains(Object e, Object[] array) {}

    public static void main(String[] args)
    {
        int[]   array = {99, 22, 33, 44, 11};
        int     e;
        Scanner             scanner = new Scanner(System.in);
        Ex17BooleanContains checker = new Ex17BooleanContains();
        boolean             it_contains;

        System.out.print("Insert an int number: ");
        int number = scanner.nextInt();
        it_contains = checker.contains(number, array);
        if (it_contains)
            System.out.println(number + " is contained in the array");
        else
            System.out.println((number + " is not contained in the array"));
        scanner.close();
    }
}
