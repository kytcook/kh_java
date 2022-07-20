package address.view3_2;

public class AddressCtrl {

	private AddressVO returnVO = new AddressVO();
	private AddressVO inVO = new AddressVO();

	private static String _DEL = "delete";
	private static String _INS = "insert";
	private static String _MOD = "update";
	private static String _SEL = "select";
	private static String _ALL = "selectall";

	public AddressCtrl() {
	}

	public AddressVO send(AddressVO vo)  {
		String command = vo.getCommand();

		if (command.equals(_DEL)) {
			DeleteAddrEty delEty = new DeleteAddrEty();
			returnVO = delEty.delete(vo);
		} else if (command.equals(_INS)) {
			RegisterAddrEty insEty = new RegisterAddrEty();
			returnVO = insEty.register(vo);
			//insEty.insertAddress(vo);
		} else if (command.equals(_MOD)) {
			ModifyAddrEty modEty = new ModifyAddrEty();
			returnVO = modEty.modify(vo);
		} else if (command.equals(_SEL)) {
			System.out.println("컨트롤 계층 - 상세보기 호출 성공");
			RetrieveAddrEty selEty = new RetrieveAddrEty();
			returnVO = selEty.retrieve(vo);
		}
//		주석처리한 이유 : 문제가 생기면 내가 직접 처리할거야~
//		else
//			throw new Exception("잘못된 Command명(" + command + ")입니다.");

		return returnVO;
	}

	public AddressVO[] send() {
		System.out.println("AddressCtrl send 호출 성공");
		AddressVO[] returnVOs = null;
		RetrieveAddrEty retEty = new RetrieveAddrEty();
		returnVOs = retEty.retrieve();			
		return returnVOs;
	}
	
}
	
