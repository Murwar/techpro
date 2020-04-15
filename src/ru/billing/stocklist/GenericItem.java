package ru.billing.stocklist;

public class GenericItem implements Cloneable {
    private static int currentID = 0;
    private int ID;
    private String name;
    private float price;
    private Category category = Category.GENERAL;
    private GenericItem analog = null;

    public GenericItem(String name, float price, Category category) {
        this.name = name;
        this.price = price;
        this.category = category;
        this.ID = GenericItem.currentID++;
    }

    public GenericItem(String name, float price, GenericItem analog) {
        this.name = name;
        this.price = price;
        this.analog = analog;
        this.ID = GenericItem.currentID++;
    }

    public GenericItem(String name, float price) {
        this.name = name;
        this.price = price;
        this.ID = GenericItem.currentID++;
    }

    public GenericItem() {
        this.ID = GenericItem.currentID++;
        this.name = "";
        this.price = 0.0f;
    }

    public GenericItem(int ID, String name, float price) {
        this.ID = ID;
        this.name = name;
        this.price = price;
    }

    public GenericItem getAnalog() {
        return this.analog;
    }

    public void setAnalog(GenericItem someItem) {
        this.analog = someItem;
    }

    public void printAll() {
        System.out.printf("ID: %d, Name: %-10s, price: %5.2f, category: %s \n", ID, name, price, category);
    }

    // Упражнение 1-2. Создание перечислений
    public enum Category {
        FOOD, PRINT, DRESS, GENERAL;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (o == null || o.getClass() != this.getClass())
            return false;
        GenericItem otherItem = (GenericItem) o;
        if (this.name != otherItem.name & this.price != otherItem.price
                & this.category != otherItem.category)
            return false;
        if (this.hashCode() != otherItem.hashCode())
            return false;
        return true;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + name.hashCode();
        result = prime * result + (int) price;
        return result;
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        if (analog == null)
            return super.clone();
        return this.analog.clone();
    }

    @Override
    public String toString() {
        String str = "ID:" + this.ID + ", Name: " + this.name + ", price: " + this.price + ", category: "
                + this.category;
        return str;
    }

    public int getID() {
        return ID;
    }

    public void setID(int iD) {
        ID = iD;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}