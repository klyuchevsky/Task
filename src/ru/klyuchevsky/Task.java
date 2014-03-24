package ru.klyuchevsky;

import ru.klyuchevsky.commands.*;

import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Task {
    private static Map<String, Command> commands = new HashMap<>(); // Hashmap to store commands

    public static Map getCommands() {
        return commands;
    }

    public static void main(String[] args) {
        Boolean isOnline;
        String string; // String to store current command
        Scanner sc;

        commands.put("add", new Add());
        commands.put("multiply", new Multiply());
        commands.put("addWithMultiply", new AddWithMultiply());
        commands.put("readFile", new ReadFile());
        commands.put("executeFromFile", new ExecuteFromFile());

        try {
            if (args.length != 0) {
                File file = new File(args[0]);
                sc = new Scanner(file);
            } else {
                isOnline = true;
                sc = new Scanner(System.in);
            }

            while (true) {
                if (sc.hasNextLine()) {
                    string = sc.nextLine();
                } else {
                    sc = new Scanner(System.in);
                    continue;
                }

                string = string.replaceAll("\\s+", " ");
                string = string.trim();

                if ("quit".equals(string)) {
                    System.out.println("Выход из приложения");
                    break;
                }

                String[] command = string.split(" ");
                String cmdName = command[0];

                if (commands.containsKey(cmdName)) {
                    Command x = commands.get(cmdName);
                    System.out.println("Выполняется команда: " + string);
                    x.execute(command);
                } else System.out.println("Неизвестная команда: " + cmdName);
            }

        } catch (Throwable t) {
            t.printStackTrace();
        }
    }
}
