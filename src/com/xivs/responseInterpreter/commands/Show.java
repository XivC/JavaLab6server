package com.xivs.responseInterpreter.commands;


import com.xivs.dataTransfer.Request;
import com.xivs.dataTransfer.Response;
import com.xivs.lab.Worker;
import com.xivs.responseInterpreter.Interpreter;

import java.util.ArrayList;
import java.util.HashMap;

public class Show extends Command {
    public String workerAsString(Worker w) {
        String s = "";

        s += "Имя: " + w.getName() + "\n";
        s += "Зарплата: " + w.getSalary() + "\n";
        s += "id: " + w.getId() + "\n";
        s += "Дата создания: " + w.getCreationDate().toString() + "\n";
        s += "Дата окончания контракта: " + w.getEndDate().toString() + "\n";
        s += "Должность: " + w.getPosition().toString() + "\n";
        s += "Статус: " + w.getStatus().toString() + "\n";
        return s;

    }

    public Show(Interpreter interpreter) {
        super(interpreter);
    }

    public Response execute(Request rq) {
        ArrayList<String> messages = new ArrayList<>();

        HashMap<String, Worker> workers = manager.getWorkers();
        for (String key : workers.keySet()) {
            messages.add(key);
            messages.add(workerAsString(workers.get(key)));
        }
        return new Response(Response.Status.OK, messages, new HashMap<>());

    }

}
