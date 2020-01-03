package cz.muni.fi.pb162.find.impl.filters;

import cz.muni.fi.pb162.find.filesystem.SearchEntry;
import cz.muni.fi.pb162.find.filters.BasicFilter;

import java.util.List;

/**
 * @author Lukáš Bašista
 */

public class MinSizeFilter extends BasicFilter {
    private final long min;

    /**
     *
     * @param paths ,
     * @param min ,
     */
    public MinSizeFilter(List<SearchEntry> paths, long min) {
        super(paths);
        this.min = min;
    }

    @Override
    public boolean filter(SearchEntry path) {
        return path.getSize() >= this.min;
    }
}
