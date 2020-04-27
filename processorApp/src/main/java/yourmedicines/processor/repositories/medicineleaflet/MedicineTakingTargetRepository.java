package yourmedicines.processor.repositories.medicineleaflet;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import yourmedicines.processor.domain.medicineleaflet.MedicineTakingTarget;

import java.util.List;

@Repository
public interface MedicineTakingTargetRepository extends CrudRepository<MedicineTakingTarget, Long> {

    List<MedicineTakingTarget> findByMedicineId(String medicineId);

    MedicineTakingTarget findById(long id);

}
