FindPath (Java CLI Project)

This is a simple Java command-line application that finds the shortest path from a start point S to a target point X in a 2D maze using:

. free space

# wall

S start

X target

🚀 Features

Pathfinding in mazes of any size

Breadth-First Search (BFS) to find the shortest path

Two input options:

--stdin: standard input

--file <path>: file input

Unit tests for verifying correctness

Clean structure with Maven

Ready for GitHub, Git, and enhancements

🧪 Example usage

java -jar target/find-path-1.0-SNAPSHOT.jar --file src/test/resources/maze.txt

Or from standard input:

java -jar target/find-path-1.0-SNAPSHOT.jar --stdin

Enter the maze (press Enter twice to finish):
..S....
.###...
......X

✅ Requirements

Java 17+

Maven 3.6+
