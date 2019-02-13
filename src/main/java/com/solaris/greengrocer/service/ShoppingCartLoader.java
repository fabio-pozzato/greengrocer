package com.solaris.greengrocer.service;

import com.solaris.greengrocer.model.Fruit;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;

@Service
public class ShoppingCartLoader {

    private Logger logger = LoggerFactory.getLogger(ShoppingCartLoader.class);

    private final FruitFactory fruitFactory;

    @Value("${solaris.shoppingItems}")
    private Resource shoppingItems;

    @Autowired
    public ShoppingCartLoader(FruitFactory fruitFactory) {
        this.fruitFactory = fruitFactory;
    }

    public List<Fruit> loadFruitItems() {

        try {
            InputStream is = shoppingItems.getInputStream();
            BufferedReader br = new BufferedReader(new InputStreamReader(is));
            while (br.ready()) {
                String line = br.readLine();
                Fruit fruit = fruitFactory.getFruit(line);
                if (fruit != null) {
                    int amount = fruit.getAmount();
                    fruit.setAmount(++amount);
                }
            }
        } catch (IOException e) {
            logger.error("Could not load file.", e);
        }
        return fruitFactory.getAll();
    }
}
