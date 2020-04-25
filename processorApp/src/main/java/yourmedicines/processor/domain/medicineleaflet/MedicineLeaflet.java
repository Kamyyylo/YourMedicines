package yourmedicines.processor.domain.medicineleaflet;

import javax.validation.constraints.NotNull;
import java.util.List;

public class MedicineLeaflet {

    @NotNull(message = "Medicine head cannot be null")
    private MedicineHead medicineHead;
    @NotNull(message = "Paragraphs cannot be null")
    private List<Paragraph> paragraphs;
    @NotNull(message = "Targets cannot be null")
    private List<MedicineTakingTarget> targets;

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

    public List<MedicineTakingTarget> getTargets() {
        return targets;
    }

    public void setTargets(List<MedicineTakingTarget> targets) {
        this.targets = targets;
    }
}
