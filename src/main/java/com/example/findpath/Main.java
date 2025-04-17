package com.example.findpath;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        if (args.length == 0) {
            System.err.println("Usage: java -jar find-path.jar --file <filename> | --stdin");
            return;
        }

        AbstractFindPathInputReader reader;

        switch (args[0]) {
            case "--stdin" -> reader = new FindPathInputReaderStdIn();
            case "--file" -> {
                if (args.length < 2) {
                    System.err.println("Missing file path. Usage: --file <filename>");
                    return;
                }
                reader = new FindPathInputReaderFile(args[1]);
            }
            default -> {
                System.err.println("Unknown argument: " + args[0]);
                return;
            }
        }

        try {
            Maze maze = reader.readMaze();
            MazeSolver solver = new MazeSolver();
            List<String> path = solver.findPath(maze);
            System.out.println(String.join(",", path));
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}
