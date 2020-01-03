package cz.muni.fi.pb162.find.impl.comparators;

import cz.muni.fi.pb162.find.comparators.BasicComparator;
import cz.muni.fi.pb162.find.filesystem.SearchEntry;

/**
 * @author Lukáš Bašista
 */

public class FileNameComparator implements BasicComparator {
    private BasicComparator comparator;

    /**
     *
     * @param comparator ,
     */
    public FileNameComparator(BasicComparator comparator) {

        this.comparator = comparator;
    }

    @Override
    public BasicComparator getNextComparator() {

        return comparator;
    }

    @Override
    public int compare(SearchEntry searchEntry, SearchEntry se) {
        String file = searchEntry.getFileName().toString();
        int comparisonByFirst = file.compareTo(se.getFileName().toString());

        if (comparisonByFirst == 0) {
            return getNextComparator().compare(searchEntry, se);
        }
        return comparisonByFirst;
    }
}
