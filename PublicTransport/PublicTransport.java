

import java.io.Serializable;

public abstract class PublicTransport implements Serializable
{
    protected String mProviderName;
    protected int mPassangers;
    protected int mCapacity;
    protected double mBaseFare;
    public String getProviderName()
    {
        return mProviderName;
    }
    public void setProviderName(String providerName)
    {
        mProviderName = providerName;
    }
    public int getPassanger()
    {
        return mPassangers;
    }
    public void setPassanger(int passangers)
    {
        mPassangers = passangers;
    }
    public int getCapacity()
    {
        return mCapacity;
    }
    public void setCapacity(int capacity)
    {
        mCapacity = capacity;
    }
    public double getBaseFare()
    {
        return mBaseFare;
    }
    public void setBaseFare(double baseFare)
    {
        mBaseFare = baseFare;
    }
    @Override
    public int hashCode()
    {
        final int prime = 31;
        int result = 1;
        long temp;
        temp = Double.doubleToLongBits(mBaseFare);
        result = prime * result + (int) (temp ^ (temp >>> 32));
        result = prime * result + mCapacity;
        result = prime * result + mPassangers;
        result = prime * result + ((mProviderName == null) ? 0 : mProviderName.hashCode());
        return result;
    }
    @Override
    public boolean equals(Object obj)
    {
        if (this == obj) return true;
        if (obj == null) return false;
        if (getClass() != obj.getClass()) return false;
        PublicTransport other = (PublicTransport) obj;
        if (Double.doubleToLongBits(mBaseFare) != Double.doubleToLongBits(other.mBaseFare)) return false;
        if (mCapacity != other.mCapacity) return false;
        if (mPassangers != other.mPassangers) return false;
        if (mProviderName == null)
        {
            if (other.mProviderName != null) return false;
        }
        else if (!mProviderName.equals(other.mProviderName)) return false;
        return true;
    }


}
