package yourmedicines.processor.services.medicineleaflet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import yourmedicines.processor.domain.medicineleaflet.Paragraph;
import yourmedicines.processor.repositories.medicineleaflet.ParagraphRepository;

import java.util.List;

@Service
public class ParagraphService {

    @Autowired
    private ParagraphRepository paragraphRepository;

    public void addParagraph(List<Paragraph> paragraph, String medicineId) {
        int displayOrder = 0;
        for(Paragraph p : paragraph) {
            p.setMedicineId(medicineId);
            p.setDisplayOrder(displayOrder);
            displayOrder++;
            paragraphRepository.save(p);
        }
    }
}
