public class MysteryMeatException extends Exception
{
    public MysteryMeatException(String message){
        super(message);
    }
    public MysteryMeatException(){
        super("Type either 1 (Meat) or 2(Seafood)");
    }
}
