package com.example.findpath;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class MazeSolverTest {

    @Test
    void pathShouldBeFoundInSampleMaze() throws Exception {
        List<String> lines = Files.readAllLines(Path.of("src/test/resources/maze.txt"));
        char[][] grid = lines.stream().map(String::toCharArray).toArray(char[][]::new);
        Maze maze = new Maze(grid);
        MazeSolver solver = new MazeSolver();
        List<String> path = solver.findPath(maze);
        Assertions.assertFalse(path.isEmpty(), "The path should exist.");
    }

    @Test
    void pathShouldNotExist() {
        List<String> lines = List.of(
                "S#####",
                "######",
                "#####X"
        );
        char[][] grid = lines.stream().map(String::toCharArray).toArray(char[][]::new);
        Maze maze = new Maze(grid);
        MazeSolver solver = new MazeSolver();
    
        Assertions.assertThrows(RuntimeException.class, () -> solver.findPath(maze),
                "When the path does not exist, we expect an exception.");
    }

    @Test
    void invalidMazeShouldThrowException() {
        List<String> lines = List.of(
                "..S..X",
                "..S..X"
        );
        char[][] grid = lines.stream().map(String::toCharArray).toArray(char[][]::new);
        Assertions.assertThrows(IllegalArgumentException.class, () -> new Maze(grid),
                "A maze with multiple 'S' or 'X' should throw an exception.");
    }

    @Test
    void simpleMazeShouldReturnCorrectPath() {
        List<String> lines = List.of(
                "..S...",
                "......",
                "...X.."
        );
        char[][] grid = lines.stream().map(String::toCharArray).toArray(char[][]::new);
        Maze maze = new Maze(grid);
        MazeSolver solver = new MazeSolver();
        List<String> path = solver.findPath(maze);

        Assertions.assertFalse(path.isEmpty(), "A path should exist.");
        System.out.println("Path: " + String.join(",", path));
    }
}
