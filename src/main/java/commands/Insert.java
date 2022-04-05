package commands;

import content.*;
import exceptions.InvalidArgumentException;
import util.CollectionManager;

/**
 * Command insert class
 */
public class Insert implements Commandable {
    CollectionManager collection;
    final public static String description = "добавить новый элемент с заданным ключом";

    /**
     * Constructor of insert command
     *
     * @param collection CollectionManager instance
     */
    public Insert(CollectionManager collection) {
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
        if (collection.contains(key)) {
            throw new InvalidArgumentException("Элемент с таким ключом уже существует");
        }
        collection.insert(key, Movie.prompt());
        System.out.println("Фильм успешно добавлен");
    }

    public String getDescription() {
        return description;
    }
}
