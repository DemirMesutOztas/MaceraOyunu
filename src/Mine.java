import java.util.Random;

public class Mine extends BattleLoc
{
        private int maxObsNo;

    public Mine(Player player)
    {
        super(player, "Maden", new Snake(), "Suprise",0);
        this.maxObsNo = randomObstacle();
        this.setMaxObstacle(this.maxObsNo);
       // System.out.println("no:"+this.getMaxObstacle());

    }

    public static int randomObstacle() {
        Random r = new Random();
        return (r.nextInt(1,6));
    }
}
