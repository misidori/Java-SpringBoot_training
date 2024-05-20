package it.src.exercises.negozio;

public class LibroDigitale extends Libro {
    private String  formato;
    private double  dimensione;

    public String getFormato()
    {
        return (formato);
    }

    LibroDigitale(String titolo, String autore, Genere genere, double prezzo, String formato, double dimensione)
    {
        super(titolo, autore, genere, prezzo);
        this.formato = formato;
        this.dimensione = dimensione;
    }

    public double getDimensione()
    {
        return (dimensione);
    }

    @Override
    public void printData()
    {
        System.out.println(getTitolo().concat(", ").concat(getAutore()).concat(", ") + getGenere() + ", " + getPrezzo() + " €, scontato al 10% costa " + calcolaPrezzoScontato() + " €" + ", formato " + formato + ",  peso: " + dimensione + "Kb");
    }
}
