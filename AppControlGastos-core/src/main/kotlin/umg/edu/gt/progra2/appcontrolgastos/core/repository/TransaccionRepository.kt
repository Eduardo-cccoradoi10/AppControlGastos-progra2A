package umg.edu.gt.progra2.appcontrolgastos.core.repository

import umg.edu.gt.progra2.appcontrolgastos.core.database.DatabaseConnection
import umg.edu.gt.progra2.appcontrolgastos.core.model.Transaccion

class TransaccionRepository {

    fun guardar(transaccion: Transaccion): Boolean {

        val sql = """
        INSERT INTO transacciones(
            descripcion,
            monto,
            tipo,
            usuario_id,
            categoria_id
        )
        VALUES (?, ?, ?, ?, ?)
    """.trimIndent()

        DatabaseConnection.getConnection().use { connection ->

            val statement = connection.prepareStatement(sql)

            statement.setString(1, transaccion.descripcion)
            statement.setDouble(2, transaccion.monto)
            statement.setString(3, transaccion.tipo)
            statement.setInt(4, transaccion.usuarioId)
            statement.setInt(5, transaccion.categoriaId)

            return statement.executeUpdate() > 0
        }
    }
}