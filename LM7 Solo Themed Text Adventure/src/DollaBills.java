public class DollaBills extends Item{
    public int amt;

    public DollaBills(int amt){
        super("DollaBills", "Cash", 10);
        this.amt = Integer.parseInt(String.valueOf(amt));


    }
}
