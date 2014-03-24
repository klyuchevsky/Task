package ru.klyuchevsky.commands;

import ru.klyuchevsky.Command;
import ru.klyuchevsky.Task;

public class Add implements Command {
    public void execute(String[] command) {
        Double result = 0d;
        for (int i = 1; i < command.length; i++) {
            try {
                result = result + Double.parseDouble(command[i]);
            } catch (NumberFormatException e) {
                Task.writeResult("Неверный параметр: " + command[i]);
            }
        }
        Task.writeResult(result.toString());
    }
}
