package commands;

import util.CollectionManager;

public class Clear extends AbsCommand {
    CollectionManager collection;
    final public static String description = "очистить коллекцию";

    public Clear(CollectionManager collection) {
        this.collection = collection;
    }

    @Override
    public void run(String arg) {
        collection.clear();
    }

    public String getDescription() {
        return description;
    }
}
