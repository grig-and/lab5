import commands.CommandManager;
import util.CollectionManager;
import util.FileManager;
import util.CLIManager;

public class Main {
    public static void main (String[] args) {
        FileManager fileManager = new FileManager(args[0]);
        CollectionManager collectionManager = new CollectionManager(fileManager);
        CommandManager commandManager = new CommandManager(collectionManager);
        CLIManager cli = new CLIManager(commandManager);
        cli.start();
    }
}
