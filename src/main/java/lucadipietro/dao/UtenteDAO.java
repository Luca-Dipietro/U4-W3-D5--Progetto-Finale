package lucadipietro.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import lucadipietro.entities.Utente;
import lucadipietro.exceptions.NotFoundException;

import java.util.UUID;

public class UtenteDAO {
    private final EntityManager em;

    public UtenteDAO(EntityManager em) {
        this.em = em;
    }

    public void save(Utente utente) {
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.persist(utente);
        transaction.commit();
        System.out.println("L'utente " + utente.getNome() + " è stato salvato con successo nel database!");
    }

    public Utente getById(String id) {
        Utente utente = em.find(Utente.class, UUID.fromString(id));
        if (utente == null) throw new NotFoundException(UUID.fromString(id));
        return utente;
    }
}
