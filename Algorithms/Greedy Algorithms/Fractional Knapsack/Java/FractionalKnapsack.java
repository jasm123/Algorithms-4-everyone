//Java program to solve fractional Knapsack Problem

import java.util.Arrays;
import java.util.Comparator;

public class FractionalKnapsack {

    //Class for Item to store its value and weight
    static class Item {
	int value, weight;

	public Item(int value, int weight) {
	    this.value = value;
	    this.weight = weight;
	}
    }

    //The greedy function to solve the probelm
    static double fractionalKnapsack(int W, Item[] arr, int n) {
	// sorting Item on basis of value/weight ratio
	Arrays.sort(arr, new Comparator<Item>() {
	    @Override
	    public int compare(Item o1, Item o2) {               // note how using o2 first gives a desc comparator which is not default
		return (int) ((o2.value / o2.weight) - (o1.value / o1.weight));
	    }
	});

	int curWeight = 0; // Current weight in knapsack
	double finalvalue = 0.0; // Result (value in Knapsack)

	// Looping through all Items take greedily
	for (int i = 0; i < n; i++) {
	    // If adding Item won't overflow, add it completely
	    if (curWeight + arr[i].weight <= W) {
		curWeight += arr[i].weight;
		finalvalue += arr[i].value;
	    }

	    // If we can't add current Item, add fractional part of it
	    else {
		int remain = W - curWeight;
		finalvalue += arr[i].value * ((double) remain / arr[i].weight);
		break;
	    }
	}

	// Returning final value
	return finalvalue;
    }

    public static void main(String[] args) {

	Item[] arr = {
			new Item(100, 20), 
			new Item(60, 10), 
			new Item(120, 30)
		     };
	System.out.println("Maximum value that can be obtained is: ");
	System.out.println(fractionalKnapsack(50, arr, arr.length));
    }
}
