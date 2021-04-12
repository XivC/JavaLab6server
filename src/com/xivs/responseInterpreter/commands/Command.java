package com.xivs.responseInterpreter.commands;

import com.xivs.dataTransfer.Request;
import com.xivs.dataTransfer.Response;
import com.xivs.responseInterpreter.Interpreter;
import com.xivs.workersManager.WorkersManager;

public abstract class Command {
    Interpreter interpreter;
    WorkersManager manager;

    public Command(Interpreter interpreter) {
        this.interpreter = interpreter;
        this.manager = this.interpreter.getManager();
    }

    public abstract Response execute(Request rq);

}
