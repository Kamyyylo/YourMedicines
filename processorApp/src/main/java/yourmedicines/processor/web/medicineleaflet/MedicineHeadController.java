package yourmedicines.processor.web.medicineleaflet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import yourmedicines.processor.domain.medicineleaflet.MedicineHead;
import yourmedicines.processor.services.medicineleaflet.MedicineHeadService;
import yourmedicines.processor.web.MapValidationErrorService;

import javax.validation.Valid;

@RestController
@RequestMapping("/medicineHead")
public class MedicineHeadController {

    @Autowired
    private MapValidationErrorService mapValidationErrorService;

    @Autowired
    private MedicineHeadService medicineHeadService;

    @PutMapping("/update")
    public ResponseEntity<?> updateHead(@Valid @RequestBody MedicineHead medicineHead, BindingResult result) {
        ResponseEntity<?> errorMap = mapValidationErrorService.mapValidationService(result);
        if (errorMap != null) {
            return errorMap;
        }
        medicineHeadService.updateMedicineHead(medicineHead);
        return new ResponseEntity<>(medicineHead, HttpStatus.CREATED);
    }
}
