package yourmedicines.processor.repositories.medicineleaflet;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import yourmedicines.processor.domain.medicineleaflet.MedicineTakingTarget;
import yourmedicines.processor.domain.medicineleaflet.MedicineTakingTargetSubtype;

import java.util.List;

@Repository
public interface MedicineTakingTargetSubtypeRepository extends CrudRepository<MedicineTakingTargetSubtype, Long> {

    List<MedicineTakingTargetSubtype> findByTarget(MedicineTakingTarget target);
}
