# WeatherApp

1.Descrierea Aplicației

Aplicația își propune obținerea informațiilor meteorologice din diferite orașe ale lumii.

Informațiile care pot fi obțiunute sunt:

* Temperatura
* Viteza vântului
* Precipitațiile curente

2.Utilizarea Aplicației

Aplicația necesită încărcarea datelor referitoare la orașele pentru care ulterior
se vor afișa datele meteorologice. 
Formatul fișierului este:
ID		nm		lat		lon		countryCode

La selectarea unei țări, se încarcă automat lista orașelor aparținând țării respective.
Atunci când este selectat un oraș aplicația afișează în interfața grafică situația meteorologică
curentă din acel oraș.

3.Implementarea Aplicației

Aplicația folosește API-ul companiei Openweathermap (https://openweathermap.org/).
Parsarea JSON-ului s-a realizat cu biblioteca org.json (https://mvnrepository.com/artifact/org.json/json).
Interfața grafică a fost realizată cu ajutorul bibliotecii JAVAFX (https://openjfx.io/).


##### [Realizator aplicatie](https://github.com/vasioniga07)

Oniga Gabriel-Vasile C-114A