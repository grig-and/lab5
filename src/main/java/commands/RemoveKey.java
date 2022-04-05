package commands;

import exceptions.InvalidArgumentException;
import util.CollectionManager;

/**
 * Command remove_key class
 */
public class RemoveKey implements Commandable {
    CollectionManager collection;
    final public static String description = "удалить элемент из коллекции по его ключу";

    /**
     * Constructor of remove_key command
     *
     * @param collection CollectionManager instance
     */
    public RemoveKey(CollectionManager collection) {
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
            throw new InvalidArgumentException("Элемента с таким ключом не существует");
        }
        collection.removeKey(key);
        System.out.println("Успешно удалено");
    }

    public String getDescription() {
        return description;
    }
}
