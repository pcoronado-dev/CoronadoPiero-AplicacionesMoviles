Prompt usado: Actúa como un Desarrollador Senior de Android experto en Jetpack Compose.

Necesito que crees una pantalla interactiva de "Lista de tareas - Tecsup" en Jetpack Compose que permita agregar tareas mediante un campo de texto (OutlinedTextField) con el label "¿Qué tarea tienes pendiente?", mostrar el conteo total de tareas, marcar/desmarcar tareas con un Checkbox, y eliminar cada tarea con un botón de icono de papelera.

Esto está dirigido a un laboratorio académico de gestión de estados en Android (Tecsup).

Quiero que respondas en formato de código Kotlin completo, limpio y listo para compilar, dividiendo la solución en el data class Tarea, el composable para la fila individual (ItemTarea), el composable principal (PantallaTareas) y una vista previa con @Preview.

Ten en cuenta estas condiciones: usa únicamente estados locales con remember, mutableStateOf y mutableStateListOf para manejar los datos sin ViewModel; utiliza Material 3 con IconButtons (Icons.Default.Delete) para la eliminación y asegura que la lista sea desplazable mediante LazyColumn.

