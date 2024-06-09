package nutzer;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class Nutzer {
    @Id
    public String id;
    public String name;
    public String passwort;
    public String email;
}
