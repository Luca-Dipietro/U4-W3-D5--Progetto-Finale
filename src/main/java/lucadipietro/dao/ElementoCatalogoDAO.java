package lucadipietro.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import lucadipietro.entities.ElementoCatalogo;
import lucadipietro.exceptions.NotFoundException;

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
}
