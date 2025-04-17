package com.example.findpath;

import org.junit.jupiter.api.Test;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class MazeSolverTest {

    @Test
    void pathShouldBeFoundInSampleMaze() throws Exception {
       // Load the test file
        List<String> lines = Files.readAllLines(Path.of("src/test/resources/maze.txt"));
        char[][] grid = lines.stream().map(String::toCharArray).toArray(char[][]::new);
        Maze maze = new Maze(grid);

        MazeSolver solver = new MazeSolver();
        List<String> path = solver.findPath(maze);

        assertFalse(path.isEmpty(), "Cesta by mala existovať.");
        System.out.println("Path: " + String.join(",", path));
    }
}
