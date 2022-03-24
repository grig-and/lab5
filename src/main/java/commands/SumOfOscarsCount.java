package commands;

import util.CollectionManager;

public class SumOfOscarsCount extends AbsCommand {
    CollectionManager collection;

    final public static String description = "вывести сумму значений поля oscarsCount для всех элементов коллекции";

    public SumOfOscarsCount(CollectionManager collection) {
        this.collection = collection;
    }


    @Override
    public void run(String arg) {
        System.out.println(collection.getSumOscars());
    }

    public String getDescription() {
        return description;
    }
}
