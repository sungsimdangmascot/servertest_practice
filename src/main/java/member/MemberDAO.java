package member;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

// ================== MemberDAO.java 작업 항목 ==================
// 각 메서드의 PreparedStatement 바인딩 · 실행 · 결과(ResultSet) 처리 부분을 완성하세요.
//  1. insertMember : 이름 · 나이 바인딩 후 executeUpdate
//  2. selectAll    : executeQuery 후 결과를 반복하며 MemberDTO 생성 → List에 담기
//  3. updateMember : 이름 · 나이 · id 바인딩 후 executeUpdate
//  4. deleteMember : id 바인딩 후 executeUpdate
//  5. selectOne    : id 바인딩 → executeQuery → MemberDTO 하나 생성
// (SQL 문자열, 커넥션 열기/닫기(자원 해제) 코드는 이미 작성되어 있습니다.)
// ============================================================

// MemberDAO : DB의 member테이블에서 접근해서 
// 데이터를 DTO단위로 넣거나 빼오는 역할을 담당
public class MemberDAO {

//	1. 회원등록(insert)
//	MemberDTO(회원 한명의 정보)를 전달받아, DB에 저장
	public void insertMember(MemberDTO dto) {
		int result = 0; // 실행 결과를 담을 변수(성공한 행의 개수)

//		sql문 작성
		String sql = "insert into member(member_name, member_age) values(?, ?)";

		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
//			1단계 : 연결 통로
			conn = DBConnection.getConnection();
//			2단계 : SQL 구조 객체 생성
			pstmt = conn.prepareStatement(sql);

//			3단계 : ?(위치 홀더)에 실제 데이터 채우기
//			[작성] 1번 ? 에 이름(dto.getMemberName()), 2번 ? 에 나이(dto.getMemberAge())를 바인딩하세요
			pstmt.setString(1, dto.getMemberName());
			pstmt.setInt(2, dto.getMemberAge());

//			4단계 : SQL실행 (insert이므로 executeUpdate 사용)
//			[작성] pstmt.executeUpdate() 실행 결과를 result 에 저장하세
			result = pstmt.executeUpdate();

//			5단계 : 결과 확인
			if (result > 0) {
				System.out.println("회원 등록 완료!");
			} else {
				System.out.println("회원 등록 실패!");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
//			6단계 : 자원 해제 
			try {
				if (pstmt != null) {
					pstmt.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}

			try {
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}

		}

	} // insertMember

//	2. 전체 회원 조회(select all)
//	DB에 있는 모든 회원 정보를 List에 담아서 반환
	public List<MemberDTO> selectAll() {

		List<MemberDTO> list = new ArrayList<>(); // 회원 정보들을 저장할 리스트
		String sql = "select * from member order by member_id";

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			conn = DBConnection.getConnection();
			pstmt = conn.prepareStatement(sql);

//			[작성] select이므로 executeQuery()를 사용하여 결과 집합(ResultSet)을 rs 에 받으세요
			rs = pstmt.executeQuery();

//			[작성] rs.next()로 데이터가 있는 만큼 반복하면서,
//			       member_id / member_name / member_age 값을 읽어 MemberDTO를 생성하고 list.add() 하세요
			while(rs.next()) {
				int memberId = rs.getInt("member_id");
				String memberName = rs.getString("member_name");
				int memberAge = rs.getInt("member_age");
				
				MemberDTO dto = new MemberDTO(memberId,memberName, memberAge);
				list.add(dto);
			}
			
			
			
			

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
//			자원해제 - 역순으로 닫기
			try {
				if (rs != null) {
					rs.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}

			try {
				if (pstmt != null) {
					pstmt.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}

			try {
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return list; // MemberDTO객체들이 저장된 List 반환
	} // selectAll()

//	3. 회원수정(update)
//	MemberDTO를 전달받아, 해당 MEMBER_ID의 이름과 나이를 변경
	public void updateMember(MemberDTO dto) {
//		update문 : where 조건(member_id)으로 수정할 행을 찾고, 
//				set로 바꿀 값을 지정
		String sql = "update member set member_name = ?, " + "member_age = ? where member_id = ?";

		int result = 0;
		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			conn = DBConnection.getConnection();
			pstmt = conn.prepareStatement(sql);

//			[작성] ?(위치 홀더)에 값 채우기
//			       1번 ? : 새 이름   2번 ? : 새 나이   3번 ? : 수정할 회원의 id
			pstmt.setString(1, dto.getMemberName());
			pstmt.setInt(2, dto.getMemberAge());
			pstmt.setInt(3, dto.getMemberId());

//			[작성] executeUpdate() 실행 후 결과를 result 에 저장하세요
			result = pstmt.executeUpdate();

			if (result > 0) {
				System.out.println("회원 수정 완료!");
			} else {
//				where 조건에 맞는 행이 없을때(존재하지 않는 ID를 입력한 경우)
				System.out.println("해당 회원을 찾을 수 없습니다.");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
//			자원 해제
			try {
				if (pstmt != null) {
					pstmt.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}

			try {
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	} // updateMember

//	4. 회원삭제(delete)
//	삭제할 회원의 member_id를 받아서 해당 행을 DB에서 제거
	public void deleteMember(int memberId) {
//		delete문 : where 조건에 맞는 행을 삭제(조건을 빠트리면 전체 삭제됨 주의!)
		String sql = "delete from member where member_id = ?";

		int result = 0;
		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			conn = DBConnection.getConnection();
			pstmt = conn.prepareStatement(sql);

//			[작성] ? 에 삭제할 회원 아이디(memberId)를 바인딩하세요
			pstmt.setInt(1, memberId);

//			[작성] executeUpdate() 실행 후 결과를 result 에 저장하세요
			result = pstmt.executeUpdate();

			if (result > 0) {
				System.out.println("회원 삭제 완료!");
			} else {
				System.out.println("해당 회원을 찾을 수 없습니다.");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstmt != null) {
					pstmt.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}

			try {
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	} // deleteMember

//	5. member_id로 회원 한명을 조회하는 메소드
//	조회 결과가 있으면 MemberDTO를 반환하고, 없으면 null을 반환
	public MemberDTO selectOne(int memberId) {

		String sql = "select * from member where member_id = ?";

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		MemberDTO dto = null; // 결과를 담을 변수(조회 실패시 null 반환)

		try {
			conn = DBConnection.getConnection();
			pstmt = conn.prepareStatement(sql);

//			[작성] ? 에 조회할 회원 아이디(memberId)를 바인딩하세요
			pstmt.setInt(1, memberId);
			
			rs = pstmt.executeQuery();

//			[작성] executeQuery()로 결과를 rs 에 받고, rs.next()가 true이면
//			       member_id / member_name / member_age 를 읽어 dto 에 MemberDTO를 생성하세요
			if(rs.next()) {
				int id = rs.getInt("member_id");
				String name = rs.getString("member_name");
				int age = rs.getInt("member_age");
				dto = new MemberDTO(id, name, age);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}

			try {
				if (pstmt != null) {
					pstmt.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}

			try {
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return dto;
	} // selectOne()

}