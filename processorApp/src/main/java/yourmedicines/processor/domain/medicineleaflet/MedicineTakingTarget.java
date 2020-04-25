package yourmedicines.processor.domain.medicineleaflet;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.sql.Timestamp;
import java.util.List;

@Entity
@Table(name="MEDICINE_TAKING_TARGET")
public class MedicineTakingTarget {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    @NotNull(message = "Uniqe medicine id cannot be null")
    private String medicineId;
    @Column
    @NotNull(message = "Target cannot be null")
    private String target;
    @OneToMany(mappedBy = "target")
    @NotNull(message = "Subtypes list cannot be null")
    private List<MedicineTakingTargetSubtype> subtypes;
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

    public String getMedicineId() {
        return medicineId;
    }

    public void setMedicineId(String medicineId) {
        this.medicineId = medicineId;
    }

    public String getTarget() {
        return target;
    }

    public void setTarget(String target) {
        this.target = target;
    }

    public List<MedicineTakingTargetSubtype> getSubtypes() {
        return subtypes;
    }

    public void setSubtypes(List<MedicineTakingTargetSubtype> subtypes) {
        this.subtypes = subtypes;
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
}
