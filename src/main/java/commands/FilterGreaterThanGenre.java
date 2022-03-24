package commands;

import content.MovieGenre;
import util.CollectionManager;

public class FilterGreaterThanGenre extends AbsCommand {
    CollectionManager collection;
    final public static String description = "вывести элементы, значение поля genre которых больше заданного";

    public FilterGreaterThanGenre(CollectionManager collection) {
        this.collection = collection;
    }

    @Override
    public void run(String arg) {
      System.out.println(collection.filterGreaterThanGenre(MovieGenre.valueOf(arg)));
    }

    public String getDescription() {
        return description;
    }
}
