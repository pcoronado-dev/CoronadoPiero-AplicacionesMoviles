Lab03 - REGISTRO DE PRODUCTO

Piero Alexander Coronado Quispe

Descripcion: Aplicación desarrollada con Kotlin y Jetpack Compose para registrar productos mediante un formulario. Permite ingresar:

Nombre del producto
Precio
Cantidad Y al presionar AGREGAR PRODUCTO se muestra una Card con los datos ingresados y el importe calculado.

¿Qué pasaría si declaras las variables de los campos SIN remember?

Sin remember, el estado de las variables no se conservaria correctamente. Durante las recomposiciones de Compose. Por eso, el contenido ingresado podria perderse cuando se vuelva a componer.
<img width="528" height="554" alt="image" src="https://github.com/user-attachments/assets/a8f80eb6-ac23-4187-88a3-b314e1825a96" />
