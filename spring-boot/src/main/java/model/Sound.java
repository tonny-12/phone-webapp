package model;

import com.datastax.driver.mapping.annotations.Field;
import com.datastax.driver.mapping.annotations.UDT;

import java.util.List;

@UDT(keyspace = "phone_webapp", name = "sound")
public class Sound {

    private String loudspeaker;
    @Field(name = "headphone_jack")
    private Boolean headphoneJack;
    private List<String> other;

    public String getLoudspeaker() {
        return loudspeaker;
    }

    public void setLoudspeaker(String loudspeaker) {
        this.loudspeaker = loudspeaker;
    }

    public Boolean getHeadphoneJack() {
        return headphoneJack;
    }

    public void setHeadphoneJack(Boolean headphoneJack) {
        this.headphoneJack = headphoneJack;
    }

    public List<String> getOther() {
        return other;
    }

    public void setOther(List<String> other) {
        this.other = other;
    }

    @Override
    public String toString() {
        return "Sound{" +
                "loudspeaker='" + loudspeaker + '\'' +
                ", headphoneJack=" + headphoneJack +
                ", other=" + other +
                '}';
    }


}
