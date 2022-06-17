package ajdbc.member3;

import jdbc.oracle.LoginDao;

public class MemberController {
	public final String _LOGIN 		= "login";
	public final String _SIGNUP 	= "membership";
	public final String _IDCHECK 	= "idcheck";
	Member3VO mVO = null;
	//선택이나 요청을 하는것은 사용자나 업무담당자가 하게 되고 그걸 들어서 요청에 맞는 프로세스를 액션을 태워야 한다
	public MemberController(){ }
	public MemberController(Member3VO mVO){ 
		this.mVO = mVO;
	}
		
	public void action() {
		String command = mVO.getCommand();
		// LoginDao 생성하기
		if(_LOGIN.equals(command)) {
			LoginDao loginDao = new LoginDao();
			String mem_name = null;
			mem_name = loginDao.login("사용자가 입력한 아이디", "사용자가 입력한 비번");
		}else if(_SIGNUP.equals(command)) {
			MemberDao memDao = new MemberDao();
			int result = 0;
			result = memDao.memberInsert();
		}else if(_IDCHECK.equals(command)) {
			LoginDao loginDao = new LoginDao();
			boolean isOk = loginDao.idcheck("사용자가 입력한 아이디값");//접두어에 is를 붙이면 boolean
			
		}
	}
}
