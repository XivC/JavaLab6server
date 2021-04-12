package com.xivs.responseInterpreter.commands;


import com.xivs.dataTransfer.Request;
import com.xivs.dataTransfer.Response;
import com.xivs.lab.Worker;
import com.xivs.responseInterpreter.Interpreter;
import com.xivs.workersManager.exceptions.ExistenceException;

import java.util.ArrayList;
import java.util.HashMap;


public class Insert extends Command {
    public Insert(Interpreter interpreter) {
        super(interpreter);
    }

    public Response execute(Request rq) {
        ArrayList<String> messages = new ArrayList<>();
        String key = (String) rq.attachments.get("key").get();
        Worker w = (Worker) rq.attachments.get("worker").get();
        try {
            manager.insert(key, w);
            messages.add("Элемент успешно добавлен");
        } catch (ExistenceException ex) {
            messages.add("Элемент уже существует");
        }


        return new Response(Response.Status.OK, messages, new HashMap<>());
    }

}
