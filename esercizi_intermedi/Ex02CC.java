package it.src.exercises.esercizi_intermedi;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Ex02CC {
    public static final String RESET = "\u001B[0m";
    public static final String RED = "\u001B[31m";
    public static final String GREEN = "\u001B[32m";
    public static final String YELLOW = "\u001B[33m";
    Scanner         scanner = new Scanner(System.in);

    private double     balance;
    private Double[]   lastFiveMovements = { null, null, null, null, null };

    Ex02CC(double amount)
    {
        this.balance = amount;
    }

    public static void rotateList(Double[] array)
    {
        Double  temp;
        int     sizeArray = array.length;

        temp = array[sizeArray - 1];
        for (int i = sizeArray - 1; i > 0; i--)
        {
            array[i] = array[i - 1];
        }
        array[0] = temp;
    }

    public void deposit(double amount)
    {
        this.balance += amount;
        this.lastFiveMovements[4] = amount;
        rotateList(this.lastFiveMovements);
    }

    public void withdrawal(double amount)
    {
        if (this.balance > amount)
        {
            this.balance -= amount;
            this.lastFiveMovements[4] = amount * -1;
            rotateList(this.lastFiveMovements);
        }
        else
            System.out.println(RED + "ERROR: YOU CAN'T WITHDRAWAL " + amount +
                " €. YOU HAVE ONLY " + this.balance + " € ON YOUR BANK ACCOUNT" + RESET);
    }

    public void checkBalance()
    {
        System.out.println(GREEN + "Your balance is: " + this.balance);
    }

    public void checkLastFiveMovements()
    {
        if (lastFiveMovements[0] == null && lastFiveMovements[1] == null && lastFiveMovements[2] == null
                && lastFiveMovements[3] == null && lastFiveMovements[4] == null)
            System.out.println(YELLOW + "NO MOVEMENTS WERE DONE YET FOR THIS BANK ACCOUNT" + RESET);
        for (int i = lastFiveMovements.length; i > 0; i--)
        {
            if (lastFiveMovements[i - 1] != null)
                System.out.println(i + ". " + lastFiveMovements[i - 1]);
        }
    }

    public static void main(String[] args)
    {
        Ex02CC  bankAccount = new Ex02CC(0);
        Scanner scanner = new Scanner(System.in);
        int     numberOperation = 0;
        double  amount = 0;

        while (true)
        {
            System.out.println(GREEN + "Choose the operation you want to do:" + RESET);
            System.out.println(YELLOW + "[1.CHECK BALANCE]\t[2.DEPOSIT]\n[3.WITHDRAWAL]\t\t" +
                "[4.CHECK LAST 5 MOVEMENTS]\n[5.EXIT]" + RESET);
            try {
                System.out.print("Insert the related number of the operation: ");
                numberOperation = bankAccount.scanner.nextInt();
                switch (numberOperation)
                {
                    case (1):
                        bankAccount.checkBalance();
                        break ;
                    case (2):
                        System.out.print("Digit the import you want to deposit: ");
                        amount = scanner.nextDouble();
                        if (amount > 0)
                            bankAccount.deposit(amount);
                        else
                            System.out.println(RED + "ERROR: YOU CAN'T INSERT A NEGATIVE NUMBER" + RESET);
                        break ;
                    case (3):
                        System.out.print("Digit the import you want to withdrawal: ");
                        amount = scanner.nextDouble();
                        if (amount > 0)
                            bankAccount.withdrawal(amount);
                        else
                            System.out.println(RED + "ERROR: YOU CAN'T INSERT A NEGATIVE NUMBER" + RESET);
                        break;
                    case (4):
                        bankAccount.checkLastFiveMovements();
                        break ;
                    case (5):
                        bankAccount.scanner.close();
                        System.exit(0);
                    default:
                        System.out.println(RED + "You digit the wrong number" + RESET);
                        break ;
                }
            } catch (InputMismatchException e) {
                System.out.println(RED + "ERROR: Your digit was not correct" + RESET);
                bankAccount.scanner.nextLine();
            }
        }
    }
}
