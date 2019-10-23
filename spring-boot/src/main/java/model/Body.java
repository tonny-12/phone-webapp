package model;

import com.datastax.driver.mapping.annotations.UDT;

import java.util.List;

@UDT(keyspace = "phone_webapp", name = "body")
public class Body {

    private String dimensions;
    private String weight;
    private String sim;
    private List<String> other;

    public String getDimensions() {
        return dimensions;
    }

    public void setDimensions(String dimensions) {
        this.dimensions = dimensions;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public String getSim() {
        return sim;
    }

    public void setSim(String sim) {
        this.sim = sim;
    }

    public List<String> getOther() {
        return other;
    }

    public void setOther(List<String> other) {
        this.other = other;
    }

    @Override
    public String toString() {
        return "Body{" +
                "dimensions='" + dimensions + '\'' +
                ", weight='" + weight + '\'' +
                ", sim='" + sim + '\'' +
                ", other=" + other +
                '}';
    }

}
