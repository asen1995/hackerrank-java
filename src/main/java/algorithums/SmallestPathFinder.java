package algorithums;

import java.util.PriorityQueue;

public class SmallestPathFinder {
    private static final int[][] DIRECTIONS = {{1, 0}, {0, 1}}; // down and right

    public static int findSmallestPath(int[][] array) {
        int m = array.length;
        int n = array[0].length;

        // Create a distance array to store the minimum distance to reach each element
        int[][] distances = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                distances[i][j] = Integer.MAX_VALUE;
            }
        }

        distances[0][0] = array[0][0];

        // Create a priority queue to store the elements with their distances
        PriorityQueue<int[]> queue = new PriorityQueue<>((a, b) -> a[2] - b[2]);
        queue.offer(new int[]{0, 0, array[0][0]});

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int row = current[0];
            int col = current[1];
            int distance = current[2];

            if (distance > distances[row][col]) {
                continue; // Skip if we've already found a shorter path
            }

            for (int[] dir : DIRECTIONS) {
                int newRow = row + dir[0];
                int newCol = col + dir[1];

                if (newRow >= 0 && newRow < m && newCol >= 0 && newCol < n) {
                    int newDistance = distance + array[newRow][newCol];

                    if (newDistance < distances[newRow][newCol]) {
                        distances[newRow][newCol] = newDistance;
                        queue.offer(new int[]{newRow, newCol, newDistance});
                    }
                }
            }
        }

        return distances[m - 1][n - 1];
    }

    public static void main(String[] args) {
        int[][] array = {
                {1, 3, 4},
                {2, 1, 3},
                {5, 2, 1}
        };

        int smallestPath = findSmallestPath(array);
        System.out.println("Smallest Path: " + smallestPath);
    }
}
