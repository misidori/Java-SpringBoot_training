package it.src.exercises.negozio;

public class Test {
    public static void main(String[] args)
    {
        Libreria        libreria = new Libreria();
        Libro           libro1 = new Libro("I miserabili", "Hugo", Genere.ROMANZO, 12.50);
        Libro           libro2 = new Libro("It", "Stephen King", Genere.THRILLER, 17.00);
        Libro           libro3 = new Libro("LOTR", "Tolkien", Genere.ROMANZO, 20.00);
        Libro           libro4 = new Libro();
        LibroDigitale   libro5 = new LibroDigitale("Shining", "Stephen King", Genere.THRILLER, 19.90, "PDF", 1000);
        Libro           libro6 = new Libreria();

        libro1.printData();     //  I miserabili
        libro2.printData();     //  It
        libro3.printData();     //  LOTR

        libro4.setAutore("Manzoni");
        libro4.setTitolo("I Promessi Sposi");
        libro4.setGenere(Genere.ROMANZO);
        libro4.setPrezzo(10.00);
        libro4.printData();     //  I Promessi Sposi

        libro4.setTitolo("Il Cinque Maggio");
        System.out.println(libro4.getTitolo());

        libro5.printData();     //  LOTR

        libro6 = libreria.creaLibro("Odissea", "Omero", 1, 8.00);
        libro6.printData();     //  Odissea
    }
}
