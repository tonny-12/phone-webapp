package model;

import com.datastax.driver.mapping.annotations.UDT;

import java.util.List;

@UDT(keyspace = "phone_webapp", name = "display")
public class Display {

    private String type;
    private String size;
    private String resolution;
    private String protection;
    private List<String> other;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getResolution() {
        return resolution;
    }

    public void setResolution(String resolution) {
        this.resolution = resolution;
    }

    public String getProtection() {
        return protection;
    }

    public void setProtection(String protection) {
        this.protection = protection;
    }

    public List<String> getOther() {
        return other;
    }

    public void setOther(List<String> other) {
        this.other = other;
    }

    @Override
    public String toString() {
        return "Display{" +
                "type='" + type + '\'' +
                ", size='" + size + '\'' +
                ", resolution='" + resolution + '\'' +
                ", protection='" + protection + '\'' +
                ", other=" + other +
                '}';
    }
}
