package umg.edu.gt.progra2.appcontrolgastos.core.app

import umg.edu.gt.progra2.appcontrolgastos.core.database.DatabaseConnection
import umg.edu.gt.progra2.appcontrolgastos.core.model.Usuario
import umg.edu.gt.progra2.appcontrolgastos.core.repository.UsuarioRepository
import umg.edu.gt.progra2.appcontrolgastos.core.model.Categoria
import umg.edu.gt.progra2.appcontrolgastos.core.repository.CategoriaRepository
import umg.edu.gt.progra2.appcontrolgastos.core.model.Transaccion
import umg.edu.gt.progra2.appcontrolgastos.core.repository.TransaccionRepository

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


    val categoriaRepository = CategoriaRepository()

    val categorias = categoriaRepository.obtenerTodos()

    categorias.forEach {
        println(it)
    }

    val categoriaRepository = CategoriaRepository()

    val categoriaActualizada = Categoria(
        id = 1,
        nombre = "Comida"
    )

    println(categoriaRepository.actualizar(categoriaActualizada))

    val transaccionRepository = TransaccionRepository()

    val transaccion = Transaccion(
        id = 0,
        descripcion = "Compra de almuerzo",
        monto = 35.50,
        tipo = "GASTO",
        usuarioId = 1,
        categoriaId = 1
    )

    println(transaccionRepository.guardar(transaccion))

    val transaccionRepository = TransaccionRepository()

    val transaccion = transaccionRepository.buscarPorId(1)

    println(transaccion)

     */


}

