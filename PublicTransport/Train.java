

import java.io.Serializable;
import java.text.NumberFormat;

public class Train extends PublicTransport implements Serializable
{
    private double mFirstClassFare;

    public Train(String providerName, int passangers, int maxCapacity, double baseFare, double firstClassFare) throws OverCapacityException
    {
        super.mProviderName = providerName;
        super.mBaseFare = baseFare;
        if(passangers > maxCapacity)
            throw new OverCapacityException();
        else{
            super.mPassangers = passangers;
            super.mCapacity = maxCapacity;
        }
        mFirstClassFare = firstClassFare;
    }

    public double getFirstClassFare()
    {
        return mFirstClassFare;
    }
    public void setFirstClassFare(double firstClassFare)
    {
        this.mFirstClassFare = firstClassFare;
    }

    @Override
    public int hashCode()
    {
        final int prime = 31;
        int result = super.hashCode();
        long temp;
        temp = Double.doubleToLongBits(mFirstClassFare);
        result = prime * result + (int) (temp ^ (temp >>> 32));
        return result;
    }

    @Override
    public boolean equals(Object obj)
    {
        if (this == obj) return true;
        if (!super.equals(obj)) return false;
        if (getClass() != obj.getClass()) return false;
        Train other = (Train) obj;
        if (Double.doubleToLongBits(mFirstClassFare) != Double.doubleToLongBits(other.mFirstClassFare)) return false;
        return true;
    }

    @Override
    public String toString()
    {
        NumberFormat currancy = NumberFormat.getCurrencyInstance();
        return "Train [" + mProviderName + ", " + mPassangers + " passengers, " + mCapacity
                + " capacity, " + currancy.format(mBaseFare) + " base fare, " + currancy.format(mFirstClassFare) + " first class fare]";
    }
}
