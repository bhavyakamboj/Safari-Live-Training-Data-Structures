package kabutz.heinz.datastructures.sets;

import java.lang.reflect.Field;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.concurrent.atomic.LongAccumulator;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class SetTest {

	public static void main(String[] args) throws NoSuchFieldException, SecurityException, IllegalAccessException {
		System.out.println(Set.of(1,2,3,4,5,6,7,8,9,10));
		var numbers = new HashSet<Integer>();
		
		for(int i=0;i<100_000; i++) {
			numbers.add(i);
		}
		int checker = 0;
		for(int num:numbers) {
			System.out.println(num);
			if(checker++ != num) {
//				throw new AssertionError(num);
			}
		}
		// order of hashset is only till 65536 and that too by coincidence	
		// A treeset is just a treemap wrapped insideit
		Set<Integer> treeSet = new TreeSet<Integer>();
		//is same as 
		Set<Integer> treeSet1 = new TreeMap<Integer,Object>().keySet();
		//or use this
		Set<Integer> treeSet2 = Collections.newSetFromMap(new TreeMap<>());
		
		Map<Integer,Object> vals = new TreeMap<>();
		List<Integer> input = IntStream.range(0,1_000_000).boxed().collect(Collectors.toList());
		input.forEach(i->vals.put(i, "dummy"));
		System.out.println(vals.size());
		
		//to find the depth of tree
		Field parentField = null;
		LongAccumulator min = new LongAccumulator(Long::min,Long.MAX_VALUE);
		LongAccumulator max = new LongAccumulator(Long::max,0);
		for(Map.Entry<Integer,Object> entry: vals.entrySet()) {
			if(parentField==null) {
				parentField = entry.getClass().getDeclaredField("parent");
				parentField.setAccessible(true);
			}
			int depth=0;
			while(entry!=null) {
				depth++;
				entry = (Entry<Integer, Object>) parentField.get(entry);
			}
			max.accumulate(depth);
			min.accumulate(depth);
		}
		System.out.println("min: "+min);
		System.out.println("max: "+max);
		// use ConcurrentSkipListSet for thread safety
		// use CopyOnWriteSet for very small set(it is extremely small)
		
	}

}
