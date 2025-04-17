package com.example.findpath;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class FindPathInputReaderFile extends AbstractFindPathInputReader {
    private final String filePath;

    public FindPathInputReaderFile(String filePath) {
        this.filePath = filePath;
    }

    @Override
    public Maze readMaze() {
        try {
            List<String> lines = Files.readAllLines(Path.of(filePath));
            char[][] grid = lines.stream().map(String::toCharArray).toArray(char[][]::new);
            return new Maze(grid);
        } catch (IOException e) {
            throw new RuntimeException(" Failed to read the file: " + filePath, e);
        }
    }
}
