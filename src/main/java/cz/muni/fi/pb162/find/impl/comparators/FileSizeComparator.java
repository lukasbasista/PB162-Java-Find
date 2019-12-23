package cz.muni.fi.pb162.find.impl.comparators;

import cz.muni.fi.pb162.find.comparators.BasicComparator;
import cz.muni.fi.pb162.find.filesystem.SearchEntry;

/**
 * @author Lukáš Bašista
 */

public class FileSizeComparator implements BasicComparator {
    private BasicComparator comparator;

    /**
     * Constructor
     *
     * @param secondComparator ,
     */
    public FileSizeComparator(BasicComparator secondComparator) {
        this.comparator = secondComparator;
    }

    @Override
    public BasicComparator getNextComparator() {
        return comparator;
    }

    @Override
    public int compare(SearchEntry searchEntry, SearchEntry t1) {
        Long p1 = searchEntry.getSize();
        int comparisonByFirst = p1.compareTo(t1.getSize());

        if (comparisonByFirst == 0) {
            return getNextComparator().compare(searchEntry, t1);
        }
        return comparisonByFirst;
    }
}
