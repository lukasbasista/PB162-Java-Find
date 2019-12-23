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
    public int compare(SearchEntry arg0, SearchEntry arg1) {

        return arg0.getPath().compareTo(arg1.getPath());
    }

}
