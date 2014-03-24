package ru.klyuchevsky.commands;

import ru.klyuchevsky.Command;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ReadFile implements Command {
    public void execute(String[] command) {
        String path;
        if (command.length >= 1) {
            path = command[1];
        } else {
            System.out.println("Не указан путь к файлу");
            System.out.println("Команда не будет выполнена");
            return;
        }

        try {
            BufferedReader in = new BufferedReader(new FileReader(path));
            String str;
            while ((str = in.readLine()) != null) {
                System.out.println(str);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
