package jdbc.oracle;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MemberList {
	public static void main(String[] args) {
		String driver="oracle.jdbc.driver.OracleDriver";
		String url="jdbc:oracle:thin:@localhost:1521:xe";
		String id="java"; //오라클 접속 아이디
		String pwd="java1234";
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try {
		Class.forName(driver); //jdbc driver 로딩(생략가능)
		conn=DriverManager.getConnection(url,id,pwd);
		System.out.println("오라클 서버에 접속되었습니다.");
		String sql="select * from member";
		pstmt = conn.prepareStatement(sql);//sql 실행 객체
		rs = pstmt.executeQuery();
		System.out.println("아이디\t이름\t비번");
		while( rs.next() ){ //다음 레코드가 존재하면 true
		String userid=rs.getString("userid");
		String passwd=rs.getString("passwd");
		String name=rs.getString("name");
		System.out.println(userid+"\t"+passwd+"\t"+name); 
		} 
		} catch (Exception e) {
		e.printStackTrace();
		} finally {
		try {
		if( rs != null ) rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			if( pstmt != null ) pstmt.close();
			} catch (SQLException e) {
			e.printStackTrace();
			}
			try {
			if( conn != null ) conn.close();
			} catch (SQLException e) {
			e.printStackTrace();
			}
		}
	}
}
