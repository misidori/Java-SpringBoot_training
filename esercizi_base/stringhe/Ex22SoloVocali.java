package it.src.exercises.esercizi_base.stringhe;

public class Ex22SoloVocali {

    public static void main(String[] args)
    {
        String  s = "Ciao mamma guarda come mi diverto";

        for (char c : s.toCharArray())
        {
            if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u'
                    || c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U')
                System.out.print(c);
        }
    }
}
