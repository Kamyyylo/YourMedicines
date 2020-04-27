package yourmedicines.processor.web.medicineleaflet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import yourmedicines.processor.services.medicineleaflet.MedicineTakingTargetService;

@RestController
@RequestMapping("/target")
public class MedicineTakingTargetController {


    @Autowired
    private MedicineTakingTargetService medicineTakingTargetService;

    @PutMapping("/update/{id}/{name}")
    public ResponseEntity<?> updateTakingTargetName(@PathVariable long id, @PathVariable String name) {

        medicineTakingTargetService.updateTakingTargetName(id,name);
        return new ResponseEntity<>("Updated target with id: "+id+". New name: "+name, HttpStatus.CREATED);
    }
}
