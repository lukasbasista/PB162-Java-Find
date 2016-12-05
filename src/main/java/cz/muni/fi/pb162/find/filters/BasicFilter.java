package cz.muni.fi.pb162.find.filters;

import java.util.List;
import java.util.stream.Collectors;

import cz.muni.fi.pb162.find.filesystestem.SearchEntry;

/**
 * Created by pstanko.
 *
 * @author pstanko
 */
public abstract class BasicFilter {
    protected List<SearchEntry> paths;

    /**
     * Basic filter
     * @param paths list of filtered entries
     */
    public BasicFilter(List<SearchEntry> paths) {
        this.paths = paths;
    }

    /**
     * Determine whether file or directory passes this filter
     *
     * @param path filtered entry
     * @return true if given entry passes the filter, false otherwise
     */
    public abstract boolean filter(SearchEntry path);

    public List<SearchEntry> filtered() {
        return paths.stream().filter(this::filter).collect(Collectors.toList());
    }

}
