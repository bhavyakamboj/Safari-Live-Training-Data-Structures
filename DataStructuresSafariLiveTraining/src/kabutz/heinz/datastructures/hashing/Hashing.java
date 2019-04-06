package kabutz.heinz.datastructures.hashing;

public class Hashing {

	public static void main(String[] args) {
		String heinz = "Heinz";
		System.out.println(heinz.hashCode() & 1023);
		String ivan = "Ivan";
		System.out.println(ivan.hashCode() & 1023);
		// 0b111111111

	}

}
