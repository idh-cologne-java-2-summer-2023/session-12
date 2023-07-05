package idh.java;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Sort1 {
	
	public static int compare(int i1, int i2) {
		if (i1 < i2)
			return -1;
		if (i1 == i2)
			return 0;
		return 1;
	}
	
	public static int findInsertPosition(List<Integer> lst, int element) {
		for (int i = 0; i < lst.size(); i++) {
			int cmp = compare(lst.get(i), element);
			if (cmp > 0) {
				return i;
			}
		}
		return 0;
	}
	
	public static List<Integer> sort(List<Integer> array) {
		ArrayList<Integer> returnList = new ArrayList<Integer>(array.size());
		for (int i = 0; i < array.size(); i++) {
			int element = array.get(i);
			if (returnList.isEmpty()) {
				returnList.add(element);
			} else {
				returnList.add(findInsertPosition(returnList, element), element);
			}
		}
		return returnList;
	}
	
	
	public static final void main(String[] args) {
		largeListExperiment(10);
		largeListExperiment(100);
		largeListExperiment(1000);
		largeListExperiment(10000);
		largeListExperiment(100000);
		largeListExperiment(1000000);
		largeListExperiment(10000000);
		
	}

	
	public static void largeListExperiment(int n) {
		long start;

		Random random = new Random(0);
		List<Integer> list = new ArrayList<Integer>();
		
		for (int i = 0; i < n; i++) {
			list.add(random.nextInt());
		}
		
		start = System.currentTimeMillis();
		sort(list);
		System.out.printf("Sort1 a list with %d = %1.0e random elements: %dms.%n", n, (double)n, (System.currentTimeMillis()-start));

	}


}
