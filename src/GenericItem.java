class GenericItem implements Cloneable {
    public int ID;
    public String name;
    public float price;
    public Category category = Category.GENERAL;
    private GenericItem analog = null;

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

    void printAll() {
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
        if (this.ID != otherItem.ID & this.name != otherItem.name & this.price != otherItem.price
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
        result = prime * result + ID;
        result = prime * result + (int) price;
        return result;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
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
}