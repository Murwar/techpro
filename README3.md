## Упражнение 4-1.Классы-коллекции.
### Цель упражнения: Изучить преимущества использования классов-коллекций, предоставляемых в стандартной поставке JDK.
### Описание упражнения: В этом упражнении вы реализуете класс ItemCatalog, хранящий список товаров, продаваемых интернет-магазином. Список в дальнейшем будет использоваться для демонстрации товаров покупателям на сайте магазина.
1) Добавьте в проект класс ItemCatalog, в котором будет реализована логика хранения списка
товаров.
1) Включите в класс ItemCatalog поля, определенные следующим образом:
```
    private HashMap<Integer, GenericItem> catalog = new HashMap<Integer, GenericItem>();
    private ArrayList<GenericItem> ALCatalog = new ArrayList<GenericItem>();
 ```
Примечание: Обе эти коллекции будут хранить один и тот же список товаров. Коллекция HashMap более оптимальна для последующего поиска товаров в каталоге, а коллекция ArrayList нужна для сравнения с ней.
2) Реализуйте в классе ItemCatalog следующие методы:
* public void addItem(GenericItem item) : добавляет товар в каталог
```
public void addItem(GenericItem item) {
  catalog.put(item.ID, item); // Добавляем товар в HashMap
  ALCatalog.add(item); // Добавляем тот же товар в ArrayList
}
```
* public void printItems() : распечатывает товары из каталога на экране. Распечатку следует производить с использованием метода toString класса GenericItem.
```
public void printItems(){
 for(GenericItem i : ALCatalog){
  System.out.println(i);
  }
}
```
* public GenericItem findItemByID(int id) : производит поиск в каталоге по переданному id товара. Поиск следует производит в коллекции catalog типа HashMap
```
public GenericItem findItemByID(int id){
//Если нет такого ID, возвращаем пустое значение
  if(!catalog.containsKey(id)) {
  return null;
  } else{
  return catalog.get(id);
  }
}
```
* public GenericItem findItemByIDAL(int id) : производит поиск в каталоге по переданному id товара. Поиск следует производит в коллекции ALCatalog типа ArrayList
```
public GenericItem findItemByIDAL(int id){
  for(GenericItem i : ALCatalog){
  if(i.ID==id) return i;
  }
  return null;
}
```
3) В методе main класса Main создайте новый экземпляр класса ItemCatalog. С помощью метода addItem добавьте в него несколько (порядка 10) товаров.
4) С помощью приема из упр. 3-1 сравните скорость поиска по двум типам коллекций:
```
long begin = new Date().getTime();
 
for(int i=0; i&lt;100000;i++)
cat.findItemByID(10);
long end = new Date().getTime();

System.out.println(&quot;In HashMap: &quot;+(end-begin)); begin = new
Date().getTime();
for(int i=0; i&lt;100000;i++)
  cat.findItemByIDAL(10);
end = new Date().getTime();
System.out.println(&quot;In ArrayList: &quot;+(end-begin));
```
Примечание: Поскольку у нас нет возможности сформировать действительно большие списки товаров, приходится производить большое количество циклов поиска, чтобы разница во времени накапливалась и становилась ощутимой.
## Упражнение4-2. Абстрактные классы и интерфейсы.
### Цель упражнения: Изучить полезные свойства абстрактных классов и интерфейсов.
### Описание упражнения: В этом упражнении вы добавите в проект интерфейс CatalogLoader c методом load. Объект, реализующий метод load будет способен загружать список товаров в указанный каталог (ItemCatalog). В дальнейшем в нашем проекте появятся несколько классов реализующих метод load и заполняющих каталог из различных источников.
1) Добавьте в проект новый интерфейс CatalogLoader.
5) Опишите в интерфейсе CatalogLoader следующий метод:
public void load(ItemCatalog cat);
6) Добавьте в проект класс CatalogStubLoader, реализующий интерфейс CatalogLoader.
7) В методе load класса CatalogStubLoader реализуйте «ручной» способ загрузки каталога с
помощью явно созданных программистом объектов:  
GenericItem item1 = new GenericItem(&quot;Sony TV&quot;,23000,Category.GENERAL);
FoodItem item2 = new FoodItem(&quot;Bread&quot;,12,null,new Date(),(short)10);
cat.addItem(item1);
cat.addItem(item2);
 
8) В методе main класса Main создайте новый фрагмент кода, загружающий товары в каталог с
помощью объекта-загрузчика:
CatalogLoader loader = new CatalogStubLoader();
loader.load(cat);
9) Запустите программу и проверьте корректность загрузки списка товаров.

## Упражнение 4-3. Пакеты, модификаторы доступа и инкапсуляция. ##
### Цель упражнения: Изучить на практике использование механизма пакетов и принципа инкапсуляции
### Описание упражнения: В этом упражнении вы создадите пакеты в рамках проекта StockListProject и распределите классы и интерфейсы проекта по пакетам. Также вы создадите инкапсулированные версии классов проекта.
1) Инкапсулируйте классы GenericItem, FoodItem, TechnicalItem и ItemCatalog своего
проекта. Для этого объявите все их поля как private, а для доступа к ним создайте
соответствующие методы set… и get…
Это лучше сделать при помощи eclipse – Source/Generate Setters and Getters.
10) Создайте в проекте StockListProject пакеты со следующим содержанием:
* ru.billing.client
  1. Класс Main
  1. Интерфейс CatalogLoader
  1. Класс CatalogStubLoader
* ru.billing.exceptions
* ru.billing.stocklist
  1. Перечисление Category
  1. Класс GenericItem
  1. Класс FoodItem
  1. Класс TechnicalItem
  1. Класс ItemCatalog
* ru.lanit.warehouse
11) Исправьте ошибки, появившиеся в проекте из-за необходимости импорта классов из других
пакетов.
12) Запустите программу, проверьте работоспособность проекта.
