package com.elsevier;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static java.awt.SystemColor.text;

/**
 * Implementation of the search engine without any consideration of performance
 * Do the simplest implementation that can possibly work
 * Do not worry about hardware or memory, but concern yourself with readability
 * and getting the unit tests to pass
 */
public class OogleBasic implements Oogle {

	Set<Page> pages = new HashSet<>();

	public void add(Page page) {
		if(null == page)
			throw new IllegalArgumentException("Can not add null");
		if(page.getText().isEmpty() || page.getUrl().isEmpty())
			throw new IllegalArgumentException("page text or url cannot be empty");
		this.pages.add(page);
	}

	public List<Page> find(String... words) {
		if(words.length == 0)
			throw new IllegalArgumentException("No words to search");
		List<Page> result = new LinkedList<>();
		for (Page page : pages) {
			boolean containsWord = Boolean.TRUE;
			for(String word: words) {
				if(null == word || word.isEmpty())
					throw new IllegalArgumentException("page text cannot be empty");
				Pattern pattern = Pattern.compile("\\b" + word.toLowerCase() + "\\b");
				Matcher matcher = pattern.matcher(page.getText().toLowerCase());
				if(!matcher.find()) {
					containsWord = Boolean.FALSE;
					break;
				}
			}
			if(containsWord)
				result.add(page);
		}
		return result;
	}

	public int size() {
		return pages.size();
	}
}
