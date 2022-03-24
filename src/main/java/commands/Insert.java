package commands;

import content.*;
import util.CLIManager;
import util.CollectionManager;

public class Insert extends AbsCommand {
    CollectionManager collection;
    final public static String description = "добавить новый элемент с заданным ключом";
    public Insert(CollectionManager collection) {
        this.collection = collection;
    }

    @Override
    public void run(String arg) {
        long id = Long.parseLong(CLIManager.prompt("id: "));
        String name = CLIManager.prompt("name: ");
        System.out.println("Coordinates: ");
        float x = Float.parseFloat(CLIManager.prompt("x: "));
        int y = Integer.parseInt(CLIManager.prompt("y: "));
        Coordinates coordinates = new Coordinates(x, y);
        int oscarsCount = Integer.parseInt(CLIManager.prompt("oscarsCount: "));

        MovieGenre genre = MovieGenre.values()[Integer.parseInt(
            CLIManager.prompt("MovieGenre: \n" +
                    "0. COMEDY\n" +
                    "1. ADVENTURE\n" +
                    "2. TRAGEDY\n")
        )];

        MpaaRating mpaaRating = MpaaRating.values()[Integer.parseInt(
            CLIManager.prompt("Mpaa: \n" +
                    "0. PG_13\n" +
                    "1. R\n" +
                    "2. NC_17\n"
                    )
        )];

        System.out.println("Person:");
        String nameP = CLIManager.prompt("name: ");
        long height = Long.parseLong(CLIManager.prompt("height: "));
        String passportID = CLIManager.prompt("passportID: ");
        Color hairColor = Color.values()[Integer.parseInt(
                CLIManager.prompt("hairColor: \n" +
                        "0. GREEN\n" +
                        "1. BLUE\n" +
                        "2. YELLOW\n" +
                        "3. ORANGE\n" +
                        "4. BROWN\n")
        )];

        Country nationality = Country.values()[Integer.parseInt(
                CLIManager.prompt("nationality: \n" +
                        "0. UNITED_KINGDOM\n" +
                        "1. GERMANY\n" +
                        "2. SPAIN\n")

        )];
        Person operator = new Person(nameP, height, passportID, hairColor, nationality);


        Movie movie = new Movie(
                id,
                name,
                coordinates,
                oscarsCount,
                genre,
                mpaaRating,
                operator
        );

        collection.insert(movie);

    }

    public String getDescription() {
        return description;
    }
}
