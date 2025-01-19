package com.elsevier;

import java.util.*;

/**
 * Implementation of the search engine so that page retrieval should be very fast even on slow hardware
 * The unit tests must all pass and the code should be readable and production quality
 */
public class OogleHighPerformance implements Oogle {

	private InvertedIndex invertedIndex = new InvertedIndex();

	@Override
	public void add(Page page) {
		if(null == page)
			throw new IllegalArgumentException("Can not add null");
		if(page.getText().isEmpty())
			throw new IllegalArgumentException("Empty text not allowed");
		if(page.getUrl().isEmpty())
			throw new IllegalArgumentException("Empty Url not allowed");
		invertedIndex.addPage(page);
	}

	@Override
	public List<Page> find(String... words) {
		if(null == words)
			throw new IllegalArgumentException("Nothing to search");
		if(words.length == 1 && words[0].isEmpty())
			throw new IllegalArgumentException("Nothing to search");
		return invertedIndex.search(words);
	}

	@Override
	public int size() {
		return invertedIndex.size();
	}
}
