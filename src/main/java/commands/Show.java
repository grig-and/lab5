package commands;

import util.CollectionManager;

public class Show extends AbsCommand {
    CollectionManager collection;
    final public static String description = "вывести в стандартный поток вывода все элементы коллекции в строковом представлении";

    public Show(CollectionManager collection) {
        this.collection = collection;
    }

    @Override
    public void run(String arg) {
        System.out.println(collection.toString());
    }

    public String getDescription() {
        return description;
    }
}
