package member;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// ============= MemberInsertController.java 작업 항목 =============
// doGet  : 회원 등록 폼(/member/memberInsertForm.jsp)으로 forward 하세요.
// doPost : 폼에서 넘어온 데이터를 읽어 DTO에 담고, DAO로 INSERT 한 뒤
//          회원 목록(/memberList)으로 리다이렉트 하세요.
// ==============================================================

@WebServlet("/memberInsert")
public class MemberInsertController extends HttpServlet {

//	doGet() : GET 요청 => 회원 등록 폼 화면으로 이동
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/html; charset=UTF-8");

//		전달할 데이터가 없으므로 setAttribute()없이 바로 forward
//		[작성] RequestDispatcher 로 "/member/memberInsertForm.jsp" 를 forward 하세요
		RequestDispatcher rd = request.getRequestDispatcher("/member/memberInsertForm.jsp");
		rd.forward(request, response);

	}

//	doPost() : POST 요청 -> 폼에서 입력한 데이터를 DB에 저장
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		1) 한글 깨짐 방지 - post방식은 인코딩 설정부터 꼭 해야 한다
		request.setCharacterEncoding("UTF-8");

//		2) 폼 데이터 읽기 - HTML input 태그의 name속성 값으로 데이터를 가져온다
//		[작성] request.getParameter("memberName") 으로 이름을,
//		       request.getParameter("memberAge") 를 int 로 변환하여 나이를 읽으세요
		String memberName = request.getParameter("memberName");
		int memberAge = Integer.parseInt(request.getParameter("memberAge"));
		
//		3) DTO에 데이터 담기 - DB에 넘겨줄 데이터를 MemberDTO객체로 생성
//		   (member_id는 auto_increment가 자동 생성)
//		[작성] MemberDTO 객체를 만들고 setMemberName / setMemberAge 로 값을 담으세요
		MemberDTO dto = new MemberDTO();
		dto.setMemberName(memberName);
		dto.setMemberAge(memberAge);

//		4) Model호출 - DAO를 통해 DB에 INSERT를 실행
//		[작성] MemberDAO 객체를 만들어 insertMember(dto) 를 호출하세요
		MemberDAO dao = new MemberDAO();
		dao.insertMember(dto);

//		5) 등록 완료 후 목록 화면으로 리다이렉트(PRG 패턴)
//		sendRedirect를 쓰는 이유 : 새로고침 시 insert가 중복 실행되는 것을 방지
//		request.getContextPath() : 프로젝트의 context root 경로를 가져온다
//		[작성] response.sendRedirect(...) 로 /memberList 로 이동하세요 (contextPath 포함)
		response.sendRedirect(request.getContextPath()+"/memberList");
		

	}

}