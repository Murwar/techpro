package ru.billing.stocklist;

public class TechnicalItem extends GenericItem {
    private short warrantyTime;

    public TechnicalItem(String name, float price, short warrantyTime) {
        super(name, price);
        this.warrantyTime = warrantyTime;
    }

    @Override
    public void printAll() {
        System.out.printf("ID: %d, Name: %-10s, price: %5.2f, category: %s, warranty time: %d \n", getID(), getName(),
                getPrice(), getCategory(), warrantyTime);
    }

    @Override
    public boolean equals(Object o) {
        if (super.equals(o) == true) {
            TechnicalItem otherItem = (TechnicalItem) o;
            if (this.warrantyTime != otherItem.warrantyTime)
                return false;
            return true;
        } else
            return false;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = super.hashCode();
        result = prime * result + warrantyTime;
        return result;
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        if (this.getAnalog() == null)
            return super.clone();
        return this.getAnalog().clone();
    }

    @Override
    public String toString() {
        String str = "ID:" + this.getID() + ", Name: " + this.getName() + ", price: " + this.getPrice() + ", category: "
                + this.getCategory() + ", warranty time: " + this.warrantyTime;
        return str;
    }

    public short getWarrantyTime() {
        return warrantyTime;
    }

    public void setWarrantyTime(short warrantyTime) {
        this.warrantyTime = warrantyTime;
    }
}