package yourmedicines.processor.domain.medicineleaflet;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.sql.Timestamp;

/*
* This table keep crucial informations of the medicine
* */
@Entity
@Table(name = "MEDICINE_HEAD")
public class MedicineHead {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    @NotNull(message = "Uniqe medicine id cannot be null")
    private String medicineId;
    @Column
    @NotNull(message = "Medicine name cannot be null")
    private String medicineName;
    @Column
    @NotNull(message = "Medicine type cannot be null")
    private MedicineTypes medicineType;
    @Column(name = "CreatedDate", updatable = false)
    @CreationTimestamp
    private Timestamp createdDate;
    @Column(name = "ModifiedDate")
    @UpdateTimestamp
    private Timestamp modifiedDate;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMedicineName() {
        return medicineName;
    }

    public void setMedicineName(String medicineName) {
        this.medicineName = medicineName;
    }

    public Timestamp getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Timestamp createdDate) {
        this.createdDate = createdDate;
    }

    public Timestamp getModifiedDate() {
        return modifiedDate;
    }

    public void setModifiedDate(Timestamp modifiedDate) {
        this.modifiedDate = modifiedDate;
    }

    public String getMedicineId() {
        return medicineId;
    }

    public void setMedicineId(String medicineId) {
        this.medicineId = medicineId;
    }


    public MedicineTypes getMedicineType() {
        return medicineType;
    }

    public void setMedicineType(MedicineTypes medicineType) {
        this.medicineType = medicineType;
    }
}


