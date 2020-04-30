package entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(
        name = "item"
)
public class Item {
    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    @Column(
            name = "ID_item"
    )
    private int itemId;
    @Column(
            name = "name"
    )
    private String name;
    @ManyToOne
    @JoinColumn(
            name = "typeid"
    )
    public ItemType itemType;
    @Column(
            nullable = true,
            name = "width"
    )
    private int width;
    @Column(
            nullable = true,
            name = "length"
    )
    private int Length;
    @Column(
            nullable = true,
            name = "height"
    )
    private int height;
    @Column(
            nullable = true,
            name = "containerId"
    )
    private int containerId;
    @Column(
            nullable = true,
            name = "locationX"
    )
    private int locationX;
    @Column(
            nullable = true,
            name = "locationY"
    )
    private int locationY;
    @Column(
            nullable = true,
            name = "description"
    )
    private String description;
    @Column(
            nullable = true,
            name = "descriptionId"
    )
    private int descriptionId;
    @Column(
            nullable = true,
            name = "hitDice"
    )
    private String hitDice;
    @Column(
            nullable = true,
            name = "health"
    )
    private int health;
    @Column(
            nullable = true,
            name = "material"
    )
    private String material;
    private String color;
    public Item() {
    }

    public Item(int itemId, String name, int width, int Length, int height, int containerId, int locationX, int locationY, String description, int descriptionId, String hitDice, int health, String material, String color) {
        this.itemId = itemId;
        this.name = name;
        this.width = width;
        this.Length = Length;
        this.height = height;
        this.containerId = containerId;
        this.locationX = locationX;
        this.locationY = locationY;
        this.description = description;
        this.descriptionId = descriptionId;
        this.hitDice = hitDice;
        this.health = health;
        this.material = material;
        this.color = color;
    }

    public int getLength() {
        return this.Length;
    }

    public void setLength(int length) {
        this.Length = length;
    }

    public int getItemId() { return this.itemId; }

    public void setItemId(int itemId) {
        this.itemId = itemId;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ItemType getItemType() {
        return this.itemType;
    }

    public void setTypeId(int typeId) { this.itemType = this.itemType; }

    public int getWidth() {
        return this.width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return this.height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getContainerId() {
        return this.containerId;
    }

    public void setContainerId(int containerId) {
        this.containerId = containerId;
    }

    public int getLocationX() {
        return this.locationX;
    }

    public void setLocationX(int locationX) {
        this.locationX = locationX;
    }

    public int getLocationY() {
        return this.locationY;
    }

    public void setLocationY(int locationY) {
        this.locationY = locationY;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getDescriptionId() {
        return this.descriptionId;
    }

    public void setDescriptionId(int descriptionId) {
        this.descriptionId = descriptionId;
    }

    public String getHitDice() {
        return this.hitDice;
    }

    public void setHitDice(String hitDice) {
        this.hitDice = hitDice;
    }

    public int getHealth() {
        return this.health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public String getMaterial() {
        return this.material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public String getColor() {
        return this.color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String toString() {
        return "Room{roomId=" + this.itemId + ", name='" + this.name + '\'' + ", typeID='" + this.itemType.getTypeName() + '\'' + ", width=" + this.width + ", height=" + this.height + ", containerId=" + this.containerId + ", locationX=" + this.locationX + ", locationY=" + this.locationY + ", description='" + this.description + '\'' + ", descriptionId=" + this.descriptionId + ", hitDice='" + this.hitDice + '\'' + ", health=" + this.health + ", material='" + this.material +  ", color='" + this.color + '\'' + '}';
    }
}
