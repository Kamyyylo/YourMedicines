package yourmedicines.processor.services.medicineleaflet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import yourmedicines.processor.domain.medicineleaflet.MedicineHead;
import yourmedicines.processor.exceptions.medicineleaflet.NoLeafletFoundException;
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

    public void deleteMedicineHead(String medicineId) {
        MedicineHead medicineHead = medicineHeadRepository.findByMedicineId(medicineId);
        if(medicineHead != null) {
            medicineHeadRepository.delete(medicineHead);
        } else {
            throw new NoLeafletFoundException("Unable to delete medicine head. Head with medicineId: " + medicineId + " not found");
        }
    }

    public String buildMedicineId(MedicineHead medicineHead) {
        StringBuilder medicineId = new StringBuilder();
        medicineId.append(medicineHead.getMedicineName().toUpperCase() + "_" + medicineHead.getMedicineType().name());
        if (medicineHeadRepository.getByMedicineId(medicineId.toString() + "_0") != null) {
            boolean finish = false;
            int counter = 0;
            while (finish != true) {
                if(medicineHeadRepository.getByMedicineId(medicineId.toString() + "_" + counter) == null){
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
