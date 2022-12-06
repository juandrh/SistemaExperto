# SistemaExperto

El sistema permite crear tanto un sistema experto “nítido” como uno difuso. 

Estos sistemas están formados por dos componentes:
- la base de conocimiento, formado por los hechos y las reglas, que son implicaciones del tipo “Si.. entonces…”. 
- el motor de inferencia que usa lo anterior para obtener un resultado, la acción a realizar.

En los primeros, las variables sólo toman dos valores, o se pertenece o no a un conjunto dado. En cambio, en los segundos las variables pueden tomar múltiples valores. Cada uno va a solucionar un problema de distinto tipo para una empresa:

-	El sistema nítido tratará la gestión de pedidos de una empresa.
-	El sistema difuso controlará la potencia a aplicar a un motor de un pequeño robot de transporte de mercancías en la misma empresa.

Cada uno realizará los siguientes pasos:
-	Declaración de variables 
-	Entrada de los datos de entrada (hechos o inputs)
-	Entrada de las reglas
-	Ejecución del motor de inferencia
-	Muestra del resultado obtenido para llevar a cabo la acción más adecuada a las circunstancias.

Se requiere:
-	Que la elección del sistema a crear se realice en tiempo de ejecución por el usuario.
-	Que el sistema pueda interpretar la información de entrada que se le suministra y producir una orden a realizar.
-	Que las reglas a crear por el sistema nítido permitan anidamiento de expresiones con operadores. El sistema difuso va a estar constreñido a dos variables de entrada y no necesita añadir esa complejidad.
-	Se requiere que el sistema sea fácilmente reutilizable y extensible.

Fuentes:
-	Gamma, E., Helm, R., Johnson, R., Vilssides, J. "Patrones de Diseño", Ed: Addison Wesley.
-	García S., Alberto: Inteligencia Artificial. Fundamentos, práctica y aplicaciones. Editorial RC Libros. 2ª Ed. 2016


