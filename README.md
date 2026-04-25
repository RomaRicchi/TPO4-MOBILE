# TPO4 - Gestión de Productos

Esta es una aplicación Android desarrollada para la asignatura de Programación Móvil. La aplicación permite gestionar un catálogo de productos simple mediante una interfaz moderna basada en un menú lateral (Navigation Drawer).

## 🚀 Características

- **Menú Lateral (Navigation Drawer):** Navegación fluida entre las distintas secciones de la aplicación.
- **Carga de Productos:** Formulario para ingresar código, descripción y precio de un producto.
    - Incluye validaciones de campos obligatorios.
    - Validación de código duplicado.
    - Control de formatos numéricos.
- **Lista de Productos:** Visualización de todos los productos cargados durante la sesión.
- **Sistema de Mensajes:** Uso de `Toasts` optimizados mediante el patrón `Evento` para evitar que los mensajes se repitan al rotar la pantalla.
- **Diálogo de Salida:** Confirmación mediante un cuadro de diálogo antes de cerrar la aplicación.

## 🛠️ Tecnologías y Conceptos Utilizados

- **Lenguaje:** Java
- **Arquitectura:** MVVM (Model-View-ViewModel)
- **Jetpack Navigation:** Manejo de fragmentos y destinos mediante `Navigation Component`.
- **View Binding:** Acceso seguro y eficiente a las vistas del layout.
- **LiveData:** Reactividad para actualizar la UI según los cambios en el ViewModel.
- **Material Design:** Componentes visuales como `NavigationView`, `DrawerLayout` y `TextInputLayout`.

## 📁 Estructura del Proyecto

- `ui/cargar`: Fragmento y ViewModel para la entrada de datos.
- `ui/listar`: Visualización de la lista de productos.
- `modelo`: Clase `Producto`.
- `utilidades`: Clases auxiliares como `Evento` para el manejo de estados de la UI.
- `MainActivity`: Punto de entrada que gestiona el Navigation Drawer y la navegación principal.

## 📝 Notas de Configuración

Para garantizar que el proyecto compile correctamente en sistemas con rutas que contienen caracteres no-ASCII (como "año"), se ha incluido la siguiente configuración en el archivo `gradle.properties`:

```properties
android.overridePathCheck=true
```

---
**Autor:** Roma  
**Materia:** Programación Móvil - Tercer Año
