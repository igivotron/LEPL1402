package complexity;

import org.junit.jupiter.api.Order;

public class KnapsackBruteForce {

    public static void main(String[] args) {
        Item[] items = {
                new Item(60, 10),
                new Item(100, 20),
                new Item(120, 30)
        };
        int capacity = 50;

        int maxValue = knapsack(items, capacity);
        System.out.println("Maximum value: " + maxValue);
    }

    static class Item {
        int value;
        int weight;

        Item(int value, int weight) {
            this.value = value;
            this.weight = weight;
        }
    }

    static boolean isPresent(Item[] sack, Item item){
        for(Item i: sack){
            if(i==item){return true;}
        }
        return false;
    }

    /**
     * Returns the maximum value that can be put in a knapsack with the given capacity.
     * Each item can only be selected once. If you pack an item it consumes its weight in the capacity
     * Your algorithm should implement a brute-force appraoch with a time comlexity
     * of O(2^n) where n is the number of items.
     * @param items
     * @param capacity
     * @return
     */
    public static int knapsack(Item[] items, int capacity) {
        if (items.length == 0 || capacity == 0){return 0;}
        Item[] sack = new Item[items.length];
        int n = 0;
        int j =0;

        while (true) {
            Item current = new Item(0, capacity + 1);
            for (Item i : items) {
                if (i.value > current.value && i.weight <= capacity && !isPresent(sack, i)) {
                    current = i;
                }
            }
            capacity -= current.weight;
            if (capacity < 0) {
                return n;
            }
            n += current.value;
            sack[j] = current;
            j++;

        }
    }
}
