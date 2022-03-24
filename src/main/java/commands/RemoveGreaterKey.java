package commands;

import util.CollectionManager;

public class RemoveGreaterKey extends AbsCommand {
    CollectionManager collection;
    final public static String description = "удалить из коллекции все элементы, превышающие заданный";

    public RemoveGreaterKey(CollectionManager collection) {
        this.collection = collection;
    }


    @Override
    public void run(String arg) {
        collection.removeGreaterKey(Long.parseLong(arg));
    }

    public String getDescription() {
        return description;
    }
}
