package ics311km;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Driver {
	
	private static final String SEP = "--------------------------------------------------------------------------------";

	public static void main(String[] args) {
		if (args.length < 1) {
			log("Usage: java Driver <filename>");
			System.exit(1);
		}
		for (String filename : args) {
			sort(filename);
		}
	}
	
	static String[] loadFile(String filename) {
		List<String> lines = new ArrayList<String>();
		try {
			BufferedReader br = new BufferedReader(new FileReader(new File(filename)));
			String line;
			while ((line = br.readLine()) != null) {
				lines.add(line.trim());
			}
			br.close();
		}
		catch (IOException e) {
			log("IO Error.");
			System.exit(1);
		}
		return (String[])lines.toArray(new String[lines.size()]);
	}
	
	static void sort(String filename) {
		String[] a = loadFile(filename);
		Heapsort heapsort = new Heapsort();
		log(SEP);
		log("Sort Test: " + a.length + " keys");
		long start = System.nanoTime();
		a = heapsort.sort(a);
		long runtime = System.nanoTime() - start;
		String first = a[0], last = a[a.length-1];
		log(" Heap Sort:      " + runtime + " ns; First key: " + first + "; Last key: " + last);
		a = loadFile(filename);
		start = System.nanoTime();
		a = Insertionsort.sort(a);
		runtime = System.nanoTime() - start;
		log(" Insertion Sort: " + runtime + " ns; First key: " + first + "; Last key: " + last);
		a = loadFile(filename);
		Mergesort mergesort = new Mergesort(a);
		start = System.nanoTime();
		a = mergesort.sort(0, a.length-1);
		runtime = System.nanoTime() - start;
		log(" Merge Sort:     " + runtime + " ns; First key: " + first + "; Last key: " + last);
	}
	
	static void log(Object o) {
		System.out.println(String.valueOf(o));
	}
}
