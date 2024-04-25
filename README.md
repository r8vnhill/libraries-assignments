# Tarea 1 

Resuelva 4 de 5 ejercicios propuestos. Puede elegir los ejercicios que prefiera excepto por la P5, que es
obligatoria. Cada ejercicio tiene un objetivo específico y se enfoca en diferentes aspectos de la programación.

##  P1) [1.5 pts] Null-safety: Sistema de Gestión de Biblioteca

**Objetivo del Ejercicio:**
Implementar un sistema para una biblioteca que maneje información sobre libros y pueda procesar correctamente las
propiedades que pueden ser nulas.

### Paso 1: Definir la Clase de Libro

Define una clase `Libro` con tres propiedades: `titulo: String?`, `autor: String?`, y `precio: Double?`. La clase
también debe tener un método `describir(): String` que retorna una cadena con la información del libro en el formato
`"Título: $titulo, Autor: $autor, Precio: $precio"`.

Si:
- `titulo` es nulo, se debe mostrar `"Sin Título"`.
- `autor` es nulo, se debe mostrar `"Autor Desconocido"`.
- `precio` es nulo, se debe mostrar `"Precio no Disponible"`.

### Paso 2: Calcular el Costo Total de los Libros Prestados

Implementa una función `calcularTotal` que sume los precios de los libros que tienen precio asignado.

### Paso 3: Crear una Lista de Libros

Utilice el siguiente código para crear una lista de libros y mostrar la información de cada uno de ellos. Al final,
muestra el costo total de los libros que tienen precio asignado.

```kotlin
fun main() {
    val libros = listOf(
        Libro("El Señor de los Anillos", "J.R.R. Tolkien", 25.0),
        Libro("A Warning", null, 15.0),
        Libro(null, "George Orwell", 20.0),
    )

    for (libro in libros) {
        println(libro.describir())
    }
    println("Costo: ${calcularTotal(libros)}")
}
```

## P2) [1.5 pts] Gradle: Tarea Gradle para Generar un Reporte de Dependencias

**Objetivo del Ejercicio:**
Programar una tarea en Gradle que genere un reporte detallado de todas las dependencias del proyecto, incluyendo las 
versiones y los grupos a los que pertenecen, y que lo escriba en un archivo de texto.

### Pasos Sugeridos para el Ejercicio:

#### Paso 1: Configuración del Proyecto

Como base, utiliza el archivo `build.gradle` incluido en el proyecto. Asegúrate de que el proyecto tenga dependencias
definidas en el bloque `dependencies` para que la tarea tenga algo que reportar.

#### Paso 2: Escribir la Tarea en Gradle

Agrega una tarea llamada `dependencyReport` al archivo `build.gradle` que recorra las configuraciones del proyecto
utilizando `configurations`. Dentro de la tarea, itera sobre las dependencias y escribe los detalles de cada una en un
archivo de texto, esto se puede hacer accediendo a la propiedad `allDependencies` de cada configuración.

#### Paso 3: Ejecutar la Tarea

Prueba la tarea ejecutando

```bash
./gradlew dependencyReport  # En sistemas Unix
```

```powershell
.\gradlew.bat dependencyReport  # En sistemas Windows
```

## P3) [1.5 pts] OOP: Sistema de Gestión de Recetas de Cocina

**Objetivo del Ejercicio:**
Desarrollar un sistema para almacenar y manejar recetas de cocina usando data classes para las recetas y funciones de
extensión para proporcionar métodos adicionales, como calcular el tiempo total de cocina y verificar si una receta 
contiene ciertos ingredientes.

#### Requisitos del Ejercicio:

1. **Definir una clase para Recetas:**
    - `Receta`: Esta data class debe incluir al menos los siguientes campos: `nombre`, `ingredientes` (una lista de 
      `String`), `tiempoPreparacion` (en minutos), y `tiempoCoccion` (en minutos).
    - Esta clase debe ser una clase abierta, cerrada, o una data class, según lo que sea más apropiado.

2. **Funciones de Extensión:**
    - Extender la clase `Receta` con una función `tiempoTotal` que devuelva la suma del tiempo de preparación y cocción.
    - Extender la clase `Receta` con una función `contieneIngrediente` que verifique si un ingrediente específico está 
      en la lista de ingredientes.
 
## P4) [1.5 pts] Enumeraciones y clases selladas: Máquina de café

**Objetivo:** Implementar una máquina de estados que modele el funcionamiento básico de una máquina de café, que puede 
estar en varios estados (por ejemplo, esperando, preparando café, sirviendo, y necesitando limpieza). La implementación 
se hará primero usando una enumeración y luego usando clases selladas.

