package umg.edu.gt.progra2.appcontrolgastos.core.app

import umg.edu.gt.progra2.appcontrolgastos.core.database.DatabaseConnection
import umg.edu.gt.progra2.appcontrolgastos.core.model.Usuario
import umg.edu.gt.progra2.appcontrolgastos.core.repository.UsuarioRepository


fun main() {

    try {
        val connection = DatabaseConnection.getConnection()

        println("Conexion exitosa a MySQL")

        connection.close()

    } catch (e: Exception) {

        println("Error de conexion")

        e.printStackTrace()
    }

    /*
    val usuario = Usuario(
        0,
        "Carlos",
        "carlos@gmail.com",
        "1234"
    )

    val repository = UsuarioRepository()

    println(repository.guardar(usuario))
*/

}

