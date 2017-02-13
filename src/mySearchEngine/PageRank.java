package mySearchEngine;

import java.util.List;

public class PageRank {

	public float pageRank(List<List<Integer>> results) {
		// results has multiple lists(one list for each query-word) 
		// each list contains all the indexes of query-word inside the file
		// e.g.: if word 'windsor' appear 3 times in file at index 5,9,14, list will be <5,9,14>

		if (results.isEmpty()) {
			return 0.0f;
		}

		if (results.size() == 1) {
			return results.get(0).size();
		}

		float pageRank= 0.0f;
		Boolean flag = false;
		List<Integer> firstQueryIndexes = results.get(0);

		for (int j=0; j < results.size(); j++) {
			if(results.get(j).size()>0) pageRank++;
		}
		
		for (int i =0; i < firstQueryIndexes.size(); i++) {
			flag = true;
			for (int j=1; j < results.size(); j++) {
				int numSearch = firstQueryIndexes.get(i) + j;
				if (!results.get(j).contains(numSearch)) {
					flag = false;
					break;
				}
			}
			if (flag == true) {
				pageRank += 100;
			}
		}
		return pageRank;
	}
}
