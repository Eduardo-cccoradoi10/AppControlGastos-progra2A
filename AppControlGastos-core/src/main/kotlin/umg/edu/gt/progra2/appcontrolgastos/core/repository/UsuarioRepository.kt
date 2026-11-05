package umg.edu.gt.progra2.appcontrolgastos.core.repository

import umg.edu.gt.progra2.appcontrolgastos.core.database.DatabaseConnection
import umg.edu.gt.progra2.appcontrolgastos.core.model.Usuario

class UsuarioRepository {

    fun guardar(usuario: Usuario): Boolean {

        val sql = """
            INSERT INTO usuarios(nombre, correo, password)
            VALUES (?, ?, ?)
        """.trimIndent()

        DatabaseConnection.getConnection().use { connection ->

            val statement = connection.prepareStatement(sql)

            statement.setString(1, usuario.nombre)
            statement.setString(2, usuario.correo)
            statement.setString(3, usuario.password)

            return statement.executeUpdate() > 0
        }
    }
}