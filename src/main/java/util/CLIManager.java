package util;

import commands.CommandManager;

import java.util.Scanner;

public class CLIManager {
    private CommandManager commandManager;
    public CLIManager(CommandManager commandManager) {
        this.commandManager = commandManager;

    }

    public void start(){
        while (true){
            commandManager.run(parseArgs());
        }
    }
    public static String[] parseArgs(){
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        return line.trim().split(" ");
    }

    public static String prompt(String msg){
        System.out.print(msg);
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        return line.trim().split(" ")[0];
    }
}
