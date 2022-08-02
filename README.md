# Resoconto

# Classi, enums e packages creati:

```java
package model.enums;

enum Genre;
enum Language;
enum Nation; 
enum Publishing House;
```

```java
package model.people;

interface Person;
abstract class Author;
class Director extends Author;
class Writer extends Author;
```

```java
package model.sellable;

interface Opera;
abstract class Product;
class DVD extends Product;
class Book extends Product;
```

```java
package model.warehouse;

class Warehouse; // Base dati
```

```java
package model.warehouse.service;

class Service; // Metodi per le query
class Menu; // Interfaccia console per l'utente
```
