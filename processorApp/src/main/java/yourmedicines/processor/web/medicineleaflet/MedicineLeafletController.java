package yourmedicines.processor.web.medicineleaflet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import yourmedicines.processor.domain.medicineleaflet.MedicineLeaflet;
import yourmedicines.processor.services.medicineleaflet.MedicineLeafletService;
import yourmedicines.processor.web.MapValidationErrorService;

import javax.validation.Valid;

@RestController
@RequestMapping("/leaflet")
public class MedicineLeafletController {

    @Autowired
    private MedicineLeafletService medicineLeafletService;

    @Autowired
    private MapValidationErrorService mapValidationErrorService;


    @PostMapping("")
    public ResponseEntity<?> createNewLeaflet(@Valid @RequestBody MedicineLeaflet medicineLeaflet, BindingResult result) {

        ResponseEntity<?> errorMap = mapValidationErrorService.mapValidationService(result);
        if(errorMap != null) {
            return errorMap;
        }
        medicineLeafletService.addMedicineLeaflet(medicineLeaflet);
        return new ResponseEntity<>(medicineLeaflet, HttpStatus.CREATED);
    }
}
