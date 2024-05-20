package it.src.exercises.esercizi_intermedi;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Ex07InsiemeDiStringhe {

    private int         numberString;
    private String[]    arrayString;

    //variabile che rappresenta l'insieme di stringhe considerato dall'oggetto.
    Ex07InsiemeDiStringhe(int numberString)
    {
        this.numberString = numberString;
        arrayString = new String[numberString];
    }
    public String stringaLunga() //restituisce la stringa di lunghezza massima, se vi sono più stringhe di lunghezza max ne restituisce una arbitrariamente.
    {
        int temp = this.arrayString[0].length();
        int indexMaxString = 0;

        for (int i = 0; i < this.numberString; i++)
        {
            if (temp < this.arrayString[i].length())
            {
                temp = this.arrayString[i].length();
                indexMaxString = i;
            }
        }
        return (this.arrayString[indexMaxString]);
    }

    public static int trovaMassimoIntIndex(int[] array)
    {
        int temp = array[0];
        int maxIndex = 0;

        for (int i = 0; i < array.length; i++)
        {
            if (array[i] > temp)
            {
                temp = array[i];
                maxIndex = i;
            }
        }

        return (maxIndex);
    }
    public String spaziStringa() //restituisce la stringa contenente più spazi
    {
        int[]   arrayNumberSpaces = new int[this.arrayString.length];
        int     counterSpaces = 0;
        int     indexMostSpaces = 0;

        for (int i = 0; i < this.arrayString.length; i++)
        {
            char[]  strChar = this.arrayString[i].toCharArray();

            for (int j = 0; j < this.arrayString[i].length(); j++)
            {
                if (strChar[j] == ' ')
                    counterSpaces++;
            }
            arrayNumberSpaces[i] = counterSpaces;
        }
        indexMostSpaces = trovaMassimoIntIndex(arrayNumberSpaces);
        return (this.arrayString[indexMostSpaces]);
    }
    public String[] preStringa(String prefix) //visualizza tutte le stringhe che hanno il prefisso specificato .
    {
        int         counterTrue = 0;

        for (int i = 0; i < this.arrayString.length; i++)
        {
            if (prefix.regionMatches(0, this.arrayString[i], 0, prefix.length()) == true)
                counterTrue++;
        }

        String[]    trueString = new String[counterTrue];
        int         j = 0;

        for (int i = 0; i < this.arrayString.length; i++)
        {
            if (prefix.regionMatches(0, this.arrayString[i], 0, prefix.length()) == true)
            {
                trueString[j] = this.arrayString[i];
                j++;
            }
        }
        return (trueString);
    }

    public static void main(String[] args)
    {
        Scanner     scanner = new Scanner(System.in);
        int         inputInt;
        String      prefix;
        String      longerString;
        String      mostSpacesString;
        String[]    prefixString;

        System.out.print("How many strings do you want in your array? ");
        inputInt = scanner.nextInt();
        scanner.nextLine();

        Ex07InsiemeDiStringhe   obj = new Ex07InsiemeDiStringhe(inputInt);

        for (int i = 0; i < inputInt; i++)
        {
            System.out.print("Write the String you want to insert in the array of Strings: ");
            obj.arrayString[i] = scanner.nextLine();
        }
        longerString = obj.stringaLunga();
        System.out.println("\nLonger String: " + longerString);
        mostSpacesString = obj.spaziStringa();
        System.out.println("\nString with most spaces: " + mostSpacesString);

        System.out.print("\nWhat prefix you're looking for in your String? ");
        prefix = scanner.nextLine();
        prefixString = obj.preStringa(prefix);
        for (int i = 0; i < prefixString.length; i++)
            System.out.println((i + 1) + ". " + prefixString[i]);
    }
}
