package commands;

import exceptions.InvalidArgumentException;
import util.CollectionManager;

/**
 * Command remove_greater_key class
 */
public class RemoveGreaterKey implements Commandable {
    CollectionManager collection;
    final public static String description = "удалить из коллекции все элементы, ключ которых превышает заданный";

    /**
     * Constructor of remove_greater_key command
     *
     * @param collection CollectionManager instance
     */
    public RemoveGreaterKey(CollectionManager collection) {
        this.collection = collection;
    }


    @Override
    public void run(String arg) throws InvalidArgumentException {
        if (arg.length() == 0){
            throw new InvalidArgumentException("Эта команда требует аргумент: ключ элемента коллекции");
        }

        System.out.println("Удалено элементов: " + collection.removeGreaterKey(arg));
    }

    public String getDescription() {
        return description;
    }
}
