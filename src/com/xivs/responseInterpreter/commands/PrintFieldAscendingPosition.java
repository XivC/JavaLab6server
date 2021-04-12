package com.xivs.responseInterpreter.commands;


import com.xivs.dataTransfer.Request;
import com.xivs.dataTransfer.Response;
import com.xivs.lab.Position;
import com.xivs.responseInterpreter.Interpreter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class PrintFieldAscendingPosition extends Command {
    public PrintFieldAscendingPosition(Interpreter interpreter) {
        super(interpreter);
    }

    public Response execute(Request rq) {

        ArrayList<String> messages = new ArrayList<>();

        HashMap<Position, List<String>> res = manager.fieldAscendingPosition();
        for (Position p : res.keySet()) {
            messages.add("------" + p.toString() + "------");
            messages.addAll(res.get(p));
        }
        return new Response(Response.Status.OK, messages, new HashMap<>());

    }

}
