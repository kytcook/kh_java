package ex10;

public class MemberVO {

	private String ID;
	private String PWD;
	private String NAME;
	
	public MemberVO() {}
	
	public MemberVO(String iD, String pWD) {
		ID = iD;
		PWD = pWD;
	}
	
	public MemberVO(String iD, String pWD, String nAME) {
		ID = iD;
		PWD = pWD;
		NAME = nAME;
	}

	public String getID() {
		return ID;
	}

	public void setID(String iD) {
		ID = iD;
	}

	public String getPWD() {
		return PWD;
	}

	public void setPWD(String pWD) {
		PWD = pWD;
	}

	public String getNAME() {
		return NAME;
	}

	public void setNAME(String nAME) {
		NAME = nAME;
	}
	
	
	
}
