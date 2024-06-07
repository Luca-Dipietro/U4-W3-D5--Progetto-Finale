package lucadipietro.entities;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "elementi_catalogo")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "tipo_elemento")
@NamedQuery(name = "ricercaAnnoPubblicazione", query = "SELECT eg FROM ElementoCatalogo eg WHERE eg.annoPubblicazione = :anno")
@NamedQuery(name = "ricercaTitolo", query = "SELECT eg FROM ElementoCatalogo eg WHERE LOWER(eg.titolo) LIKE LOWER(:titolo)")
@NamedQuery(name = "ricercaElementiInPrestito", query = "SELECT eg FROM ElementoCatalogo eg JOIN eg.prestiti p WHERE p.utente.id = :utenteId AND p.dataRestituzioneEffettiva IS NULL")
public abstract class ElementoCatalogo {

    @Id
    private String isbn;
    private String titolo;
    @Column(name = "anno_pubblicazione")
    private int annoPubblicazione;
    @Column(name = "numero_pagine")
    private int numeroPagine;

    @OneToMany(mappedBy = "elementoPrestato")
    private List<Prestito> prestiti;

    public ElementoCatalogo() {
    }

    public ElementoCatalogo(String isbn, String titolo, int annoPubblicazione, int numeroPagine) {
        this.isbn = isbn;
        this.titolo = titolo;
        this.annoPubblicazione = annoPubblicazione;
        this.numeroPagine = numeroPagine;
    }

    public String getIsbn() {
        return isbn;
    }

    public String getTitolo() {
        return titolo;
    }

    public void setTitolo(String titolo) {
        this.titolo = titolo;
    }

    public int getAnnoPubblicazione() {
        return annoPubblicazione;
    }

    public void setAnnoPubblicazione(int annoPubblicazione) {
        this.annoPubblicazione = annoPubblicazione;
    }

    public int getNumeroPagine() {
        return numeroPagine;
    }

    public void setNumeroPagine(int numeroPagine) {
        this.numeroPagine = numeroPagine;
    }

    @Override
    public String toString() {
        return
                "isbn = " + isbn +
                        ", titolo = '" + titolo + '\'' +
                        ", annoPubblicazione = " + annoPubblicazione +
                        ", numeroPagine = " + numeroPagine
                ;
    }
}
