package model;

import javax.swing.table.AbstractTableModel;

/*
 * �� ��ü�� JTable�� �����ڿ��� �䱸�ϴ� ��Ʈ�ѷ� ��ü�̴�.
 * �� ��ü�� ������ �����ΰ� ������ �и����� �ִ� �߰��� ����..
 * 
 * */

public class OracleModel extends AbstractTableModel{
	String driver="oracle.jdbc.OracleDriver";
	String url="jdbc:oracle:thin:@localhost:1521:XE";
	String user="batman";
	String password="1234";
	
	String[][] data=new String[3][2];
	
	//JTable�� TableModel�� ö�ⰰ�� ����. ������
	public OracleModel() {
		data[0][0]="¥���";
		data[0][1]="�ϰ����";
		data[1][0]="������ġ";
		data[1][1]="�������";
		data[2][0]="��ũ������ ġŲ";
		data[2][1]="KFC";
		
		
	}

	//�÷��� ������ ��ȯ
	public int getColumnCount() {		
		return 2;
	}

	//���ڵ� ������ ��ȯ
	public int getRowCount() {		
		return 3;
	}

	//Ư�� ��ġ�� ���� ��ȯ
	public Object getValueAt(int row, int col) {		
		System.out.println("row="+row+",col="+col+"�� �� �־�� �ؿ�?"); //row*col��ŭ JTable�� ȣ��
		return data[row][col];
	}
	
}