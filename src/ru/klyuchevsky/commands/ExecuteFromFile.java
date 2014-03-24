package ru.klyuchevsky.commands;

import ru.klyuchevsky.Command;
import ru.klyuchevsky.Task;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ExecuteFromFile implements Command {
    public void execute(String[] command) {
        String path;
        if (command.length >= 1) {
            path = command[1];
        } else {
            Task.writeResult("Не указан путь к файлу");
            Task.writeResult("Команда не будет выполнена");
            return;
        }

        try {
            BufferedReader in = new BufferedReader(new FileReader(path));
            String string;
            while ((string = in.readLine()) != null) {
                string = string.replaceAll("\\s+", " ");
                string = string.trim();

                String[] commandF = string.split(" ");
                String cmdName = commandF[0];

                if (Task.getCommands().containsKey(cmdName)) {
                    Command x = (Command) Task.getCommands().get(cmdName);
                    Task.writeResult("Выполняется команда: " + string);
                    x.execute(commandF);
                } else Task.writeResult("Неизвестная команда: " + cmdName);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
