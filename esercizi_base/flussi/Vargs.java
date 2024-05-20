package it.src.exercises.esercizi_base.flussi;

public class Vargs {

    public static class MyClass {
        void vargs(int ... arg) {
            System.out.print(arg.length + " parametri interi: ");
            for (int a : arg)
                System.out.print(a + " ");
            System.out.println();
        }

        void vargs(double ... arg) {
            System.out.print(arg.length + " parametri double: ");
            for (double a : arg)
                System.out.print(a + " ");
            System.out.println();
        }
    }

    public static void main(String[] args) {
        String s = "CIAO MAMMA";

        System.out.println(s + "\ns.length(): " + s.length() + "\ns.charAt: " + s.charAt(2));
        System.out.println("s.indexOf: " + s.indexOf("AO") + "\ns.substring: " + s.substring(0, 4));

        MyClass mc = new MyClass();

        mc.vargs(1, 2, 3, 4, 5);
        mc.vargs(6.5, 7.1, 8.6);
        mc.vargs();
    }
}
