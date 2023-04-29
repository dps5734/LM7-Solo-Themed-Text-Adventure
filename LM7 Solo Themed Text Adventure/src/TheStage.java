public class TheStage extends EnemyRoom{
    SummerTimeSong enemy;

    public TheStage(int x, int y, SummerTimeSong enemy){
        super(x, y, enemy);
        this.enemy=enemy;
    }
    public String intro_text(){
        if (enemy.is_alive()){
            return "Uggggghhhh it's that SummerTimeSong again, and it's playing it's song on the stage! ";
        }else{
            return "You run away from that annoying song.";
        }
    }
}
