package kabutz.heinz.datastructures.hashing;

import java.util.Comparator;

public class Pixel implements Comparable{
	private int x;
	private int y;
	public Pixel(int x, int y) {
		this.x = x;
		this.y = y;
	}
	@Override
	public int hashCode() {
//		final int prime = 31;
//		int result = 1;
//		result = prime * result + x;
//		result = prime * result + y;
//		return result;
//		return 31 * x + y;
//		return x << 16 ^ y;
		return x * 768 + y;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pixel other = (Pixel) obj;
		if (x != other.x)
			return false;
		if (y != other.y)
			return false;
		return true;
	}
	@Override
	public int compareTo(Object o) {
		return NATURAL_COMPARATOR.compare(this, o);
	}
	public int getX() {
		return x;
	}
	public int getY() {
		return y;
	}
	public static final Comparator NATURAL_COMPARATOR = Comparator.comparingInt(Pixel::getX).thenComparingInt(Pixel::getY);
	
	
}
