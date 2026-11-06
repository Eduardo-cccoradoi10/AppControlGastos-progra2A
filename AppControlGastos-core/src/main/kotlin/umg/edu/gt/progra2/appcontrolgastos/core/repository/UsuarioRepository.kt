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

    fun obtenerTodos(): List<Usuario> {

        val usuarios = mutableListOf<Usuario>()

        val sql = "SELECT * FROM usuarios"

        DatabaseConnection.getConnection().use { connection ->

            val statement = connection.prepareStatement(sql)

            val resultSet = statement.executeQuery()

            while (resultSet.next()) {

                val usuario = Usuario(
                    resultSet.getInt("id"),
                    resultSet.getString("nombre"),
                    resultSet.getString("correo"),
                    resultSet.getString("password")
                )

                usuarios.add(usuario)
            }
        }

        return usuarios
    }

    fun buscarPorId(id: Int): Usuario? {

        val sql = "SELECT * FROM usuarios WHERE id = ?"

        DatabaseConnection.getConnection().use { connection ->

            val statement = connection.prepareStatement(sql)

            statement.setInt(1, id)

            val resultSet = statement.executeQuery()

            if (resultSet.next()) {

                return Usuario(
                    resultSet.getInt("id"),
                    resultSet.getString("nombre"),
                    resultSet.getString("correo"),
                    resultSet.getString("password")
                )
            }
        }

        return null
    }

    fun actualizar(usuario: Usuario): Boolean {

        val sql = """
        UPDATE usuarios
        SET nombre = ?, correo = ?, password = ?
        WHERE id = ?
    """.trimIndent()

        DatabaseConnection.getConnection().use { connection ->

            val statement = connection.prepareStatement(sql)

            statement.setString(1, usuario.nombre)
            statement.setString(2, usuario.correo)
            statement.setString(3, usuario.password)
            statement.setInt(4, usuario.id)

            return statement.executeUpdate() > 0
        }
    }

    fun eliminar(id: Int): Boolean {

        val sql = "DELETE FROM usuarios WHERE id = ?"

        DatabaseConnection.getConnection().use { connection ->

            val statement = connection.prepareStatement(sql)

            statement.setInt(1, id)

            return statement.executeUpdate() > 0
        }
    }
}