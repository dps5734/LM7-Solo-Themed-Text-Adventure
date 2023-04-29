//Base/Super/Parent class Enemy
public class Enemy {

    protected String name;
    protected String description;
    protected int hp;
    protected int damage;


    //class Level Variable
    //A constructor method can be overloaded
    //this keyword is the current object's properties

    public Enemy(String name, String description, int hp, int damage){
        this.name = name;
        this.description = description;
        this.hp = hp;
        this.damage = damage;
    }

    //Health Check Method: return boolean value, accepts no input arguments
    //Player is alive if health points are greater than zero
    public boolean is_alive(){
        return (this.hp > 0);
    //public String toString() {
        //return String.format("%s \n=====\n %s \nValue= %d \n", this.name, this.hp, this.damage);
    }
}
