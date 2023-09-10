package com.epam.collections.queue;

import java.util.*;

public class PriorityQueueCreator {
    public PriorityQueue<String> createPriorityQueue(List<String> firstList, List<String> secondList) {
        PriorityQueue<String> result = new PriorityQueue<>(Collections.reverseOrder());
        List<String> mergedFirstSecondLists = new ArrayList<>();

        mergedFirstSecondLists.addAll(firstList);
        mergedFirstSecondLists.addAll(secondList);
        mergedFirstSecondLists.sort(Collections.reverseOrder());

        result.addAll(mergedFirstSecondLists);

        return result;
    }

    public static void main(String[] args) {
        List<String> firstList = Arrays.asList("Java", "PriorityQueue", "class");
        List<String> secondList = Arrays.asList("It", "is", "different", "from", "standard", "queues", "where", "FIFO");

        PriorityQueueCreator pqc = new PriorityQueueCreator();
        pqc.createPriorityQueue(firstList, secondList);

        //Input:
        //firstList = ["Java", "PriorityQueue", "class"]
        //secondList = ["It", "is", "different", "from", "standard", "queues", "where", "FIFO"]

        //Output:
        //["where", "standard", "queues", "is", "from", "different", "class",  "PriorityQueue", "Java", "It", "FIFO"]
    }
}
