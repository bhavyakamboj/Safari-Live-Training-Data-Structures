package kabutz.heinz.datastructures.general;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class CowTest {

	public static void main(String[] args) {
		CopyOnWriteArrayList<String> list = new CopyOnWriteArrayList<String>();
		Collections.addAll(list, "Amar","Akbar","Anthony");
		for(String s: list) {
			if (s.equals("Amar"))  
				list.add("Bhavya"); //list is linear - very costly
			// CopyOnWriteArrayList is good for only very small arrays
		}
		System.out.println("List: " + list);

	}

}
