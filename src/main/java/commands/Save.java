package commands;

import util.CollectionManager;

public class Save extends AbsCommand {
    CollectionManager collection;
    final public static String description = "сохранить коллекцию в файл";

    public Save(CollectionManager collection) {
        this.collection = collection;
    }

    @Override
    public void run(String arg) {
        collection.save();
    }

    public String getDescription() {
        return description;
    }
}
