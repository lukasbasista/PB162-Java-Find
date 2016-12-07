package cz.muni.fi.pb162.find.filesystem;

import java.nio.file.Path;

/**
 * @author pstanko
 */
public class DirEntry extends SearchEntry {

    public DirEntry(Path path) {
        super(path);
    }

    @Override
    public Types getType() {
        return Types.DIR;
    }

    @Override
    public String toString() {
        return "D " + super.toString();
    }
}
