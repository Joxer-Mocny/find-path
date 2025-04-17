package com.example.findpath;

import java.util.*;

public class MazeSolver {

    private static final Map<String, int[]> DIRECTIONS = Map.of(
            "u", new int[]{-1, 0},
            "d", new int[]{1, 0},
            "l", new int[]{0, -1},
            "r", new int[]{0, 1}
    );

    public List<String> findPath(Maze maze) {
        Optional<Position> startOpt = maze.findChar('S');
        Optional<Position> goalOpt = maze.findChar('X');

        if (startOpt.isEmpty() || goalOpt.isEmpty()) {
            throw new IllegalStateException("Maze must contain both 'S' and 'X'");
        }

        Position start = startOpt.get();
        Position goal = goalOpt.get();

        Queue<Position> queue = new LinkedList<>();
        Map<Position, Position> cameFrom = new HashMap<>();
        Map<Position, String> moveTaken = new HashMap<>();

        queue.add(start);
        cameFrom.put(start, null);

        while (!queue.isEmpty()) {
            Position current = queue.poll();

            if (current.equals(goal)) break;

            for (Map.Entry<String, int[]> entry : DIRECTIONS.entrySet()) {
                String move = entry.getKey();
                int[] delta = entry.getValue();

                Position next = current.move(delta[0], delta[1]);

                if (maze.isInside(next) && maze.isFree(next) && !cameFrom.containsKey(next)) {
                    queue.add(next);
                    cameFrom.put(next, current);
                    moveTaken.put(next, move);
                }
            }
        }

        // If the goal is unreachable
        if (!cameFrom.containsKey(goal)) {
            throw new RuntimeException("No path found from 'S' to 'X'");
        }

        // Path reconstruction
        List<String> path = new ArrayList<>();
        Position current = goal;

        while (!current.equals(start)) {
            String move = moveTaken.get(current);
            path.add(move);
            current = cameFrom.get(current);
        }

        Collections.reverse(path);
        return path;
    }
}
