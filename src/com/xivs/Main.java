package com.xivs;

import com.xivs.responseInterpreter.Interpreter;
import com.xivs.workersManager.WorkersManager;

import java.io.IOException;
import java.net.BindException;

public class Main {

    public static void main(String[] args) throws IOException {
        WorkersManager manager = new WorkersManager();
        try {
            manager.load();
        } catch (Exception ex) {

            manager.dump();

        }

        Interpreter interpreter = new Interpreter(manager);

        Server server = new Server(interpreter);


        try {
            server.bind(13337);
            server.run();
        } catch (BindException ex) {
            System.out.println("Порт занят");
        }


    }
}
