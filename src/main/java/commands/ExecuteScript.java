package commands;

import util.CollectionManager;

public class ExecuteScript extends AbsCommand {
    final public static String description = "считать и исполнить скрипт из указанного файла";
    public ExecuteScript(CollectionManager collection) {
    }

    @Override
    public void run(String arg) {

    }

    public String getDescription() {
        return description;
    }
}
