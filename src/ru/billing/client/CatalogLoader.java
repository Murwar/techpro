package ru.billing.client;

import ru.billing.stocklist.ItemCatalog;
import ru.itmo.exceptions.CatalogLoadException;

//Упражнение 4-2. Абстрактные классы и интерфейсы
public interface CatalogLoader {

    public void load(ItemCatalog cat) throws CatalogLoadException;

}