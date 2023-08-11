package algorithums;

public class SmallestPathFinder {
    public static void main(String[] args) {

        int[][] matrix = {
                {1, 8, 1, 1},
                {1, 5, 1, 85},
                {4, 2, 14, 1},
                {4, 2, 1, 1}
        };

        System.out.println(String.format("The minimum path sum is %d", new SmallestPathFinder().findSmallestPath(matrix)));
    }

    public int findSmallestPath(int[][] matrix) {

        final int numberOfRows = matrix.length;
        final int numberOfColumns = matrix[0].length;

        int[][] arrayPathSums = new int[numberOfRows][numberOfColumns];

        arrayPathSums[0][0] = matrix[0][0];

        for (int i = 1; i < numberOfColumns; i++) {
            arrayPathSums[0][i] = arrayPathSums[0][i - 1] + matrix[0][i];
        }

        for (int i = 1; i < numberOfRows; i++) {
            arrayPathSums[i][0] = arrayPathSums[i - 1][0] + matrix[i][0];
        }

        for (int row = 1; row < numberOfRows; row++) {
            for (int column = 1; column < numberOfColumns; column++) {
                arrayPathSums[row][column] =
                        Math.min(arrayPathSums[row - 1][column], arrayPathSums[row][column - 1]) + matrix[row][column];
            }
        }

        return arrayPathSums[numberOfRows - 1][numberOfColumns - 1];
    }
}
