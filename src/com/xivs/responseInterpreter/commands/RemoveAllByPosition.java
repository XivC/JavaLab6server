package com.xivs.responseInterpreter.commands;


import com.xivs.dataTransfer.Request;
import com.xivs.dataTransfer.Response;
import com.xivs.lab.Position;
import com.xivs.responseInterpreter.Interpreter;

import java.util.ArrayList;
import java.util.HashMap;

public class RemoveAllByPosition extends Command {

    public RemoveAllByPosition(Interpreter interpreter) {
        super(interpreter);
    }

    public Response execute(Request rq) {
        Position position = (Position) rq.attachments.get("position").get();
        manager.removeAllByPosition(position);
        ArrayList<String> messages = new ArrayList<>();
        messages.add("Выполнено");
        return new Response(Response.Status.OK, messages, new HashMap<>());
    }

}
