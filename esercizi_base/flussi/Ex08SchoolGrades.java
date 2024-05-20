package it.src.exercises.esercizi_base.flussi;

public class Ex08SchoolGrades {
    public static void main(String[] args)
    {
        if (args.length < 2)
        {
            System.out.println("Too few arguments");
            System.exit(1);
        }
        else if (args.length > 2)
        {
            System.out.println("Too many arguments");
            System.exit(1);
        }

        int theory_grade;
        int practice_grade;
        int final_grade;

        try {
            theory_grade = Integer.parseInt(args[0]);
            practice_grade = Integer.parseInt(args[1]);
            if ((theory_grade < -8 || theory_grade > 8)
                    || (practice_grade < 0 || practice_grade > 24))
            {
                if (theory_grade < -8 || theory_grade > 8)
                    System.out.println("The theory grade " + theory_grade + " is out of range");
                else
                    System.out.println("The practice grade " + practice_grade + " is out of range");
                System.exit(1);
            }

            final_grade = practice_grade + theory_grade;

            if (theory_grade <= 0 && practice_grade < 18)
            {
                System.out.println("The student failed");
                System.exit(0);
            }
            if ((theory_grade <= 0 && final_grade > 18) || (theory_grade > 0 && final_grade < 18))
                System.out.println("The student failed");
            else if (final_grade == 31 || final_grade == 32)
                System.out.println("Congratulations: 30 e lode");
            else
                System.out.println("The student passed with gared: " + final_grade);
        }
        catch (NumberFormatException ex)
        {
            System.out.println("Not valid argument");
            System.exit(1);
        }
    }
}