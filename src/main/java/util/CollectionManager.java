package util;

import content.Movie;
import content.MovieGenre;

import java.time.LocalDate;
import java.util.NavigableMap;

public class CollectionManager {
    private NavigableMap<Long, Movie> movies;
    private FileManager file;
    private LocalDate date;

    public CollectionManager(FileManager fileManager){
        this.file = fileManager;
        this.movies = file.read();
        this.date = LocalDate.now();
    }

    public void clear() {
        movies.clear();
    }

    @Override
    public String toString() {
        String str = "";
        for (Movie movie : movies.values()) {
            str += movie.toString() + "\n";
        }
        return str;
    }

    public String filterGreaterThanGenre(MovieGenre genre) {
        String str = "";
        for (Movie movie : movies.values()) {
            if (movie.getGenre().compareTo(genre) > 0){
                str += movie.toString() + "\n";
            }
        }
        return str;
    }

    public String getInfo() {
        return "type: TreeMap\n" +"date: " + date +"\nsize: " + movies.size();
    }

    public void save() {
    }

    public void insert(Movie movie) {
        movies.put(movie.getId(), movie);
    }

    public String getAscending() {
        return null;
    }

    public void removeGreater(int n) {
        for (Long k : movies.keySet()) {
            if (movies.get(k).getOscarsCount() > n){
                movies.remove(k);
            }
        }
    }

    public void removeGreaterKey(long key) {
        for (Long k : movies.keySet()) {
            if (k > key){
                movies.remove(k);
            }
        }
    }

    public void removeKey(Long key) {
       movies.remove(key);
    }

    public int getSumOscars() {
        int n = 0;
        for (Movie movie : movies.values()) {
            n += movie.getOscarsCount();
        }
        return n;
    }

    public void update(Movie upd) {
        movies.replace(upd.getId(), upd);
    }
}
