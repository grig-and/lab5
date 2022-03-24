package commands;

public abstract class AbsCommand {
    abstract void run(String arg);
    abstract String getDescription();
}
