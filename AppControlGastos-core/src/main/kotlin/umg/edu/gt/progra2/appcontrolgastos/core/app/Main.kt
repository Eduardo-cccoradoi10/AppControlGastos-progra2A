package umg.edu.gt.progra2.appcontrolgastos.core.app

import umg.edu.gt.progra2.appcontrolgastos.core.database.DatabaseConnection

fun main() {

    try {
        val connection = DatabaseConnection.getConnection()

        println("Conexion exitosa a MySQL")

        connection.close()

    } catch (e: Exception) {

        println("Error de conexion")

        e.printStackTrace()
    }
}

