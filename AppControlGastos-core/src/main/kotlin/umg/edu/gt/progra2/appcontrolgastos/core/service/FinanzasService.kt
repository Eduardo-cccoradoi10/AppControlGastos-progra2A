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

    fun obtenerTotalPorCategoria(
        categoriaId: Int
    ): Double {

        return transaccionRepository
            .obtenerTodos()
            .filter {
                it.categoriaId == categoriaId &&
                        it.tipo == "GASTO"
            }
            .sumOf { it.monto }
    }

    fun obtenerTransaccionesUsuario(
        usuarioId: Int
    ) = transaccionRepository
        .obtenerTodos()
        .filter {
            it.usuarioId == usuarioId
        }

    fun contarTransacciones(): Int {

        return transaccionRepository
            .obtenerTodos()
            .size
    }

    fun obtenerIngresosPorUsuario(
        usuarioId: Int
    ): Double {

        return transaccionRepository
            .obtenerTodos()
            .filter {
                it.usuarioId == usuarioId &&
                        it.tipo == "INGRESO"
            }
            .sumOf { it.monto }
    }

    fun obtenerGastosPorUsuario(
        usuarioId: Int
    ): Double {

        return transaccionRepository
            .obtenerTodos()
            .filter {
                it.usuarioId == usuarioId &&
                        it.tipo == "GASTO"
            }
            .sumOf { it.monto }
    }

    fun obtenerSaldoPorUsuario(
        usuarioId: Int
    ): Double {

        return obtenerIngresosPorUsuario(usuarioId) -
                obtenerGastosPorUsuario(usuarioId)
    }
}