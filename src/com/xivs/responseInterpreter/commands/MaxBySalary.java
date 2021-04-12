package com.xivs.responseInterpreter.commands;


import com.xivs.dataTransfer.Request;
import com.xivs.dataTransfer.Response;
import com.xivs.responseInterpreter.Interpreter;

import java.util.ArrayList;
import java.util.HashMap;

public class MaxBySalary extends Command {
    public MaxBySalary(Interpreter interpreter) {
        super(interpreter);
    }

    public Response execute(Request rq) {
        ArrayList<String> messages = new ArrayList<>();

        messages.add("Элемент с ключом [" + manager.maxBySalary() + "] имеет макс. salary");
        return new Response(Response.Status.OK, messages, new HashMap<>());

    }

}
