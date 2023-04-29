import java.util.ArrayList;
public class MapTile {
    int x;
    int y;
    public MapTile(int x, int y){
        this.x = x;
        this.y = y;
    }
    public int hashCode(){
        final int prime = 31;
        int result = 1;
        result = prime * result + x;
        result = prime * result + y;
        return result;
    }
    public boolean equals(Object obj){
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        MapTile other = (MapTile) obj;
        if (x != other.x)
            return false;
        if (x != other.y)
            return false;
        return true;
    }

    public ArrayList<Actions> adjacent_moves(){
        ArrayList<Actions> moves = new ArrayList<>();
        if (World.tile_exists(x, y +1) !=null)
            moves.add(new MoveEast());
        if (World.tile_exists(x, y -1) !=null)
            moves.add(new MoveWest());
        if (World.tile_exists(x -1, y) !=null)
            moves.add(new MoveNorth());
        if (World.tile_exists(x +1, y) !=null)
            moves.add(new MoveSouth());
        return moves;
    }
    public ArrayList<Actions> available_actions(){
        ArrayList<Actions> moves = new ArrayList<>();
        moves = adjacent_moves();
        moves.add(new ViewInventory());
        return moves;
    }
    public String intro_text(){return null;
    }

    public void modify_player(Player player) {

    }
}