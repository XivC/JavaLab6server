package com.xivs.responseInterpreter.commands;

import com.xivs.dataTransfer.Request;
import com.xivs.dataTransfer.Response;
import com.xivs.responseInterpreter.Interpreter;

import java.util.ArrayList;
import java.util.HashMap;


public class RemoveGreater extends Command {
    public RemoveGreater(Interpreter interpreter) {
        super(interpreter);
    }

    public Response execute(Request rq) {
        Float salary = (Float) rq.attachments.get("salary").get();
        ArrayList<String> messages = new ArrayList<>();
        manager.removeGreater(salary);
        messages.add("Выполнено");

        return new Response(Response.Status.OK, messages, new HashMap<>());


    }

}

