package ru.billing.stocklist;

import java.util.ArrayList;
import java.util.HashMap;

// Упражнение 4-1. Классы-коллекции
public class ItemCatalog {
    private HashMap<Integer, GenericItem> catalog = new HashMap<Integer, GenericItem>();
    private ArrayList<GenericItem> ALCatalog = new ArrayList<GenericItem>();

    // добавляет товар в каталог
    public void addItem(GenericItem item) {
        catalog.put(item.getID(), item); // Добавляем товар в HashMap
        ALCatalog.add(item); // Добавляем тот же товар в ArrayList
    }

    // распечатывает товары из каталога на экране
    public void printItems() {
        for (GenericItem i : ALCatalog) {
            System.out.println(i.toString());
        }
    }

    // производит поиск в каталоге по переданному id товара
    // поиск производится в коллекции catalog
    public GenericItem findItemByID(int id) {
        // Если нет такого ID, возвращаем пустое значение
        if (!catalog.containsKey(id))
            return null;
        else
            return catalog.get(id);

    }

    // производит поиск в каталоге по переданному id товара.
    // Поиск производится в коллекции ALCatalog
    public GenericItem findItemByIDAL(int id) {
        for (GenericItem i : ALCatalog) {
            if (i.getID() == id)
                return i;
        }
        return null;
    }

    public int size() {
        return ALCatalog.size();
    }

}