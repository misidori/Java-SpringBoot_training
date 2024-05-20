package it.src.exercises.negozio;

public class Libreria extends Libro {
    public Libro creaLibro(String titolo, String autore, int valoreGenere, double prezzo)
    {
        Libro   newLibro = new Libro();

        newLibro.setTitolo(titolo);
        newLibro.setAutore(autore);
        newLibro.setGenere(valoreGenere);
        newLibro.setPrezzo(prezzo);

        if (prezzo > 20)
        {
            System.out.println("Più di 20,00 € per un libro? L'inflazione è alle stelle!");
            System.exit(0);
        }
        return (newLibro);
    }
}
