public class ParkPath extends LootRoom {
    public ParkPath(int x, int y, DollaBills dollaBills){
        super(x, y, dollaBills);
    }
    public String intro_text(){
        if(pickedItem == false)
            return String.format("You found a pile of DollaBills on the ground. Sweet! It's 20 bucks! ");
        else
            return "";
    }
}