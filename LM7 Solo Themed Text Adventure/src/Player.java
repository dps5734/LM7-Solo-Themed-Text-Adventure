import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
public class Player implements Comparable<Player> {
    int hp;
    String name;

    public int compareTo(Player othrPlyr) {
        return othrPlyr.score.compareTo(this.score);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    int plyrGems;
    Integer score;
    Boolean victory;
    int location_x, location_y;
    int prevLocatnX, prevLocatnY;
    ArrayList<Item> inventory = new ArrayList<Item>();

    //Constructor method
    public Player(String name) {
        super();
        this.name = name;
        inventory.add(new DollaBills(15));
        inventory.add(new Pillow());
        this.hp = 140; // Health Points
        this.location_x = World.Starting_Position.x;
        this.location_y = World.Starting_Position.y;
        this.victory = false; //no victory on start up
    }

    public Player() {
    }

    public boolean is_alive() {
        return (hp > 0);
    }

    public void print_inventory() {
        int totalGems = 0;
        DollaBills dollaBills = null;
        for (Item item : inventory) {
            if (!(item instanceof DollaBills)) {

                System.out.println(item.toString());
            } else {
                dollaBills = (DollaBills) item;
                totalGems += dollaBills.amt;
            }

        }
        Item gold = new DollaBills(totalGems);
        plyrGems = totalGems;
        System.out.println(dollaBills.toString());
    }

    public void updateGems() {
        int totalGems = 0;
        DollaBills dollaBills = null;
        for (Item item : inventory) {
            if (!(item instanceof DollaBills)) {

            } else {
                dollaBills = (DollaBills) item;
                totalGems += dollaBills.amt;
            }

        }
        Item Gems = new DollaBills(totalGems);
        plyrGems = totalGems;

    }

    public void writeToFile() {
        updateGems();
        try {
            File fw = new File("Scores.txt");
            if (!fw.exists()) {
                fw.createNewFile();
            }

            FileWriter fobj = new FileWriter(fw, true);
            PrintWriter pobj = new PrintWriter(fobj);
            pobj.println(name + "\t" + plyrGems);

            pobj.close();
            fobj.close();
            FileReader frdr = new FileReader(fw);
            BufferedReader brdr = new BufferedReader(frdr);
            String entry = "";
            ArrayList<Player> plyrs = new ArrayList<Player>();
            while ((entry = brdr.readLine()) != null) {
                String arr[] = entry.split("\t");
                Player plyr = new Player();
                plyr.setName(arr[0]);
                plyr.setScore(Integer.parseInt(arr[1]));
                plyrs.add(plyr);
            }

            Collections.sort(plyrs);
            for (Player p : plyrs) {
                System.out.println("Name:" + p.getName() + "    Score:" + p.getScore());

            }

        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    public void move(int dx, int dy) {
        prevLocatnX = location_x;
        prevLocatnY = location_y;
        location_x += dx;
        location_y += dy;
        System.out.print(World.tile_exists(location_x, location_y).intro_text());
    }

    public void move_north() {
        move(-1, 0);
    }

    public void move_south() {
        move(1, 0);
    }

    public void move_east() {
        move(0, 1);
    }

    public void move_west() {
        move(0, -1);
    }

    public void doFlee(MapTile mp) {
        ArrayList<Actions> available_moves = mp.adjacent_moves();
        Random rn = new Random();
        int random = rn.nextInt(available_moves.size());
        Actions randomActions = available_moves.get(random);
        do_action(randomActions, null, null);

    }

    public void attackEnemy(Enemy enemy) {
        Weapon best_weapon = new Weapon("None", "None", 0, 0);
        int max_dmg = 0;
        for (Item i : inventory) {
            if (i instanceof Weapon) {
                Weapon wpn = (Weapon) i;
                if (wpn.getDamage() > max_dmg) {
                    max_dmg = wpn.getDamage();
                    best_weapon = wpn;
                }
            }
        } //End Code block for loop
        System.out.printf("You use %s against %s!", best_weapon.name, enemy.name);
        enemy.hp -= best_weapon.getDamage();
        if (!enemy.is_alive()) {
            System.out.printf("You killed %s!", enemy.name);
        } else {
            System.out.printf("%s HP is %d.", enemy.name, enemy.hp);
        }
    }

    public void do_action(Actions actions, Enemy kwargs, MapTile mp) {
        if (kwargs == null) {
            if (actions instanceof MoveEast) {
                move_east();
            } else if (actions instanceof MoveWest) {
                move_west();
            } else if (actions instanceof MoveNorth) {
                move_north();
            } else if (actions instanceof MoveSouth) {
                move_south();
            } else if (actions instanceof ViewInventory) {
                print_inventory();
            } else if (actions instanceof Run) {
                doFlee(mp);
            }

        } else if (actions instanceof Attack) {
            attackEnemy(kwargs);
        }

    }
}