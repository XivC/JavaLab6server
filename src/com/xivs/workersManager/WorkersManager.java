package com.xivs.workersManager;


import com.xivs.lab.Position;
import com.xivs.lab.Worker;
import com.xivs.workersManager.exceptions.ExistenceException;
import com.xivs.workersManager.exceptions.NotFoundException;

import java.beans.*;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class WorkersManager {
    private HashMap<String, Worker> workers;
    public final LocalDateTime creationTime;

    public WorkersManager() {
        this.workers = new HashMap<String, Worker>();
        this.creationTime = LocalDateTime.now();
    }

    public HashMap<String, Worker> getWorkers() {
        return this.workers;
    }

    public void clear() {
        this.workers.clear();
    }

    private Worker add(String key, Worker w) {
        w.setCreationDate(LocalDate.now());
        w.setId(1 + (long) (Math.random() * (Long.MAX_VALUE - 1)));
        workers.put(key, w);
        return w;
    }

    public String insert(String key, Worker w) throws ExistenceException {
        if (workers.get(key) != null) throw new ExistenceException();
        this.add(key, w);
        return key;
    }

    public String maxBySalary() {
        Optional<String> key = workers.keySet().stream().max((u, v) -> (int) Math.floor(workers.get(u).getSalary() - workers.get(v).getSalary()));
        return key.orElse(null);
    }

    public HashMap<Position, List<String>> fieldAscendingPosition() {
        HashMap<Position, List<String>> ret = new HashMap<>();
        for (Position position : Position.values()) {
            List<String> keys = workers.keySet().stream().filter(p -> position.equals(workers.get(p).getPosition())).map(String::toString).collect(Collectors.toList());
            ret.put(position, keys);
        }
        return ret;
    }

    public void removeAllByPosition(Position position) {

        workers.keySet().stream().filter(p -> position.equals(workers.get(p).getPosition())).collect(Collectors.toSet()).forEach(p -> this.workers.remove(p));
    }

    public void removeGreater(Float salary) {
        workers.keySet().stream().filter((u) -> (int) Math.floor(salary - workers.get(u).getSalary()) < 0).collect(Collectors.toSet()).forEach(p -> this.workers.remove(p));
    }

    public String removeKey(String key) throws NotFoundException {
        if (workers.get(key) == null) throw new NotFoundException();
        workers.remove(key);
        return key;
    }

    public boolean replaceIfLower(String key, Float salary) throws NotFoundException {
        if (workers.get(key) == null) throw new NotFoundException();
        Worker w = workers.get(key);
        if (w.getSalary() >= salary) {
            w.setSalary(salary);
            return true;
        }
        return false;
    }

    public String update(Long id, Worker w) throws NotFoundException {
        Optional<String> key = workers.keySet().stream().filter(p -> id == workers.get(p).getId()).findFirst();
        if (!key.isPresent()) throw new NotFoundException();
        this.workers.put(key.get(), w);
        return key.get();
    }

    public void dump() throws IOException {
        FileOutputStream fos = new FileOutputStream("collection.xml");
        XMLEncoder encoder = new XMLEncoder(fos);
        encoder.setExceptionListener(new ExceptionListener() {
            public void exceptionThrown(Exception e) {
                System.out.println("Exception! :" + e.toString());
            }
        });
        encoder.setPersistenceDelegate(LocalDate.class,
                new PersistenceDelegate() {
                    @Override
                    protected Expression instantiate(Object localDate, Encoder encdr) {
                        return new Expression(localDate,
                                LocalDate.class,
                                "parse",
                                new Object[]{localDate.toString()});
                    }
                });
        encoder.writeObject(this.workers);
        encoder.close();
        fos.close();
    }

    public void load() throws IOException {
        FileInputStream fis = new FileInputStream("collection.xml");
        XMLDecoder decoder = new XMLDecoder(fis);
        decoder.setExceptionListener(new ExceptionListener() {
            public void exceptionThrown(Exception e) {
                System.out.println("Exception! :" + e.toString());
            }
        });
        workers = (HashMap<String, Worker>) decoder.readObject();
        decoder.close();
        fis.close();

    }


}
