package model;

import com.datastax.driver.mapping.annotations.UDT;

@UDT(keyspace = "phone_webapp", name = "platform")
public class Platform {

    private String os;
    private String chipset;
    private String cpu;
    private String gpu;

    public String getOs() {
        return os;
    }

    public void setOs(String os) {
        this.os = os;
    }

    public String getChipset() {
        return chipset;
    }

    public void setChipset(String chipset) {
        this.chipset = chipset;
    }

    public String getCpu() {
        return cpu;
    }

    public void setCpu(String cpu) {
        this.cpu = cpu;
    }

    public String getGpu() {
        return gpu;
    }

    public void setGpu(String gpu) {
        this.gpu = gpu;
    }

    @Override
    public String toString() {
        return "Platform{" +
                "os='" + os + '\'' +
                ", chipset='" + chipset + '\'' +
                ", cpu='" + cpu + '\'' +
                ", gpu='" + gpu + '\'' +
                '}';
    }

}
