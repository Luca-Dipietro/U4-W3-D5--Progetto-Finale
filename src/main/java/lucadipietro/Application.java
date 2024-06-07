package lucadipietro;

import com.github.javafaker.Faker;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import lucadipietro.dao.ElementoCatalogoDAO;
import lucadipietro.dao.PrestitoDAO;
import lucadipietro.dao.UtenteDAO;

public class Application {

    public static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("u4w3d5");

    public static void main(String[] args) {
        EntityManager em = emf.createEntityManager();
        Faker faker = new Faker();

        ElementoCatalogoDAO ed = new ElementoCatalogoDAO(em);
        UtenteDAO ud = new UtenteDAO(em);
        PrestitoDAO pd = new PrestitoDAO(em);

//        Utente luca = new Utente("Luca", "Dipietro", LocalDate.of(1997, 10, 16));
//        Utente aldo = new Utente("Aldo", "Baglio", LocalDate.of(1958, 9, 28));
//        Utente giovanni = new Utente("Giovanni", "Storti", LocalDate.of(1957, 2, 20));
//        Utente giacomo = new Utente("Giacomo", "Poretti", LocalDate.of(1956, 4, 26));
//        ud.save(luca);
//        ud.save(aldo);
//        ud.save(giovanni);
//        ud.save(giacomo);

//        Libro book1 = new Libro(faker.code().isbn13(), faker.book().title(), faker.number().numberBetween(1950, 2024), faker.number().numberBetween(100, 1500), faker.book().author(), faker.book().genre());
//        Libro book2 = new Libro(faker.code().isbn13(), faker.book().title(), faker.number().numberBetween(1950, 2024), faker.number().numberBetween(100, 1500), faker.book().author(), faker.book().genre());
//        Libro book3 = new Libro(faker.code().isbn13(), faker.book().title(), faker.number().numberBetween(1950, 2024), faker.number().numberBetween(100, 1500), faker.book().author(), faker.book().genre());
//        Libro book4 = new Libro(faker.code().isbn13(), faker.book().title(), faker.number().numberBetween(1950, 2024), faker.number().numberBetween(100, 1500), faker.book().author(), faker.book().genre());
//        Libro book5 = new Libro(faker.code().isbn13(), faker.book().title(), faker.number().numberBetween(1950, 2024), faker.number().numberBetween(100, 1500), faker.book().author(), faker.book().genre());
//        Rivista riv1 = new Rivista(faker.code().isbn13(), faker.company().name(), faker.number().numberBetween(1980, 2024), faker.number().numberBetween(50, 200), Periodicita.MENSILE);
//        Rivista riv2 = new Rivista(faker.code().isbn13(), faker.company().name(), faker.number().numberBetween(1980, 2024), faker.number().numberBetween(50, 200), Periodicita.SEMESTRALE);
//        Rivista riv3 = new Rivista(faker.code().isbn13(), faker.company().name(), faker.number().numberBetween(1980, 2024), faker.number().numberBetween(50, 200), Periodicita.SETTIMANALE);
//        ed.save(book1);
//        ed.save(book2);
//        ed.save(book3);
//        ed.save(book4);
//        ed.save(book5);
//        ed.save(riv1);
//        ed.save(riv2);
//        ed.save(riv3);


    }
}
