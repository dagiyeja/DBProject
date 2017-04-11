package model;

import javax.swing.table.AbstractTableModel;

/*
 * �� ��ü�� JTable�� �����ڿ��� �䱸�ϴ� ��Ʈ�ѷ� ��ü�̴�.
 * �� ��ü�� ������ �����ΰ� ������ �и����� �ִ� �߰��� ����..
 * 
 * */

public class MariaModel extends AbstractTableModel{
	String driver="oracle.jdbc.OracleDriver";
	String url="jdbc:oracle:thin:@localhost:1521:XE";
	String user="batman";
	String password="1234";
	
	String[][] data=new String[4][3];
	
	//JTable�� TableModel�� ö�ⰰ�� ����. ������
	public MariaModel() {
		data[0][0]="û����";
		data[0][1]="�����ٳ�";
		data[0][2]="2000";
		
		data[1][0]="�����";
		data[1][1]="���";
		data[1][2]="4000";
		
		data[2][0]="ġ��";
		data[2][1]="����Ű";
		data[2][2]="3000";
		
		data[3][0]="ġ��";
		data[3][1]="����Ű";
		data[3][2]="9000";
		
		
	}

	//�÷��� ������ ��ȯ
	public int getColumnCount() {		
		return data[0].length;
	}

	//���ڵ� ������ ��ȯ
	public int getRowCount() {		
		return data.length;
	}

	//Ư�� ��ġ�� ���� ��ȯ
	public Object getValueAt(int row, int col) {		
		System.out.println("row="+row+",col="+col+"�� �� �־�� �ؿ�?"); //row*col��ŭ JTable�� ȣ��
		return data[row][col];
	}
	
}
