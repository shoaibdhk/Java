

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Scanner;

public class PublicTransportDemo
{

    @SuppressWarnings("unchecked")
    public static void main(String[] args)
    {
        ArrayList<PublicTransport> transList = new ArrayList<>();
        File binaryFile = new File("transportationList.dat");
        NumberFormat currency = NumberFormat.getCurrencyInstance();
       System.out.println("~~~~~~~~~~~~~~~ Public transportation Option~~~~~~~~~~~~\n");

       if(binaryFile.exists())
       {
           try
        {
            ObjectInputStream fileReader = new ObjectInputStream(new FileInputStream(binaryFile));
            transList = (ArrayList<PublicTransport>) fileReader.readObject();
            fileReader.close();

            for(PublicTransport pt: transList)
            {
                System.out.println(pt);
            }
            System.out.println();
        }
        catch (FileNotFoundException e)
        {
            System.out.println(e.getMessage());
        }
        catch (IOException e)
        {
            System.out.println(e.getMessage());
        }
        catch (ClassNotFoundException e)
        {
            System.out.println(e.getMessage());
        }
       }

       else
           System.out.println("[No data. Please enter public transportation options.]\n");
       int option=0;
       Scanner scnr = new Scanner(System.in);
       do{
           System.out.println("****** Transportation Options Menu*******\n"
                   +"Enter (1) to enter a Bus\n"
                   +"Enter (2) to enter a Train\n"
                   +"Enter (3) to exit");
           option = scnr.nextInt();
           scnr.nextLine();
           String providerName;
           int passangers, capacity, horsePower, firstClassFare;
           double baseFare;
           switch(option)
           {
               case 1:
                   System.out.print("What is the provider name for the bus? ");
                   providerName = scnr.nextLine();

                   System.out.print("How many passangers are on the bus? ");
                   passangers = scnr.nextInt();

                   System.out.print("What is the total capacity of the bus? ");
                   capacity = scnr.nextInt();

                   System.out.print("Enter the base fare $");
                   baseFare = scnr.nextDouble();

                   System.out.print("What is the horsepower of the bus? ");
                   horsePower = scnr.nextInt();

                   try
                {
                    Bus b = new Bus(providerName, passangers, capacity, baseFare, horsePower);
                    transList.add(b);
                }
                catch (OverCapacityException e)
                {
                    System.out.println(e.getMessage());
                }
                   break;
               case 2:
                   System.out.print("What is the provider name for the train? ");
                   providerName = scnr.nextLine();

                   System.out.print("How many passangers are on the train? ");
                   passangers = scnr.nextInt();

                   System.out.print("What is the total capacity of the train? ");
                   capacity = scnr.nextInt();

                   System.out.print("Enter the base fare $");
                   baseFare = scnr.nextDouble();

                   System.out.print("Enter the first class fare $");
                   firstClassFare = scnr.nextInt();


                   try
                {
                    Train b = new Train(providerName, passangers, capacity, baseFare, firstClassFare);
                    transList.add(b);
                }
                catch (OverCapacityException e)
                {
                    System.out.println(e.getMessage());
                }
                   break;
           }

           if(option==3)
               break;


           System.out.println();

           for(PublicTransport tp : transList)
           {
               System.out.println(tp);
           }


           System.out.println("\nAverage base fare: " + currency.format(averageBaseFare(transList))+"\n"
                           + "Bus with maximum horsepower: "+ findBusWithMaxHorsepower(transList)+"\n");

           try
        {
            ObjectOutputStream fileWriter = new ObjectOutputStream(new FileOutputStream(binaryFile));
            fileWriter.writeObject(transList);
            fileWriter.close();
        }
        catch (FileNotFoundException e)
        {
            System.out.println(e.getMessage());
        }
        catch (IOException e)
        {
            System.out.println(e.getMessage());
        }


       }while(option!=3);
       scnr.close();
       System.out.println("Travel safe and have an enjoyable break!");


    }

    public static double averageBaseFare(ArrayList<PublicTransport> transportList)
    {

        double total = 0.0, average;

        for(PublicTransport tp : transportList)
        {
            total+= tp.mBaseFare;
        }
        average = total/ transportList.size();
        return average;
    }

    public static Bus findBusWithMaxHorsepower(ArrayList<PublicTransport> transportList)
    {
        int max = Integer.MIN_VALUE;
        Bus maxHP = null;
        for(PublicTransport tp : transportList)
        {
            if(tp instanceof Bus){
                Bus b = (Bus) tp;

                if(b.getHorsePower()>max){
                    max = b.getHorsePower();
                     maxHP = b;
                }
            }
        }
       return maxHP;
    }
}
