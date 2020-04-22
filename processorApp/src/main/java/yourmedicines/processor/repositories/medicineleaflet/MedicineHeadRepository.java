package yourmedicines.processor.repositories.medicineleaflet;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import yourmedicines.processor.domain.medicineleaflet.MedicineHead;
@Repository
public interface MedicineHeadRepository extends CrudRepository<MedicineHead, Long> {

    @Override
    Iterable<MedicineHead> findAllById(Iterable<Long> iterable);

    MedicineHead getByMedicineId(String medicineName);

}
