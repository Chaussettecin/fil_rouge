package inventory;

import java.util.Arrays;
import java.util.ArrayList;


public class armures_creation {

	public static ArrayList<armures> getAll() {
		return (new ArrayList<armures>(Arrays.asList(new armures[]{cuire("normale")})));
    }
    
	public static armures cuire(String discription) {
 	    return new armures("cuire", discription, 5, 5, 10, 50, 1, 1, 0);
    }
}
