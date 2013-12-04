package ics311km;

public class Heapsort {
	
	private String[] a;
	private int heapsize;

	String[] sort(String[] input) {
		this.a = input;
		buildMaxHeap();
		for (int i = a.length-1; i > 0; i--) {
			// Swap a[0] with a[i].
			String temp = a[0];
			a[0] = a[i];
			a[i] = temp;
			this.heapsize--;
			maxHeapify(0);
		}
		return a;
	}
	
	private void buildMaxHeap() { 
		this.heapsize = a.length;
		for (int i = (int)Math.floor(a.length / 2); i >= 0; i--) {
			maxHeapify(i);
		}
	}

	private void maxHeapify(int i) {
		int l = left(i);
		int r = right(i);
		int largest;
		if (l < heapsize && a[l].compareTo(a[i]) > 0)
			largest = l;
		else
			largest = i;
		if (r < heapsize && a[r].compareTo(a[i]) > 0)
			largest = r;
		if (largest != i) {
			String temp = a[i];
			a[i] = a[largest];
			a[largest] = temp;
			maxHeapify(largest);
		}
	}
	private int left(int index) { return index * 2; }
	private int right(int index) { return index * 2 + 1; }
}
