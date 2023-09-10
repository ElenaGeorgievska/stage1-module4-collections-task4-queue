package com.epam.collections.queue;

import java.util.*;

//First, both take turns adding two cards to the ArrayDeque<Integer>. Then, with each move, the player:
//
//takes the top card from the ArrayDeque<Integer> and adds this card to the end of his Queue<Integer>
//then puts two cards from the beginning of his Queue<Integer> into the ArrayDeque<Integer>.
//The moves go until the both players' Queue<Integer> of cards are not empty.

public class ArrayDequeCreator extends PriorityQueue<String> {
    public ArrayDeque<Integer> createArrayDeque(Queue<Integer> firstQueue, Queue<Integer> secondQueue) {
        ArrayDeque<Integer> result = new ArrayDeque<>();

        //both take turns adding two cards to the ArrayDeque<Integer>
        result.add(firstQueue.poll());
        result.add(firstQueue.poll());
        result.add(secondQueue.poll());
        result.add(secondQueue.poll());

        while( !firstQueue.isEmpty() && !secondQueue.isEmpty()) {
            //1st Player :
            // takes the top card from the ArrayDeque<Integer> and adds this card to the end of his Queue<Integer>
            //then puts two cards from the beginning of his Queue<Integer> into the ArrayDeque<Integer>.
            firstQueue.add(result.pollLast());
            result.add(firstQueue.poll());
            result.add(firstQueue.poll());

            //2nd Player :
            // takes the top card from the ArrayDeque<Integer> and adds this card to the end of his Queue<Integer>
            //then puts two cards from the beginning of his Queue<Integer> into the ArrayDeque<Integer>.
            secondQueue.add(result.pollLast());
            result.add(secondQueue.poll());
            result.add(secondQueue.poll());
        }

        return result;
    }

    public static void main(String[]args){

        Queue<Integer> firstQueue = new LinkedList<>(List.of(new Integer[]{1, 5, 7, 6}));  //  //List.of(1, 5, 7, 6)
        Queue<Integer> secondQueue = new LinkedList<>(List.of(new Integer[]{2, 5, 8, 3}));

        ArrayDequeCreator adc = new ArrayDequeCreator();
        adc.createArrayDeque(firstQueue,secondQueue);

      //Input
        //
        //firstQueue = [1, 5, 7, 6]
        //secondQueue = [2, 5, 8, 3]
        //Output
        //
        //[1, 5, 2, 7, 8, 5, 6, 3]
    }
}
