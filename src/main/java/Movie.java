import org.hibernate.validator.constraints.Range;

import java.sql.Timestamp;
import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "movies")
public class Movie {
    @Id
    @SequenceGenerator(name = "movie_generator", sequenceName = "movies_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "movie_generator")
    @Column(name = "id", nullable = false, unique = true)
    private Long id;

    @NotNull(message = "It cannot be empty")
    @Size(min = 1, max = 255)
    @Column(name = "title", nullable = false)
    private String title;

    @NotNull(message = "It cannot be empty")
    @Min(value = 1920, message = "Hey! It's bad year")
    @Column(name = "year", nullable = false)
    private Integer year;

    @Column(name = "synopsis")
    private String synopsis;

    @Range(min = 0, max = 100)
    @Column(name = "rating")
    private Integer rating;

    @Column(name = "created_at")
    private Timestamp createdAt;

    @Column(name = "updated_at")
    private Timestamp updatedAt;

    @NotNull(message = "It cannot be empty")
    @Column(name = "genre_id", nullable = false)
    private Long genreId;

    @Column(name = "studio_id")
    private Long studioId;

    public Long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getSynopsis() {
        return synopsis;
    }

    public void setSynopsis(String synopsis) {
        this.synopsis = synopsis;
    }

    public Integer getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }

    public Timestamp getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Timestamp updatedAt) {
        this.updatedAt = updatedAt;
    }

    public long getGenreId() {
        return genreId;
    }

    public void setGenreId(Long genreId) {
        this.genreId = genreId;
    }

    public long getStudioId() {
        return studioId;
    }

    public void setStudio_id(Long studio_id) {
        this.studioId = studioId;
    }
}
