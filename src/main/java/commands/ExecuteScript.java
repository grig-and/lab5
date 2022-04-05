package commands;

import exceptions.InvalidArgumentException;
import util.CLIManager;
import util.CommandManager;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.InvalidPathException;
import java.nio.file.Paths;
import java.util.HashSet;

/**
 * Command execute_script class
 */
public class ExecuteScript implements Commandable {
    final public static String description = "считать и исполнить скрипт из указанного файла";
    private CommandManager commandManager;

    /**
     * Constructor of execute_script command
     * @param commandManager CommandManager instance
     */
    public ExecuteScript(CommandManager commandManager) {
        this.commandManager = commandManager;
    }

    /**
     * history of executed files
     */
    private static HashSet<String> history = new HashSet<>();

    @Override
    public void run(String arg) throws InvalidArgumentException {
        if (arg == null) throw new InvalidArgumentException("Необходим аргумент - путь");
        try {
            if (history.contains(arg)) {
                new InvalidArgumentException("Обнаружен цикл");
            }
            history.add(arg);
            BufferedReader reader = Files.newBufferedReader(Paths.get(arg), StandardCharsets.UTF_8);
            String line;
            while ((line = reader.readLine()) != null) {
                commandManager.run(CLIManager.parseArgs(line));
            }
            System.out.println("Скрипт выполнен");
        } catch (InvalidPathException e) {
            throw new InvalidArgumentException("Путь содержит недопустимые символы");
        } catch (IOException e) {
            throw new InvalidArgumentException("Ошибка чтения");
        }
    }

    public String getDescription() {
        return description;
    }
}
