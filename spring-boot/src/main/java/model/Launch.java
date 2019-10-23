package model;

import com.datastax.driver.core.LocalDate;
import com.datastax.driver.mapping.annotations.UDT;

@UDT(keyspace = "phone_webapp", name = "launch")
public class Launch {

    private LocalDate announced;
    private LocalDate released;
    private String status;

    public LocalDate getAnnounced() {
        return announced;
    }

    public void setAnnounced(LocalDate announced) {
        this.announced = announced;
    }

    public LocalDate getReleased() {
        return released;
    }

    public void setReleased(LocalDate released) {
        this.released = released;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Launch{" +
                "announce=" + announced +
                ", release=" + released +
                ", status='" + status + '\'' +
                '}';
    }
}
