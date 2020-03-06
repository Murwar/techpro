import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

class FoodItem extends GenericItem {
    Date dateOfIncome;
    short expires;

    public FoodItem(String name, float price, FoodItem analog, Date date, short expires) {
        super(name, price, analog);
        this.dateOfIncome = date;
        this.expires = expires;
        this.category = Category.FOOD;
    }

    public FoodItem(String name, float price, short expires) {
        this(name, price, null, new Date(), expires);
    }

    public FoodItem(String name){
        this(name, 0.0f, null, new Date(), (short)0);
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
        } else
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