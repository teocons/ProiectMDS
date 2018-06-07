public class RockTile extends Tile{

	public RockTile(int id) {
		super(Assets.stone, id);
	}
	
	public int isSolid() {
		return 1;
	}

}
