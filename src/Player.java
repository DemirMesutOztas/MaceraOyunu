import java.util.Scanner;

public class Player {
    private int damage;
    private int orginalHealth;
    private int health;
    private int money;
    private String name;
    private String charName;
    private Inventory inventory;

    private Scanner input = new Scanner(System.in);
    public Player(String name)
    {
        this.inventory = new Inventory();
        this.name = name;
    }

    public int getTotalDamage(){
        return damage + this.getInventory().getWeapon().getDamage();
    }
    public int getDamage()
    {

        return damage;
    }

    public int getOrginalHealth() {
        return orginalHealth;
    }

    public void setOrginalHealth(int orginalHealth) {
        this.orginalHealth = orginalHealth;
    }

    public void setDamage(int damage)
    {
        this.damage = damage;
    }

    public int getHealth()
    {
        return health;
    }

    public void setHealth(int health)
    {
        if(health < 0)
        {
            health = 0;
        }
        this.health = health;
    }

    public int getMoney()
    {
        return money;
    }

    public void setMoney(int money)
    {
        this.money = money;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCharName() {
        return charName;
    }

    public void setCharName(String charName) {
        this.charName = charName;
    }

    public Inventory getInventory()
    {
        return inventory;
    }

    public void setInventory(Inventory inventory)
    {
        this.inventory = inventory;
    }

    public void selectChar()
    {
        Samurai samurai = new Samurai();
        Knight knight = new Knight();
        Archer archer = new Archer();

        GameChar[] charList = {new Samurai(), new Archer(),new Knight() };

        System.out.println("Karakterler:");
        System.out.println("--------------------------------------------");
        for(GameChar gameChar: charList)
        {

            System.out.println("ID:" + gameChar.getId()+ "\tKarakter:" + gameChar.getName() +
                    "\t\tHasar:" + gameChar.getDamage() + "\t\tSağlık:" + gameChar.getHealth() +
                    "\t\tPara:" +gameChar.getMoney());
        }

        System.out.println("--------------------------------------------");

        int selectChar = input.nextInt();
        switch(selectChar){
            case 1:
                initPlayer(new Samurai());
                break;

            case 2:
                initPlayer(new Archer());
                break;

            case 3:
                initPlayer(new Knight());
                break;

            default:
                initPlayer(new Samurai());
        }

        System.out.println("Karakteriniz: " + this.getCharName() + "\tHasar: "+ this.getDamage() +
                "\tSağlık: "+ this.getHealth() + "\tPara: "+ this.getMoney());


    }
    public void initPlayer(GameChar gameChar)
    {
        this.setOrginalHealth(gameChar.getHealth());
        this.setDamage(gameChar.getDamage());
        this.setHealth((gameChar.getHealth()));
        this.setMoney(gameChar.getMoney());
        this.setCharName(gameChar.getName());


    }

    public void printInfo() {
        System.out.println("Silah : " + this.getInventory().getWeapon().getName() +
                ", Zırh : "+ this.getInventory().getArmor().getName() +
                ", Bloklama : "+ this.getInventory().getArmor().getBlock() +
                ", Hasar : "+ this.getTotalDamage() +
                ", Sağlık : "+ this.getHealth() +
                ", Para : "+this.getMoney());
    }


}
