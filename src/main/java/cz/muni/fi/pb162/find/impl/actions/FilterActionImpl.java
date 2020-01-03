package cz.muni.fi.pb162.find.impl.actions;

import cz.muni.fi.pb162.find.ApplicationOptions;
import cz.muni.fi.pb162.find.actions.FilterAction;
import cz.muni.fi.pb162.find.filesystem.SearchEntry;
import cz.muni.fi.pb162.find.impl.filters.FileContentFilter;
import cz.muni.fi.pb162.find.impl.filters.FileNameFilter;
import cz.muni.fi.pb162.find.impl.filters.MaxSizeFilter;
import cz.muni.fi.pb162.find.impl.filters.MinSizeFilter;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Lukáš Bašista
 */

public class FilterActionImpl implements FilterAction {
    private final ApplicationOptions options;

    /**
     * Constructor
     *
     * @param opts ,
     */
    public FilterActionImpl(ApplicationOptions opts) {
        this.options = opts;
    }

    @Override
    public List<SearchEntry> filter(List<SearchEntry> entries) {
        List<SearchEntry> rlist = new ArrayList<>(entries);

        if (options.getTextRegex() != null) {
            FileContentFilter fcf = new FileContentFilter
                    (rlist, options.getTextRegex());
            rlist = fcf.filtered();
        }

        if (options.getNameRegex() != null) {
            FileNameFilter fnf = new FileNameFilter
                    (rlist, options.getNameRegex());
            rlist = fnf.filtered();
        }

        if (options.getSizeMax() != null) {
            MaxSizeFilter maxsf = new MaxSizeFilter(rlist, options.getSizeMax());
            rlist = maxsf.filtered();
        }

        if (options.getSizeMin() != null) {
            MinSizeFilter minsf = new MinSizeFilter(rlist, options.getSizeMin());
            rlist = minsf.filtered();
        }
        return rlist;

    }

}
