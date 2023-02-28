public class Inventory {
    private Weapon weapon;
    private Armor armor;

    private ZoneAward zoneAward;



    public Inventory() {
        this.weapon = new Weapon("Yumruk", -1, 0, 0);
        this.armor = new Armor(-1, "Paçavra", 0, 0);
        this.zoneAward = new ZoneAward("-");
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

    public ZoneAward getZoneAward() {
        return zoneAward;
    }

    public void setZoneAward(ZoneAward zoneAward) {
        this.zoneAward = zoneAward;
    }
}
