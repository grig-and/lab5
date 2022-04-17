package util;

import com.opencsv.exceptions.CsvValidationException;
import content.Movie;
import exceptions.InvalidParameterException;

import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.TreeMap;

import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;

/**
 * File manager class
 */
public class FileManager {
    private TreeMap<String, Movie> movies;
    private String src;

    /**
     * Constructor
     *
     * @param src string path
     */
    public FileManager(String src) {
        this.src = src;
        this.movies = open(src);
    }

    /**
     * Opens CSV file with movies
     *
     * @param src string path
     * @return TreeMap of movies
     */
    private TreeMap<String, Movie> open(String src) {
        TreeMap<String, Movie> tmpMovies = new TreeMap<>();
        Path path = Paths.get(src);
        if (!Files.isRegularFile(path)) {
            if (Files.isDirectory(path)) {
                System.out.println("Требуется файл а не директория");
            } else {
                System.out.println("Файл не найден");
            }
            System.exit(1);
        }
        long ind = 0;
        try {
            BufferedReader reader = Files.newBufferedReader(path, StandardCharsets.UTF_8);
            CSVReader csv = new CSVReader(reader);
            String[] line;
            while ((line = csv.readNext()) != null) {
                System.out.println(Arrays.toString(line));
                Movie movie;
                try {
                    movie = Movie.createMovie(line);
                    tmpMovies.put(line[0], movie);

                } catch (InvalidParameterException e) {
                    System.out.println("Ошибка на строке " + ind + ": " + e.getMessage() + ". Пропуск строки.");
                } finally {
                    ind += 1;
                }
            }
        } catch (NoSuchFileException e) {
            System.out.println("Файл не найден");
            System.exit(1);
        } catch (CsvValidationException e) {
            System.out.println("Некорректный файл");
            System.exit(1);
        } catch (IOException e) {
            System.out.println("Ошибка чтения");
            System.exit(1);
        }

        return tmpMovies;
    }

    /**
     * @return movies
     */
    public TreeMap<String, Movie> read() {
        return movies;
    }

    /**
     * Save movies to CSV
     */
    public void save() {
        try {
            CSVWriter writer = new CSVWriter(new FileWriter(src));

            for (String key : movies.keySet()) {
                writer.writeNext(movies.get(key).getCSVMovie(key), false);
                System.out.println(Arrays.toString(movies.get(key).getCSVMovie()));
            }
            writer.close();

        } catch (IOException e) {
            System.out.println("Ошибка записи");
        } catch (Error e) {
            e.printStackTrace();
        }
    }
}
