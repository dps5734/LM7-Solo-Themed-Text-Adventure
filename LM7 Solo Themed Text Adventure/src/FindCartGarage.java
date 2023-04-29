public class FindCartGarage extends LootRoom{
    public FindCartGarage(int x, int y, Cart Cart){
        super(x, y, Cart);
    }
    public String intro_text(){
        if(pickedItem == false)
            return String.format("You found a Cart for running over Enemies ");
        else
            return "";
    }
}