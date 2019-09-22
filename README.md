# online shop project

Zaimplementuj sklep internetowy, który oferuje 3 warianty.
Podstawową funkcjonalnością jaką posiada każdy sklep jest wariant „START”. Umożliwia on na dodawanie produktów do koszyka (produkt przechowuje nazwę i cenę), oraz na ich podstawie wypisywać na oknie konsoli cenę wszystkich produktów.
Pakiet „PLUS” dodatkowo umożliwia doliczenie do ceny wynikowej podatku VAT. Stawka podatku VAT ma zostać uwzględniona w pliku konfiguracyjnym.
Pakiet „PRO” oprócz wyliczania podatku ma również możliwość wyliczenia rabatu, którego wartość jest uwzględniona w pliku konfiguracyjnym.
Aplikacja na start dodaje 5 dowolnych produktów z losowaną ceną (w przedziale 50-300 zł) i wyświetla ich sumaryczną cenę.

## program properties
Generowanie cen domyślnych produktów w granicach zbioru podanego w pliku application.properties.
Domyślny zakres zbioru to <min=50, max=300>

`
shop-price-random-generator.min=50d
`

`
shop-price-random-generator.max=300d
`

Można zmienić zakres generowania cen np. na zakres <min=1, max=10> wywołując program z parametrem: 

`
java -jar shop-0.0.1-SNAPSHOT.jar --shop-price-random-generator.min=1 --shop-price-random-generator.max=10
`


### sample output
* `application-start.profile`  
just put: `spring.profiles.active=start` in `application.properties`  
or execute: `
            java -jar shop-0.0.1-SNAPSHOT.jar --spring.profiles.active=start
            `
```bash
--- Shop started ---
Added products count: 5
[{name='P1', price=158.96}, {name='P2', price=204.27}, {name='P3', price=186.46}, {name='P4', price=66.71}, {name='P5', price=255.03}]
Total Price: 871.43
```
* `application-plus.profile`  
just put: `spring.profiles.active=plus` in `application.properties`  
or execute: `
            java -jar shop-0.0.1-SNAPSHOT.jar --spring.profiles.active=plus
            `
```bash
--- Shop started ---
Added products count: 5
[{name='P1', price=56.76}, {name='P2', price=219.64}, {name='P3', price=174.42}, {name='P4', price=275.48}, {name='P5', price=114.01}]

Products with VAT 23%
{name='P1', price=69.81}
{name='P2', price=270.16}
{name='P3', price=214.54}
{name='P4', price=338.84}
{name='P5', price=140.23}
Total Price: 1033.58
```

* `application-pro.profile`  
just put: `spring.profiles.active=pro` in `application.properties`  
or execute: `
            java -jar shop-0.0.1-SNAPSHOT.jar --spring.profiles.active=pro
            `
```bash
--- Shop started ---
Added products count: 5
[{name='P1', price=67.73}, {name='P2', price=193.66}, {name='P3', price=104.44}, {name='P4', price=226.79}, {name='P5', price=204.28}]

Products with VAT 23% :
{name='P1', price=83.31}
{name='P2', price=238.20}
{name='P3', price=128.46}
{name='P4', price=278.95}
{name='P5', price=251.26}
Total Price: 980.18

Products with VAT 23 and discount 5% :
{name='P1', price=79.14}
{name='P2', price=226.29}
{name='P3', price=122.04}
{name='P4', price=265.00}
{name='P5', price=238.70}
Total Price: 931.17
 ```
