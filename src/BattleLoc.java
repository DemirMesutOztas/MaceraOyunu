import java.security.spec.RSAOtherPrimeInfo;
import java.sql.SQLOutput;
import java.util.Random;

public class BattleLoc extends Location{

    private Obstacle obstacle;
    private String award;
    private int maxObstacle;


    public BattleLoc(Player player, String name, Obstacle obstacle, String award, int maxObstacle)
    {
        super(player, name);
        this.award = award;
        this.obstacle = obstacle;
        this.maxObstacle = maxObstacle;

    }

    @Override
    public boolean onLocation()
    {
        int obsNumber;
        if(!(this.getName().equals("Maden")))
        {
             obsNumber =this.randomObstancleNumber();
        }
        else{
            obsNumber =  this.maxObstacle;
        }


        System.out.println("Şuan buradasınız : "+this.getName());

        System.out.println("Dikkatli ol. Burada "+ obsNumber+ " tane " +this.getObstacle().getName() + " yaşıyor.");
        System.out.print("<S>avaş ya da <K>aç : ");
        String selectCase = input.nextLine();
        selectCase = selectCase.toUpperCase();
        if(selectCase.equals("S") && combat(obsNumber))
        {

            System.out.println(this.getName() + " tüm düşmanları yendiniz !");
            System.out.println("Bölge özel ödülü olan " + this.getAward() +" kazanmaya hak kazandınız");
            this.getPlayer().getInventory().addAward(this.getAward());

            return true;
        }

        if(this.getPlayer().getHealth() <= 0)
        {
            System.out.println("Öldünüz !!!");
            return false;
        }

        return true;
    }

    public boolean combat(int obsNumber)
    {
        int luckNumber = this.luck();
        System.out.println("şanslı numara :"+luckNumber);
        for(int i=0; i<obsNumber; i++)
        {
            this.getObstacle().setHealth(this.getObstacle().getOrginalHealth());
            playerStats();
            obstacleStats(i);
            while(this.getPlayer().getHealth() > 0 && this.getObstacle().getHealth() > 0){
                System.out.print("<V>ur veya <K>aç :");
                String selectCombat = input.nextLine().toUpperCase();

                if(selectCombat.equals("V") && luckNumber==0)
                {


                        System.out.println("Siz vurdunuz !");
                        this.obstacle.setHealth(this.obstacle.getHealth() - this.getPlayer().getTotalDamage());
                        afterHit();

                        if(this.getObstacle().getHealth() > 0 )
                        {
                            System.out.println();
                            System.out.println("Canavar size vurdu!");
                            int obstacleDamage = this.getObstacle().getDamage() - this.getPlayer().getInventory().getArmor().getBlock();
                            if(obstacleDamage < 0){
                                obstacleDamage = 0;
                            }
                            this.getPlayer().setHealth(this.getPlayer().getHealth() - obstacleDamage);
                            afterHit();
                        }
                        else if(this.getObstacle().getHealth()<=0)
                        {
                            System.out.println("Canavar geberdi!!!");

                        }


                }
                else if(selectCombat.equals("V") && luckNumber==1)
                {
                    if(this.getObstacle().getHealth() > 0 )
                    {
                        System.out.println();
                        System.out.println("Canavar size vurdu!");
                        int obstacleDamage = this.getObstacle().getDamage() - this.getPlayer().getInventory().getArmor().getBlock();
                        if(obstacleDamage < 0){
                            obstacleDamage = 0;
                        }
                        this.getPlayer().setHealth(this.getPlayer().getHealth() - obstacleDamage);
                        afterHit();
                    }
                    else if(this.getObstacle().getHealth()<=0)
                    {
                        System.out.println("Canavar geberdi!!!");

                    }
                    System.out.println("Siz vurdunuz !");
                    this.obstacle.setHealth(this.obstacle.getHealth() - this.getPlayer().getTotalDamage());
                    afterHit();
                }
                else
                {
                    return false;
                }
            }
            if(this.getObstacle().getHealth() < this.getPlayer().getHealth())
            {
                if(this.getName().equals("Maden"))
                {
                    System.out.println("Düşmanı yendiniz !!!");
                    if(this.obstacle.getAward()>0)
                    {
                        System.out.println(this.getObstacle().getAward() + " para kazandınız !");
                        this.getPlayer().setMoney(this.getPlayer().getMoney() + this.getObstacle().getAward());
                    }
                    else if(this.obstacle.getArmor()!=null)
                    {
                        System.out.println(this.getObstacle().getArmor().getName() + "  kazandınız !");
                        this.getPlayer().getInventory().setArmor(this.getObstacle().getArmor());

                    } else if (this.obstacle.getWeapon()!=null)
                    {
                        System.out.println(this.getObstacle().getWeapon().getName() + "  kazandınız !");
                        this.getPlayer().getInventory().setWeapon(this.getObstacle().getWeapon());
                    }

                    System.out.println("Güncel paranız : "+ this.getPlayer().getMoney());
                }
                else
                {
                    System.out.println("Düşmanı yendiniz !!!");
                    System.out.println(this.getObstacle().getAward() + " para kazandınız !");

                    this.getPlayer().setMoney(this.getPlayer().getMoney() + this.getObstacle().getAward());
                    System.out.println("Güncel paranız : "+ this.getPlayer().getMoney());
                }



            }
            else
            {
                System.out.println("Düşman, sizi YENDİ!!!");
                return false;
            }

        }
        return true;
    }

    public void afterHit(){
        System.out.println("Canınız : " + this.getPlayer().getHealth());
        System.out.println(this.getObstacle().getName() + " Canı : " + this.getObstacle().getHealth());
        System.out.println();
    }
    public void playerStats(){
        System.out.println("Oyuncu Değerleri : ");
        System.out.println("--------------------");
        System.out.println("Sağlık : "+ this.getPlayer().getHealth());
        System.out.println("Silah : "+ this.getPlayer().getInventory().getWeapon().getName());
        System.out.println("Zırh : "+ this.getPlayer().getInventory().getArmor().getName());
        System.out.println("Bloklama : "+ this.getPlayer().getInventory().getArmor().getBlock());
        System.out.println("Hasar : "+ this.getPlayer().getTotalDamage());
        System.out.println("Para : "+this.getPlayer().getMoney());

        System.out.println("*****");


    }
    public void obstacleStats(int i){
        System.out.println((i+1) + ".  "+ this.getObstacle().getName() + " Değerleri");
        System.out.println("--------------------");
        System.out.println("Sağlık : "+ this.getObstacle().getHealth());
        System.out.println("Hasar : "+ this.getObstacle().getDamage());
        if(this.getObstacle().getAward()>0)
        {
            System.out.println("Ödül : "+ this.getObstacle().getAward());
        }



        System.out.println("####");
    }
    public int randomObstancleNumber (){
        Random r = new Random();

        return (r.nextInt(this.getMaxObstacle())+1);

    }

    public int luck (){
        Random s = new Random();
        return (s.nextInt((2)));
    }



    public Obstacle getObstacle() {
        return obstacle;
    }

    public void setObstacle(Obstacle obstacle) {
        this.obstacle = obstacle;
    }

    public String getAward() {
        return award;
    }

    public void setAward(String award) {
        this.award = award;
    }

    public int getMaxObstacle() {
        return maxObstacle;
    }

    public void setMaxObstacle(int maxObstacle) {
        this.maxObstacle = maxObstacle;
    }


}
