
public class TreeTile extends Tile{

	public TreeTile(int id) {
		super(Assets.tree, id);
		
	}
	
	public int isSolid() {
		return 2;
	}

}
