package kabutz.heinz.datastructures.general;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Complexity {
	
	public static void main(String[] args) {
		// Arrays are not immutable 
		List<String> arr = Arrays.asList("a","b","c");
//		arr.remove("a"); //java.lang.UnsupportedOperationException -fixed
//		arr.add("d");	//java.lang.UnsupportedOperationException - fixed  size
		arr.set(0,"D"); // can be modified so not immutable
		System.out.println(arr);
		
		//To make immutable
		List.of("a","b","c");
		
		// Create a large list of integers
		var largerList = new ArrayList<Integer>();
		ThreadLocalRandom.current().ints(100_000).forEach(i -> largerList.add(i));
		System.out.println(largerList.size());
		var largerLinkedList = new LinkedList<Integer>(largerList);
//		largerLinkedList.forEach(i->System.out.println(i));
		
		int [] data = new int[100_000]; // 12(array instance) + 4 * 100000 + 4 = 400016 bytes(1X)
		
		ArrayList<Integer> data1 = new ArrayList(); // 24 + 106710*4 + 100000*16 OR 202864(5X)
		
		List<Integer> data3 = new LinkedList<>(); // 32 + 100000*24 + 100000*16 = 4_000_032(8X)
		
		var anotherList = ThreadLocalRandom.current().ints(100_000).boxed().collect(
				Collectors.toList()
			); // boxed() creates a stream and then collector
	
		// Insert operation
		long time = System.nanoTime();
		var stats = IntStream.range(0,10_000_000).mapToDouble(
				i-> Math.random()
				).parallel().summaryStatistics();
		time = System.nanoTime() - time;
		System.out.println("Time elapsed " + (time/1000000) + " ms");
		
		// Remove operation
		long initialTime = System.nanoTime();
		List<Integer> bigList = new ArrayList<Integer>();
		for(int i=0; i<100_000_000; i++) {
			bigList.add(42);
		}
		System.out.println("Add operation: " + (System.nanoTime() - initialTime)/1000000 + " ms");
		initialTime = System.nanoTime();
//		for(Iterator<Integer> it=bigList.iterator(); it.hasNext(); ) {
//			int next = it.next();
//			if(next == 42) it.remove();
//		} // quadratic time complexity
		
		bigList.removeIf(i -> i == 42);
		System.out.println("Remove operation: " + (System.nanoTime() - initialTime)/1000000 + " ms");
		
		//  Object constructed on stack has lower cost than object on heap
//		for(int i=0; i<1000; i++) {
//			initialTime = System.nanoTime();
//			objectOnStack();
//			System.out.println("Object created in : " + (System.nanoTime() - initialTime)/1000000 + " ms");
//		}
		
	//  Object constructed on heap has higher cost than object on heap
			for(int i=0; i<1000; i++) {
				initialTime = System.nanoTime();
				objectOnHeap();
				System.out.println("Object created on heap in : " + (System.nanoTime() - initialTime)/1000000 + " ms");
			}
			
		
			
			
	}	
	private static void objectOnStack() {
		Object stackObj = new Object();
	}
	// this should be created on heap instead
//	private static Object heapObj;
	private static void objectOnHeap() {
		Object heapObj = new Object[1292];
	}
}
