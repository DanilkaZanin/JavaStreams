# Stream
## Бесконечные последовательности

    //Генерация бесконевчного потока данных
    Scanner scanner = new Scanner(System.in);
    Stream<String> s = Stream.generate(() -> scanner.nexLine());
    //чтобы фильтровать значеня есть
    s.filter()//в аргументах можно узать критерий, по которому будет отфильтровываться информация

В потоках есть методы конвейерные и терминальные

### Конвейерные методы

| Метод stream | Описание                                                                 | Пример                                           |
|--------------|--------------------------------------------------------------------------|--------------------------------------------------|
| filter       | Отфильтровывает записи, возвращает только записи, соответствующие условию | collection.stream().filter(«a1»::equals).count() |
| skip         | Позволяет пропустить N первых элементов                                  | collection.stream().skip(collection.size() — 1).findFirst().orElse(«1»)|
|distinct |Возвращает стрим без дубликатов (для метода equals)|collection.stream().distinct().collect(Collectors.toList())|
|map| Преобразует каждый элемент стрима |collection.stream().map((s) -> s + "_1").collect(Collectors.toList())|
|peek |Возвращает тот же стрим, но применяет функцию к каждому элементу стрима|collection.stream().map(String::toUpperCase).peek((e) -> System.out.print("," + e)).collect(Collectors.toList())|
|limit| Позволяет ограничить выборку определенным количеством первых элементов |collection.stream().limit(2).collect(Collectors.toList())|
|sorted| Позволяет сортировать значения либо в натуральном порядке, либо задавая Comparator |collection.stream().sorted().collect(Collectors.toList())|
|mapToInt, mapToDouble, mapToLong| Аналог map, но возвращает числовой стрим (то есть стрим из числовых примитивов)|collection.stream().mapToInt((s) -> Integer.parseInt(s)).toArray()|
|flatMap, flatMapToInt, flatMapToDouble, flatMapToLong| Похоже на map, но может создавать из одного элемента несколько| collection.stream().flatMap((p) -> Arrays.asList(p.split(",")).stream()).toArray(String[]::new)|



### Терминальные методы

#### collect()

#### findFirst()
Получим первый элемент

#### findAny()
Получим любого

#### count()
Возвращает количество нужных нам записей