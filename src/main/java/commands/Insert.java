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
        if (arg == null){
            throw new InvalidArgumentException("Эта команда требует аргумент: ключ элемента коллекции");
        }
        if (collection.contains(arg)) {
            throw new InvalidArgumentException("Элемент с таким ключом уже существует");
        }
        collection.insert(arg, Movie.prompt());
        System.out.println("Фильм успешно добавлен");
    }

    public String getDescription() {
        return description;
    }
}
