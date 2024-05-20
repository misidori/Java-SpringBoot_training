package it.src.exercises.esercizi_base.flussi;

import java.util.Scanner;

public class Ex09RockPaperScissor {

    public enum Labels {
        ROCK ("ROCK"),
        SCISSOR ("SCISSOR"),
        PAPER ("PAPER");

        private String value;

        Labels(String value) {
        }

        public String getValue() {
            return value;
        }
    }
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        String  player_1;
        String  player_2;

        System.out.print("Player_1 pick between rock, scissor and paper: ");
        player_1 = scanner.nextLine();
        if (!player_1.equalsIgnoreCase(Labels.ROCK.getValue()) && !player_1.equalsIgnoreCase("scissor") && !player_1.equalsIgnoreCase("paper"))
        {
            System.out.println("Not valid");
            System.exit(0);
        }

        System.out.print("Player_2 pick between rock, scissor and paper: ");
        player_2 = scanner.nextLine();
        if (!player_2.equalsIgnoreCase("rock") && !player_2.equalsIgnoreCase("scissor") && !player_2.equalsIgnoreCase("paper"))
        {
            System.out.println("Not valid");
            System.exit(0);
        }

        if (player_1.equalsIgnoreCase(player_2))
        {
            System.out.println("Tied");
            System.exit(0);
        }

        if (player_1.equalsIgnoreCase("rock") && player_2.equalsIgnoreCase("scissor"))
            System.out.println("Player_1 won");
        else if (player_1.equalsIgnoreCase("rock") && player_2.equalsIgnoreCase("paper"))
            System.out.println("Player_2 won");
        else if (player_1.equalsIgnoreCase("paper") && player_2.equalsIgnoreCase("rock"))
            System.out.println("Player_1 won");
        else if (player_1.equalsIgnoreCase("paper") && player_2.equalsIgnoreCase("scissor"))
            System.out.println("Player_2 won");
        else if (player_1.equalsIgnoreCase("scissor") && player_2.equalsIgnoreCase("paper"))
            System.out.println("Player_1 won");
        else if (player_1.equalsIgnoreCase("scissor") && player_2.equalsIgnoreCase("rock"))
            System.out.println("Player_2 won");
        else
            System.out.println("Error");
    }
}