import java.io.Serializable;

public abstract class PaleoFood implements Serializable
{
    protected int mCaloris;
    protected int mCarbohydrates;
    protected String mName;
    public int getCaloris()
    {
        return mCaloris;
    }
    public void setCaloris(int caloris)
    {
        mCaloris = caloris;
    }
    public int getCarbohydrates()
    {
        return mCarbohydrates;
    }
    public void setCarbohydrates(int carbohydrates)
    {
        mCarbohydrates = carbohydrates;
    }
    public String getName()
    {
        return mName;
    }
    public void setName(String name)
    {
        mName = name;
    }
    @Override
    public int hashCode()
    {
        final int prime = 31;
        int result = 1;
        result = prime * result + mCaloris;
        result = prime * result + mCarbohydrates;
        result = prime * result + ((mName == null) ? 0 : mName.hashCode());
        return result;
    }
    @Override
    public boolean equals(Object obj)
    {
        if (this == obj) return true;
        if (obj == null) return false;
        if (getClass() != obj.getClass()) return false;
        PaleoFood other = (PaleoFood) obj;
        if (mCaloris != other.mCaloris) return false;
        if (mCarbohydrates != other.mCarbohydrates) return false;
        if (mName == null)
        {
            if (other.mName != null) return false;
        }
        else if (!mName.equals(other.mName)) return false;
        return true;
    }




}
