package commands;

import content.Movie;
import exceptions.InvalidArgumentException;
import util.CollectionManager;

/**
 * Command replace_if_greater class
 */
public class ReplaceIfGreater implements Commandable {
    CollectionManager collection;

    final public static String description = "заменить значение по ключу, если новое значение больше старого";

    /**
     * Constructor of replace_if_greater command
     *
     * @param collection CollectionManager instance
     */
    public ReplaceIfGreater(CollectionManager collection) {
        this.collection = collection;
    }

    @Override
    public void run(String arg) throws InvalidArgumentException {
        long key;
        try {
            key = Long.parseLong(arg);
        } catch (NumberFormatException e) {
            throw new InvalidArgumentException("Эта команда требует аргумент: ключ элемента коллекции");
        }
        if (!collection.contains(key)) {
            throw new InvalidArgumentException("Элемент с таким ключом не существует");
        }
        collection.replaceIfGreater(key, Movie.prompt());
    }

    public String getDescription() {
        return description;
    }
}
