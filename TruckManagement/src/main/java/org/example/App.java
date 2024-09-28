package org.example;
import java.util.List;
import java.util.Scanner;


public class App
{


    static {
        System.out.println("Welcome To Truck HUb");
    }

    public static void main( String[] args )
    {

        SubMain Smain = new SubMain();
        Scanner scan = new Scanner(System.in);

        System.out.print("Enter the number to Perform a Operation :\n" +
                "1. Add Truck \n" +
                "2. Update Truck\n" +
                "3. Delete Truck\n" +
                "4. Get Truck By TruckId \n" +
                "5. Get All Truck \n" +
                "Press Any Key For Exit");
        System.out.println();

        int operation = scan.nextInt();


        switch (operation){
            case 1 :
                System.out.println("Welcome To Truck Adding services ");
                Smain.InsertTruck();
                break;
            case 2 :
                System.out.println("Welcome To Truck Updating Services");
                Smain.UpdateTruckData();
                break;
            case 3 :
                Smain.DeleteTruckById();
                break;
            case 4 :
                Smain.fetchTruck();
                break;
            case 5 :
                Smain.GetAllTruck();
                break;
            default :
                System.out.println("Thank You For Visiting.");



        }




        /*TruckService truckService=new TruckService();

        Truck tata=new Truck("TATA","2019",1000,"rajesh");
        Truck volvo=new Truck("VOLVO","2023",1000,"Akash");
        Truck eicher=new Truck("Eicher","2022",1000,"Harsh");

        //adding data into database
        System.out.println("Adding data......");
        truckService.addTruck(tata);
        truckService.addTruck(volvo);
        truckService.addTruck(eicher);

        //fetch
        System.out.println("Fetching data by id : ......"+1);
        Truck truck = truckService.getTruckById(1);
        System.out.println("Truck data : "+truck);

       //updating truck data
        System.out.println("Updated  data......");
        truck.setDriver_name("Ramesh");
        truckService.updateTruck(truck);
        System.out.println("Updated truck data : "+truckService.getTruckById(1));


        //get all truck data
        System.out.println("fetching all data......");
        List<Truck> allTrucks = truckService.getAllTrucks();
        System.out.println("All trucks in DB :");
        for (Truck truck1 : allTrucks)
        {
            System.out.println(truck1);
        }



        //delete truck data
        System.out.println("Deleting data by id......"+2);
        truckService.DeleteTruckById(2);
        System.out.println("Data deleted by id : "+2);



        System.out.println("get all data......");
        allTrucks=truckService.getAllTrucks();
        System.out.println("All trucks after all operations :");
        System.out.println(allTrucks);
*/

    }
}
