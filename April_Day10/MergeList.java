package April_Day10;

import java.util.*;

	public class MergeList {
		public static void main(String[] args) {
	        List<Integer> list1 = Arrays.asList(1, 2, 3, 4);
	        List<Integer> list2 = Arrays.asList(3, 4, 5, 6);

	        Set<Integer> set = new HashSet<>();
	        set.addAll(list1);
	        set.addAll(list2);

	        List<Integer> result = new ArrayList<>(set);

	        System.out.println(result);
	    }
	}
	
	    

