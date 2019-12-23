package cz.muni.fi.pb162.find.impl.comparators;

import cz.muni.fi.pb162.find.comparators.BasicComparator;
import cz.muni.fi.pb162.find.filesystem.SearchEntry;

/**
 * @author Lukáš Bašista
 */

public class FileNameComparator implements BasicComparator {
    private BasicComparator comparator;

    /**
     * Constructor
     *
     * @param secondComparator ,
     */
    public FileNameComparator(BasicComparator secondComparator) {

        this.comparator = secondComparator;
    }

    @Override
    public BasicComparator getNextComparator() {

        return comparator;
    }

    @Override
    public int compare(SearchEntry searchEntry, SearchEntry t1) {
        String p1 = searchEntry.getFileName().toString();
        int comparisonByFirst = p1.compareTo(t1.getFileName().toString());

        if (comparisonByFirst == 0) {
            return getNextComparator().compare(searchEntry, t1);
        }
        return comparisonByFirst;
    }
}
