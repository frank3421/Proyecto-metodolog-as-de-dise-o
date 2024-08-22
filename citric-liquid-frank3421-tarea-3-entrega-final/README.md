# 99.7% Citric Liquid

## About

`99.7% Citric Liquid` is a simplified clone of the renowned game, `100% Orange Juice`. Its main
purpose is to serve as an educational tool, teaching foundational programming concepts.

📢 **Note**: This project is purely educational and will not be used for any commercial purposes.

---

## For Students

The remainder of this README is yours to complete. Take this opportunity to describe your
contributions, the design decisions you've made, and any other information you deem necessary.



<div style="text-align:center;">
    <img src="https://i.creativecommons.org/l/by/4.0/88x31.png" alt="Creative Commons License">
</div>

This project is licensed under the [Creative Commons Attribution 4.0 International License](http://creativecommons.org/licenses/by/4.0/).

¿Qué funcionalidades implementó?
Implemente lo requerido en las entregas parciales de la tarea 2 junto con lo que se solicito para la entrega final.   En particular, hice algunas modificaciones con respecto a la entrega 1 como por ejemplo crear clases abstracts, traits, etc.  Añadi clases resultados que permiten hacer los cambios necesarios tras la derrota de una unidad y cree los metodos ataque, defensa y evasion. El double dispatch se empleo entre estos metodos.   Tambien implemente el efecto apply en los paneles y implemente el metodo generatewildUnit para generar una unidad salvaje de manera aleatoria y implemente getter y setter a ciertas variables protegidas.

¿Por qué tomó ciertas decisiones en su diseño?
Un Wild Unit tecnicamente no deberia tener un metodo para que pueda defender frente a otra wild unit pero no halle alguna manera de no implementarlo.   Si wildUnit es una unidad y se comporta como una unidad entonces debe tener todos los metodos que una unidad implementa por el principio de liskov.  Si no entonces no seria una unidad y no deberia extender de Unit1. Tambien tome como referencia el hecho de que para neutralPanel el metodo apply no produce efecto alguno por lo que en base a esto, que una WildUnit tenga este metodo no es malo.
Elegi emplear doubleDispatch con el fin de no emplear isInstaceOf, getClass o metodos por el estilo. Tambien implemente las clases que extienden de results para que el codigo sea mas extensible.

¿Cómo está organizado su código?
Mi codigo esta organizado en paquetes.  En el main de model se hallan los paquetes Units, Panels, Results y Norma.   Esto se aplica tambien para los tests que estan en model de test y este model contiene los paquetes TestUnits, TestPanels, TestResults y TestNorma.
La idea es separar cada entidad de otras entidades que no comparten cosas en comun.

¿Qué patrones de diseño utilizó?
Ocupe traits para que sirvan de tipos y sean plantillas sobre las cuales se hagan las clases.  Segui el principio de liskov.  Separe en paquetes dejando aquellas clases o traits dentro de un mismo paquete.   Documente cada clase, variable,trait y metodo siguiendo las reglas estalecidades por scala.doc.  Aplique las buenas practicas a la hora de realizar test de mis clases.  Ocupe clases abstractas para no tener que repetir codigo de manera innecesaria.  Tambien hice uso de excepciones en mis clases.

## Diagrama de estados para entrega parcial 5

![Diagrama de estados](docs/diagrama-estados.png)


Tarea 3

¿Que funcionalidades implementó?
En esta tarea implemente los patrones de diseños flyweight, template, observer y state pattern. Son patornes bien
conocidos siendo flyweight implementado para guardar las clases de estado que se ocupan para transicionar, template para crear una c
configuracion inicial del juego ocupando otras funciones con roles especificos, state para controlar el flujo del juego y las transiciones en cada instante
del mismo y observer para realizar la notificacion de quien gano la partida a los participantes.
En general desarrolle bastante el controlador que contiene el estado actual de una partida colocando variables y metodos
utiles y necesarios para poder controlar el flujo del juego.

¿Por que tome ciertas decisiones en mi diseño?
Decidi ocupar flyweight porque note que se iban a generar muchos clases de tipo estado lo cual podria relentizar el procesamiento 
a la larga y estas clases iban a ser constantemente reemplazadas.   Por otra parte, ocupe template porque creo que es bueno delegar
aquellas partes que se pueden diferenciar en la creacion de la configuracioin inicial del juego.

¿Como esta organizado mi codigo?
Mi codigo esta organizado en paquetes que comparten ciertos aspectos en comun.   Los paquetes principales son los que contiene
los test y los que contienes las clases.

¿Que patrones de diseño ocupe?
Como mencione, ocupe flyweight, template, observer, state y observer pattern