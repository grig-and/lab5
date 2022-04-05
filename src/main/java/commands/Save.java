package commands;

import util.CollectionManager;

/**
 * Command save class
 */
public class Save implements Commandable {
    CollectionManager collection;
    final public static String description = "сохранить коллекцию в файл";

    /**
     * Constructor of save command
     *
     * @param collection CollectionManager instance
     */
    public Save(CollectionManager collection) {
        this.collection = collection;
    }

    @Override
    public void run(String arg) {
        collection.save();
        System.out.println("Сохранено");
    }

    public String getDescription() {
        return description;
    }
}
