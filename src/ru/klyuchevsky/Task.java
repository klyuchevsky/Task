package ru.klyuchevsky;

import ru.klyuchevsky.commands.*;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Task {
    private static Map<String, Command> commands = new HashMap<>(); // Hashmap to store commands
    private static Boolean isOnline = false; // program mode
    private static File inFile; // input file
    private static File outFile; // output file

    public static Map getCommands() {
        return commands;
    }

    public static void writeResult(String string) {
        if (isOnline) {
            try {
                FileWriter out = new FileWriter(outFile, true);
                try {
                    out.write(string);
                    out.write("\n");
                } finally {
                    out.close();
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        } else System.out.println(string);
    }

    public static void main(String[] args) {
        String string; // String to store current command
        Scanner sc;
        try {

            commands.put("add", new Add());
            commands.put("multiply", new Multiply());
            commands.put("addWithMultiply", new AddWithMultiply());
            commands.put("readFile", new ReadFile());
            commands.put("executeFromFile", new ExecuteFromFile());

            if (args.length >= 2) {
                inFile = new File(args[0]);
                sc = new Scanner(inFile);
                outFile = new File(args[1]);
                isOnline = true;
                System.out.println("Запуск в фоновом режиме");
            } else {
                System.out.println("Программа запущена в режиме консоли");
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
                    writeResult("Выход из приложения");
                    break;
                }

                String[] command = string.split(" ");
                String cmdName = command[0];

                if (commands.containsKey(cmdName)) {
                    Command x = commands.get(cmdName);
                    writeResult("Выполняется команда: " + string);
                    x.execute(command);
                } else writeResult("Неизвестная команда: " + cmdName);
            }

        } catch (Throwable t) {
            t.printStackTrace();
        }
    }
}
