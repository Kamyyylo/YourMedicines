package yourmedicines.processor.services.medicineleaflet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import yourmedicines.processor.domain.medicineleaflet.Paragraph;
import yourmedicines.processor.exceptions.medicineleaflet.NoParagraphFoundException;
import yourmedicines.processor.repositories.medicineleaflet.ParagraphRepository;

import java.util.List;

@Service
public class ParagraphService {

    @Autowired
    private ParagraphRepository paragraphRepository;

    public void addParagraph(List<Paragraph> paragraph, String medicineId) {
        int displayOrder = 0;
        for (Paragraph p : paragraph) {
            p.setMedicineId(medicineId);
            p.setDisplayOrder(displayOrder);
            displayOrder++;
            paragraphRepository.save(p);
        }
    }

    public void deleteParagraphs(String medicineId) {
        List<Paragraph> paragraphs = paragraphRepository.findByMedicineId(medicineId);
        if(paragraphs.size() != 0) {
            for (Paragraph p : paragraphs) {
                paragraphRepository.delete(p);
            }
        } else {
            throw new NoParagraphFoundException("Unable to delete paragraphs. Paragraphs with medicineId: "+medicineId+" not found");
        }


    }
}
