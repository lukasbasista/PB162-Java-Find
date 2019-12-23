package cz.muni.fi.pb162.find.impl.comparators;

import cz.muni.fi.pb162.find.comparators.BasicComparator;
import cz.muni.fi.pb162.find.filesystem.SearchEntry;

/**
 * @author Lukáš Bašista
 */

public class FilePathComparator implements BasicComparator {

    @Override
    public BasicComparator getNextComparator() {

        return null;
    }

    @Override
    public int compare(SearchEntry se, SearchEntry se1) {

        return se.getPath().compareTo(se1.getPath());
    }

}
