public class LootRoom extends MapTile{
    Item item;
    public boolean pickedItem = false;
    public LootRoom(int x, int y, Item item){
        super(x, y);
        this.item = item;
    }
    public void add_Loot(Player player){
        player.inventory.add(item);
        pickedItem = true;
    }
    public void modify_player(Player player) {
        if (!pickedItem) {
            player.inventory.add(item);
            pickedItem = true;
            System.out.println("You picked up a " + item.name + ".");
        } else {
            System.out.println("You already picked up the item in this room.");
        }
    }
}

