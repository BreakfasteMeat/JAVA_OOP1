package LA3_PVZ_v2;

interface SunProducer {
	int produce_sun();
}

interface PlantUpgrade {
	int concurrentSunCost();
}
interface Attacker{
	int attack();
	int rangeType();
}
interface InstantKiller{
	int killType();
}
interface Upgradable{
	PlantUpgrade upgrade();
}

// add more interfaces here