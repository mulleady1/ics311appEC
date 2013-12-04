package ics311km;

public class Mergesort {
	
	private String[] a;

	public Mergesort(String[] a) {
		this.a = a;
	}

	public String[] sort(int p, int r) {
		if (p < r) {
			int q = (int)Math.floor((p + r) / 2);
			sort(p, q);
			sort(q + 1, r);
			merge(p, q, r);
		}
		return a;
	}
	
	private void merge(int p, int q, int r) {
		int n = q - p + 1;
		int m = r - q;
		String[] L = new String[n];
		String[] R = new String[m];
		for (int i = 0; i < n; i++) {
			L[i] = a[p + i];
		}
		for (int i = 0; i < m; i++) {
			R[i] = a[q + i];
		}
		int i = 0, j = 0;
		for (int k = p; k <= r; p++) {
			if (L[i].compareTo(R[j]) <= 0) {
				a[k] = L[i];
				i++;
			}
			else {
				a[k] = R[j];
				j++;
			}
		}
	}
}
