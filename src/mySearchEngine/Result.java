package mySearchEngine;

import java.util.ArrayList;
import java.util.List;

public class Result {
	String fileName;
	int frequency;
	List<Integer> frequency2 = new ArrayList<Integer>();
	float pageRank;

	public Result(String fileName, float pagerank) {
		this.fileName = fileName;
		this.frequency = (int) pagerank;
		this.pageRank = pagerank;
	}
}
