package yourmedicines.processor.domain.medicineleaflet;

public enum MedicineTypes {
    PILL(0,"PILL"),
    SYRUP(1,"SYRUP"),
    INJECTION(2,"INJECTION");

    String name;
    int id;

    MedicineTypes( int id, String name) {
    this.name=name;
    this.id=id;
    }

}
