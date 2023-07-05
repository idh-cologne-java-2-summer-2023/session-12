package idh.java;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Sort2 {

	
	public static int compare(int i1, int i2) {
		if (i1 < i2)
			return -1;
		if (i1 == i2)
			return 0;
		return 1;
	}
	

	
	public static List<Integer> sort(List<Integer> array) {
		// recursive base case
		if (array.size() == 1)
			return array;
		else {
			// recursion step
			int splitpos = array.size() / 2;
			List<Integer> h1 = array.subList(0, splitpos);
			List<Integer> h2 = array.subList(splitpos, array.size());
			
			h1 = sort(h1);
			h2 = sort(h2);

			ArrayList<Integer> r = new ArrayList<Integer>(array.size());
		 	
			int h1i = 0, h2i = 0;
			while(h1i < h1.size() && h2i < h2.size()) {
				int e1 = h1.get(h1i);
				int e2 = h2.get(h2i);
				
				int comp = compare(e1, e2);
				
				if (comp < 0) {
					r.add(e1);
					h1i++;
				} else if (comp > 0) {
					r.add(e2);
					h2i++;
				} else {
					r.add(e1);
					r.add(e2);
					h1i++;
					h2i++;
				}
			}
			
			for (; h1i < h1.size(); h1i++) {
				r.add(h1.get(h1i));
			}
			for (; h2i < h2.size(); h2i++) {
				r.add(h2.get(h2i));
			}
			
			return r;

		}
				
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
		System.out.printf("Sort2 a list with %d = %1.0e random elements: %dms.%n", n, (double)n, (System.currentTimeMillis()-start));

	}

}
