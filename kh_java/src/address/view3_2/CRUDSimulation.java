package address.view3_2;

import java.util.List;
import java.util.Map;

public class CRUDSimulation {

	public static void main(String[] args) {
		CRUDSimulation cs = new CRUDSimulation();
		List<Map<String,Object>> addressList = null;
		RetrieveAddrEty retEty = new RetrieveAddrEty();
		addressList = retEty.myBatisRetrieve();	
		System.out.println(addressList);
	}
}
