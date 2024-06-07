package lucadipietro.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.TypedQuery;
import lucadipietro.entities.Prestito;
import lucadipietro.exceptions.NotFoundException;

import java.util.List;
import java.util.UUID;

public class PrestitoDAO {

    private final EntityManager em;

    public PrestitoDAO(EntityManager em) {
        this.em = em;
    }

    public void save(Prestito prestito) {
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.persist(prestito);
        transaction.commit();
        System.out.println("Il prestito di " + prestito.getUtente().getNome() + " dell'elemento " + prestito.getElementoPrestato().getTitolo() + " è stato salvato con successo nel database!");
    }

    public Prestito getById(String id) {
        Prestito prestito = em.find(Prestito.class, UUID.fromString(id));
        if (prestito == null) throw new NotFoundException(UUID.fromString(id));
        return prestito;
    }

    public List<Prestito> ricercaPrestitiScaduti() {
        TypedQuery<Prestito> query = em.createNamedQuery("ricercaPrestitiScaduti", Prestito.class);
        return query.getResultList();
    }

}
