package commands;

import util.CollectionManager;

/**
 * Command show class
 */
public class Show implements Commandable {
    CollectionManager collection;
    final public static String description = "вывести в стандартный поток вывода все элементы коллекции в строковом представлении";

    /**
     * Constructor of show command
     *
     * @param collection CollectionManager instance
     */
    public Show(CollectionManager collection) {
        this.collection = collection;
    }

    @Override
    public void run(String arg) {
        System.out.print(collection.toString());
    }

    public String getDescription() {
        return description;
    }
}
