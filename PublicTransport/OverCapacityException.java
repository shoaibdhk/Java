

public class OverCapacityException extends Exception
{
    public OverCapacityException(){
        super("Capacity exceeded, too many passengers.");
    }
    public OverCapacityException(String m){
        super(m);
    }
}
