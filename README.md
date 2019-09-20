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

Można zmienić zakres generowania cen np na zakres <min=1, max=10> wywołując program z parametrem: 

`
java -jar shop-0.0.1-SNAPSHOT.jar --shop-price-random-generator.min=1 --hop-price-random-generator.max=10
`