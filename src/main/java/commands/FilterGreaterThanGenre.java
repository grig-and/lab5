package commands;

import content.MovieGenre;
import exceptions.InvalidArgumentException;
import exceptions.InvalidParameterException;
import util.CollectionManager;

/**
 * Command filter_greater_than_genre class
 */
public class FilterGreaterThanGenre implements Commandable {
    CollectionManager collection;
    final public static String description = "вывести элементы, значение поля genre которых больше заданного";

    /**
     * Constructor of filter_greater_than_genre command
     *
     * @param collection CollectionManager instance
     */
    public FilterGreaterThanGenre(CollectionManager collection) {
        this.collection = collection;
    }

    @Override
    public void run(String arg) throws InvalidArgumentException {
        if (arg == null) {
            throw new InvalidArgumentException("Необходим параметр - жанр");
        }

        try {
            System.out.println(collection.filterGreaterThanGenre(MovieGenre.parse(arg)));
        } catch (InvalidParameterException e) {
            throw new InvalidArgumentException("Нет такого жанра");
        }

    }

    public String getDescription() {
        return description;
    }
}
