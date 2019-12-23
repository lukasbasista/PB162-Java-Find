package cz.muni.fi.pb162.find.impl.comparators;

import cz.muni.fi.pb162.find.comparators.BasicComparator;
import cz.muni.fi.pb162.find.filesystem.SearchEntry;
import cz.muni.fi.pb162.find.tools.FileTools;

/**
 * @author Lukáš Bašista
 */

public class FileExtensionComparator implements BasicComparator {
    private BasicComparator comparator;

    /**
     * Constructor ,
     *
     * @param secondComparator ,
     */
    public FileExtensionComparator(BasicComparator secondComparator) {

        this.comparator = secondComparator;
    }

    @Override
    public BasicComparator getNextComparator() {

        return comparator;
    }

    @Override
    public int compare(SearchEntry searchEntry, SearchEntry t1) {
        String p1 = FileTools.fileExtension(searchEntry.getPath());
        String p2 = FileTools.fileExtension(t1.getPath());

        if (p1 != null && p2 != null) {
            int comparisonByFirst = p1.compareTo(p2);
            if (comparisonByFirst == 0) {
                return getNextComparator().compare(searchEntry, t1);
            }
            return comparisonByFirst;
        }
        if (p1 == null && p2 == null) {
            return getNextComparator().compare(searchEntry, t1);
        }
        if (p1 == null) {
            return -1;
        } else {
            return 1;
        }
    }
}
