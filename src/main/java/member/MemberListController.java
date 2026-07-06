package member;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// ============= MemberListController.java 작업 항목 =============
// doGet : DAO로 전체 회원 목록을 조회하여 request에 담고(setAttribute),
//         회원 목록 화면(/member/memberList.jsp)으로 forward 하세요.
// ============================================================

// 브라우저가 /memberList로 요청하면 이 서블릿이 실행
@WebServlet("/memberList")
public class MemberListController extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 1) 한글 인코딩 설정 - 음답 결과가 한글로 깨지지 않게 설정
		response.setContentType("text/html; charset=UTF-8");

		// 2) Model호출 => DAO를 통해 DB에서 전체 회원 목록 가져오기
		// [작성] MemberDAO 객체를 만들어 selectAll() 결과를 List<MemberDTO> 로 받으세요
		MemberDAO dao = new MemberDAO();
		List<MemberDTO> list = dao.selectAll();

//		3) 데이터 전달 준비 => JSP에서 꺼낼 수 있도록 request에 데이터를 담는다
//		setAttribute(키이름, 데이터) : "memberList"라는 이름(key)에 list를 저장
//		[작성] request.setAttribute("memberList", list) 로 목록을 담으세요
		request.setAttribute("memberList", list);

//		4) View로 위임 - JSP 파일 경로를 지정(webapp 폴더 기준 경로 작성)
//		forward(request, response) : request에 담긴 데이터와 함께 JSP로 처리를 넘긴다
//		[작성] RequestDispatcher 로 "/member/memberList.jsp" 를 forward 하세요
		RequestDispatcher rd = request.getRequestDispatcher("member/memberList.jsp");
		rd.forward(request, response);

	}

}