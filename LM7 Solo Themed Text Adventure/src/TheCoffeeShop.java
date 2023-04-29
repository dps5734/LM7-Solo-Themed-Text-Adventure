public class TheCoffeeShop extends MapTile {
    private String desc;

    public TheCoffeeShop(int x, int y) {
        super(x, y);
        desc = "You walk into the coffee shop for a cup of joe, and to say hi to Margret. ";
    }
    public String intro_text() {
        return desc;
    }
    @Override
    public void modify_player(Player player) {

    }
}