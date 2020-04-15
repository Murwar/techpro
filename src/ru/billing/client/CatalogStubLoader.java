package ru.billing.client;

import java.util.Date;

import ru.billing.stocklist.*;
import ru.itmo.exceptions.CatalogLoadException;
import ru.itmo.exceptions.ItemAlreadyExistsException;

//Упражнение 4-2. Абстрактные классы и интерфейсы
public class CatalogStubLoader implements CatalogLoader {

    public void load(ItemCatalog cat) throws CatalogLoadException {
        GenericItem item1 = new GenericItem("Sony TV", 23000, GenericItem.Category.GENERAL);
        FoodItem item2 = new FoodItem("Bread", 12, null, new Date(), (short) 10);

        try {
            cat.addItem(item1);
            cat.addItem(item2);
            //Проверка на срабатывание exception
            // cat.addItem(item2);
        } catch (ItemAlreadyExistsException e) {
            e.printStackTrace();
            throw new CatalogLoadException(e);
        }

    }

}