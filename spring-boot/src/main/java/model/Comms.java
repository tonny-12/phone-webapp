package model;

import com.datastax.driver.mapping.annotations.UDT;

@UDT(keyspace = "phone_webapp", name = "comms")
public class Comms {

    private String wlan;
    private String bluetooth;
    private String gps;
    private Boolean nfc;
    private String radio;
    private String usb;

    public String getWlan() {
        return wlan;
    }

    public void setWlan(String wlan) {
        this.wlan = wlan;
    }

    public String getBluetooth() {
        return bluetooth;
    }

    public void setBluetooth(String bluetooth) {
        this.bluetooth = bluetooth;
    }

    public String getGps() {
        return gps;
    }

    public void setGps(String gps) {
        this.gps = gps;
    }

    public Boolean getNfc() {
        return nfc;
    }

    public void setNfc(Boolean nfc) {
        this.nfc = nfc;
    }

    public String getRadio() {
        return radio;
    }

    public void setRadio(String radio) {
        this.radio = radio;
    }

    public String getUsb() {
        return usb;
    }

    public void setUsb(String usb) {
        this.usb = usb;
    }

    @Override
    public String toString() {
        return "Comms{" +
                "wlan='" + wlan + '\'' +
                ", bluetooth='" + bluetooth + '\'' +
                ", gps='" + gps + '\'' +
                ", nfc=" + nfc +
                ", radio='" + radio + '\'' +
                ", usb='" + usb + '\'' +
                '}';
    }

}
