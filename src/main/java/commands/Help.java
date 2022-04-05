package commands;

import java.util.Map;
/**
 * Command help class
 */
public class Help implements Commandable {
    final public static String description = "вывести справку по доступным командам";
    /**
     * commands list
     */
    private Map<String, Commandable> commands;

    /**
     * Constructor of help command
     *
     * @param commands commands list
     */
    public Help(Map<String, Commandable> commands) {
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
