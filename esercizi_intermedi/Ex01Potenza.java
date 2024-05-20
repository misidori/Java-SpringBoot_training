package it.src.exercises.esercizi_intermedi;

import java.util.Scanner;

public class Ex01Potenza {

    private int base;

    Ex01Potenza(int base)
    {
        this.base = base;
    }

    public void cambiobase(int base)
    {
        this.base = base;
    }

    public void pow()
    {
        System.out.println(this.base + " alla potenza di 2 è " + (this.base * this.base));
    }

    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Di quale numero vuoi calcolare la potenza? ");
        int numeroIntero = scanner.nextInt();
        Ex01Potenza obj = new Ex01Potenza(numeroIntero);
        obj.pow();

        System.out.print("Di quale altro numero vuoi calcolare la potenza? ");
        numeroIntero = scanner.nextInt();
        obj.cambiobase(numeroIntero);
        obj.pow();
    }
}
