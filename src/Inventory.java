public class Inventory
{
    private Weapon weapon;
    private Armor armor;

    private static String [] zoneAward;

    private static int i = 0;


    public Inventory()
    {
        this.weapon = new Weapon("Yumruk", -1, 0, 0);
        this.armor = new Armor(-1, "Paçavra", 0, 0);

        this.zoneAward = new String[3];
        for(int k = 0; k<zoneAward.length;k++)
        {
            zoneAward[k]="-";
        }
    }


    public Armor getArmor()
    {
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


    public void addAward(String award){
        zoneAward[i++]=award;



    }

    public void printAward()
    {
        for(int j=0;j<i;j++){
            System.out.print(zoneAward[j]+" ");
        }
        System.out.println("");
    }

    public boolean searchAward(String s) {
        for (String st : zoneAward) {
            if (st.equals(s)) {
                return true;

            }

        }
        return false;

    }
}
