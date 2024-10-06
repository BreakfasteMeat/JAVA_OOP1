package LA3_PVZ_v2;

import java.util.Comparator;
class CompareHP implements Comparator<Plant>{
	@Override
	public int compare(Plant p1, Plant p2){
		int ret = Integer.compare(p1.getHP(),p2.getHP());
		if(ret == 0){
			ret = p2.getName().compareTo(p1.getName());
		}
		return ret;
	}
}
class CompareSunCost implements Comparator<Plant>{
	@Override
	public int compare(Plant p1, Plant p2){
		int ret = Integer.compare(p1.getSunCost(),p2.getSunCost());
		if(ret == 0){
			ret = p2.getName().compareTo(p1.getName());
		}
		return ret;
	}
}