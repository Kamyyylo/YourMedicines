package yourmedicines.processor.domain.medicineleaflet;

import java.util.List;

public class MedicineLeaflet {

    private MedicineHead medicineHead;
    private List<Paragraph> paragraphs;

    public MedicineHead getMedicineHead() {
        return medicineHead;
    }

    public void setMedicineHead(MedicineHead medicineHead) {
        this.medicineHead = medicineHead;
    }

    public List<Paragraph> getParagraphs() {
        return paragraphs;
    }

    public void setParagraphs(List<Paragraph> paragraphs) {
        this.paragraphs = paragraphs;
    }
}
