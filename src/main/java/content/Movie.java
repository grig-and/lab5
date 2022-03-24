package content;

import java.time.LocalDate;
import java.util.NavigableSet;
import java.util.Objects;

public class Movie {


    private long id; //Значение поля должно быть больше 0, Значение этого поля должно быть уникальным, Значение этого поля должно генерироваться автоматически
    private String name; //Поле не может быть null, Строка не может быть пустой
    private Coordinates coordinates; //Поле не может быть null
    private java.time.LocalDate creationDate; //Поле не может быть null, Значение этого поля должно генерироваться автоматически
    private Integer oscarsCount; //Значение поля должно быть больше 0, Поле не может быть null


    private MovieGenre genre; //Поле может быть null
    private MpaaRating mpaaRating; //Поле может быть null
    private Person operator; //Поле может быть null


    public Movie(long id, String name, Coordinates coordinates, Integer oscarsCount, MovieGenre genre, MpaaRating mpaaRating, Person operator) {
        this.id = id;
        this.creationDate = java.time.LocalDate.now();
        this.name = name;
        this.coordinates = coordinates;
        this.oscarsCount = oscarsCount;
        this.genre = genre;
        this.mpaaRating = mpaaRating;
        this.operator = operator;
    }

    public MovieGenre getGenre() {
        return genre;
    }

    public Integer getOscarsCount() {
        return oscarsCount;
    }

    public long getId() {
        return id;
    }

    public static Movie createMovie(long id, String[] data) {
        Movie movie = new Movie(
                id,
                data[0],
                new Coordinates(
                        Float.parseFloat(data[1]),
                        Integer.parseInt(data[2])
                ),
                Integer.parseInt(data[4]),
                MovieGenre.valueOf(data[5]),
                MpaaRating.valueOf(data[6]),
                new Person(
                        data[7],
                        Long.parseLong(data[8]),
                        data[9],
                        Color.valueOf(data[10]),
                        Country.valueOf(data[11])
                )
        );
        return movie;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Movie movie = (Movie) o;
        return id == movie.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Movie: " +
                "\nname= " + name +
                "\ncoordinates=" + coordinates +
                "\ncreationDate=" + creationDate +
                "\noscarsCount=" + oscarsCount +
                "\ngenre=" + genre +
                "\nmpaaRating=" + mpaaRating +
                "\noperator=" + operator;
    }
}