package yourmedicines.processor.repositories.medicineleaflet;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import yourmedicines.processor.domain.medicineleaflet.Paragraph;

import java.util.List;

@Repository
public interface ParagraphRepository extends CrudRepository<Paragraph, Long> {

    @Override
    Iterable<Paragraph> findAllById(Iterable<Long> iterable);

    List<Paragraph> findByMedicineId(String medicineId);

    Paragraph findById(long id);
}
