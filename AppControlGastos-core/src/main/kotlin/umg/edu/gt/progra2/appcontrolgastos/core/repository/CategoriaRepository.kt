package umg.edu.gt.progra2.appcontrolgastos.core.repository

import umg.edu.gt.progra2.appcontrolgastos.core.database.DatabaseConnection
import umg.edu.gt.progra2.appcontrolgastos.core.model.Categoria

class CategoriaRepository {

    fun guardar(categoria: Categoria): Boolean {

        val sql = """
            INSERT INTO categorias(nombre)
            VALUES (?)
        """.trimIndent()

        DatabaseConnection.getConnection().use { connection ->

            val statement = connection.prepareStatement(sql)

            statement.setString(1, categoria.nombre)

            return statement.executeUpdate() > 0
        }
    }

    fun obtenerTodos(): List<Categoria> {

        val categorias = mutableListOf<Categoria>()

        val sql = "SELECT * FROM categorias"

        DatabaseConnection.getConnection().use { connection ->

            val statement = connection.prepareStatement(sql)

            val resultSet = statement.executeQuery()

            while (resultSet.next()) {

                val categoria = Categoria(
                    id = resultSet.getInt("id"),
                    nombre = resultSet.getString("nombre")
                )

                categorias.add(categoria)
            }
        }

        return categorias
    }

    fun buscarPorId(id: Int): Categoria? {

        val sql = "SELECT * FROM categorias WHERE id = ?"

        DatabaseConnection.getConnection().use { connection ->

            val statement = connection.prepareStatement(sql)

            statement.setInt(1, id)

            val resultSet = statement.executeQuery()

            if (resultSet.next()) {

                return Categoria(
                    id = resultSet.getInt("id"),
                    nombre = resultSet.getString("nombre")
                )
            }
        }

        return null
    }
}