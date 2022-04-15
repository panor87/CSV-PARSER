# CSV-PARSER
Dado un archivo csv que se carga en la vista, se parsea dicho archivo y se guarda en base de datos. Por último es posible descargar el archivo ordenado por el campo order_id

Desde http://localhost:8080 se selecciona el csv incluido aquí y se carga. Se vuelcan los datos en BD Postgresql y se muestra un conteo de varias de lso datos en otra vista. Desde aquí se puede descargar el csv ordenado por uno de los campos (order_id)
