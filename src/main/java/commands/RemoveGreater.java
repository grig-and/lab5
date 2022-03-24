package commands;

import util.CollectionManager;

public class RemoveGreater extends AbsCommand {
    CollectionManager collection;
    final public static String description = "удалить из коллекции все элементы, превышающие заданный";

    public RemoveGreater(CollectionManager collection) {
        this.collection = collection;
    }


    @Override
    public void run(String arg) {
        collection.removeGreater(Integer.parseInt(arg));
    }

    public String getDescription() {
        return description;
    }
}
