import java.util.Date;

public class Main {
    public static void main(String[] args) throws Exception {
        // Упражнение 1-1. Создание собственных классов
        GenericItem item0 = new GenericItem("Milk", 69.3f, GenericItem.Category.FOOD);
        GenericItem item1 = new GenericItem("Juice", 94.5f, GenericItem.Category.FOOD);
        GenericItem item2 = new GenericItem("Water", 34.2f, GenericItem.Category.FOOD);
        item0.printAll();
        item1.printAll();
        item2.printAll();
        // Опционально. Добавление аналога
        item2.setAnalog(item1);
        System.out.println("\n Analog of " + item2.name + " is " + item2.getAnalog().name + "\n");

        // Упражнение 2-1. Применение наследования
        TechnicalItem item3 = new TechnicalItem("TV", 5045.0f, (short) 1080);
        TechnicalItem item4 = new TechnicalItem("Phone", 9999.99f, (short) 720);
        Date date = new Date();
        FoodItem item5 = new FoodItem("Apples", 120.2f, null, date, (short) 30);
        FoodItem item6 = new FoodItem("Beef", 350.59f, null, date, (short) 14);
        GenericItem[] iList = { item3, item4, item5, item6 };
        for (int i = 0; i < iList.length; i++) {
            iList[i].printAll();
        }

        // Упражнение 2-2. Использование методов класса Object
        System.out.println("\n item5 == item6 : " + item5.equals(item6));
        FoodItem clonedFor6 = (FoodItem) item6.clone();
        System.out.println(" item6 == item6 : " + item6.equals(clonedFor6));

        // Упражнение 2-3. Расширенное клонирование.
        GenericItem clonedFor2 = (GenericItem) item2.clone();
        System.out.println(" item2 == analog of item2 : " + item2.equals(clonedFor2) + "\n");

        System.out.println(item6.toString());

        // Упражнение 3-1.Работа со строками
        String line = "Конфеты ’Маска’;45;120";
        String[] item_fld = line.split(";");
        FoodItem item7 = new FoodItem(item_fld[0], Float.valueOf(item_fld[1]), Short.valueOf(item_fld[2]));
        System.out.println();
        item7.printAll();
    }
}