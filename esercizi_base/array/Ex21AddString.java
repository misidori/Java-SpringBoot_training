package it.src.exercises.esercizi_base.array;

public class Ex21AddString {
    public String[] addString(String s, String[] a)
    {
        int         arrayLength = a.length;
        String[]    newArrayString = new String[arrayLength + 1];
        int         i = 0;

        for (String str : a)
        {
            newArrayString[i] = str;
            i++;
        }
        newArrayString[i] = s;
        return (newArrayString);
    }

    public static void main(String[] args)
    {
        Ex21AddString   ex = new Ex21AddString();
        String[]        arrayString = {
                "Ciao",
                "Mondo!"
        };
        String[] newArrayString;

        for (String str : arrayString)
        {
            System.out.println(str);
        }

        newArrayString = ex.addString("Hello world!", arrayString);
        System.out.println("--------");
        for (String str : newArrayString)
        {
            System.out.println(str);
        }
    }
}
