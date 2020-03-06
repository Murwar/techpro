import java.util.Date;

public class Main {
    public static void main(String[] args) throws Exception {
        // Упражнение 1-1. Создание собственных классов
        GenericItem item1 = new GenericItem(1, "Milk", 69.3f);
        GenericItem item2 = new GenericItem(2, "Juice", 94.5f);
        GenericItem item3 = new GenericItem(3, "Water", 34.2f);
        item1.printAll();
        item2.printAll();
        item3.printAll();
        // Опционально. Добавление аналога
        item3.setAnalog(item2);
        System.out.println("\n Analog of " + item3.name + " is " + item3.getAnalog().name + "\n");

        // Упражнение 2-1. Применение наследования
        TechnicalItem item4 = new TechnicalItem(4, "TV", 5045.0f, (short) 1080);
        TechnicalItem item5 = new TechnicalItem(5, "Phone", 9999.99f, (short) 720);
        Date date = new Date();
        FoodItem item6 = new FoodItem(6, "Apples", 120.2f, date, (short) 30);
        FoodItem item7 = new FoodItem(7, "Beef", 350.59f, date, (short) 14);
        GenericItem[] iList = { item4, item5, item6, item7 };
        for (int i = 0; i < iList.length; i++) {
            iList[i].printAll();
        }

        // Упражнение 2-2. Использование методов класса Object
        System.out.println("\n item6 == item7 : " + item6.equals(item7));
        FoodItem clonedFor6 = (FoodItem) item6.clone();
        System.out.println(" item6 == item6 : " + item6.equals(clonedFor6));

        // Упражнение 2-3. Расширенное клонирование.
        GenericItem clonedFor3 = (GenericItem) item3.clone();
        System.out.println(" item3 == analog of item3 : " + item6.equals(clonedFor3) + "\n");        

        System.out.println(item7.toString());
    }
}