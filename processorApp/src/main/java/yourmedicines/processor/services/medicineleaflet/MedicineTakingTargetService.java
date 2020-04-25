package yourmedicines.processor.services.medicineleaflet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import yourmedicines.processor.domain.medicineleaflet.MedicineTakingTarget;
import yourmedicines.processor.domain.medicineleaflet.MedicineTakingTargetSubtype;
import yourmedicines.processor.exceptions.medicineleaflet.NoParagraphFoundException;
import yourmedicines.processor.repositories.medicineleaflet.MedicineTakingTargetRepository;

import java.util.List;

@Service
public class MedicineTakingTargetService {

    @Autowired
    private MedicineTakingTargetRepository medicineTakingTargetRepository;

    @Autowired
    private MedicineTakingTargetSubtypeService medicineTakingTargetSubtypeService;

    public void addMedicineTakingTarget(List<MedicineTakingTarget> medicineTakingTarget, String medicineId) {
        for (MedicineTakingTarget m : medicineTakingTarget) {
            m.setMedicineId(medicineId);
            medicineTakingTargetRepository.save(m);
            for (MedicineTakingTargetSubtype s : m.getSubtypes()) {
                s.setTarget(m);
                medicineTakingTargetSubtypeService.addSubtypeForTarget(s);
            }
        }
    }

    public void deleteMedicineTakingTargets(String medicineId) {
        List<MedicineTakingTarget> medicineTakingTargets = medicineTakingTargetRepository.findByMedicineId(medicineId);
        if (medicineTakingTargets.size() != 0) {
            for (MedicineTakingTarget m : medicineTakingTargets) {
                medicineTakingTargetSubtypeService.deleteSubtypeForTarget(m);
                medicineTakingTargetRepository.delete(m);
            }
        } else {
            throw new NoParagraphFoundException("Unable to delete target. Target with medicineId: " + medicineId + " not found");
        }
    }
}
