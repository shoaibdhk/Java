import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class FoodJournalDemo
{

    @SuppressWarnings("unchecked")
    public static void main(String[] args)
    {

        ArrayList<PaleoFood> foodList= new ArrayList<>();
        File binaryFile = new File("food.dat");
        Scanner scnr = new Scanner(System.in);
        System.out.println("~~~~~~~~~~~Welcome to the Paleo Food Journal~~~~~~~~~~~~~ \n");
        if(binaryFile.exists()){
            try
            {
                ObjectInputStream fileReader = new ObjectInputStream(new FileInputStream(binaryFile));
                foodList = (ArrayList<PaleoFood>) fileReader.readObject();
                fileReader.close();
                for(PaleoFood food: foodList){
                    System.out.println(food);
                }
            }
            catch (ClassNotFoundException e)
            {
                System.out.println(e.getMessage());
            }
            catch (IOException e)
            {
                System.out.println(e.getMessage());
            }
        }else
            System.out.println("[No food eaten.  You must be hungry.] \n");
         try{

             int menu=0;
             do{
                 System.out.println("\n******* Options Menu ********\n"+
                         "Enter (1) to record a meat\n"+
                         "Enter (2) to record a produce\n"+
                         "Enter (3) to quit");
                 menu = scnr.nextInt();
                 scnr.nextLine();
                 String name;
                 int calories, type, cookingTemp, carbohydrates;
                 if(menu==1){
                     System.out.print("What is the name of the meat eaten? ");
                     name = scnr.nextLine();
                     System.out.print("How many calories was it? ");
                     calories = scnr.nextInt();
                     scnr.nextLine();
                     System.out.print("Enter (1) for animal or (2) for Seafood: ");
                     type = scnr.nextInt();
                     scnr.nextLine();
                     System.out.print("Enter the cooking temparature:");
                     cookingTemp = scnr.nextInt();

                     try{
                         Meat meat = new Meat(name, calories, type, cookingTemp);
                         foodList.add(meat);
                     }
                     catch(MysteryMeatException e){
                         System.out.println(e.getMessage());
                         scnr.nextLine();
                     }


                 }
                 else if(menu==2){
                     System.out.print("What is the name of the produce eaten? ");
                     name = scnr.nextLine();
                     System.out.print("How many calories was it? ");
                     calories = scnr.nextInt();
                     scnr.nextLine();
                     System.out.print("How many carbohydrates? ");
                     carbohydrates = scnr.nextInt();
                     System.out.print("Enter (1) for organic or (2) for non-organic: ");
                     type = scnr.nextInt();
                     boolean organic;
                     if(type==1){
                         organic = true;
                     }else
                         organic = false;
                     Produce food = new Produce(name, calories, carbohydrates, organic);
                     foodList.add(food);
                 }
                 else if(menu==3)
                     break;
                 else{
                     System.out.println("Please enter again.");
                 }
                 System.out.println();
                 for(PaleoFood f: foodList)
                     System.out.println(f);
                 System.out.println("\nTotal calories eaten: "+ totalCalories(foodList)
                 +"\nNumber of organic fruits and veggies eaten: "+ organicProductConsumed(foodList));
                 try
                {
                    ObjectOutputStream binaryWriter = new ObjectOutputStream(new FileOutputStream(binaryFile));
                    binaryWriter.writeObject(foodList);
                    binaryWriter.close();
                }
                catch (FileNotFoundException e)
                {
                    System.out.println(e.getMessage());
                }
                catch (IOException e)
                {
                    System.out.println(e.getMessage());
                }
             }while(menu!=3);
             System.out.println("\nEat healthy and enjoy your break!");
         }
         catch(InputMismatchException e){
             System.out.println(e.getMessage());
             scnr.nextLine();
         }



    }

    public static int totalCalories(ArrayList<PaleoFood> foodList){
        int total = 0;
        for(PaleoFood pf : foodList)
            total+= pf.getCaloris();
        return total;
    }

    public static int organicProductConsumed(ArrayList<PaleoFood> foodList){
        int total = 0;
        for(PaleoFood pf : foodList){
            if(pf instanceof Produce)
            {
                Produce p = (Produce) pf;
                if(p.isOrganic())
                    total++;
            }
        }
        return total;
    }

}
