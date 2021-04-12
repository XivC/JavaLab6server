package com.xivs.responseInterpreter.commands;


import com.xivs.dataTransfer.Request;
import com.xivs.dataTransfer.Response;
import com.xivs.responseInterpreter.Interpreter;

import java.util.ArrayList;
import java.util.HashMap;

public class Clear extends Command {
    public Clear(Interpreter interpreter) {
        super(interpreter);
    }

    public Response execute(Request rq) {
        manager.clear();
        ArrayList<String> messages = new ArrayList<>();
        messages.add("Коллекция очищена");
        return new Response(Response.Status.OK, messages, new HashMap<>());


    }
}
