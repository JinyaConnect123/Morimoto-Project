package IMP_Jinyaconnect.dialog;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.swing.table.AbstractTableModel;

public class ErrorDetails extends AbstractTableModel {

	private static final long serialVersionUID = -7908781480062834324L;

	public final static int DATE_TIME = 0;
	public final static int ERROR_DTL = 1;

	public final static String[] columnNames = { "処理日時", "エラー概要" };

	public String [][] values = { };
	
	public void addErrorDetal(String datetime, String detail) {
		List<String[]> lstOrg = Arrays.asList(values);
		String[] nn = new String[] {datetime, detail};
		
		List<String[]> lstNew = new ArrayList<String[]>();
		lstNew.add(nn);
		lstNew.addAll(lstOrg);
		values = lstNew.toArray(new String[0][2]);
	}
	
	public int getRowCount() {
		return values.length;
	}

	public int getColumnCount() {
		return values[0].length;
	}

	public String getValueAt(int row, int column) {
		return values[row][column];
	}

	public String[] getValueAtRow(int row) {
		return values[row];
	}
	
	public String getColumnName(int column) {
		return columnNames[column];
	}

}
