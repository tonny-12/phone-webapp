package model;

import com.datastax.driver.mapping.annotations.UDT;

import java.util.List;

@UDT(keyspace = "phone_webapp", name = "battery")
public class Battery {

    private String battery;
    private List<String> charging;

    public String getBattery() {
        return battery;
    }

    public void setBattery(String battery) {
        this.battery = battery;
    }

    public List<String> getCharging() {
        return charging;
    }

    public void setCharging(List<String> charging) {
        this.charging = charging;
    }

    @Override
    public String toString() {
        return "Battery{" +
                "battery='" + battery + '\'' +
                ", charging=" + charging +
                '}';
    }

}
