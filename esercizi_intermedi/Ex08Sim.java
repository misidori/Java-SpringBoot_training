package it.src.exercises.esercizi_intermedi;

import java.util.Scanner;

public class Ex08Sim {
    public static final String RESET = "\u001B[0m";
    public static final String RED = "\u001B[31m";
    public static final String GREEN = "\u001B[32m";
    public static final String YELLOW = "\u001B[33m";
    private String          telephoneNumber;
    private double          credit;
    private Ex08PhoneCall[] listPhoneCalls;
    Scanner scanner = new Scanner(System.in);

    public Ex08Sim() {}
    public Ex08Sim(String telephoneNumber, double credit)
    {
        this.telephoneNumber = telephoneNumber;
        this.credit = credit;
        this.listPhoneCalls = new Ex08PhoneCall[0];
    }

    public String getTelephoneNumber()
    {
        return (telephoneNumber);
    }
    public double getCredit()
    {
        return (credit);
    }

    public int totalMinutes(Ex08Sim sim)
    {
        int  sum = 0;

        for (int i = 0; i < this.listPhoneCalls.length; i++)
        {
            sum += this.listPhoneCalls[i].getPhoneCallTime();
        }

        return (sum);
    }
    public void printPhoneRecords(Ex08Sim sim)
    {
        System.out.println(GREEN + "Telephone user number: " + this.getTelephoneNumber() + RESET);
        System.out.println("Credit left: " + this.getCredit());

        for (int i = 0; i < this.listPhoneCalls.length; i++)
        {
            System.out.println((i + 1) + ". Call to: " + listPhoneCalls[i].getTelephoneNumberCalled() +
                " - Duration: " + listPhoneCalls[i].getPhoneCallTime());
        }
        System.out.println("Total amount minutes calls: " + totalMinutes(sim));
    }
    public Ex08PhoneCall[] makeCall()
    {
        int             numberCalls = this.listPhoneCalls.length;
        Ex08PhoneCall   newPhoneCall = new Ex08PhoneCall();
        int             i = 0;

        System.out.print("Digit the number you want to call: ");
        newPhoneCall.setTelephoneNumberCalled(scanner.nextLine());
        System.out.print("Digit the duration of the call: ");
        newPhoneCall.setPhoneCallTime(scanner.nextInt());
        scanner.nextLine();

        Ex08PhoneCall[]    newListPhoneCalls = new Ex08PhoneCall[numberCalls + 1];
        while (i < this.listPhoneCalls.length)
        {
            newListPhoneCalls[i] = this.listPhoneCalls[i];
            i++;
        }
        newListPhoneCalls[i] = newPhoneCall;
        return (newListPhoneCalls);
    }

    public static void main(String[] args)
    {
        Ex08Sim sim = new Ex08Sim();
        String  telephoneNumber;
        double  credit;
        int     input;


        System.out.print("Insert your telephone number: ");
        telephoneNumber = sim.scanner.nextLine();
        System.out.print("How much credit you want to load into your Sim: ");
        credit = sim.scanner.nextDouble();
        sim.scanner.nextLine();

        sim = new Ex08Sim(telephoneNumber, credit);

        while (true)
        {
            System.out.println(YELLOW + "[1.MAKE A CALL]\t[2.PHONE RECORDS]\t[3.EXIT]" + RESET);
            System.out.print("Choose the operation: ");
            input = sim.scanner.nextInt();
            sim.scanner.nextLine();
            switch (input)
            {
                case (1):
                    sim.listPhoneCalls = sim.makeCall();
                    break ;
                case (2):
                    sim.printPhoneRecords(sim);
                    break ;
                case (3):
                    System.exit(0);
                default:
                    System.out.println(RED + "ERROR: wrong value inserted" + RESET);
            }
        }
    }
}
