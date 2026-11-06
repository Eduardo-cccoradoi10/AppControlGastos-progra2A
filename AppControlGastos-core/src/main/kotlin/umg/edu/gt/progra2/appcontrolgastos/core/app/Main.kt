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

    val repository = UsuarioRepository()

    val usuarios = repository.obtenerTodos()

    usuarios.forEach {
        println(it)
    }


    val repository = UsuarioRepository()

    val usuario = repository.buscarPorId(1)

    println(usuario)


    val repository = UsuarioRepository()

    val usuarioActualizado = Usuario(
        id = 1,
        nombre = "Carlos Eduardo",
        correo = "carlos@gmail.com",
        password = "4321"
    )

    println(repository.actualizar(usuarioActualizado))

     */

}

