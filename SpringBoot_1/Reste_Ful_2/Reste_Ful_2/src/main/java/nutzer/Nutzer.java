package nutzer;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
//import javax.persistence.Entity.*;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.annotation.Id;
import org.springframework.web.bind.annotation.RequestMapping;


@Data
@NoArgsConstructor
@AllArgsConstructor
@RequestMapping("/nutzer")
public class Nutzer {
    @Id
    public String id;
    public String name;
    public String passwort;
    public String email;
}
