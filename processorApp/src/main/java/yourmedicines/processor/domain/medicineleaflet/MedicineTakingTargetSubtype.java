package yourmedicines.processor.domain.medicineleaflet;


import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.sql.Timestamp;

@Entity
@Table(name = "MEDICINE_TAKING_TARGET_SUBTYPE")
public class MedicineTakingTargetSubtype {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    @NotNull(message = "Subtype name cannot be null")
    private String subType;
    @Column
    @NotNull(message = "Description of dosage for subtype cannot be null")
    private String description;
    @ManyToOne
    @JoinColumn(name = "target", nullable = false)
    @JsonIgnore
    private MedicineTakingTarget target;
    @CreationTimestamp
    private Timestamp createdDate;
    @Column(name = "ModifiedDate")
    @UpdateTimestamp
    private Timestamp modifiedDate;

    public MedicineTakingTargetSubtype() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSubType() {
        return subType;
    }

    public void setSubType(String subType) {
        this.subType = subType;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public MedicineTakingTarget getTarget() {
        return target;
    }

    public void setTarget(MedicineTakingTarget target) {
        this.target = target;
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
