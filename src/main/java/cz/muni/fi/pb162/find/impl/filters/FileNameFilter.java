package cz.muni.fi.pb162.find.impl.filters;

import cz.muni.fi.pb162.find.filesystem.SearchEntry;
import cz.muni.fi.pb162.find.filters.BasicFilter;

import java.util.List;

/**
 * @author Lukáš Bašista
 */

public class FileNameFilter extends BasicFilter {
    private final String reg;

    /**
     *
     * @param paths ,
     * @param reg ,
     */
    public FileNameFilter(List<SearchEntry> paths, String reg) {
        super(paths);
        this.reg = reg;
    }

    @Override
    public boolean filter(SearchEntry path) {
        return path.getFileName().toString().matches(reg);
    }
}
