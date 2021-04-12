package com.xivs.responseInterpreter.commands;


import com.xivs.dataTransfer.Request;
import com.xivs.dataTransfer.Response;
import com.xivs.responseInterpreter.Interpreter;

import java.util.ArrayList;
import java.util.HashMap;

public class Info extends Command {
    public Info(Interpreter interpreter) {
        super(interpreter);
    }

    public Response execute(Request rq) {

        ArrayList<String> messages = new ArrayList<>();

        messages.add("Дата создания: " + manager.creationTime);
        messages.add("Кол-во элементов: " + manager.getWorkers().keySet().size());
        messages.add("Тип: " + manager.getClass());
        return new Response(Response.Status.OK, messages, new HashMap<>());


    }

}
