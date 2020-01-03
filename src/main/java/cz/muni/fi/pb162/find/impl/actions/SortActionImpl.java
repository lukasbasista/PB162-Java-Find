package cz.muni.fi.pb162.find.impl.actions;

import cz.muni.fi.pb162.find.ApplicationOptions;
import cz.muni.fi.pb162.find.actions.SortAction;
import cz.muni.fi.pb162.find.filesystem.SearchEntry;
import cz.muni.fi.pb162.find.tools.SortFactory;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author Lukáš Bašista
 */

public class SortActionImpl implements SortAction {
    private final ApplicationOptions options;

    /**
     * Constructor
     *
     * @param options ,
     */
    public SortActionImpl(ApplicationOptions options) {

        this.options = options;
    }

    @Override
    public List<SearchEntry> sorted(List<SearchEntry> entries) {
        List<SearchEntry> newList = new ArrayList<>(entries);
        Collections.sort(newList, SortFactory.create(options.getSort()));
        return newList;
    }
}