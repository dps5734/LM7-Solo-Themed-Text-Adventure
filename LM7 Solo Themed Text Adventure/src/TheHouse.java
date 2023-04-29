public class TheHouse extends MapTile {

    private String description;

    public TheHouse(int x, int y) {
        super(x, y);
        description = "You made it back to the house! You are safe now.";
    }
    public String intro_text() {
        return description;
    }
    @Override
    public void modify_player(Player player) {

    }
}