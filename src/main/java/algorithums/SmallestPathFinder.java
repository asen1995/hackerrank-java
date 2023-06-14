package algorithums;

public class SmallestPathFinder {
    public int findSmallestPath(int[][] matrix) {

        final int numberOfRows = matrix.length;
        final int numberOfColumns = matrix[0].length;

        // Create a 2D array to store the minimum path sums
        int[][] arrayPathSums = new int[numberOfRows][numberOfColumns];

        // Initialize the top left element to be the same as the value of the matrix
        arrayPathSums[0][0] = matrix[0][0];

        // Calculate the minimum path sum for the first row
        for (int i = 1; i < numberOfColumns; i++) {
            arrayPathSums[0][i] = arrayPathSums[0][i - 1] + matrix[0][i];
        }

        // Calculate the minimum path sum for the first column
        for (int i = 1; i < numberOfRows; i++) {
            arrayPathSums[i][0] = arrayPathSums[i - 1][0] + matrix[i][0];
        }

        // Calculate the minimum path sum for the rest of the matrix
        for (int row = 1; row < numberOfRows; row++) {
            for (int column = 1; column < numberOfColumns; column++) {
                arrayPathSums[row][column] =
                        Math.min(arrayPathSums[row - 1][column], arrayPathSums[row][column - 1]) + matrix[row][column];
            }
        }

        // The last element of the arrayPathSums array will contain the minimum path sum
        return arrayPathSums[numberOfRows - 1][numberOfColumns - 1];
    }

    public static void main(String[] args) {

        int[][] matrix = {
                {1, 3, 1},
                {1, 5, 1},
                {4, 2, 1}
        };

        System.out.println("Smallest path sum: " + new SmallestPathFinder().findSmallestPath(matrix));
    }
}
