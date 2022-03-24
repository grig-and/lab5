package commands;

import util.CollectionManager;

public class Info extends AbsCommand{
    CollectionManager collection;
    final public static String description = "вывести в стандартный поток вывода информацию о коллекции";

    public Info(CollectionManager collection) {
        this.collection = collection;
    }

    @Override
    public void run(String arg) {
        System.out.println(collection.getInfo());
    }

    public String getDescription() {
        return description;
    }
}
