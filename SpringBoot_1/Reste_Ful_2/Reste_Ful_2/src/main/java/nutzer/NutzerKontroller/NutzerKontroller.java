package nutzer.NutzerKontroller;

import nutzer.Nutzer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import schnittstellen.UserReposetory;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/nutzer")

public class NutzerKontroller {



        @Autowired
        private UserReposetory userReposetory;

        @GetMapping("/")
        List<Nutzer> getAlleNutzer () {

        return userReposetory.findAll();


    }

        @GetMapping("/{id")
        Nutzer getNutzer (@PathVariable String id){
        return userReposetory.findById(id).orElse(null);
    }


        @PostMapping("/")
        Nutzer getNutzer (@RequestBody Nutzer nutzer){
        return userReposetory.save(nutzer);
    }

        @PutMapping("/{id}")
        Nutzer getNutzer (@PathVariable String id, @RequestBody Nutzer nutzer){

        Nutzer alteNutzer = userReposetory.findById(id).orElse(null);
        alteNutzer.setName(nutzer.getName());
        alteNutzer.setEmail(nutzer.getEmail());
        alteNutzer.setPasswort(nutzer.getPasswort());
        return userReposetory.save(alteNutzer);
    }


        @DeleteMapping("{id")
        String dleteNutzer (@PathVariable String id){

        userReposetory.findById(id);
        return id;
    }

}
