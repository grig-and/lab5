package commands;
import util.CollectionManager;

/**
 * Command clear class
 */
public class Clear implements Commandable {
    CollectionManager collection;
    final public static String description = "очистить коллекцию";

    /**
     * Constructor of clear command
     * @param collection CollectionManager instance
     */
    public Clear(CollectionManager collection) {
        this.collection = collection;
    }

    @Override
    public void run(String arg) {
        collection.clear();
        System.out.println("Успешно очищено");
    }

    public String getDescription() {
        return description;
    }
}
