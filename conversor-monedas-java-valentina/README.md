# Conversor de Monedas en Java

Bienvenido/a al Conversor de Monedas, una aplicación de consola en Java que permite realizar conversiones de divisas en tiempo real consumiendo la API de `exchangerate.host`. 

Este proyecto fue desarrollado para practicar la integración de APIs REST en aplicaciones de consola, así como el manejo y lectura de JSON.

## Tecnologías y Herramientas Utilizadas
- **Java 17**: Lenguaje de programación principal empleado.
- **Maven**: Herramienta de gestión y construcción del proyecto.
- **HttpClient**: Nueva API incluida en Java 11+ para realizar las peticiones HTTP (`GET`).
- **Jackson (2.15.2)**: Librería para procesar y deserializar los objetos JSON recibidos por la API directamente a clases/modelos Java (DTOs).
- **API `exchangerate.host`**: API pública externa encargada de proveer las tasas de cambio de las monedas actuales.

## Estructura del Proyecto
- **`com.tuforo.conversor.principal`**: Contiene la clase `Principal`, encargada de iniciar la ejecución y mostrar el menú al usuario en consola mediante la clase `Scanner`.
- **`com.tuforo.conversor.service`**: Lógica de red y de negocio; incluye a `ClienteHttp` para invocar la API, y `ConvertirMoneda` para procesar sus resultados utilizando el `ObjectMapper` de Jackson.
- **`com.tuforo.conversor.model`**: Componentes que representan los datos, como lo es el DTO `ConversionResponse`.

## Requisitos Previos
1. Tener **Java JDK 17** o superior instalado en el equipo.
2. Contar con un IDE como IntelliJ IDEA, Eclipse, o con Maven instalado en consola.
3. Conexión a Internet para consumir la API de conversión de divisas.

## Ejecución del Proyecto
1. Clona o descarga el repositorio en tu equipo.
2. Abre la carpeta raíz `conversor-monedas-java-valentina` en tu IDE y deja que Maven descargue la dependencia de Jackson.
3. Dirígete a la ruta: `src/main/java/com/tuforo/conversor/principal/Principal.java`.
4. Ejecuta el archivo (`Run 'Principal.main()'`). 
5. Comienza a interactuar con el menú desde la consola.

*(Otra alternativa desde terminal con Maven)*:
```bash
mvn clean install
mvn exec:java -Dexec.mainClass="com.tuforo.conversor.principal.Principal"
```

## Funcionalidades del Sistema
- **Conversión de monedas en tiempo real**: Capacidad para ingresar cualquier código de moneda origen o destino válido en la API.
- **Menú interactivo repetitivo**: Puedes consultar las tasas o salir desde un submenú, incluyendo el despliegue de códigos de uso popular como `USD`, `EUR`, `BRL`, entre otros.
- **Manejo de Errores e Ingresos Inválidos**: Verificación básica y bloque `try-catch` para capturar conexiones fallidas y formatos incorrectos ingresados por el teclado en consola.
- **Deserialización amigable de JSON**: Al implementar `@JsonIgnoreProperties`, la clase `ConversionResponse` esquiva atributos redundantes de la API.

## Ejemplo de Uso en Terminal (Simulación de Conversión)

```text
*************************************************
Sea bienvenido/a al Conversor de Monedas
Menú de opciones:
1) Convertir moneda
2) Mostrar códigos de monedas más comunes
3) Salir
*************************************************
Elija una opción válida: 1
Ingrese el código de la moneda de origen (ej. USD): USD
Ingrese el código de la moneda de destino (ej. EUR): EUR
Ingrese la cantidad a convertir: 50
El valor de 50.00 [USD] corresponde al valor final de: 46.50 [EUR]

*************************************************
Sea bienvenido/a al Conversor de Monedas
...
```

## Posibles Mejoras (Futuros agregados)
- Guardar localmente el histórico de conversiones hechas por el usuario dentro de un archivo `.txt` o `.json`.
- Mejorar el sistema para usar librerías de tiempo al crear registros (`LocalDateTime`, `ZonedDateTime`).
- Implementar validaciones de API en base a tokens (`API Keys`) que `exchangerate.host` planee integrar o actualizar en futuras versiones.
- Implementar peticiones asíncronas de HttpClient en caso de conversiones múltiples.
