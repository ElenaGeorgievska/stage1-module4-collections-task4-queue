package com.epam.collections.queue;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class DishOrderDeterminer {
    public static List<Integer> determineDishOrder(int numberOfDishes, int everyDishNumberToEat) {
        List<Integer> dishes = new LinkedList<>();
        List<Integer> result = new ArrayList<>();

        for (int i = 1; i <= numberOfDishes; i++) {
            dishes.add(i);
        }

        int step = everyDishNumberToEat - 1;
        int j = 0;
        while (!dishes.isEmpty()) {
            j = (j + step) % dishes.size();
            result.add(dishes.remove(j));
        }
        return result;
    }

    public static void main(String[] args) {
        DishOrderDeterminer dod = new DishOrderDeterminer();
        dod.determineDishOrder(10, 3);


        //Input
        //numberOfDishes = 10
        //everyDishNumberToEat = 3
        //dishes: 1, 2, 3, 4, 5, 6, 7, 8, 9, 10

        //Output
        //[3, 6, 9, 2, 7, 1, 8, 5, 10, 4]
    }
}
