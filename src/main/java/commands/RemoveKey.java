package commands;

import util.CollectionManager;

public class RemoveKey extends AbsCommand {
    CollectionManager collection;

    final public static String description = "удалить элемент из коллекции по его ключу";

    public RemoveKey(CollectionManager collection) {
        this.collection = collection;
    }


    @Override
    public void run(String arg) {
        collection.removeKey(Long.parseLong(arg));

    }

    public String getDescription() {
        return description;
    }
}
