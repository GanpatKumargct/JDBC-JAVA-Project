package org.example;

import java.util.List;
import java.util.Scanner;

public class SubMain {
    TruckService truckService=new TruckService();
    Scanner scan = new Scanner(System.in);

    public void InsertTruck(){
        System.out.print("Enter the Truck name : ");
        String name = scan.next();

        System.out.print("Enter the Truck model : ");
        String model = scan.next();

        System.out.print("Enter the Truck capacity : ");
        int capacity = scan.nextInt();

        System.out.print("Enter the Truck Driver name : ");
        String driver = scan.next();

        Truck truck = new Truck(name,model,capacity,driver);

        truckService.addTruck(truck);


    }

    public void fetchTruck(){
        System.out.print("Enter the Truck ID : ");
        int id = scan.nextInt();

        System.out.println("Fetching data by id : "+id);
        Truck truck = truckService.getTruckById(id);
        System.out.println("Truck data : "+truck);
    }

    public void UpdateTruckData(){

        System.out.print("Enter the Truck ID : ");
        int id = scan.nextInt();
        Truck truck = truckService.getTruckById(id);

        System.out.println("Before Updating Truck : "+truck);

        System.out.println("What You want to Update \n"+
                "\t1. Truck Name\n" +
                "\t2.Truck Model\n" +
                "\t3. Truck Capacity\n" +
                "\t4. Driver Name\n");

        int updateinfo = scan.nextInt();

        switch (updateinfo){
            case 1 :
                System.out.print("Enter the Truck Name : ");
                String truckname = scan.next();

                truck.setName(truckname);
                truckService.updateTruck(truck);

                break;
            case 2 :
                System.out.print("Enter the Truck model ");
                String TruckModel = scan.next();

                truck.setModel(TruckModel);
                truckService.updateTruck(truck);

                break;
            case 3 :
                System.out.print("Enter the Truck Capacity : ");
                int TruckCapacity = scan.nextInt();

                truck.setCapacity(TruckCapacity);
                truckService.updateTruck(truck);

                break;
            case 4 :
                System.out.print("Enter the Truck Driver Name : ");
                String driverName = scan.next();

                truck.setDriver_name(driverName);
                truckService.updateTruck(truck);

                break;

            default:
                System.out.println("Please Enter the valid input.");
                break;
        }

        System.out.println("After Updating Truck : "+truckService.getTruckById(id));
    }

    public void GetAllTruck(){
        System.out.println("fetching all data......");
        List<Truck> allTrucks = truckService.getAllTrucks();
        System.out.println("All trucks From Database :");
        for (Truck truck1 : allTrucks)
        {
            System.out.println(truck1);
        }
    }

    public void DeleteTruckById(){
        System.out.print("Enter the Truck ID : ");
        int id = scan.nextInt();

        System.out.println("Data is deleting for Truck Id "+id);
        truckService.DeleteTruckById(id);
        System.out.println("Data deleted Successfully.");
    }



}
