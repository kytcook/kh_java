package address.view3;

public class CRUDSimulation {

	public static void main(String[] args) {
		CRUDSimulation cs = new CRUDSimulation();
		//------------- 단위테스트 시작------------
//		RetrieveAddrEty raEty = new RetrieveAddrEty();
//		raEty.retrieve();
//		AddressVO[] rvo = raEty.retrieve();
//		System.out.println(rvo);
//		System.out.println(rvo.length);
//		for(AddressVO avo : rvo) {
//			System.out.println(avo.getName()+", "+avo.getBirthday());
//		}
		//------------- 단위테스트 끝 -------------
		/* 단테시작 단테끝*/ 
		/*
		 * 트랜잭션 처리
		 * con.setAutocommit(true) - 디폴트 라서 커밋을 자동으로 처리함
		 * 2개의 테이블에 데이터를 넣어야 하나의 업무 종결 - flase / 묶음배송 - 2가지가 함께 가거나 하나도 가지 않거나. 
		 * */
		RegisterAddrEty insEty = new RegisterAddrEty();
		AddressVO pVO = new AddressVO("나신입", "서울시 영등포구 당산동", "010-555-7777"
                                   , "1", "JAVA과정동기", "19900712", "백엔드개발자", "2022-03-25",3);
		insEty.register(pVO);
		if(pVO.getResult() == 1) {
			System.out.println("입력 성공");
		}else {
			System.out.println("입력 실패");			
		}
	}
}
