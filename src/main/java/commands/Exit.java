package commands;

/**
 * Command exit class
 */
public class Exit implements Commandable {
    final public static String description = "завершить программу";

    @Override
    public void run(String arg) {
        System.exit(0);
    }

    public String getDescription() {
        return description;
    }
}
