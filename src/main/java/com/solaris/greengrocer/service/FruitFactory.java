package com.solaris.greengrocer.service;

import com.solaris.greengrocer.model.Fruit;
import com.solaris.greengrocer.model.discount.Discount;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class FruitFactory {

    private Logger logger = LoggerFactory.getLogger(FruitFactory.class);
    private Map<String, Fruit> fruits;

    private FruitFactory() {
        fruits = new HashMap<>();

        Fruit apple = new Fruit("Apple", 0.25);
        Fruit orange = new Fruit("Orange", 0.3);
        Fruit banana = new Fruit("Banana", 0.15);
        Fruit papaya = new Fruit("Papaya", 0.5, Discount.Type.BUY_3X2 );

        fruits.put(apple.getName().toLowerCase(), apple);
        fruits.put(orange.getName().toLowerCase(), orange);
        fruits.put(banana.getName().toLowerCase(), banana);
        fruits.put(papaya.getName().toLowerCase(), papaya);
    }

    public Fruit getFruit(String name) {

        if (!fruits.containsKey(name.toLowerCase())) {
            logger.warn("Fruit \""+name+"\" cannot be handled.");
        }

        return fruits.get(name);
    }

    public List<Fruit> getAll() {

        return new ArrayList<>(fruits.values());
    }
}
