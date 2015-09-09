package lesson1;

import java.util.Arrays;
import java.util.Random;

public class lsd {
	
	private static final int SIZE = (int) 1e6;

	private static Random random = new Random();
	
	public static void main(String[] args) {
		
		int[] data = generate();
		int[] data2 = data.clone();
		
		long start = System.nanoTime();
		
		Arrays.sort(data);
		
		long stop = System.nanoTime();
		
		System.out.println("Elapsed = " + (stop - start));
		
		start = System.nanoTime();
		
		LSDsort(data);
		
		stop = System.nanoTime();
		
		System.out.println("Elapsed = " + (stop - start));
	}

	private static void LSDsort(int[] data) {
		
		
	}

	private static int[] generate() {
		int[] data = new int[SIZE];
		
		for (int i = 0; i < data.length; i++) {
			data[i] = random.nextInt(SIZE);
		}
		
		return data;
	}
}
