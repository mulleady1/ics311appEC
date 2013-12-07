package ics311km;

import java.util.ArrayList;
import java.util.List;

public class Heapsort {
	
	private String[] a;
	private int heapsize;

	String[] sort(String[] input) {
		this.a = input;
		buildMinHeap();
		List<String> minList = new ArrayList<String>(input.length);
		for (int i = a.length-1; i >= 0; i--) {
			minList.add(a[0]);
			a[0] = a[i];
			this.heapsize--;
			minHeapify(0);
		}
		return (String[])minList.toArray(new String[minList.size()]);
	}
	
	private void buildMinHeap() { 
		this.heapsize = a.length;
		for (int i = (int)Math.floor(a.length / 2) - 1; i >= 0; i--) {
			minHeapify(i);
		}
	}

	private void minHeapify(int i) {
		int l = left(i);
		int r = right(i);
		int smallest;
		if (l < heapsize && a[l].compareTo(a[i]) < 0)
			smallest = l;
		else
			smallest = i;
		if (r < heapsize && a[r].compareTo(a[smallest]) < 0)
			smallest = r;
		if (smallest != i) {
			String temp = a[i];
			a[i] = a[smallest];
			a[smallest] = temp;
			minHeapify(smallest);
		}
	}
	private int left(int index) { return index * 2 + 1; }
	private int right(int index) { return index * 2 + 2; }
}
