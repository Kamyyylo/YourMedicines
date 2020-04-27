package yourmedicines.processor.web.medicineleaflet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import yourmedicines.processor.domain.medicineleaflet.MedicineTakingTargetSubtype;
import yourmedicines.processor.services.medicineleaflet.MedicineTakingTargetSubtypeService;
import yourmedicines.processor.web.MapValidationErrorService;

import javax.validation.Valid;

@RestController
@RequestMapping("/targetSubtype")
public class MedicineTakingTargetSubtypeController {

    @Autowired
    private MapValidationErrorService mapValidationErrorService;

    @Autowired
    private MedicineTakingTargetSubtypeService medicineTakingTargetSubtypeService;

    @PutMapping("/update")
    public ResponseEntity<?> updateSubtype(@Valid @RequestBody MedicineTakingTargetSubtype medicineTakingTargetSubtype, BindingResult result) {
        ResponseEntity<?> errorMap = mapValidationErrorService.mapValidationService(result);
        if (errorMap != null) {
            return errorMap;
        }
        medicineTakingTargetSubtypeService.updateSubtype(medicineTakingTargetSubtype);
        return new ResponseEntity<>(medicineTakingTargetSubtype, HttpStatus.CREATED);
    }
}

