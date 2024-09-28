package org.example;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class TruckService {
    public void addTruck(Truck truck){
        String InsertQuery = "insert into trucks (name,model,capacity,driver_name) values (?,?,?,?)";
        try {
            Connection connection = CreateConnection.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(InsertQuery);
            preparedStatement.setString(1, truck.getName());
            preparedStatement.setString(2, truck.getModel());
            preparedStatement.setInt(3, truck.getCapacity());
            preparedStatement.setString(4, truck.getDriver_name());

            int update = preparedStatement.executeUpdate();
            System.out.println("Data Inserted : "+update);
        }catch(Exception e){
            e.getStackTrace();
        }
    }

    public Truck getTruckById(int id){
        String sql = "select * from trucks where id = ?";
        Truck truck = new Truck();
        try {
            Connection connection = CreateConnection.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
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



    public void updateTruck(Truck truck){
        String sql = "update trucks set name = ?, model = ?, capacity = ?, driver_name = ? where id = ?";
        try {
            Connection connection = CreateConnection.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, truck.getName());
            preparedStatement.setString(2, truck.getModel());
            preparedStatement.setInt(3, truck.getCapacity());
            preparedStatement.setString(4, truck.getDriver_name());
            preparedStatement.setInt(5, truck.getId());


            int update = preparedStatement.executeUpdate();
            System.out.println("Rows Updated : "+update);
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }


    public void DeleteTruckById(int id){
        String sql = "delete from trucks where id = ?";
        Truck truck = new Truck();
        try {
            Connection connection = CreateConnection.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1,id);


            int update = preparedStatement.executeUpdate();
            System.out.println("Rows Deleted  : "+update);
        } catch (SQLException e) {
            e.getStackTrace();
        }

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
