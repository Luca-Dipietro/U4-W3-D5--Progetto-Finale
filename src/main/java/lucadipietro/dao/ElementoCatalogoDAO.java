package lucadipietro.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.TypedQuery;
import lucadipietro.entities.ElementoCatalogo;
import lucadipietro.entities.Libro;
import lucadipietro.exceptions.NotFoundException;

import java.util.List;

public class ElementoCatalogoDAO {
    private final EntityManager em;

    public ElementoCatalogoDAO(EntityManager em) {
        this.em = em;
    }

    public void save(ElementoCatalogo elementoCatalogo) {
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.persist(elementoCatalogo);
        transaction.commit();
        System.out.println("L'elemento " + elementoCatalogo.getTitolo() + " è stato salvato con successo nel database!");
    }

    public ElementoCatalogo getById(String isbn) {
        ElementoCatalogo elementoCatalogo = em.find(ElementoCatalogo.class, isbn);
        if (elementoCatalogo == null) throw new NotFoundException(isbn);
        return elementoCatalogo;
    }

    public void delete(String isbn) {
        ElementoCatalogo found = this.getById(isbn);

        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.remove(found);
        transaction.commit();
        System.out.println("L'elemento " + found.getTitolo() + " è stato eliminato con successo dal database!");
    }

    public List<ElementoCatalogo> ricercaAnnoPubblicazione(int anno) {
        TypedQuery<ElementoCatalogo> query = em.createNamedQuery("ricercaAnnoPubblicazione", ElementoCatalogo.class);
        query.setParameter("anno", anno);
        return query.getResultList();
    }

    public List<Libro> ricercaPerAutore(String autore) {
        TypedQuery<Libro> query = em.createNamedQuery("ricercaAutore", Libro.class);
        query.setParameter("autore", autore);
        return query.getResultList();
    }
}
