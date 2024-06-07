package lucadipietro;

import com.github.javafaker.Faker;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import lucadipietro.dao.ElementoCatalogoDAO;
import lucadipietro.dao.PrestitoDAO;
import lucadipietro.dao.UtenteDAO;

import java.util.UUID;

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

//        Prestito aldoPrestito = new Prestito(ud.getById("08ae4d74-830b-4805-be62-5995c617e8ca"), ed.getById("9780452293281"), LocalDate.of(2024, 6, 1));
//        Prestito giovanniPrestito = new Prestito(ud.getById("f91c0749-e15c-4a15-8ddb-713b1d7c53f7"), ed.getById("9791952874573"), LocalDate.now());
//        Prestito giacomoPrestito = new Prestito(ud.getById("64b4d178-62d5-4f47-a0f9-8d78e73221dd"), ed.getById("9791986450040"), LocalDate.of(2024, 5, 25));
//        pd.save(aldoPrestito);
//        pd.save(giovanniPrestito);
//        pd.save(giacomoPrestito);

        System.out.println("Ricerca per anno di pubblicazione");
        ed.ricercaAnnoPubblicazione(2011).forEach(System.out::println);
        System.out.println();
        System.out.println("Ricerca per autore");
        ed.ricercaPerAutore("Jonathon Kub").forEach(System.out::println);
        System.out.println();
        System.out.println("Ricerca per titolo");
        ed.ricercaPerTitolo("That Good Night").forEach(System.out::println);
        ed.ricercaPerTitolo("Inc").forEach(System.out::println);
        System.out.println();
        System.out.println("Ricerca elementi in prestito");
        ed.ricercaPerElementiInPrestito(UUID.fromString("08ae4d74-830b-4805-be62-5995c617e8ca")).forEach(System.out::println);

    }
}
