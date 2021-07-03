import java.util.Set;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

public class Main {

    public static void main(String[] args) {
        Movie movie = new Movie();
        validate(movie);
        movie.setTitle("Batman 23");
        movie.setGenreId(Long.parseLong("3"));
        validate(movie);
        movie.setYear(1400);
        validate(movie);

        movie.setYear(1999);
        validate(movie);

        movie.setRating(400);
        validate(movie);

        movie.setRating(-20);
        validate(movie);

        Studio studio = new Studio();
        validate(studio);

        studio.setName("Disney-Fox-WB");
        validate(studio);

        Genre genre = new Genre();
        validate(genre);

        studio.setName("Drama");
        validate(genre);
    }

    public static void validate(Movie movie) {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("com.launchacademy.movies");
        EntityManager em = emf.createEntityManager();

        Set<ConstraintViolation<Movie>> violations = validator.validate(movie);
        if (violations.size() > 0) {
            for (ConstraintViolation<Movie> violation : violations) {
                System.out.println(violation.getPropertyPath() + ": " + violation.getMessage());
            }
            System.out.println("****************\n");
        } else {
            System.out.println("OK.\n****************\n");
            em.getTransaction().begin();
            em.persist(movie);
            em.getTransaction().commit();
        }
        em.close();
        emf.close();
    }

    public static void validate(Studio studio) {
        ValidatorFactory vf = Validation.buildDefaultValidatorFactory();
        Validator validator = vf.getValidator();
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("com.launchacademy.movies");
        EntityManager em = emf.createEntityManager();

        Set<ConstraintViolation<Studio>> violations = validator.validate(studio);
        if (violations.size() > 0) {
            for (ConstraintViolation<Studio> violation : violations) {
                System.out.println(violation.getPropertyPath() + ": " + violation.getMessage());
            }
            System.out.println("******************\n");
        } else {
            System.out.println("OK.\n******************\n");
            em.getTransaction().begin();
            em.persist(studio);
            em.getTransaction().commit();
        }
    }

    public static void validate(Genre genre) {
        ValidatorFactory vf = Validation.buildDefaultValidatorFactory();
        Validator validator = vf.getValidator();

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("com.launchacademy.movies");
        EntityManager em = emf.createEntityManager();

        Set<ConstraintViolation<Genre>> violations = validator.validate(genre);
        if (violations.size() > 0) {
            for (ConstraintViolation<Genre> violation : violations) {
                System.out.println(violation.getPropertyPath() + ": " + violation.getMessage());
            }
            System.out.println("*****************\n");
        } else {
            System.out.println("OK.\n******************\n");
            em.getTransaction().begin();
            em.persist(genre);
            em.getTransaction().commit();
        }
    }
}

