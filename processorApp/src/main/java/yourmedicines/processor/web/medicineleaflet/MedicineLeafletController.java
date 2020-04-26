package yourmedicines.processor.web.medicineleaflet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import yourmedicines.processor.domain.medicineleaflet.MedicineHead;
import yourmedicines.processor.domain.medicineleaflet.MedicineLeaflet;
import yourmedicines.processor.services.medicineleaflet.MedicineHeadService;
import yourmedicines.processor.services.medicineleaflet.MedicineTakingTargetService;
import yourmedicines.processor.services.medicineleaflet.ParagraphService;
import yourmedicines.processor.web.MapValidationErrorService;

import javax.validation.Valid;

@RestController
@RequestMapping("/leaflet")
public class MedicineLeafletController {

    @Autowired
    private MedicineHeadService medicineHeadService;

    @Autowired
    private MapValidationErrorService mapValidationErrorService;

    @Autowired
    private ParagraphService paragraphService;

    @Autowired
    private MedicineTakingTargetService medicineTakingTargetService;

    @PostMapping("")
    public ResponseEntity<?> createNewLeaflet(@Valid @RequestBody MedicineLeaflet medicineLeaflet, BindingResult result) {

        ResponseEntity<?> errorMap = mapValidationErrorService.mapValidationService(result);
        if (errorMap != null) {
            return errorMap;
        }
        String medicineId = medicineHeadService.buildMedicineId(medicineLeaflet.getMedicineHead());
        medicineHeadService.addMedicineHead(medicineLeaflet.getMedicineHead(), medicineId);
        paragraphService.addParagraph(medicineLeaflet.getParagraphs(), medicineId);
        medicineTakingTargetService.addMedicineTakingTarget(medicineLeaflet.getTargets(), medicineId);

        return new ResponseEntity<>(medicineLeaflet, HttpStatus.CREATED);
    }


    @DeleteMapping("/{medicineId}")
    public ResponseEntity<?> deleteLeaflet(@PathVariable String medicineId) {
        medicineTakingTargetService.deleteMedicineTakingTargets(medicineId);
        paragraphService.deleteParagraphs(medicineId);
        medicineHeadService.deleteMedicineHead(medicineId);
        return new ResponseEntity<String>("Leaflet with id: "+medicineId+" successfully deleted", HttpStatus.OK);
    }
}
