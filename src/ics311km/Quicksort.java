package ics311km;

public class Quicksort {

	private String[] a;
	
	public Quicksort(String[] a) {
		this.a = a;
	}
	
	public String[] sort(int p, int r) {
		if (p < r) {
			int q = partition(p, r);
			sort(p, q - 1);
			sort(q + 1, r);
		}
		return a;
	}
	
	private int partition(int p, int r) {
		String x = a[r];
		int i = p - 1;
		for (int j = p; j < r - 1; j++) {
			if (a[j].compareTo(x) <= 0) {
				i++;
				String temp = a[i];
				a[i] = a[j];
				a[j] = temp;
			}
		}
		String temp = a[i+1];
		a[i+1] = a[r];
		a[r] = temp;
		return i+1;
	}
}
