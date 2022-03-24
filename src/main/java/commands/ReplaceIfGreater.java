package commands;

import util.CollectionManager;

public class ReplaceIfGreater extends AbsCommand {
    CollectionManager collection;

    final public static String description = "заменить значение по ключу, если новое значение больше старого";

    public ReplaceIfGreater(CollectionManager collection) {
        this.collection = collection;
    }

    @Override
    public void run(String arg) {
        //todo
    }

    public String getDescription() {
        return description;
    }
}
