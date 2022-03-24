package commands;

import util.CollectionManager;

import java.util.HashMap;
import java.util.Map;

public class CommandManager {
    private Map<String, AbsCommand> commands = new HashMap<>();

    public CommandManager(CollectionManager collectionManager) {
        commands.put("help", new Help(commands));
        commands.put("info", new Info(collectionManager));
        commands.put("show", new Show(collectionManager));
        commands.put("insert", new Insert(collectionManager));
        commands.put("update", new Update(collectionManager));
        commands.put("remove_key", new RemoveKey(collectionManager));
        commands.put("clear", new Clear(collectionManager));
        commands.put("save", new Save(collectionManager));
        commands.put("execute_script", new ExecuteScript(collectionManager));
        commands.put("exit", new Exit());
        commands.put("remove_greater", new RemoveGreater(collectionManager));
        commands.put("replace_if_greater", new ReplaceIfGreater(collectionManager));
        commands.put("remove_greater_key", new RemoveGreaterKey(collectionManager));
        commands.put("sum_of_oscars_count", new SumOfOscarsCount(collectionManager));
        commands.put("filter_greater_than_genre", new FilterGreaterThanGenre(collectionManager));
        commands.put("print_ascending", new PrintAscending(collectionManager));

    }

    public void run(String[] args) {
       commands.get(args[0]).run(args.length > 1 ? args[1] : null);
    }
}
