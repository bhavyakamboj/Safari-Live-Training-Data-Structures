package kabutz.heinz.datastructures.general;

import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

public class Facades {

	public static void main(String[] args) {
		
		int[] bigArray = ThreadLocalRandom.current().ints(100_000_000).toArray();
		for(int i=0; i<30; i++) {
			sortArray(bigArray);
		}
	}

	private static void sortArray(int[] bigArray) {
		long time = System.nanoTime();
		try {
//			Arrays.sort(bigArray);;
			Arrays.parallelSort(bigArray);
		} finally {
			time = System.nanoTime() - time;
			System.out.printf("time = %dms%n",(time/1000_000));
		}
	}
}
