package member;

// ================= MemberDTO.java 작업 항목 =================
// 회원 한 명의 정보를 담는 DTO 클래스를 완성하세요.
//  1) 필드 3개 : memberId(int), memberName(String), memberAge(int)
//  2) 생성자   : 기본 생성자 + 세 필드를 모두 받는 생성자
//  3) getter / setter : 세 필드 각각
// ==========================================================

public class MemberDTO {

//	필드
//	[작성] memberId(int), memberName(String), memberAge(int) 세 필드를 private 으로 선언하세요
	private int memberId;
	private String memberName;
	private int memberAge;

//	기본 생성자
//	[작성] 매개변수 없는 기본 생성자를 작성하세요
	public MemberDTO(){
		
	}

//	생성자
//	단축키 :  alt + shift + s => o   (Generate Constructor using Fields)
//	[작성] 세 필드를 모두 초기화하는 생성자를 작성하세요
	public MemberDTO(int memberId, String memberName, int memberAge) {
		this.memberId = memberId;
		this.memberName = memberName;
		this.memberAge = memberAge;
	}

//	getter & setter
//	단축키 :  alt + shift + s => r   (Generate Getters and Setters)
//	[작성] 세 필드 각각의 getter / setter 메서드를 작성하세요
	public int getMemberId() {
		return memberId;
	}

	public void setMemberId(int memberId) {
		this.memberId = memberId;
	}

	public String getMemberName() {
		return memberName;
	}

	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}

	public int getMemberAge() {
		return memberAge;
	}

	public void setMemberAge(int memberAge) {
		this.memberAge = memberAge;
	}	

	
}