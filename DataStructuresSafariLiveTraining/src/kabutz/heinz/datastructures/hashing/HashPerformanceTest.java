package kabutz.heinz.datastructures.hashing;

import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentSkipListMap;
import java.util.concurrent.ConcurrentSkipListSet;

public class HashPerformanceTest {

	public static void main(String[] args) {
//		Map<Pixel, Object> pixels = new HashMap<>(
		Map<Pixel, Object> pixels = new ConcurrentHashMap<>(
//		Map<Pixel, Object> pixels = new ConcurrentSkipListMap<>(
//				Comparator.comparingInt(Pixel::getX).thenComparingInt(Pixel::getY)
				);
		// Always prefer ConcurrentHashMap over HashMap and ConcurrentSkipListMap over TreeMap as they are thread safe
		// no such thing as ConcurrentHashSet rather use COncurrentHashMap.newKeySet()
//		Map<Pixel, Object> pixels = new HashMap<>();
		Set<Integer> uniqueHashCodes = new ConcurrentSkipListSet<>();
		for(int x = 0; x < 1024; x++) {
			for(int y = 0; y < 768; y++) {
				Pixel pixel = new Pixel(x,y);
				pixels.put(pixel,"dummy");
				uniqueHashCodes.add(pixel.hashCode());
			}
		}
		System.out.println("Total pixels: "+pixels.size());
		Pixel[] allPixels = pixels.keySet().toArray(new Pixel[0]);
		
		long time = System.nanoTime();
		try {
			for(int i=0; i<10; i++) {
				for(Pixel p: allPixels) {
					if(pixels.get(p) != "dummy") throw new AssertionError();
				}
			}
		} finally {
			time = System.nanoTime() - time;
			System.out.printf("time = %dms%n", (time/1000_000));
			System.out.println("uniqueHashCodes : "+uniqueHashCodes.size());
		} 
	}

}
