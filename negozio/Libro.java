package it.src.exercises.negozio;

public class Libro implements Vendibile, Scontabile {
    private String titolo;
    private String autore;
    private Genere genere;
    private double prezzo;

    Libro()
    {
    }

    Libro(String titolo, String autore, Genere genere, double prezzo)
    {
        this.titolo = titolo;
        this.autore = autore;
        this.genere = genere;
        this.prezzo = prezzo;
    }

    Libro(String titolo, String autore, int valoreGenere, double prezzo)
    {
        this.titolo = titolo;
        this.autore = autore;
        setGenere(valoreGenere);
        this.prezzo = prezzo;
    }

    public double calcolaPrezzo()
    {
        return (prezzo);
    }

    public double calcolaPrezzoScontato()
    {
        return (prezzo - ((prezzo / 100) * 10));
    }

    public void printData()
    {
        System.out.println(getTitolo().concat(", ").concat(getAutore()).concat(", ") + getGenere() + ", " + getPrezzo() + " €, scontato al 10% costa " + calcolaPrezzoScontato() + " €");
    }

    public void setTitolo(String titolo)
    {
        this.titolo = titolo;
    }

    public void setAutore(String autore)
    {
        this.autore = autore;
    }

    public void setGenere(Genere genere)
    {
        this.genere = genere;
    }

    public void setGenere(int valoreGenere)
    {
        switch (valoreGenere)
        {
            case 1:
                this.genere = Genere.FANTASY;
                break;
            case 2:
                this.genere = Genere.ROMANZO;
                break;
            case 3:
                this.genere = Genere.THRILLER;
                break;
            default:
                System.out.println("Genere non valido");
        }
    }

    public void setPrezzo(double prezzo)
    {
        this.prezzo = prezzo;
    }

    public String getTitolo()
    {
        return (titolo);
    }

    public String getAutore()
    {
        return (autore);
    }

    public Genere getGenere()
    {
        return (genere);
    }

    public double getPrezzo()
    {
        return (prezzo);
    }
}
