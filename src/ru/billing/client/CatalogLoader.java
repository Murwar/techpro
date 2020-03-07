package ru.billing.client;

import ru.billing.stocklist.ItemCatalog;

//Упражнение 4-2. Абстрактные классы и интерфейсы
public interface CatalogLoader {

    public void load(ItemCatalog cat);

}