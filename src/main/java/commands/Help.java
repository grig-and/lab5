package commands;

import java.util.Map;

public class Help extends AbsCommand {
    final public static String description = "вывести справку по доступным командам";
    private Map<String, AbsCommand> commands;

    public Help(Map<String, AbsCommand> commands) {
        this.commands = commands;
    }

    @Override
    public void run(String arg) {
        for (String key: commands.keySet()){
            System.out.println(key + ": " + commands.get(key).getDescription());
        }
    }
    public String getDescription() {
        return description;
    }
}
