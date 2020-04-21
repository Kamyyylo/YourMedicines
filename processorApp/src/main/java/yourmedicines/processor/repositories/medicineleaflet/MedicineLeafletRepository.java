package yourmedicines.processor.repositories.medicineleaflet;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import yourmedicines.processor.domain.medicineleaflet.MedicineLeaflet;

@Repository
public interface MedicineLeafletRepository extends CrudRepository<MedicineLeaflet, Long> {

    @Override
    Iterable<MedicineLeaflet> findAllById(Iterable<Long> iterable);
}
