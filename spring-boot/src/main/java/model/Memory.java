package model;

import com.datastax.driver.mapping.annotations.Field;
import com.datastax.driver.mapping.annotations.UDT;

import java.util.List;

@UDT(keyspace = "phone_webapp", name = "memory")
public class Memory {

    @Field(name = "card_slot")
    private String cardSlot;
    private List<String> internal;
    private List<String> other;

    public String getCardSlot() {
        return cardSlot;
    }

    public void setCardSlot(String cardSlot) {
        this.cardSlot = cardSlot;
    }

    public List<String> getInternal() {
        return internal;
    }

    public void setInternal(List<String> internal) {
        this.internal = internal;
    }

    public List<String> getOther() {
        return other;
    }

    public void setOther(List<String> other) {
        this.other = other;
    }

    @Override
    public String toString() {
        return "Memory{" +
                "cardSlot='" + cardSlot + '\'' +
                ", internal=" + internal +
                ", other=" + other +
                '}';
    }

}
