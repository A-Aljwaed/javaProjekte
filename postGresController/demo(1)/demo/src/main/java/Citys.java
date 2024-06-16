import jakarta.persistence.*;
import com.example.demo.*;


@Entity
@Table(name = "Citys")

public class Citys {
@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
private String name;
private boolean isCapital;


    public boolean isCapital() {
        return isCapital;
    }

    public void setCapital(boolean capital) {
        isCapital = capital;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
