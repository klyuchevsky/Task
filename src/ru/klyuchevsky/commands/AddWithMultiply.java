package ru.klyuchevsky.commands;

import ru.klyuchevsky.Command;

import java.util.ArrayList;
import java.util.List;

public class AddWithMultiply implements Command {
    public void execute(String[] command) {
        List<Double> pars = new ArrayList<>(3);
        Double result;

        if (command.length < 4) {
            System.out.println("Недостаточно параметров для выполнения команды");
            return;
        }

        Double a;
        for (int i = 1; i <= 3; i++) {
            try {
                a = Double.parseDouble(command[i]);
            } catch (NumberFormatException e) {
                System.out.println("Неверный параметр: " + command[1]);
                System.out.println("Команда не будет выполнена");
                return;
            }
            pars.add(a);
        }

        result = (pars.get(0) + pars.get(1)) * pars.get(2);
        System.out.println(result);
    }
}
