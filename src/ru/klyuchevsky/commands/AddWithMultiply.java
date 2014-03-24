package ru.klyuchevsky.commands;

import ru.klyuchevsky.Command;
import ru.klyuchevsky.Task;

import java.util.ArrayList;
import java.util.List;

public class AddWithMultiply implements Command {
    public void execute(String[] command) {
        List<Double> pars = new ArrayList<>(3);
        Double result;

        if (command.length < 4) {
            Task.writeResult("Недостаточно параметров для выполнения команды");
            return;
        }

        Double a;
        for (int i = 1; i <= 3; i++) {
            try {
                a = Double.parseDouble(command[i]);
            } catch (NumberFormatException e) {
                Task.writeResult("Неверный параметр: " + command[i]);
                Task.writeResult("Команда не будет выполнена");
                return;
            }
            pars.add(a);
        }

        result = (pars.get(0) + pars.get(1)) * pars.get(2);
        Task.writeResult(result.toString());
    }
}
