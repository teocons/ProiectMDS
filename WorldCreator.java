
public class WorldCreator {
	int level = 1;
	
	
	public void create() {
		if(level == 1) {
			createEasyWorld();
		}
		else if(level == 2) {
			createMediumWorld();
		}
		else if(level == 3) {
			createHardWorld();
		}
	}
	
	public void setLevel(int lvl) {
		level = lvl;
	}
	
	public void createEasyWorld() {
		
	}
	
	public void createMediumWorld() {
		
	}
	
	public void createHardWorld() {
		
	}
}
