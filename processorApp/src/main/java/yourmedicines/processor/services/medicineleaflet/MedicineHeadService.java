package yourmedicines.processor.services.medicineleaflet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import yourmedicines.processor.domain.medicineleaflet.MedicineHead;
import yourmedicines.processor.domain.medicineleaflet.MedicineLeaflet;
import yourmedicines.processor.repositories.medicineleaflet.MedicineHeadRepository;

@Service
public class MedicineHeadService {

    @Autowired
    private MedicineHeadRepository medicineHeadRepository;

    public MedicineHead addMedicineHead(MedicineHead medicineHead, String medicineId) {
        medicineHead.setMedicineId(medicineId);
        medicineHead.setMedicineName(medicineHead.getMedicineName().toUpperCase());
        return medicineHeadRepository.save(medicineHead);
    }

    public String buildMedicineId(MedicineHead medicineHead) {
        StringBuilder medicineId = new StringBuilder();
        medicineId.append(medicineHead.getMedicineName().toUpperCase() + "_" + medicineHead.getMedicineType().name());
        MedicineHead medicinesTheSameId = medicineHeadRepository.getByMedicineId(medicineId.toString() + "_0");
        if (medicinesTheSameId != null) {
            boolean finish = false;
            int counter = 0;
            while (finish != true) {
                medicinesTheSameId = medicineHeadRepository.getByMedicineId(medicineId.toString() + "_" + counter);
                if(medicinesTheSameId == null){
                    finish = true;
                    medicineId.append("_" + counter++);
                } else {
                    counter++;
                }
            }
        } else {
            medicineId.append("_0");
        }
        return medicineId.toString();
    }


}
