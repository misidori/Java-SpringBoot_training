package it.src.exercises.esercizi_base.stringhe;

public class Ex25Contrario {
    public String contrario(String str)
    {
        char[]  charArray = str.toCharArray();
        int     str_len = str.length() - 1;
        char[]  newStr = new char[str_len + 1];
        int     i = 0;

        while (str_len >= 0)
        {
            newStr[i] = charArray[str_len];
            i++;
            str_len--;
        }
        return (new String(newStr));
    }

    public static void main(String[] args)
    {
        Ex25Contrario   contr = new Ex25Contrario();
        String          newStr;

        newStr = contr.contrario("Viva Java!");
        System.out.println(newStr);
    }
}
