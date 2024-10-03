package PVZ_Codechum_version.Comparator_Interfaces;

import PVZ_Codechum_version.Plant;
import java.util.Comparator;

public class Plant_CompareByHitPoints implements Comparator<Plant>{
	public int compare(Plant p1, Plant p2){
		int ret = Integer.compare(p2.getHit_points(),p1.getHit_points());
		if(ret == 0){
			ret = p1.compareTo(p2);
		}
		return ret;
	}
}
