package org.example;

public class Truck {
    private int id;
    private String name;
    private String model;
    private int capacity;
    private String driver_name;



    public Truck(String name, String model, int capacity, String driver_name) {
        this.name = name;
        this.model = model;
        this.capacity = capacity;
        this.driver_name = driver_name;
    }

    public Truck() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public String getDriver_name() {
        return driver_name;
    }

    public void setDriver_name(String driver_name) {
        this.driver_name = driver_name;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Truck{");
        sb.append("id=").append(id);
        sb.append(", name='").append(name).append('\'');
        sb.append(", model='").append(model).append('\'');
        sb.append(", capacity=").append(capacity);
        sb.append(", driver_name='").append(driver_name).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
