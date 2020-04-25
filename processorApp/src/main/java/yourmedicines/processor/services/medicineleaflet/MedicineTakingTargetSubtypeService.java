package yourmedicines.processor.services.medicineleaflet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import yourmedicines.processor.domain.medicineleaflet.MedicineTakingTarget;
import yourmedicines.processor.domain.medicineleaflet.MedicineTakingTargetSubtype;
import yourmedicines.processor.exceptions.medicineleaflet.NoParagraphFoundException;
import yourmedicines.processor.repositories.medicineleaflet.MedicineTakingTargetSubtypeRepository;

import java.util.List;

@Service
public class MedicineTakingTargetSubtypeService {
    @Autowired
    private MedicineTakingTargetSubtypeRepository medicineTakingTargetSubtypeRepository;

    public void addSubtypeForTarget(MedicineTakingTargetSubtype medicineTakingTargetSubtype) {
        medicineTakingTargetSubtypeRepository.save(medicineTakingTargetSubtype);
    }

    public void deleteSubtypeForTarget(MedicineTakingTarget target) {
        List<MedicineTakingTargetSubtype> targetSubtypes = medicineTakingTargetSubtypeRepository.findByTarget(target);
        if (targetSubtypes.size() != 0) {
            for (MedicineTakingTargetSubtype st : targetSubtypes) {
                medicineTakingTargetSubtypeRepository.delete(st);
            }
        } else {
           throw new NoParagraphFoundException("Unable to delete subtypes. subtypes for target with medicineId: "+target.getMedicineId()+" not found");
        }

    }
}
