package yourmedicines.processor.web.medicineleaflet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import yourmedicines.processor.domain.medicineleaflet.Paragraph;
import yourmedicines.processor.services.medicineleaflet.ParagraphService;
import yourmedicines.processor.web.MapValidationErrorService;

import javax.validation.Valid;

@RestController
@RequestMapping("/paragraph")
public class ParagraphController {

    @Autowired
    private MapValidationErrorService mapValidationErrorService;

    @Autowired
    private ParagraphService paragraphService;


    @PutMapping("/update")
    public ResponseEntity<?> updateParagraph(@Valid @RequestBody Paragraph paragraph, BindingResult result) {
        ResponseEntity<?> errorMap = mapValidationErrorService.mapValidationService(result);
        if (errorMap != null) {
            return errorMap;
        }
        paragraphService.updateParagraph(paragraph);
        return new ResponseEntity<>(paragraph, HttpStatus.CREATED);
    }
}
