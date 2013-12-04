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
		// Check args.
		if (args.length < 1) {
			log("Usage: java Driver <filename>");
			System.exit(1);
		}
		// Iterate over input files.
		for (String filename : args) {
			sort(filename);
		}
	}
	
	static void sort(String filename) {
		// Load array for heap sort.
		String[] a = loadFile(filename);
		Heapsort heapsort = new Heapsort();
		// Time heap sort.
		long start = System.nanoTime();
		a = heapsort.sort(a);
		long runtime = System.nanoTime() - start;
		String first = a[0], last = a[a.length-1];
		// Print results.
		log(SEP);
		log("Sort Test: " + a.length + " keys");
		log(" Heap Sort:      " + runtime + " ns; First key: " + first + "; Last key: " + last);
		
		// Load array for insertion sort.
		a = loadFile(filename);
		// Time insertion sort.
		start = System.nanoTime();
		a = Insertionsort.sort(a);
		runtime = System.nanoTime() - start;
		first = a[0]; last = a[a.length-1];
		// Print results.
		log(" Insertion Sort: " + runtime + " ns; First key: " + first + "; Last key: " + last);

		// Load array for merge sort.
		a = loadFile(filename);
		Mergesort mergesort = new Mergesort(a);
		// Time merge sort.
		start = System.nanoTime();
		a = mergesort.sort(0, a.length-1);
		runtime = System.nanoTime() - start;
		first = a[0]; last = a[a.length-1];
		// Print results.
		log(" Merge Sort:     " + runtime + " ns; First key: " + first + "; Last key: " + last);

		// Load array for quick sort.
		a = loadFile(filename);
		Quicksort quicksort = new Quicksort(a);
		// Time quick sort.
		start = System.nanoTime();
		a = quicksort.sort(0, a.length-1);
		runtime = System.nanoTime() - start;
		first = a[0]; last = a[a.length-1];
		// Print results.
		log(" Quick Sort:     " + runtime + " ns; First key: " + first + "; Last key: " + last);
		log("\n");
	}
	
	static String[] loadFile(String filename) {
		// Load input into list of strings.
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
		// Return array version of list.
		return (String[])lines.toArray(new String[lines.size()]);
	}
	
	static void log(Object o) {
		System.out.println(String.valueOf(o));
	}
}
