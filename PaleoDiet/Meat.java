import java.io.Serializable;

public class Meat extends PaleoFood implements Serializable
{
    private int mType;
    private int mCookingTemp;


    public Meat(String name, int calories, int type, int cookingTemp) throws MysteryMeatException
    {
        super.mCaloris = calories;
        super.mName = name;
        super.mCarbohydrates=0;
        setType(type);
        this.mCookingTemp = cookingTemp;
    }


    @Override
    public int hashCode()
    {
        final int prime = 31;
        int result = super.hashCode();
        result = prime * result + mCookingTemp;
        result = prime * result + mType;
        return result;
    }


    @Override
    public boolean equals(Object obj)
    {
        if (this == obj) return true;
        if (!super.equals(obj)) return false;
        if (getClass() != obj.getClass()) return false;
        Meat other = (Meat) obj;
        if (mCookingTemp != other.mCookingTemp) return false;
        if (mType != other.mType) return false;
        return true;
    }


    public int getType()
    {
        return mType;
    }


    public void setType(int type) throws MysteryMeatException
    {
        if(type!=1 && type !=2)
            throw new MysteryMeatException();
        mType = type;
    }


    public int getCookingTemp()
    {
        return mCookingTemp;
    }


    public void setCookingTemp(int cookingTemp)
    {
        mCookingTemp = cookingTemp;
    }


    @Override
    public String toString()
    {
        String output="";
        if(mType==1){
        output= "Meat: " + mName + ", " + mCaloris + " calories, " + mCarbohydrates
                + "g carbs, " + mCookingTemp + " degrees F";
        }
        else
            output= "Seafood: " + mName + ", " + mCaloris + " calories, " + mCarbohydrates
                    + "g carbs, " + mCookingTemp + " degrees F";
        return output;
    }





}
