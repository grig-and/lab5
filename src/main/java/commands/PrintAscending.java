package commands;

import util.CollectionManager;

/**
 * Command print_ascending class
 */
public class PrintAscending implements Commandable {
    CollectionManager collection;
    final public static String description = "вывести элементы коллекции в порядке возрастания";

    /**
     * Constructor of print_ascending command
     *
     * @param collection CollectionManager instance
     */
    public PrintAscending(CollectionManager collection) {
        this.collection = collection;
    }

    @Override
    public void run(String arg) {
        System.out.println(collection.getAscending());
    }

    public String getDescription() {
        return description;
    }
}