### Especificaciones del Sistema de la Máquina de Café

1. **Estados de la Máquina de Café:**
   - **Esperando**: La máquina está esperando que el usuario elija una acción.
   - **Preparando**: La máquina está preparando el café.
   - **Sirviendo**: La máquina está sirviendo el café.
   - **NecesitaLimpieza**: La máquina necesita ser limpiada después de servir una cierta cantidad de cafés.

2. **Transiciones de Estado:**
   - De **Esperando** a **Preparando** cuando el usuario selecciona "preparar café".
   - De **Preparando** a **Sirviendo** una vez que el café está listo.
   - De **Sirviendo** a **Esperando** para preparar otro café o a **NecesitaLimpieza** después de servir 5 cafés.
   - De **NecesitaLimpieza** a **Esperando** después de limpiar la máquina.

**Nota:** Este ejercicio puede resolverse usando state pattern, pero en este caso se busca una solución más simple y directa.

## P5) [1.5 pts] Herencia múltiple: Manejo de dispositivos inteligentes (Obligatorio)

**Objetivo:** Implementar un sistema de dispositivos inteligentes que no solo se conecten y se controlen por voz, sino 
que también gestionen su estado interno y respondan de manera dinámica a los comandos en un entorno de domótica.

### Funcionalidades de los Dispositivos

1. **SmartLight**:
   - **Conexión/Desconexión**: Puede conectarse a la red doméstica para recibir comandos. Si está desconectado, no debe responder a ningún comando de encendido o apagado.
   - **Ahorro de Energía**: En modo de ahorro de energía, el brillo de la luz se reduce automáticamente para consumir menos energía.
   - **Control de Encendido/Apagado**: La luz puede ser encendida o apagada. Si se intenta cambiar el estado de la luz mientras está desconectada, debería informar que la acción no es posible.
   - **Automatización de Respuesta**: Si la luz está en modo de ahorro de energía y se enciende, debería ajustar automáticamente su brillo para seguir siendo eficiente.
   - **Control por Voz**: Puede ser encendida o apagada mediante comandos de voz.

2. **SmartSpeaker**:
   - **Conexión/Desconexión**: Necesita estar conectado para reproducir música o responder a comandos de voz.
   - **Control por Voz**: Cuando está habilitado, el altavoz puede recibir comandos de voz para reproducir música, aumentar o disminuir el volumen, y otras funciones multimedia.
   - **Reproducción de Música**: Puede reproducir, pausar y detener música. Si se le pide que reproduzca música sin estar conectado, debe notificar que no está listo.
   - **Ajuste de Volumen**: Puede ajustar su volumen a través de comandos de voz o programación previa.

3. **SmartThermostat**:
   - **Conexión/Desconexión**: Debe estar conectado para que pueda ajustarse su configuración o para que informe sobre las condiciones actuales del ambiente.
   - **Control de Temperatura**: Permite establecer una temperatura específica. Si se intenta ajustar la temperatura mientras está desconectado, se debería informar al usuario.
   - **Modo de Ahorro de Energía**: En este modo, el termostato ajusta la temperatura para maximizar la eficiencia energética, por ejemplo, bajando la temperatura automáticamente durante la noche.
   - **Monitoreo Ambiental**: Puede informar sobre la temperatura actual, la humedad o incluso la calidad del aire si se integran sensores adicionales.


### Integración en el Sistema Domótico

El sistema debe permitir interacciones entre dispositivos para crear escenarios de uso más complejos, como:

- **Escenarios Automatizados**: Por ejemplo, un escenario "Buenas Noches" que apaga todas las luces, baja la temperatura del termostato, y activa el modo de ahorro de energía en todos los dispositivos conectados.
- **Interacciones Dependientes**: Si el SmartSpeaker detecta que se ha dado un comando de voz para el escenario "Buenas Noches", automáticamente podría enviar comandos para activar este modo en otros dispositivos.
- **Respuestas a Condiciones Ambientales**: El termostato podría enviar una señal para encender las luces si detecta que la temperatura baja de un cierto umbral y es de noche, suponiendo que alguien podría estar en casa y necesitar luz.

_Hint: Considera implementar interfaces con métodos predeterminados donde sea apropiado, para proporcionar funcionalidades comunes que pueden ser reutilizadas por varios dispositivos_

### Opcional: [0.5 pts] Diamond Problem (debe haber resuelto el ejercicio principal)

Menciona una posible situación de "problema del diamante" que podría surgir en el diseño de este sistema, cómo se podría 
resolver, y que implicaciones tendría en la implementación.
