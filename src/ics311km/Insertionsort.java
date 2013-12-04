package ics311km;

public class Insertionsort {

	public static String[] sort(String[] a) {
		for (int j = 1; j < a.length; j++) {
			String key = a[j];
			int i = j - 1;
			while (i >= 0 && a[i].compareTo(key) > 0) {
				a[i+1] = a[i];
				i--;
			}
			a[i+1] = key;
		}
		return a;
	}
}
