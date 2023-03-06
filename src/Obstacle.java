public class Obstacle {
    private int id;
    private int award;
    private String name;
    private int damage;
    private int health;
    private int orginalHealth;

    private Armor armor;

    private Weapon weapon;

    public Obstacle(int id, String name,int damage, int health, int award) {
        this.id = id;
        this.damage = damage;
        this.health = health;
        this.orginalHealth = health;
        this.name = name;
        this.award = award;
        this.armor=null;
        this.weapon = null;

    }



    public Obstacle() {

    }

    public int getAward() {
        return award;
    }

    public int getOrginalHealth() {
        return orginalHealth;
    }

    public void setOrginalHealth(int orginalHealth) {
        this.orginalHealth = orginalHealth;
    }

    public void setAward(int award) {
        this.award = award;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getDamage() {
        return damage;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
       if(health < 0)
       {
           health = 0;
       }
        this.health = health;
    }

    public Armor getArmor() {
        return armor;
    }

    public void setArmor(Armor armor) {
        this.armor = armor;
    }

    public Weapon getWeapon() {
        return weapon;
    }

    public void setWeapon(Weapon weapon) {
        this.weapon = weapon;
    }
}
