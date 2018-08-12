

import java.io.Serializable;
import java.text.NumberFormat;

public class Bus extends PublicTransport implements Serializable
{
    private int mHorsePower;

    public Bus(String providerName, int passangers, int maxCapacity, double baseFare, int horsePower) throws OverCapacityException
    {
        super.mProviderName = providerName;
        super.mBaseFare = baseFare;
        if(passangers > maxCapacity)
            throw new OverCapacityException();
        else{
            super.mPassangers = passangers;
            super.mCapacity = maxCapacity;
        }

        mHorsePower = horsePower;
    }

    public int getHorsePower()
    {
        return mHorsePower;
    }

    public void setHorsePower(int horsePower)
    {
        mHorsePower = horsePower;
    }

    @Override
    public int hashCode()
    {
        final int prime = 31;
        int result = super.hashCode();
        result = prime * result + mHorsePower;
        return result;
    }

    @Override
    public boolean equals(Object obj)
    {
        if (this == obj) return true;
        if (!super.equals(obj)) return false;
        if (getClass() != obj.getClass()) return false;
        Bus other = (Bus) obj;
        if (mHorsePower != other.mHorsePower) return false;
        return true;
    }

    @Override
    public String toString()
    {
        NumberFormat currancy = NumberFormat.getCurrencyInstance();
        return "Bus [" + mProviderName + ", " + mPassangers + " passengers, " + mCapacity
                + " capacity, " + currancy.format(mBaseFare) + " base fare, " + mHorsePower + " HP]";
    }


}
