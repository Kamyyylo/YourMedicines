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
import yourmedicines.processor.domain.medicineleaflet.Paragraph;
import yourmedicines.processor.exceptions.medicineleaflet.NoParagraphFoundException;
import yourmedicines.processor.services.medicineleaflet.MedicineHeadService;
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

    @PostMapping("")
    public ResponseEntity<?> createNewLeaflet(@Valid @RequestBody MedicineLeaflet medicineLeaflet, BindingResult result) {

        ResponseEntity<?> errorMap = mapValidationErrorService.mapValidationService(result);
        if (errorMap != null) {
            return errorMap;
        }
        if (medicineLeaflet.getParagraphs().size() != 0) {
            String medicineId = medicineHeadService.buildMedicineId(medicineLeaflet.getMedicineHead());
            medicineHeadService.addMedicineHead(medicineLeaflet.getMedicineHead(), medicineId);
            paragraphService.addParagraph(medicineLeaflet.getParagraphs(), medicineId);

        } else {
            throw new NoParagraphFoundException("No Paragraphs found for leaflet!");
        }

        return new ResponseEntity<>(medicineLeaflet, HttpStatus.CREATED);
    }
}
