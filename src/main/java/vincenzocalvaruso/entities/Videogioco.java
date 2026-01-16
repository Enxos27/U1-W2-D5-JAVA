package vincenzocalvaruso.entities;

import java.util.Date;

//- Piattaforma (es. PC, PS5, XBox)
//- Durata di gioco (in ore)
//- Genere (enum con lista generi a vostro piacimento)

public class Videogioco extends Gioco {
    private String piattaforma;
    private double durata;
    private Genere genere;


    public Videogioco(int id, String titolo, double prezzo, Date data, String piattaforma, double durata, Genere genere) {
        super(id, titolo, prezzo, data);
        this.piattaforma = piattaforma;
        this.durata = durata;
        this.genere = genere;
    }

    public enum Genere {
        ACTION,
        RPG,
        SPORT,
        HORROR,
        STRATEGY,
        SIMULATION
    }
}
