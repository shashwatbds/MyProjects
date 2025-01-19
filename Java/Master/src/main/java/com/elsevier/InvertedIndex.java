package com.elsevier;

import java.util.*;

public class InvertedIndex {

    private Map<String, Set<Page>> index = new HashMap<>();

    public void addPage(Page page) {
        String[] words = page.getText().toLowerCase().split("\\W+");
        for (String word : words) {
            if (!index.containsKey(word)) {
                index.put(word, new HashSet<Page>());
            }
            index.get(word).add(page);
        }
    }

    public List<Page> search(String[] query) {
        if (query.length == 0) {
            throw new IllegalArgumentException("No words to search");
        }

        Set<Page> result = new HashSet<Page>(index.getOrDefault(query[0].toLowerCase(), Collections.<Page>emptySet()));
        boolean containsWord = Boolean.TRUE;
        for (String word : query) {
            if(null == word || word.isEmpty())
                throw new IllegalArgumentException("No words to search");

            result.retainAll(index.getOrDefault(word.toLowerCase(), Collections.<Page>emptySet()));
        }
        return new ArrayList<Page>(result);
    }

    public int size() {
        return index.size();
    }
}
