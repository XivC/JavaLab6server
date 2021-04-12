package com.xivs.responseInterpreter.commands;


import com.xivs.dataTransfer.Request;
import com.xivs.dataTransfer.Response;
import com.xivs.responseInterpreter.Interpreter;
import com.xivs.workersManager.exceptions.NotFoundException;

import java.util.ArrayList;
import java.util.HashMap;


public class ReplaceIfLower extends Command {
    public ReplaceIfLower(Interpreter interpreter) {
        super(interpreter);
    }

    public Response execute(Request rq) {
        ArrayList<String> messages = new ArrayList<>();
        String key = (String) rq.attachments.get("key").get();
        Float salary = (Float) rq.attachments.get("salary").get();
        try {
            if (manager.replaceIfLower(key, salary)) {
                messages.add("Элемент обновлён");
            } else {
                messages.add("Элемент не обновлён");
            }
        } catch (NotFoundException ex) {
            messages.add("Элемент не найден");
        }

        return new Response(Response.Status.OK, messages, new HashMap<>());


    }
}