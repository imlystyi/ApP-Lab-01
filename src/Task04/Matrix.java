/* Vladyslav Yakubovskyi,
 * Lviv Polytechnic National University, Institute of Computer Science and Information Technologies,
 * Department of Information Systems and Networks, "PI-21" Student group,
 * Discipline "Applied programming",
 * Laboratory work #01,
 * Task #04,
 * "Matrix.java" file */

package Task04;

import java.util.List;

public class Matrix {
    // region Fields

    public final Double[][] container;

    // endregion

    // region Properties

    public int getNumRows() {
        return this.container.length;
    }

    public int getNumCols() {
        return this.container[0].length;
    }

    // endregion

    // region Constructors

    public Matrix(final List<Double[]> rows) {
        final int numRows = rows.size();
        final int numCols = rows.get(0).length;

        for (final Double[] row: rows)
            if (row.length != numCols)
                throw new IllegalArgumentException("The matrix is not rectangular.");

        this.container = new Double[numRows][numCols];
        for (int ii = 0; ii < numRows; ii++)
            System.arraycopy(rows.get(ii), 0, this.container[ii], 0, numCols);
    }

    public Matrix(final Double[][] container) {
        final int numCols = container[0].length;

        for (final Double[] row: container)
            if (row.length != numCols)
                throw new IllegalArgumentException("The matrix is not rectangular.");

        this.container = container;
    }

    // endregion

    // region Methods

    public Matrix multiply(final Matrix target) {
        if (this.getNumCols() != target.getNumRows())
            throw new IllegalArgumentException("The number of columns in the first matrix must match the number of " +
                    "rows in the second matrix.");

        final int numRows = this.getNumRows();
        final int numCols = target.getNumCols();
        final int multiplyRank = this.getNumCols();

        final Double[][] productContainer = new Double[numRows][numCols];

        for (int ii = 0; ii < numRows; ii++)
            for (int jj = 0; jj < numCols; jj++) {
                productContainer[ii][jj] = 0d;
                for (int kk = 0; kk < multiplyRank; kk++) {
                    productContainer[ii][jj] += this.container[ii][kk] * target.container[kk][jj];
                }
            }

        return new Matrix(productContainer);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();

        for (final Double[] row: this.container) {
            sb.append("\n");
            for (final Double element: row)
                sb.append(element).append(" ");
        }

        sb.append("\n");

        return sb.toString();
    }

    // endregion
}
