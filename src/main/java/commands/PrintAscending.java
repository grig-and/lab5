package commands;

import util.CollectionManager;

public class PrintAscending extends AbsCommand {
    CollectionManager collection;
    final public static String description = "вывести элементы коллекции в порядке возрастания";

    public PrintAscending(CollectionManager collection) {
        this.collection = collection;
    }

    @Override
    public void run(String arg) {
      System.out.println(collection.getAscending());
    }

    public String getDescription() {
        return description;
    }
}
