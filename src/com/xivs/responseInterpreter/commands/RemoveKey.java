package com.xivs.responseInterpreter.commands;

import com.xivs.dataTransfer.Request;
import com.xivs.dataTransfer.Response;
import com.xivs.responseInterpreter.Interpreter;
import com.xivs.workersManager.exceptions.NotFoundException;

import java.util.ArrayList;
import java.util.HashMap;


public class RemoveKey extends Command {
    public RemoveKey(Interpreter interpreter) {
        super(interpreter);
    }

    public Response execute(Request rq) {
        String key = (String) rq.attachments.get("key").get();
        ArrayList<String> messages = new ArrayList<>();
        try {
            messages.add("Элемент [" + manager.removeKey(key) + "] удалён");

        } catch (NotFoundException ex) {
            messages.add("Элемент не существует");
        }


        return new Response(Response.Status.OK, messages, new HashMap<>());

    }


}
