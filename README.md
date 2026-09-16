LazyColumn - LazyRow
El carrito de compras permite añadir y eliminar productos asi como una tarjeta que permite ver el subtotal a pagar.
<img width="292" height="622" alt="image" src="https://github.com/user-attachments/assets/a0c3f708-4257-4e6c-b086-d11a19ca74b0" />
<img width="292" height="618" alt="image" src="https://github.com/user-attachments/assets/80506bce-d01f-4977-ba0b-62cae64d9515" />
(a) ¿por qué mutableStateListOf y no una MutableList normal?Una MutableList normal permite añadir o eliminar elementos, pero no le avisa a Compose que la lista cambió. Con mutableStateListOf, cada vez que haces un .add() o un .remove(), Compose detecta automáticamente el cambio de estado y gatilla una recomposición (redibuja la pantalla) para actualizar la lista visual
(b) ¿por qué la lista es val? Puedes agregar, editar o borrar sus elementos internos libremente. 
(c)¿qué hace weight(1f) en la LazyColumn? Hace que la lista se expanda para ocupar todo el espacio disponible sobrante dentro de la Column principal.
