import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.HashMap;

/**
 * Class to return a list of unique ints between bounds in O(n) time and space
 * 	where n is the size of the list. Uses a modified Durstenfeld's algorithm
 * 	this version doesn't have to allocate an array of size (end - start)
 * @author Daniel Chung
 * @version 0.0.1
*/

public class UniqueRandom {
	private static int getInt(int ind, HashMap<Integer, Integer> mappings) {
		return (mappings.containsKey(ind)) ? mappings.get(ind) : ind;
	}

	public static List getInts(int start, int end, int length)
		throws IllegalArgumentException {
		if (start >= end)
			throw new IllegalArgumentException("start must be less than end");

		if (length <= 0)
			throw new IllegalArgumentException("length must be positive");

		if (end - start < length)
			throw new IllegalArgumentException("end - start must be greater or equal to the length");

		Random rand = new Random();
		HashMap<Integer, Integer> mappings = new HashMap<>();
		List<Integer> ints = new ArrayList<>();
		for (int i = 0; i < length; i++) {
			int ind = rand.nextInt(end - start) + start;
			int newInt = ind;

			ints.add(getInt(ind, mappings));

			// replace taken index with end to ensure uniqueness
			mappings.put(ind, getInt(end - 1, mappings)); 

			end--;
		}

		return ints;
	}
}