public class ZoneAward
{
    private String name;


    public ZoneAward(String name)
    {
        this.name = name;

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static ZoneAward[] awards()
    {
        ZoneAward[] awardList = new ZoneAward[3];
        awardList[0] = new ZoneAward("Food");
        awardList[1] = new ZoneAward("Firewood");
        awardList[2] = new ZoneAward("Water");
        return awardList;

    }

    public static ZoneAward getWeaponObjByID(String name)
    {
        for (ZoneAward w : ZoneAward.awards()){
            if(w.getName() == name)
            {
                return w;
            }
        }
        return null;
    }

}
