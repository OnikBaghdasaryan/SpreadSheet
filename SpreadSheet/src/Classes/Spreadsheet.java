package Classes;

import enums.Color;
import enums.Type;
import exceptions.NotNumberException;
import exceptions.TableException;

public class Spreadsheet {
    Cell[][] cells;
    int columns;
    int rows;

    public Spreadsheet(int rows, int columns) {
        this.columns = columns;
        this.rows = rows;
        cells = new Cell[rows][columns];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                cells[i][j] = new Cell();
            }
        }
    }

    public void addRow(int k) throws TableException {

        if (k > rows || k < 1) {
            throw new TableException("Row : " + k + " does not exist!");
        } else {

            k--;
            Cell[][] temp = new Cell[rows + 1][columns];

            for (int i = 0; i < rows; i++) {

                for (int j = 0; j < columns; j++) {

                    if (i == k) {
                        temp[i][j] = new Cell();
                        continue;
                    }
                    temp[i][j] = cells[i][j];
                }
            }
            cells = temp;
            for (int j = 0; j < columns; j++) {
                cells[rows][j] = new Cell();
            }
            rows++;


        }
    }

    public void addRow() {

        Cell[][] temp = new Cell[rows + 1][columns];

        for (int i = 0; i < rows; i++) {

            for (int j = 0; j < columns; j++) {
                temp[i][j] = cells[i][j];
            }
        }
        cells = temp;
        for (int j = 0; j < columns; j++) {
            cells[rows][j] = new Cell();
        }
        rows++;


    }

    public void addColumn(int k) throws TableException {

        if (k > columns || k < 1) {
            throw new TableException("Column : " + k + " does not exist!");
        } else {

            k--;

            Cell[][] temp = new Cell[rows][columns + 1];

            for (int i = 0; i < rows; i++) {

                for (int j = 0; j < columns; j++) {

                    if (j == k) {
                        temp[i][j] = new Cell();
                        continue;
                    }

                    temp[i][j] = cells[i][j];

                }
            }
            cells = temp;
            for (int i = 0; i < rows; i++) {
                cells[i][columns] = new Cell();
            }
            columns++;

        }
    }

    public void addColumn() {

        Cell[][] temp = new Cell[rows][columns + 1];

        for (int i = 0; i < rows; i++) {

            for (int j = 0; j < columns; j++) {

                temp[i][j] = cells[i][j];
            }
        }
        cells = temp;
        for (int i = 0; i < rows; i++) {
            cells[i][columns] = new Cell();
        }



        columns++;

    }

    public void setValueAt(int row, int column, Object obj) throws Throwable {

        if (row > rows || column > columns || row < 1 || column < 1) {
            throw new TableException("There is no cell at Row : " + row + " Column : " + column);
        } else {

            cells[row-1][column-1].setValue(obj);

        }
    }

    public Object getValueAt(int row, int column) throws TableException {

        if (row > rows || column > columns || row < 1 || column < 1) {
            throw new TableException("There is no cell at Row : " + row + " Column : " + column);
        } else {

            return cells[row-1][column-1].getValue();

        }

    }

    public void setColorAt(int row, int column, Color color) throws TableException {

        if (row > rows || column > columns || row < 1 || column < 1) {
            throw new TableException("There is no cell at Row : " + row + " Column : " + column);
        } else {

            cells[row - 1][column - 1].setColor(color);

        }
    }

    public Color getColorAt(int row, int column) throws TableException {

        if (row > rows || column > columns || row < 1 || column < 1) {
            throw new TableException("There is no cell at Row : " + row + " Column : " + column);
        } else {

            return cells[row - 1][column - 1].getColor();

        }
    }

    public Type getTypeAt(int row, int column) throws TableException {

        if (row > rows || column > columns || row < 1 || column < 1) {
            throw new TableException("There is no cell at Row : " + row + " Column : " + column);
        } else {

            return cells[row - 1][column - 1].getType();

        }
    }

    public void reset() {

        for (Cell[] i : cells) {
            for (Cell j : i) {
                j.reset();
            }
        }

    }

    public void resetCellAt(int row, int column) throws TableException {

        if (row > rows || column > columns || row < 1 || column < 1) {
            throw new TableException("There is no cell at Row : " + row + " Column : " + column);
        } else {

            cells[row - 1][column - 1].reset();

        }
    }

    public double getRowSum(int i) throws NotNumberException, TableException {

        if (i > rows || i < 1) {
            throw new TableException("Row : " + i + " does not exist!");
        } else {

            double sum = 0;
            i--;

            for (int j = 0; j < columns; j++) {

                if (cells[i][j].getType() != Type.NUMBER) {
                    throw new NotNumberException("Cell value at Row : " + i + " Column : " + j + " is not a Number");
                } else {
                    sum += (double) cells[i][j].getValue();
                }

            }

            return sum;
        }
    }

    public double getColumnSum(int j) throws NotNumberException, TableException {


        if (j > columns || j < 1) {
            throw new TableException("Column : " + j + " does not exist!");
        } else {

            double sum = 0;
            j--;

            for (int i = 0; i < rows; i++) {

                if (cells[i][j].getType() != Type.NUMBER) {
                    throw new NotNumberException("Cell value at Row : " + i + " Column : " + j + " is not a Number");
                } else {
                    sum += (double) cells[i][j].getValue();
                }

            }

            return sum;
        }
    }

    public double getAreaSum(int i_1, int j_1, int i_2, int j_2) throws NotNumberException, TableException {

        if (i_1 > rows || j_1 > columns ||
                i_2 > rows || j_2 > columns ||
                i_1 > i_2 || j_1 > j_2 ||
                i_1 < 1 || j_1 < 1) {

            throw new TableException("Wrong Position Entered!");
        } else {

            double sum = 0;

            for (int i = i_1 - 1; i < i_2; i++) {
                for (int j = j_1 - 1; j < j_2; j++) {

                    if (cells[i][j].getType() != Type.NUMBER) {
                        throw new NotNumberException("Cell value at Row : " + i + " Column : " + j + " is not a Number");
                    } else {
                        sum += (double) cells[i][j].getValue();
                    }

                }
            }

            return sum;
        }
    }

    public double getRowAverage(int i) throws NotNumberException, TableException {

        return getRowSum(i) / cells[i].length;

    }

    public double getColumnAverage(int j) throws NotNumberException, TableException {

        return getColumnSum(j) / cells.length;

    }

    public double getAreaAverage(int i_1, int j_1, int i_2, int j_2) throws NotNumberException, TableException {

        return getAreaSum(i_1, j_1, i_2, j_2) / (i_2 - i_1 + 1) * (j_2 - j_1 + 1);

    }

}
