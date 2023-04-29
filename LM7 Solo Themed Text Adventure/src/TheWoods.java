public class TheWoods extends EnemyRoom{

    BritishTaxi enemy;
    public TheWoods(int x, int y, BritishTaxi enemy){
        super(x, y, enemy);
        this.enemy = enemy;
    }

    public String intro_text(){
        if (enemy.is_alive()){
            return "You stumble across a path into the woods. Suddenly high-beams are pointed in your direction. Ello Gov'ner! You run but the British Taxi runs over your ankle! ";
        }else{
            return "You smashed the lights out of that dumb Taxi! You continue your quest.";
        }
    }

}