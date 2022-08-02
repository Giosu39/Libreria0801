# Project summary

# Packages, enums & classes:

```java
package model.enums;

enum Genre;
enum Language;
enum Nation; 
enum PublishingHouse;
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

class Warehouse; // Database simulation
```

```java
package model.warehouse.service;

class Service; // Query simulation
class Menu; // CLI
```
