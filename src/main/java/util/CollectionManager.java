package util;

import content.Movie;
import content.MovieGenre;

import java.time.LocalDate;
import java.util.*;

/**
 * Collection manager class
 */
public class CollectionManager {
    private TreeMap<String, Movie> movies;
    private FileManager file;
    private LocalDate date;

    /**
     * Constructor
     *
     * @param fileManager FileManager
     */
    public CollectionManager(FileManager fileManager) {
        this.file = fileManager;
        this.movies = file.read();
        this.date = LocalDate.now();
    }

    /**
     * Clear collection
     */
    public void clear() {
        movies.clear();
    }

    @Override
    public String toString() {
        String str = "";
        for (String k : movies.keySet()) {
            str += k + ":\n" + movies.get(k).toString() + "\n";
        }
        if (str.isEmpty()) {
            str += "Коллекция пуста\n";
        }
        return str;
    }

    /**
     * Filter movie greater then genre
     *
     * @param genre MovieGenre for filter
     * @return filtered movies
     */
    public String filterGreaterThanGenre(MovieGenre genre) {
        String str = "";
        for (Movie movie : movies.values()) {
            if (movie.getGenre() == null) {
                continue;
            }
            if (movie.getGenre().compareTo(genre) > 0) {
                str += movie + "\n";
            }
        }
        return str;
    }

    /**
     * @return info about collection
     */
    public String getInfo() {
        return "type: " + movies.getClass() + "\n" + "date: " + date + "\nsize: " + movies.size();
    }

    /**
     * Save to CSV
     */
    public void save() {
        file.save();
    }

    /**
     * @param key key
     * @return is collection contains key
     */
    public boolean contains(String key) {
        return movies.containsKey(key);
    }

    public boolean containsID(Long id) {
        for (Movie m : movies.values()) {
            if (m.getId() == id) {
                return true;
            }
        }
        return false;
    }

    /**
     * Insert movie by key
     *
     * @param key   key
     * @param movie movie
     */
    public void insert(String key, Movie movie) {
        movies.put(key, movie);
    }

    /**
     * @return movies in ascending by OscarsCount orfer
     */
    public String getAscending() {
        Map<String, Movie> sorted = new TreeMap<>((k1, k2) -> {
            Movie v1 = movies.get(k1);
            Movie v2 = movies.get(k2);
            if (v1.getOscarsCount() > v2.getOscarsCount()) {
                return 1;
            } else if (v1.getOscarsCount() == v2.getOscarsCount()) {
                return 0;
            } else {
                return -1;
            }
        });
        sorted.putAll(movies);

        String str = "";
        for (String k : sorted.keySet()) {
            str += k + ":\n" + sorted.get(k).toString() + "\n";
        }
        if (str.isEmpty()) {
            str += "Коллекция пуста\n";
        }
        return str;

    }

    /**
     * Remove all elements with OC > entered
     *
     * @param movie movie for comparation
     * @return n of removed elements
     */
    public int removeGreater(Movie movie) {
        int i = 0;
        for (String k : movies.keySet()) {
            if (movies.get(k).getOscarsCount() > movie.getOscarsCount()) {
                movies.remove(k);
                i += 1;
            }
        }
        return i;
    }

    /**
     * Remove all with key > entered key
     *
     * @param key key
     * @return n of removed elements
     */
    public int removeGreaterKey(String key) {
        int i = 0;

        Iterator iterator = movies.keySet().iterator();
        while (iterator.hasNext()) {
            String k = (String) iterator.next();
            if (k.compareTo(key)>0) {
                iterator.remove();
                i += 1;
            }
        }
        return i;
    }

    /**
     * Remove by key
     *
     * @param key key
     */
    public void removeKey(String key) {
        movies.remove(key);
    }

    /**
     * @return sum of oscars
     */
    public int getSumOscars() {
        int n = 0;
        for (Movie movie : movies.values()) {
            n += movie.getOscarsCount();
        }
        return n;
    }

    /**
     * Update existing element
     *
     * @param id    id
     * @param movie movie
     */
    public void update(Long id, Movie movie) {
        for (String k : movies.keySet()) {
            if (movies.get(k).getId() == id) {
                movies.put(k, movie);
                return;
            }
        }
    }

    /**
     * Replace if OC greater
     *
     * @param key   key
     * @param movie movie
     */
    public void replaceIfGreater(String key, Movie movie) {
        if (movies.get(key).getOscarsCount() < movie.getOscarsCount()) {
            movies.put(key, movie);
            System.out.println("Заменено");
        } else {
            System.out.println("Не заменено");
        }
    }

}
