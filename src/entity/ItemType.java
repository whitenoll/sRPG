package entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(
        name = "itemtype"
)
public class ItemType {
    @Id
    @Column(
            name = "idType"
    )
    private int idType;
    @Column(
            name = "typeName"
    )
    private String typeName;
    @Column(
            name = "typeDescription"
    )
    private String typeDescription;

    public ItemType() {
    }

    public ItemType(int idType, String typeName, String typeDescription) {
        this.idType = idType;
        this.typeName = typeName;
        this.typeDescription = typeDescription;
    }



    public int getIdType() {
        return this.idType;
    }

    public void setIdType(int idType) {
        this.idType = idType;
    }

    public String getTypeName() {
        return this.typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public String getTypeDescription() {
        return this.typeDescription;
    }

    public void setTypeDescription(String typeDescription) {
        this.typeDescription = typeDescription;
    }

    @Override
    public String toString() {
        return typeName ;
    }
}