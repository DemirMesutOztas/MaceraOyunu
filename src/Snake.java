import java.util.Random;

public class Snake extends Obstacle {


    private int damage;
    private int awardNumber;
    private Weapon weapon;
    private Armor armor;
    private int money ;


    public Snake() {

        super(1, "Yılan", 0,1,0);
        this.setDamage(randomDamage());
        this.setId(4);
        this.setName("Yılan");
        this.setOrginalHealth(12);
        this.setHealth(12);
        this.awardNumber =randomAwardNumber();
        selectAward(awardNumber);

    }

    public int randomDamage() {
        Random r = new Random();
        return (r.nextInt(3, 7));
    }

    public static int randomAwardNumber (){
        Random r = new Random();
        int no = r.nextInt(101);

        return no;
    }

    public  void selectAward(int number)
    {
        int selectNumber;
        if(number<=15)
        { //silah
            selectNumber = randomAwardNumber();
            if(selectNumber<=20)
            {
                this.weapon = Weapon.getWeaponObjByID(2);
                this.setWeapon(this.weapon);
            }
            else if (selectNumber>20 && selectNumber<=50)
            {
                this.weapon = Weapon.getWeaponObjByID(3);
                this.setWeapon(this.weapon);
            }
            else
            {
                this.weapon = Weapon.getWeaponObjByID(1);
                this.setWeapon(this.weapon);
            }
        }
        else if (number>15 && number<=30)
        { //zırh
            selectNumber = randomAwardNumber();
            if(selectNumber<=20)
            {
                this.armor = Armor.getArmorObjByID(3);
                this.setArmor(this.armor);
            }
            else if (selectNumber>20 && selectNumber<=50)
            {
                this.armor = Armor.getArmorObjByID(2);
                this.setArmor(this.armor);
            }
            else
            {
                this.armor = Armor.getArmorObjByID(1);
                this.setArmor(this.armor);
            }

        }
        else if (number>30 && number<=55)
        { //para
            selectNumber = randomAwardNumber();
            if(selectNumber<=20)
            {
                this.money = 10;
                this.setAward(this.money);
            }
            else if (selectNumber>20 && selectNumber<=50)
            {
                this.money = 5;
                this.setAward(this.money);
            }
            else
            {
                this.money = 1;
                this.setAward(this.money);
            }

        }
        else
        { //hiçbirşey


        }

    }



}
