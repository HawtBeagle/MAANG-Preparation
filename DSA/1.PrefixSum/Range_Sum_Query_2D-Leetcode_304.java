class NumMatrix {

  int[][] prefixMatrix;

  public NumMatrix(int[][] matrix) {
    prefixMatrix = new int[matrix.length + 1][matrix[0].length + 1];
    populate(prefixMatrix, matrix);
  }

  public int sumRegion(int row1, int col1, int row2, int col2) {
    return prefixMatrix[row2 + 1][col2 + 1]
        - prefixMatrix[row1][col2 + 1]
        - prefixMatrix[row2 + 1][col1]
        + prefixMatrix[row1][col1];
  }

  private void populate(int[][] prefixMatrix, int[][] matrix) {
    for (int i = 0; i < matrix.length; i++) {
      for (int j = 0; j < matrix[0].length; j++) {
        int prefixrow = i + 1, prefixcol = j + 1;
        prefixMatrix[prefixrow][prefixcol] =
            matrix[i][j]
                + prefixMatrix[prefixrow - 1][prefixcol]
                + prefixMatrix[prefixrow][prefixcol - 1]
                - prefixMatrix[prefixrow - 1][prefixcol - 1];
      }
      // System.out.println(Arrays.toString(prefixMatrix[i+1]));
    }
  }
}
