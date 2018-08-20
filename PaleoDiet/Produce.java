import java.io.Serializable;

public class Produce extends PaleoFood implements Serializable
{
    private boolean mOrganic;

    public Produce(String name, int calories, int carbohydrates, boolean organic)
    {
        super.mName= name;
        super.mCaloris= calories;
        super.mCarbohydrates = carbohydrates;
        mOrganic = organic;
    }

    public boolean isOrganic()
    {
        return mOrganic;
    }

    public void setOrganic(boolean organic)
    {
        mOrganic = organic;
    }

    @Override
    public int hashCode()
    {
        final int prime = 31;
        int result = super.hashCode();
        result = prime * result + (mOrganic ? 1231 : 1237);
        return result;
    }

    @Override
    public boolean equals(Object obj)
    {
        if (this == obj) return true;
        if (!super.equals(obj)) return false;
        if (getClass() != obj.getClass()) return false;
        Produce other = (Produce) obj;
        if (mOrganic != other.mOrganic) return false;
        return true;
    }

    @Override
    public String toString()
    {
        String output="";
        if(mOrganic)
            output =   "Organic Produce: " + mName + ", " + mCaloris + " calories, " + mCarbohydrates + "g carbs";
        else
          output = "Produce: " + mName + ", " + mCaloris + " calories, " + mCarbohydrates + "g carbs";
          return output;
    }


}
