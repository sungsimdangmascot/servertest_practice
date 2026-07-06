package member;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// ============= MemberUpdateController.java 작업 항목 =============
// doGet  : 수정할 회원의 기존 정보를 조회(selectOne)하여 request에 담고,
//          수정 폼(/member/memberUpdateForm.jsp)으로 forward 하세요.
// doPost : 폼에서 넘어온 수정 데이터를 DTO에 담아 DAO로 update 한 뒤,
//          회원 목록(/memberList)으로 리다이렉트 하세요.
// ==============================================================

@WebServlet("/memberUpdate")
public class MemberUpdateController extends HttpServlet {

//	doGet() : GET요청 => 기존 회원 정보를 조회하여 수정 폼에 채워 보여준다
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");

//		1) URL 파라미터에서 수정할 회원의 ID를 읽는다
//		ex) /memberUpdate?memberId=3 => "3"을 가져옴
//		[작성] request.getParameter("memberId") 를 int 형(memberId)으로 변환하세요
		int memberId = Integer.parseInt(request.getParameter("memberId"));

//		2) DB에서 해당 회원 정보 조회(수정 폼에 기존 값을 미리 채우기 위해)
//		[작성] MemberDAO 객체를 만들어 selectOne(memberId) 결과를 MemberDTO 로 받으세요
		MemberDAO dao = new MemberDAO();
		MemberDTO dto = dao.selectOne(memberId);

//		3) 조회한 dto를 request에 담아 JSP로 전달
//		[작성] request.setAttribute("dto", dto) 로 담은 뒤,
//		       RequestDispatcher 로 "/member/memberUpdateForm.jsp" 를 forward 하세요
		request.setAttribute("dto", dto);
		RequestDispatcher rd = request.getRequestDispatcher("/member/memberUpdateForm.jsp");
		rd.forward(request, response);

	}

//	doPost() : POST요청 => 수정된 데이터를 DB에 반영
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
//		1) 한글 깨짐 방지
		request.setCharacterEncoding("UTF-8");

//		2) 폼에서 전달된 수정 데이터 읽기 (memberId는 hidden 필드)
//		[작성] memberId, memberName, memberAge 를 request.getParameter(...) 로 읽으세요
//		       (memberId, memberAge 는 int 로 변환)
		int memberId = Integer.parseInt(request.getParameter("memberId"));
		String memberName = request.getParameter("memberName");
		int memberAge = Integer.parseInt(request.getParameter("memberAge"));

//		3) DTO에 수정 데이터 담기
//		[작성] MemberDTO 객체를 만들고 setMemberId / setMemberName / setMemberAge 로 값을 담으세요
		MemberDTO dto = new MemberDTO();
		dto.setMemberId(memberId);
		dto.setMemberName(memberName);
		dto.setMemberAge(memberAge);

//		4) DB update 실행
//		[작성] MemberDAO 객체를 만들어 updateMember(dto) 를 호출하세요
		MemberDAO dao = new MemberDAO();
		dao.updateMember(dto);
		

//		5) 수정 완료 후 목록으로 리다이렉트
//		[작성] response.sendRedirect(...) 로 /memberList 로 이동하세요 (contextPath 포함)
		response.sendRedirect(request.getContextPath()+"/memberList");

	}

}