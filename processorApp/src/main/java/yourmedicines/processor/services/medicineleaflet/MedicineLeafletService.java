package yourmedicines.processor.services.medicineleaflet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import yourmedicines.processor.domain.medicineleaflet.MedicineLeaflet;
import yourmedicines.processor.repositories.medicineleaflet.MedicineLeafletRepository;

@Service
public class MedicineLeafletService {

    @Autowired
    private MedicineLeafletRepository medicineLeafletRepository;

    public MedicineLeaflet addMedicineLeaflet (MedicineLeaflet medicineLeaflet) {
        return medicineLeafletRepository.save(medicineLeaflet);
    }
}
