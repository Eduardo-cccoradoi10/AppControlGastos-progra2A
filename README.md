# 👨‍💻 ALUMNO

**Carlos Eduardo Corado Ibañez 0905-25-5315**

Proyecto Final - Programación II

Universidad Mariano Gálvez de Guatemala

---
# 📱💸 AppControlGastos

Aplicación móvil para Android desarrollada en **Kotlin**, diseñada para el registro, control y análisis de finanzas personales.

El proyecto está dividido en dos componentes principales:

- **AppControlGastos-Core** → Lógica de negocio, acceso a datos y servicios financieros.
- **AppControlGastos-UI** → Aplicación Android encargada de la interfaz de usuario y experiencia visual.

---

# 🏗 Arquitectura del Proyecto

```text
AppControlGastos
│
├── AppControlGastos-core
│   ├── Modelos
│   ├── Repositories
│   ├── Services
│   └── MySQL Database
│
└── AppControlGastos-ui
    ├── Activities
    ├── Adapters
    ├── Models
    ├── Layouts XML
    └── RecyclerViews
```

---

# 🚀 Características Implementadas

## 👤 Gestión de Usuarios

- Registro de usuarios.
- Consulta de usuarios.
- Actualización de usuarios.
- Eliminación de usuarios.

---

## 🏷 Gestión de Categorías

- Crear categorías.
- Consultar categorías.
- Actualizar categorías.
- Eliminar categorías.

### Categorías de ejemplo

- Alimentación
- Transporte
- Salud
- Educación

---

## 💵 Gestión de Transacciones

Registro de:

✅ Ingresos

✅ Gastos

Cada transacción almacena:

- Descripción
- Monto
- Tipo
- Fecha

---

## 📊 Dashboard Financiero

Visualización rápida mediante:

- Registrar Gasto
- Registrar Ingreso
- Ver Transacciones
- Ver Reportes

---

## 📈 Análisis Financiero

Cálculo automático de:

- Ingresos Totales
- Gastos Totales
- Saldo Disponible

Los ingresos se muestran en color verde y los gastos en color rojo para una mejor experiencia visual.

---

# 🧩 Tecnologías Utilizadas

## Backend / Core

- Kotlin
- Maven
- JDBC
- MySQL
- Repository Pattern
- Service Layer

## Android

- Android Studio
- Kotlin
- RecyclerView
- ConstraintLayout
- CardView
- Material Design

---

# 🗄 Base de Datos

Base de datos:

```sql
prog2_app
```

Tablas:

```sql
usuarios
categorias
transacciones
```

---

## Tabla Usuarios

```sql
CREATE TABLE usuarios (
    id INT PRIMARY KEY AUTO_INCREMENT,
    nombre VARCHAR(100),
    correo VARCHAR(100),
    password VARCHAR(255)
);
```

---

## Tabla Categorías

```sql
CREATE TABLE categorias (
    id INT PRIMARY KEY AUTO_INCREMENT,
    nombre VARCHAR(100)
);
```

---

## Tabla Transacciones

```sql
CREATE TABLE transacciones (
    id INT PRIMARY KEY AUTO_INCREMENT,
    descripcion VARCHAR(255),
    monto DECIMAL(10,2),
    tipo VARCHAR(20),
    usuario_id INT,
    categoria_id INT,

    FOREIGN KEY (usuario_id) REFERENCES usuarios(id),
    FOREIGN KEY (categoria_id) REFERENCES categorias(id)
);
```

---

# 📱 Pantallas Implementadas

## LoginActivity

Permite al usuario ingresar al sistema.

---

## MainActivity

Dashboard principal.

Opciones disponibles:

- Registrar gasto
- Registrar ingreso
- Ver transacciones
- Ver reportes

---

## AddTransactionActivity

Pantalla reutilizable para:

- Registrar Gastos
- Registrar Ingresos

Cambio dinámico según el tipo de transacción seleccionado.

---

## TransactionListActivity

Listado de movimientos utilizando:

```text
RecyclerView
```

Cada elemento muestra:

- Fecha
- Descripción
- Monto
- Tipo

---

## AnalyticsActivity

Resumen financiero:

```text
Ingresos Totales

Gastos Totales

Saldo Disponible
```

---

# 📂 Estructura del Proyecto Android

```text
AppControlGastos-ui
│
├── activities
│   ├── LoginActivity
│   ├── MainActivity
│   ├── AddTransactionActivity
│   ├── TransactionListActivity
│   └── AnalyticsActivity
│
├── adapter
│   └── TransactionAdapter
│
├── model
│   ├── TransactionUI
│   └── SummaryUI
│
├── utils
│   └── TransactionRepositoryUI
│
└── viewmodel
```

---

# 📂 Estructura del Proyecto Core

```text
AppControlGastos-core
│
├── app
├── database
│   └── DatabaseConnection
│
├── model
│   ├── Usuario
│   ├── Categoria
│   └── Transaccion
│
├── repository
│   ├── UsuarioRepository
│   ├── CategoriaRepository
│   └── TransaccionRepository
│
└── service
    └── FinanzasService
```

---

# 🔧 Requisitos

- Android Studio Hedgehog o superior.
- IntelliJ IDEA.
- JDK 17 o superior.
- Maven 3.9+
- MySQL 8+

---

# ▶ Instalación

## 1. Clonar el repositorio

```bash
git clone https://github.com/TU-USUARIO/AppControlGastos.git
```

---

## 2. Configurar la base de datos

Ejecutar el script:

```sql
schema_app.sql
```

en MySQL Workbench.

---

## 3. Compilar el módulo Core

```bash
cd AppControlGastos-core

mvn clean install
```

---

## 4. Abrir el proyecto Android

Abrir:

```text
AppControlGastos-ui
```

en Android Studio.

---

## 5. Ejecutar la aplicación

En:

- Emulador Android
- Dispositivo físico con depuración USB

---
