import org.springframework.stereotype.Component;

@Component
public class SagService implements Sager {


    @Override
    public String hey() {
        return "hallo Leute";
    }
}
