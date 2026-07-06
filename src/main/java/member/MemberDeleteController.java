package member;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// ============= MemberDeleteController.java 작업 항목 =============
// doGet : URL 파라미터로 받은 회원 ID로 DB에서 해당 회원을 삭제한 뒤,
//         회원 목록 페이지(/memberList)로 리다이렉트 하세요.
// ==============================================================

//URL파라미터에서 받은 회원 ID로 DB에서 해당 회원 삭제 후
//다시 목록페이지로 리다이렉트
@WebServlet("/memberDelete")
public class MemberDeleteController extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

//		1) 삭제할 회원 ID
//		[작성] request.getParameter("memberId") 로 받은 값을 int 형(memberId)으로 변환하세요
		int memberId = Integer.parseInt(request.getParameter("memberId"));

//		2) DB에서 해당 회원 삭제
//		[작성] MemberDAO 객체를 생성하여 deleteMember(memberId) 를 호출하세요
		MemberDAO dao = new MemberDAO();
		dao.deleteMember(memberId);


//		3) 삭제 완료 후 목록 페이지로 리다이렉트
//		[작성] response.sendRedirect(...) 로 /memberList 로 이동하세요 (contextPath 포함)
		response.sendRedirect(request.getContentType()+"/memberList");

	}

}