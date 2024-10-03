package PVZ_Codechum_version.Comparator_Interfaces;

import PVZ_Codechum_version.Plant;

import java.util.Comparator;

public class Plant_CompareBySunCost implements Comparator<Plant>{
	@Override
	public int compare(Plant o1, Plant o2){
		int ret = Integer.compare(o1.getSun_cost(),o2.getSun_cost());
		if(ret == 0){
			ret = o1.compareTo(o2);
		}
		return ret;
	}
}
