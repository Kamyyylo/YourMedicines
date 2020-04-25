package yourmedicines.processor.Services;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import yourmedicines.processor.domain.medicineleaflet.MedicineHead;
import yourmedicines.processor.domain.medicineleaflet.MedicineTypes;
import yourmedicines.processor.repositories.medicineleaflet.MedicineHeadRepository;
import yourmedicines.processor.services.medicineleaflet.MedicineHeadService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MedicineHeadServiceTest {

    @Mock
    MedicineHeadRepository medicineHeadRepositoryMock;

    @Mock
    MedicineHead medicineHeadTest;

    @Autowired
    private MedicineHeadService medicineHeadService;

    @Test
    public void buildMedicineId_if_not_in_db_Test() {
        MedicineHead testObj = new MedicineHead();
        testObj.setMedicineName("medicine");
        testObj.setMedicineType(MedicineTypes.PILL);
        when(medicineHeadRepositoryMock.getByMedicineId(any())).thenReturn(isNull());
        String medicineId = medicineHeadService.buildMedicineId(testObj);
        assertEquals("MEDICINE_PILL_0", medicineId);
    }

    @Test
    public void buildMedicineId_if_exist_in_db_Test() {
        MedicineHead testObj = new MedicineHead();
        testObj.setMedicineName("medicine");
        testObj.setMedicineType(MedicineTypes.PILL);
        StringBuilder sb = new StringBuilder();
        when(sb.toString()).thenReturn("");
        when(medicineHeadRepositoryMock.getByMedicineId(anyString())).thenReturn(isNotNull());

        //when(medicineHeadRepositoryMock.getByMedicineId("MEDICINE_PILL_0")).thenReturn(isNull());
        String medicineId = medicineHeadService.buildMedicineId(testObj);
        assertEquals("MEDICINE_PILL_0", medicineId);
    }
}
