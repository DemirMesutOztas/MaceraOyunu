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
            if(selectNumber<=15)
            {
                this.weapon = Weapon.getWeaponObjByID(1);
            }
            else if (selectNumber>15 && selectNumber<=35)
            {
                this.weapon = Weapon.getWeaponObjByID(2);
            }
            else
            {
                this.weapon = Weapon.getWeaponObjByID(3);
            }
        }
        else if (number>15 && number<=30)
        { //zırh

        }
        else if (number>30 && number<=55)
        { //para

        }
        else
        { //hiçbirşey

        }

    }



}
