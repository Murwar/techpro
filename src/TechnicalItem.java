class TechnicalItem extends GenericItem {
    short warrantyTime;

    public TechnicalItem(int ID, String name, float price, short warrantyTime) {
        super(ID, name, price);
        this.warrantyTime = warrantyTime;
    }

    @Override
    void printAll() {
        System.out.printf("ID: %d, Name: %-10s, price: %5.2f, category: %s, warranty time: %d \n", ID, name, price,
                category, warrantyTime);
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
    protected Object clone() throws CloneNotSupportedException {
        if (this.getAnalog() == null)
            return super.clone();
        return this.getAnalog().clone();
    }

    @Override
    public String toString() {
        String str = "ID:" + this.ID + ", Name: " + this.name + ", price: " + this.price + ", category: "
                + this.category + ", warranty time: " + this.warrantyTime;
        return str;
    }
}