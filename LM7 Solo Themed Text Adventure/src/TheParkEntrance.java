public class TheParkEntrance extends MapTile {
    public TheParkEntrance(int x, int y){
        super(x, y);
    }


    public String intro_text() {
        return "You enter the park through the front gates. Your journey to the house begins. ";
    }
    public void modify_player(Player player){

    }
}
