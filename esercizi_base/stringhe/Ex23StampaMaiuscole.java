package it.src.exercises.esercizi_base.stringhe;

public class Ex23StampaMaiuscole {
    public static void main(String[] args)
    {
        String[]  arrayString = {
                "Ciao mamma guarda come mi diverto",
                "lollo Pelle",
                "Hulk Hogan",
                "babbo Natale",
                "Pippo Franco"
        };

        for (String s : arrayString)
        {
            if (Character.isUpperCase(s.charAt(0)))
                System.out.println(s);
        }
    }
}
