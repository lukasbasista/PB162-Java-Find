package cz.muni.fi.pb162.find.impl;

import cz.muni.fi.pb162.find.ApplicationOptions;
import cz.muni.fi.pb162.find.filesystem.FSWalkResult;
import cz.muni.fi.pb162.find.filesystem.SearchEntry;
import cz.muni.fi.pb162.find.filesystem.DirEntry;
import cz.muni.fi.pb162.find.filesystem.FileEntry;
import cz.muni.fi.pb162.find.tools.FileTools;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Lukáš Bašista
 */

public class FSWalkResultImpl extends FSWalkResult {
    /**
     * Constructor for class FSWalkResult
     *
     * @param options application optios
     */
    public FSWalkResultImpl(ApplicationOptions options) {
        super(options);
    }

    @Override
    public List<SearchEntry> getDirectories() {
        return listFileTree(new File(this.getOpts().getDirectory())).stream()
                .filter(entry -> entry.isDirectory())
                .map(entry -> {
                    DirEntry de = new DirEntry(entry.toPath());
                    de.setSize(FileTools.dirSize(de.getPath()));
                    return de;
                })
                .collect(Collectors.toList());
    }

    @Override
    public List<SearchEntry> getFiles() {
        return listFileTree(new File(this.getOpts().getDirectory())).stream()
                .filter(entry -> entry.isFile())
                .map(entry -> {
                    FileEntry fe = new FileEntry(entry.toPath());
                    fe.setSize(FileTools.dirSize(fe.getPath()));
                    return fe;
                })
                .collect(Collectors.toList());
    }

    private static List<File> listFileTree(File start) {
        List<File> retlist = new ArrayList<>();
        if (start == null) {
            return retlist;
        }
        retlist.add(start);
        for (File entry : start.listFiles()) {
            if (entry.isFile()) {
                retlist.add(entry);
            }
            if (entry.isDirectory()) {
                retlist.addAll(listFileTree(entry));
            }
        }
        return retlist;
    }
}
