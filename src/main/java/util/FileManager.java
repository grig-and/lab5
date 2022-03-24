package util;

import content.Movie;

import java.io.BufferedReader;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.NavigableMap;
import java.util.TreeMap;

public class FileManager {
    private NavigableMap<Long, Movie> movies;

    public FileManager(String src) {
        this.movies = open(src);
    }

    private NavigableMap<Long, Movie> open(String src){
        NavigableMap<Long, Movie> tmpMovies = new TreeMap<>();
        Path path = Paths.get(src);

        try(
                BufferedReader reader = Files.newBufferedReader(path, StandardCharsets.UTF_8)
        ){
            String line = reader.readLine();
            while (line != null) {
                String[] data = line.split(",");
                Movie movie = Movie.createMovie(tmpMovies.size() + 1, data);
                tmpMovies.put(movie.getId(), movie);
                line = reader.readLine();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }


        return tmpMovies;
    }

    public NavigableMap<Long, Movie> read() {
        return movies;
    }
}
