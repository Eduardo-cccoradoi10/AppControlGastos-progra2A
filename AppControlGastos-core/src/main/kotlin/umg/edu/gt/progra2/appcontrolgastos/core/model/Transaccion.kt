package umg.edu.gt.progra2.appcontrolgastos.core.model

data class Transaccion(
    val id: Int,
    val descripcion: String,
    val monto: Double,
    val tipo: String,
    val usuarioId: Int,
    val categoriaId: Int
)