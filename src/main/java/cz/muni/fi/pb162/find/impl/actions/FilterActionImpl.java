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
    private final ApplicationOptions opts;

    /**
     * Constructor
     *
     * @param opts ,
     */
    public FilterActionImpl(ApplicationOptions opts) {
        this.opts = opts;
    }

    @Override
    public List<SearchEntry> filter(List<SearchEntry> entries) {
        List<SearchEntry> retlist = new ArrayList<>(entries);

        if (opts.getTextRegex() != null) {
            FileContentFilter fcf = new FileContentFilter
                    (retlist, opts.getTextRegex());
            retlist = fcf.filtered();
        }

        if (opts.getNameRegex() != null) {
            FileNameFilter fnf = new FileNameFilter
                    (retlist, opts.getNameRegex());
            retlist = fnf.filtered();
        }

        if (opts.getSizeMax() != null) {
            MaxSizeFilter masf = new MaxSizeFilter(retlist, opts.getSizeMax());
            retlist = masf.filtered();
        }

        if (opts.getSizeMin() != null) {
            MinSizeFilter misf = new MinSizeFilter(retlist, opts.getSizeMin());
            retlist = misf.filtered();
        }
        return retlist;

    }

}
