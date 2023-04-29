import java.awt.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
public class World {
    public static String[][] _world;
    static Point Starting_Position = new Point(0, 0);
    public static ArrayList<MapTile> history = new ArrayList<MapTile>();

    public void load_tiles() {

        List<String> rows = new ArrayList<String>();
        try {
            BufferedReader f = new BufferedReader(new FileReader("C:\\Users\\roboc\\Downloads\\Regular Show LM7 Theme\\src\\map5.txt")); // Buffer Class
            String row;
            while ((row = f.readLine()) != null) {
                rows.add(row);
            }
            f.close();
            int x_max = rows.get(0).split("\t").length;
            _world = new String[rows.size()][x_max];
            String[] cols;
            String tile_name;
            for (int y = 0; y < rows.size(); y++) {
                cols = rows.get(y).split("\t");
                for (int x = 0; x < cols.length; x++) {
                    tile_name = cols[x];
                    if (tile_name.equals("TheParkEntrance")) {
                        Starting_Position.x = y;
                        Starting_Position.y = x;
                    }
                    _world[y][x] = tile_name.equals(" ") ? null : tile_name;
                }
            }
            System.out.println(_world);

        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static MapTile tile_exists(int x, int y) {
        MapTile mt = null;

        //Todo : verify the x and y exist in the world
        if ((x >= 0 && x < _world.length) && (y >= 0 && y < _world[0].length)
                && _world[x][y] != null) {
            switch (_world[x][y]) {
                case "TheParkEntrance":
                    mt = new TheParkEntrance(x, y);
                    mt = checkRoomExists(mt);
                    break;
                case "TheDojo":

                    mt = new TheDojo(x, y,new RippedShortsMullet());
                    mt = checkRoomExists(mt);
                    break;
                case "TheWoods":
                    mt = new TheWoods(x, y,new BritishTaxi());
                    mt = checkRoomExists(mt);
                    break;
                case "ParkPath":
                    mt = new ParkPath(x, y, new DollaBills(15));
                    mt = checkRoomExists(mt);
                    break;
                case "TheCoffeeShop":
                    mt = new TheCoffeeShop(x, y);
                    break;
                case "FindCartGarage":
                    mt = new FindCartGarage(x,y,new Cart());
                    mt = checkRoomExists(mt);
                    break;
                case "TheStage":
                    mt = new TheStage(x, y, new SummerTimeSong());
                    mt = checkRoomExists(mt);
                    break;
                case "TheHouse":
                    mt = new TheHouse(x, y);
                    break;
            }
        }
        return mt;
    }
    private static MapTile checkRoomExists(MapTile mt){
        if(history.indexOf(mt) != -1){
            mt = history.get(history.indexOf(mt));
        }else{
            history.add(mt);
        }
        return mt;
    }
}
