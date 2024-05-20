package it.src.exercises.negozio;

public enum Genere {
    FANTASY(1),

    THRILLER(2),
    ROMANZO(3);

    private final int valore;

    private Genere(int valore)
    {
        this.valore = valore;
    }
}

