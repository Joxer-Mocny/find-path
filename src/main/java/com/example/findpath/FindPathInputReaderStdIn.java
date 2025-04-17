package com.example.findpath;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FindPathInputReaderStdIn extends AbstractFindPathInputReader {

    @Override
    public Maze readMaze() {
        Scanner scanner = new Scanner(System.in);
        List<char[]> lines = new ArrayList<>();

        System.out.println(" Enter the maze (press Enter twice to finish):");
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            if (line.isBlank()) break;
            lines.add(line.toCharArray());
        }

        return new Maze(lines.toArray(new char[0][]));
    }
}
