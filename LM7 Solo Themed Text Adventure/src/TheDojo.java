public class TheDojo extends LootRoom {

    public TheDojo(int x, int y, RippedShortsMullet RippedShortsMullet){
        super(x, y, RippedShortsMullet);

    }

    public String intro_text(){
        if(pickedItem == false)
            return String.format("You got Ripped Shorts & a Mullet for being totally cool!");
        else
            return "";
    }

}
