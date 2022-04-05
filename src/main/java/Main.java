import util.CommandManager;
import util.CollectionManager;
import util.FileManager;
import util.CLIManager;

/**
 * Main class
 */
public class Main {
    public static void main(String[] args) {
        FileManager fileManager;
        try {
            fileManager = new FileManager(args[0]);

            CollectionManager collectionManager = new CollectionManager(fileManager);
            CommandManager commandManager = new CommandManager(collectionManager);
            CLIManager cli = new CLIManager(commandManager);
            cli.start();
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Не передан путь");
            System.exit(1);
        }
    }
}
