package PVZ_Codechum_version.Comparator_Interfaces;

import PVZ_Codechum_version.Plant;
import java.util.Comparator;

public class Plant_CompareByGivenHitPoints implements Comparator<Plant>{
	int hit_points;

	public Plant_CompareByGivenHitPoints(int hit_points){
		this.hit_points = hit_points;
	}

	public void setHit_points(int hit_points){
		this.hit_points = hit_points;
	}

	@Override
	public int compare(Plant o1, Plant o2){
		int o1_diff = Math.abs(hit_points - o1.getHit_points());
		int o2_diff = Math.abs(hit_points - o2.getHit_points());
		int ret = Integer.compare(o1_diff,o2_diff);
		if(ret == 0){
			ret = o1.getName().compareTo(o2.getName());
		}
		return ret;
	}
}
