package ru.klyuchevsky.commands;

import ru.klyuchevsky.Command;
import ru.klyuchevsky.Task;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ReadFile implements Command {
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
            String str;
            while ((str = in.readLine()) != null) {
                Task.writeResult(str);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
