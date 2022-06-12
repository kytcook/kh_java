package oracle;
// Lombok - setter, getter 생략 - 자동으로 해주지만
// 초보자는 정석대로 이해하고 나중에 쓰자.
// setter - 쓰기, 저장 : 반드시 파라미터가 있다. 무엇을 쓰고 저장할 것인가? 리턴타입이 없다. 전역변수에 담는다.
// getter - 읽기, 듣기 : 파라미터가 없다. setter에서 저장한 전역변수에 있는 값을 리턴타입으로 받는다.
// private으로 두는 이유 - 외부에서의 위변조를 막기 위해서
// getter, setter public으로 사용
// 오라클의 컬럼명과 VO 전변 이름은 통일
// 오라클 타입과 자바 타입은 맞춘다.
// 예외 발생 - 화면에서 입력 받는 값이 문자열 취급을 함
// <input type = "text">
public class MemberVO {
	private int	   mem_no   = 0;//
	private String mem_id   = "";//
	private String mem_pw   = "";//
	private String mem_name = "";//
	private String mem_zipcode = "";
	private String mem_address = "";
	int	   mem_nos[] = new int[3];
	String mem_dis[] = new String[3];
	String mem_pws[] = new String[3];
	String mem_names[] = new String[3];
	// 전역변수는 초기화를 생략할 수 있다.
	// 왜? 생성자가 대신 해주니까
	public MemberVO() {
	}
	public MemberVO(int mem_no, String mem_id, String mem_pw, String mem_name) {
		this.mem_no = mem_no;
		this.mem_id = mem_id;
		this.mem_pw = mem_pw;
		this.mem_name = mem_name;
	}
	public int getMem_no() {
		return mem_no;
	}
	public void setMem_no(int mem_no) {
		this.mem_no = mem_no;
	}
	public String getMem_id() {
		return mem_id;
	}
	public void setMem_id(String mem_id) {
		this.mem_id = mem_id;
	}
	public String getMem_pw() {
		return mem_pw;
	}
	public void setMem_pw(String mem_pw) {
		this.mem_pw = mem_pw;
	}
	public String getMem_name() {
		return mem_name;
	}
	public void setMem_name(String mem_name) {
		this.mem_name = mem_name;
	}
	public String getMem_zipcode() {
		return mem_zipcode;
	}
	public void setMem_zipcode(String mem_zipcode) {
		this.mem_zipcode = mem_zipcode;
	}
	public String getMem_address() {
		return mem_address;
	}
	public void setMem_address(String mem_address) {
		this.mem_address = mem_address;
	}
	
}   

/*
  
1, apple , 123, 애플
2, tomato, 123, 토마토
3, banana, 123, 바나나

*/
 