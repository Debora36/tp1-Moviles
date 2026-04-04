Conversor de Moneda
Es una aplicación de Android desarrollada en Java que permite realizar conversiones entre Dólares y Euros, con la capacidad de actualizar el tipo de cambio.

Patron MVVM
El proyecto está estructurado bajo el patrón de diseño Model-View-ViewModel (MVVM) para separar la lógica de negocio de la interfaz de usuario:

View (MainActivity): Gestiona la interfaz y los eventos del usuario. Implementa ViewBinding para la vinculación segura de las vistas.

ViewModel (MainActivityViewModel): Centraliza la lógica matemática de las conversiones, manteniendo la integridad de los datos frente a cambios en el ciclo de vida de la actividad.

LiveData: Utiliza MutableLiveData para almacenar el valor de la moneda, permitiendo que se actualice de forma segura la información.

Tecnologías utilizadas
Java

Android Studio

Componentes de Arquitectura de Android (ViewModel, LiveData)

ViewBinding

ConstraintLayout

Instalación y uso
Clonar el repositorio.

Abrir el proyecto en Android Studio.

Sincronizar los archivos de Gradle.

Ejecutar en un emulador o dispositivo físico (API 33 o superior).