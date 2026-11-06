package umg.edu.gt.progra2.appcontrolgastos.core.service

import umg.edu.gt.progra2.appcontrolgastos.core.repository.TransaccionRepository

class FinanzasService(
    private val transaccionRepository: TransaccionRepository
) {

    fun calcularTotalIngresos(): Double {

        return transaccionRepository
            .obtenerTodos()
            .filter { it.tipo == "INGRESO" }
            .sumOf { it.monto }
    }

    fun calcularTotalGastos(): Double {

        return transaccionRepository
            .obtenerTodos()
            .filter { it.tipo == "GASTO" }
            .sumOf { it.monto }
    }

    fun calcularSaldoActual(): Double {

        return calcularTotalIngresos() - calcularTotalGastos()
    }
}