package commands;

import exceptions.InvalidArgumentException;

/**
 * Interface for commands
 */
public interface Commandable {
    /**
     * @param arg argument of command
     * @throws InvalidArgumentException
     */
    void run(String arg) throws InvalidArgumentException;
    /**
     * @return description for Help command
     */
    String getDescription();
}
