package ru.klyuchevsky.commands;

import ru.klyuchevsky.Command;

public class Add implements Command {
    public void execute(String[] command) {
        Double result = 0d;
        for (int i = 1; i < command.length; i++) {
            try {
                result = result + Double.parseDouble(command[i]);
            } catch (NumberFormatException e) {
                System.out.println("Неверный параметр: " + command[i]);
            }
        }
        System.out.println(result);
    }
}
