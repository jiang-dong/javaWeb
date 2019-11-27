package com.jaing03;

import java.util.ArrayList;
import java.util.List;
import java.util.ServiceLoader;
import java.util.concurrent.CopyOnWriteArrayList;

public class test {
    public static void main(String[] args) {
        CopyOnWriteArrayList<Object> objects = new CopyOnWriteArrayList<>();
        objects.add("a");

        List<Object> list = new ArrayList<>();
        list.add("a");

       // ServiceLoader<Myservice> load = ServiceLoader.load(Myservice.class);

    }
}
