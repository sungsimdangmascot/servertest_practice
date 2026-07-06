package member;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

//DBConnection클래스
//자바와 MySql 데이터 베이스를 연결해주는 통로 역할
//DB 접속 정보(주소, 아이디, 비밀번호)를 한 곳에 모아두고
//어디서든 getConnection()을 호출해서 연결을 가져다 쓸 수 있다

public class DBConnection {

//	1. 접속에 필요한 설정 정보
//	MySQL 드라이버 경로
	private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
//	데이터베이스 위치(내 컴퓨터(localhost)의 3306번 포트, jdbc_db라는 이름의 db)
	private static final String URL = "jdbc:mysql://localhost:3306/server_db";
//	접속 아이디
	private static final String USER = "root";
//	접속 비밀번호
	private static final String PASS = "1234";

//	데이터 베이스와 연결된 '통로(Connection)'를 만들어 주는 메서드 정의
//	어디서든 쓸 수 있도록 static(정적) 메서드로 정의
	public static Connection getConnection() {
//		자동 import 단축키 : ctrl + shift + o

		Connection conn = null; // 연결 통로를 담을 변수

		try {
//			[1단계] 드라이버 로딩 : "MySQL드라이버, 일할 준비 되었니??"라고 확인하는 과정
			Class.forName(DRIVER);

//			[2단계] 실제 연결 : 주소, 아이디, 비번을 들고 가서 연결 통로를 만든다
			conn = DriverManager.getConnection(URL, USER, PASS);

//			System.out.println("DB연결 성공!");

		} catch (ClassNotFoundException e) {
//			드라이버 파일(mysql-connector-j.jar)이 프로젝트에 등록되지 않았을 때 발생
			System.out.println("드라이버 로딩 실패: mysql-connector-j.jar 라이브러리 확인");
		} catch (SQLException e) {
//			주소가 틀렸거나, 아이디/비번이 틀렸을 때 발생하는 예외
			System.out.println("접속 실패 혹은 SQL 오류: " + e.getMessage());
		} catch (Exception e) {
//			그 외 알 수 없는 예상치 못한 예외가 발생했을 때
			System.out.println("DB 연결 중 예상치 못한 오류 발생!");
			e.printStackTrace(); // 구체적으로 어디서 예외가 발생했는지 출력
		}

//		만들어진 연결 통로(conn)을 반환
		return conn;

	}

}
