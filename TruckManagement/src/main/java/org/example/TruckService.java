package org.example;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class TruckService {
    public void addTruck(Truck truck){
        String InsertQuery = "insert into trucks (name,model,capacity,driver_name) values (?,?,?,?)";
        try {
            //Create Connection
            Connection connection = CreateConnection.getConnection();

            //Prepared statement
            PreparedStatement preparedStatement = connection.prepareStatement(InsertQuery);

            //Set the value of the parameter
            preparedStatement.setString(1, truck.getName());
            preparedStatement.setString(2, truck.getModel());
            preparedStatement.setInt(3, truck.getCapacity());
            preparedStatement.setString(4, truck.getDriver_name());


            //execute Update
            int update = preparedStatement.executeUpdate();
            System.out.println("Data Inserted : "+update);
        }catch(Exception e){
            e.getStackTrace();
        }
    }

    public void updateTruck(Truck truck){

        //query
        String sql = "update trucks set name = ?, model = ?, capacity = ?, driver_name = ? where id = ?";
        try {
            //CC
            Connection connection = CreateConnection.getConnection();

            //PS --> DQ
            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            //Set value to parameter
            preparedStatement.setString(1, truck.getName());
            preparedStatement.setString(2, truck.getModel());
            preparedStatement.setInt(3, truck.getCapacity());
            preparedStatement.setString(4, truck.getDriver_name());
            preparedStatement.setInt(5, truck.getId());


            //ex up
            int update = preparedStatement.executeUpdate();
            System.out.println("Rows Updated : "+update);
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }


    public void DeleteTruckById(int id){

        //Sql Query
        String sql = "delete from trucks where id = ?";
        try {
            //creating connection
            Connection connection = CreateConnection.getConnection();

            //Prepared Statement --> Dynamic Query
            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            //Set value to parameter
            preparedStatement.setInt(1,id);

            //execute Update
            int update = preparedStatement.executeUpdate();
            System.out.println("Data Deleted  : "+update);
        } catch (SQLException e) {
            e.getStackTrace();
        }

    }

    public Truck getTruckById(int id){
        String sql = "select * from trucks where id = ?";
        Truck truck = new Truck();
        try {
            //create connection
            Connection connection = CreateConnection.getConnection();

            //prepared statement
            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            //set value to parameter
            preparedStatement.setInt(1,id);


            ResultSet resultSet = preparedStatement.executeQuery();

            if(resultSet.next()){
                truck.setId(resultSet.getInt("id"));
                truck.setName(resultSet.getString("name"));
                truck.setModel(resultSet.getString("model"));
                truck.setCapacity(resultSet.getInt("capacity"));
                truck.setDriver_name(resultSet.getString("driver_name"));
            }

        } catch (SQLException e) {
            e.getStackTrace();
        }

        return truck;
    }

    public List<Truck> getAllTrucks(){
        String sql = "select * from trucks";
        List<Truck> trucks = new ArrayList<>();

        try {
            Connection connection = CreateConnection.getConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);

            while(resultSet.next()){
                Truck truck = new Truck();
                truck.setId(resultSet.getInt("id"));
                truck.setName(resultSet.getString("name"));
                truck.setModel(resultSet.getString("model"));
                truck.setCapacity(resultSet.getInt("capacity"));
                truck.setDriver_name(resultSet.getString("driver_name"));
                trucks.add(truck);
            }
        } catch (SQLException e) {
            e.getStackTrace();
        }

        return trucks;
    }
}
