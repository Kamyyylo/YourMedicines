package yourmedicines.processor.Services;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import yourmedicines.processor.domain.medicineleaflet.MedicineHead;
import yourmedicines.processor.domain.medicineleaflet.MedicineTypes;
import yourmedicines.processor.repositories.medicineleaflet.MedicineHeadRepository;
import yourmedicines.processor.services.medicineleaflet.MedicineHeadService;

@RunWith(MockitoJUnitRunner.class)
public class MedicineHeadServiceTest {

    @InjectMocks
    private MedicineHeadService medicineHeadService;

    @Mock
    MedicineHeadRepository medicineHeadRepositoryMock;

    @Test
    public void buildMedicineId_if_not_in_db_Test() {
        MedicineHead testObj = new MedicineHead();
        testObj.setMedicineName("medicine");
        testObj.setMedicineType(MedicineTypes.PILL);
        when(medicineHeadRepositoryMock.getByMedicineId(anyString())).thenReturn(null);
        String medicineId = medicineHeadService.buildMedicineId(testObj);
        assertEquals("MEDICINE_PILL_0", medicineId);
    }

    @Test
    public void buildMedicineId_if_exist_in_db_Test() {
        MedicineHead medicineHead = new MedicineHead();
        medicineHead.setMedicineName("medicine");
        medicineHead.setMedicineType(MedicineTypes.PILL);
        when(medicineHeadRepositoryMock.getByMedicineId("MEDICINE_PILL_0")).thenReturn(medicineHead);
        String medicineId = medicineHeadService.buildMedicineId(medicineHead);
        assertEquals("MEDICINE_PILL_1", medicineId);
    }
}
