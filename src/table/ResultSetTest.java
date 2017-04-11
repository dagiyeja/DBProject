/*
 * 레코드 결과를 배열로 받을때의 단점
 * 레코드의 총 개수를 알 수가 없다..
 * 
 * */

package table;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

//Java Data Base Connectivity=자바의 데이터베이스 연동 기술 
public class ResultSetTest {
	String driver="oracle.jdbc.OracleDriver";
	String url="jdbc:oracle:thin:@localhost:1521:XE";
	String user="batman";
	String password="1234";
	
	//3개의 인터페이스-중립적
	Connection con; //접속시도X, 접속한 이후 그 결과를 담는 객체
	PreparedStatement pstmt;
	ResultSet rs;
	
	//레코드셋 객체를 이용하여 총 레코드 수 알아 맞춰보기!!
	public ResultSetTest() {
		try {
			Class.forName(driver);
			
			con=DriverManager.getConnection(url, user, password);
			if(con!=null){
				String sql="select * from company";
				
				//rs의 커서를 전방향, 후방향 등으로
				//자유롭게 움직이거나 한꺼번에 건너뛰게 하려면
				//스크롤 가능한 상수옵션을 부여해야 한다..
				//select 문의 결과집합을 대상으로 단지 보기만 할경우,
				//READ_ONLY, 수정을 가할 경우 UPDATABLE
				//선생님 경험상 SELECT문에 의한 레코드는 읽기 위함이다!
				//즉 거의 전자를 사용한다.
				pstmt=con.prepareStatement(sql,ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY); //접속된 이후에 쿼리문 날릴 수 있음
				rs=pstmt.executeQuery();

				//제일 마지막 레코드로 보내기
				rs.last();
				int num=rs.getRow(); //현재 커서가 가리키는 레코드 번호!! 즉 레코드의 위치!!
				System.out.println(num);
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		new ResultSetTest();

	}

}
