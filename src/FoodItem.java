import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

class FoodItem extends GenericItem {
    Date dateOfIncome;
    short expires;

    public FoodItem(int ID, String name, float price, Date dateOfIncome, short expires) {
        super(ID, name, price);
        this.category = Category.FOOD;
        this.dateOfIncome = dateOfIncome;
        this.expires = expires;
    }

    @Override
    void printAll() {
        System.out.printf("ID: %d, Name: %-10s, price: %5.2f, category: %s, date of income: %tF, expires: %d \n", ID,
                name, price, category, dateOfIncome, expires);
    }

    @Override
    public boolean equals(Object o) {
        if (super.equals(o) == true) {
            FoodItem otherItem = (FoodItem) o;
            if (this.expires != otherItem.expires || this.dateOfIncome != otherItem.dateOfIncome)
                return false;
            return true;
        }
        else 
            return false;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = super.hashCode();
        result = prime * result + expires;
        result = prime * result + dateOfIncome.hashCode();
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
        DateFormat df = new SimpleDateFormat("dd.MM.yy");
        String str = "ID:" + this.ID + ", Name: " + this.name + ", price: " + this.price + ", category: "
                + this.category + ", date of income: " + df.format(this.dateOfIncome) + ", expires: " + this.expires;
        return str;
    }
}