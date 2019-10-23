package model;

import com.datastax.driver.mapping.annotations.Column;
import com.datastax.driver.mapping.annotations.Frozen;
import com.datastax.driver.mapping.annotations.PartitionKey;
import com.datastax.driver.mapping.annotations.Table;

import java.util.List;
import java.util.UUID;

@Table(keyspace = "phone_webapp", name = "phone")
public class Phone {

    @PartitionKey(0)
    @Column(name = "id")
    private UUID uuid;

    @PartitionKey(1)
    @Column(name = "phone_id")
    private String phoneId;

    private String brand;
    private String name;
    private List<Integer> price;
    private List<String> color;
    private String image;

    @Frozen
    private Launch launch;

    @Frozen
    private Body body;

    @Frozen
    private Display display;

    @Frozen
    private Memory memory;

    @Frozen
    @Column(name = "main_camera")
    private MainCamera mainCamera;

    @Frozen
    @Column(name = "selfie_camera")
    private SelfieCamera selfieCamera;

    @Frozen
    private Sound sound;

    @Frozen
    private Comms comms;

    @Frozen
    private Features features;

    @Frozen
    private Battery battery;

    public UUID getUuid() {
        return uuid;
    }

    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }

    public String getPhoneId() {
        return phoneId;
    }

    public void setPhoneId(String phoneId) {
        this.phoneId = phoneId;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Integer> getPrice() {
        return price;
    }

    public void setPrice(List<Integer> price) {
        this.price = price;
    }

    public List<String> getColor() {
        return color;
    }

    public void setColor(List<String> color) {
        this.color = color;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Launch getLaunch() {
        return launch;
    }

    public void setLaunch(Launch launch) {
        this.launch = launch;
    }

    public Body getBody() {
        return body;
    }

    public void setBody(Body body) {
        this.body = body;
    }

    public Display getDisplay() {
        return display;
    }

    public void setDisplay(Display display) {
        this.display = display;
    }

    public Memory getMemory() {
        return memory;
    }

    public void setMemory(Memory memory) {
        this.memory = memory;
    }

    public MainCamera getMainCamera() {
        return mainCamera;
    }

    public void setMainCamera(MainCamera mainCamera) {
        this.mainCamera = mainCamera;
    }

    public SelfieCamera getSelfieCamera() {
        return selfieCamera;
    }

    public void setSelfieCamera(SelfieCamera selfieCamera) {
        this.selfieCamera = selfieCamera;
    }

    public Sound getSound() {
        return sound;
    }

    public void setSound(Sound sound) {
        this.sound = sound;
    }

    public Comms getComms() {
        return comms;
    }

    public void setComms(Comms comms) {
        this.comms = comms;
    }

    public Features getFeatures() {
        return features;
    }

    public void setFeatures(Features features) {
        this.features = features;
    }

    public Battery getBattery() {
        return battery;
    }

    public void setBattery(Battery battery) {
        this.battery = battery;
    }

    @Override
    public String toString() {
        return "Phone{" +
                "uuid=" + uuid +
                ", phoneId='" + phoneId + '\'' +
                ", brand='" + brand + '\'' +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", color=" + color +
                ", image='" + image + '\'' +
                ", launch=" + launch +
                ", body=" + body +
                ", display=" + display +
                ", memory=" + memory +
                ", mainCamera=" + mainCamera +
                ", selfieCamera=" + selfieCamera +
                ", sound=" + sound +
                ", comms=" + comms +
                ", features=" + features +
                ", battery=" + battery +
                '}';
    }

}
