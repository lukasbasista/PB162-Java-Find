package cz.muni.fi.pb162.find.impl.filters;

import cz.muni.fi.pb162.find.filesystem.SearchEntry;
import cz.muni.fi.pb162.find.filters.BasicFilter;

import java.io.IOException;
import java.nio.file.Files;
import java.util.List;

/**
 * @author Lukáš Bašista
 */

public class FileContentFilter extends BasicFilter {
    private final String reg;

    /**
     *
     * @param paths ,
     * @param reg ,
     */
    public FileContentFilter(List<SearchEntry> paths, String reg) {
        super(paths);
        this.reg = reg;
    }

    @Override
    public boolean filter(SearchEntry path) {
        if (!Files.isReadable(path.getPath())) {
            throw new IllegalArgumentException("directory contents is not readable");
        }
        try {
            return Files.readString(path.getPath()).matches(this.reg);
        } catch (IOException e) {
            throw new IllegalArgumentException("file contents could not be read", e);
        }
    }
}
