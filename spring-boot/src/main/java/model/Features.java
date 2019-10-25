package model;

import com.datastax.driver.mapping.annotations.UDT;

import java.util.List;

@UDT(keyspace = "phone_webapp", name = "features")
public class Features {

    private List<String> sensor;
    private List<String> other;

    public List<String> getSensor() {
        return sensor;
    }

    public void setSensor(List<String> sensor) {
        this.sensor = sensor;
    }

    public List<String> getOther() {
        return other;
    }

    public void setOther(List<String> other) {
        this.other = other;
    }

    @Override
    public String toString() {
        return "Features{" +
                "sensor=" + sensor +
                ", other=" + other +
                '}';
    }
}
