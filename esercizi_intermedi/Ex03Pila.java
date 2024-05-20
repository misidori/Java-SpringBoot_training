package it.src.exercises.esercizi_intermedi;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Ex03Pila { //LIFO (Last In, First Out)
    public static final String RESET = "\u001B[0m";
    public static final String RED = "\u001B[31m";
    public static final String GREEN = "\u001B[32m";
    public static final String YELLOW = "\u001B[33m";

    Scanner         scanner = new Scanner(System.in);
    private int[]   array;

    public void printArray(int size)
    {
        int i = 1;

        if (this.array.length == 0)
            System.out.println(YELLOW + "The array is empty" + RESET);
        else
        {
            System.out.println("- - - - - - - - - - ");
            while (size > 0) {
                System.out.println(" " + (size) + "° element: " + this.array[size - 1]);
                size--;
                i++;
            }
            System.out.println("- - - - - - - - - - ");
        }
    }

    public static void initArray(Ex03Pila obj)
    {
        int         numberElements = 0;
        int         input = 0;

        while (true)
        {
            try {
                System.out.print("Digit the number of elements you want the array to be made of (max 5): ");
                numberElements = obj.scanner.nextInt();
                if (numberElements >= 0 && numberElements <= 5)
                {
                    obj.array = new int[numberElements];
                    for (int i = 0; i < obj.array.length; i++)
                    {
                        System.out.print("Insert the number at " + (i + 1) + "° position in the array: ");
                        input = obj.scanner.nextInt();
                        obj.array[i] = input;
                    }
                    break ;
                }
                else
                {
                    System.out.println(RED + "ERROR: number must be between 0 and 5 included" + RESET);
                }
            } catch (InputMismatchException e) {
                System.out.println(RED + "ERROR: Only numbers accepted" + RESET);
                obj.scanner.nextLine();
            }
        }
    }

    public int[] addElement(int[] array, int newElement)
    {
        int[] newArray = new int[array.length + 1];
        int i = 0;

        while (i < array.length) {
            newArray[i] = array[i];
            i++;
        }
        newArray[i] = newElement;

        return (newArray);
    }

    public int[] removeElement(int[] array)
    {
        int[]   newArray = new int[array.length - 1];
        int     i = 0;

        while (i < array.length - 1)
        {
            newArray[i] = array[i];
            i++;
        }
        return (newArray);
    }

    public static void main(String[] args)
    {
        Ex03Pila obj = new Ex03Pila();
        int         input = 0;
        int         newElement = 0;

        initArray(obj);
        obj.printArray(obj.array.length);
        while (true)
        {
            try {
                System.out.println("Choose the operation:\n" + YELLOW +
                        "[1.VIEW LIST]\t\t[2.ADD ELEMENT]\n[3.REMOVE ELEMENT]\t[4.EXIT]" + RESET);
                System.out.print("Insert the related number of the operation: ");
                input = obj.scanner.nextInt();
                switch (input) {
                    case (1):
                        obj.printArray(obj.array.length);
                        break;
                    case (2):
                        if (obj.array.length < 5)
                        {
                            System.out.print("Digit the new element you want to add: ");
                            newElement = obj.scanner.nextInt();
                            obj.array = obj.addElement(obj.array, newElement);
                        }
                        else
                            System.out.println(RED + "ERROR: you have already reached full capacity" + RESET);
                        break;
                    case (3):
                        if (obj.array.length == 0)
                        {
                            System.out.println(RED + "ERROR: the array is already empty" + RESET);
                            break;
                        }
                        obj.array = obj.removeElement(obj.array);
                        System.out.println("The array is now: ");
                        obj.printArray(obj.array.length);
                        break ;
                    case (4):
                        obj.scanner.close();
                        System.exit(0);
                }
            } catch (InputMismatchException e) {
                System.out.println(RED + "ERROR: Only numbers accepted" + RESET);
                obj.scanner.nextLine();
            }
        }
    }
}
