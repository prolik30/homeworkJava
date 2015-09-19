package lesson1;

import java.util.Arrays;
import java.util.Random;

public class lsd {
	
	private static final int SIZE = (int) 1e6;

	private static final int CAPACITY = 0xff + 1;
	private static final int SIZE_OF_INT = Integer.SIZE / 4;

	private static Random random = new Random();
	
	public static void main(String[] args) {
		int[] data = generate();
		int[] data2 = data.clone();
		
		long quickTime, lsdTime;
		long start = System.nanoTime();
		
		Arrays.sort(data);
		
		long stop = System.nanoTime();
		
		quickTime = stop - start;
		System.out.println("Elapsed = " + quickTime);
		
		start = System.nanoTime();
		
		LSDsort(data2);
		
		stop = System.nanoTime();
		lsdTime = stop - start;
		
		System.out.println("Elapsed = " + lsdTime);
		
		System.out.println(Arrays.equals(data, data2));
		System.out.println("Ratio = " + (double)quickTime / (double)lsdTime);
	}

	private static void LSDsort(int[] data) {
		int[] newData = new int[data.length];
		
		int[] counter = new int[CAPACITY];
		
		for (int i = 0; i < SIZE_OF_INT; i++) {
			for (int j = 0; j < CAPACITY; j++) {
				counter[j] = 0;
			}
			for (int j = 0; j < data.length; j++) {
				int d = digit(data[j], i);
				counter[d]++;
			}
			int count = 0;
			for (int j = 0; j < CAPACITY; j++) {
				int temp = counter[j];
				counter[j] = count;
				count += temp;
			} 
			for (int j = 0; j < data.length; j++) {
				int d = digit(data[j], i);
				newData[counter[d]] = data[j];
				counter[d]++;
			}
			for (int j = 0; j < data.length; j++) {
				data[j] = newData[j];
			}
		}
		
	}

	private static int digit(int number, int k) {
		return (number >> 8*k) & 0xff;
	}

	private static int[] generate() {
		int[] data = new int[SIZE];
		
		for (int i = 0; i < data.length; i++) {
			data[i] = random.nextInt(SIZE);
		}
		
		return data;
	}
}
