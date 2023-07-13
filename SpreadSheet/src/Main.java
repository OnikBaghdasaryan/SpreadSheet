import Classes.Cell;
import Classes.Spreadsheet;
import enums.Color;
import exceptions.TableException;

public class Main {
    public static void main(String[] args) {

        Spreadsheet spreadsheet = new Spreadsheet(3,3);

        try {
            spreadsheet.setColorAt(1,1, Color.RED);
            System.out.println(spreadsheet.getColorAt(1,1));
            spreadsheet.addColumn(3);
            spreadsheet.setValueAt(1,4,"2004-12-29");
            System.out.println(spreadsheet.getTypeAt(1,4));
        } catch (Throwable e) {
            e.printStackTrace();
        }


    }
}