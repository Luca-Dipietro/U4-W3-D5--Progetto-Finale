package lucadipietro.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.NamedQuery;

@Entity
@NamedQuery(name = "ricercaAutore", query = "SELECT li FROM Libro li WHERE li.autore = :autore")
public class Libro extends ElementoCatalogo {

    private String autore;
    private String genere;

    public Libro() {
    }

    public Libro(String isbn, String titolo, int annoPubblicazione, int numeroPagine, String autore, String genere) {
        super(isbn, titolo, annoPubblicazione, numeroPagine);
        this.autore = autore;
        this.genere = genere;
    }

    public String getAutore() {
        return autore;
    }

    public void setAutore(String autore) {
        this.autore = autore;
    }

    public String getGenere() {
        return genere;
    }

    public void setGenere(String genere) {
        this.genere = genere;
    }

    @Override
    public String toString() {
        return "Libro {" + super.toString() +
                ", autore = '" + autore + '\'' +
                ", genere = '" + genere + '\'' +
                '}';
    }
}
