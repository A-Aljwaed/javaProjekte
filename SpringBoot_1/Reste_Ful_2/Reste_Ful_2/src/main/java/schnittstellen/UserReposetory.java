package schnittstellen;

import nutzer.Nutzer;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserReposetory extends MongoRepository<Nutzer,String> {




}
