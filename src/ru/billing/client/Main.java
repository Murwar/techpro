package ru.billing.client;

import java.util.Date;

import ru.billing.stocklist.*;
import ru.itmo.client.CatalogFileLoader;

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
        System.out.println("\n Analog of " + item2.getName() + " is " + item2.getAnalog().getName() + "\n");

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

        // Упражнение 4-1. Классы-коллекции
        ItemCatalog catalog = new ItemCatalog();
        TechnicalItem item8 = new TechnicalItem("Laptop", 58700.0f, (short) 1080);
        TechnicalItem item9 = new TechnicalItem("Smart Watch", 18600.99f, (short) 1080);

        // добавление товаров в catalog
        GenericItem[] allItem = { item0, item1, item2, item3, item4, item5, item6, item7, item8, item9 };
        for (GenericItem item : allItem) {
            catalog.addItem(item);
        }

        // сравнение скорости поиска по двум типам коллекций
        long begin = new Date().getTime();
        for (int i = 0; i < 100000; i++) {
            catalog.findItemByID(9);
        }
        long end = new Date().getTime();
        System.out.println("\nIn HashMap: " + (end - begin) + "ms");

        begin = new Date().getTime();
        for (int i = 0; i < 100000; i++) {
            catalog.findItemByIDAL(9);
        }
        end = new Date().getTime();
        System.out.println("In ArrayList: " + (end - begin) + "ms\n");

        // Упражнение 4-2. Абстрактные классы и интерфейсы
        CatalogLoader loader = new CatalogStubLoader();
        loader.load(catalog);

        // проверка корректности загрузки списка товаров
        for (int i = 0; i < catalog.size(); i++) {
            catalog.findItemByID(i).printAll();
        }

        // Задание 6-1. Проверка на exception.

        // TechnicalItem item10 = new TechnicalItem("Smart Watch", 18600.99f, (short) 1080);
        // catalog.addItem(item10);


        //Задание 6-3.Потоки ввода-вывода
        //Загружаем товары из каталога(текстового файла)
        ItemCatalog catalog2 = new ItemCatalog();
        CatalogFileLoader cLoader = new CatalogFileLoader("C://Users//msmar//OneDrive//Документы//VS Code_projects//techpro-master//src//ru//billing//client//items.lst.txt");
        cLoader.load(catalog2);
        //Проверяем на корректность загрузки списка товаров из файла
        System.out.println("\n...downloading items from a file...");
        for (int i = catalog2.getFirstItemID(); i < catalog2.getFirstItemID() + catalog2.size(); i++) {
            System.out.println(catalog2.findItemByID(i));
        }

    }
}