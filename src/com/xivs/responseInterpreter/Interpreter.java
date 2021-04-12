package com.xivs.responseInterpreter;

import com.xivs.dataTransfer.Request;
import com.xivs.dataTransfer.Response;
import com.xivs.responseInterpreter.commands.*;
import com.xivs.workersManager.WorkersManager;

import java.util.ArrayList;
import java.util.HashMap;

public class Interpreter {
    private final WorkersManager manager;
    public final HashMap<String, Command> executors;

    public Interpreter(WorkersManager manager) {
        this.manager = manager;
        this.executors = new HashMap<>();
        this.executors.put("info", new Info(this));
        this.executors.put("show", new Show(this));
        this.executors.put("insert", new Insert(this));
        this.executors.put("update", new Update(this));
        this.executors.put("remove_key", new RemoveKey(this));
        this.executors.put("clear", new Clear(this));
        this.executors.put("remove_greater", new RemoveGreater(this));
        this.executors.put("replace_if_lower", new ReplaceIfLower(this));
        this.executors.put("remove_all_by_position", new RemoveAllByPosition(this));
        this.executors.put("max_by_salary", new MaxBySalary(this));
        this.executors.put("print_field_ascending_position", new PrintFieldAscendingPosition(this));
    }

    public Response execute(Request rq) {

        String method = rq.method;
        if (this.executors.containsKey(method)) {
            return this.executors.get(method).execute(rq);
        }
        return new Response(Response.Status.ERROR, new ArrayList<>(), new HashMap<>());

    }

    public WorkersManager getManager() {
        return this.manager;
    }


}
