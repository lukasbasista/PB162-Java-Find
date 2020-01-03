package cz.muni.fi.pb162.find.impl.filters;

import cz.muni.fi.pb162.find.filesystem.SearchEntry;
import cz.muni.fi.pb162.find.filters.BasicFilter;

import java.util.List;

/**
 * @author Lukáš Bašista
 */

public class MaxSizeFilter extends BasicFilter {
    private final long max;

    /**
     *
     * @param paths ,
     * @param max ,
     */
    public MaxSizeFilter(List<SearchEntry> paths, long max) {
        super(paths);
        this.max = max;
    }

    @Override
    public boolean filter(SearchEntry path) {
        return path.getSize() <= this.max;
    }
}
