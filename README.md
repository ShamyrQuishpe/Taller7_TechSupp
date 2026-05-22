# Sistema de Administración de Misiones - Caballeros del Zodiaco

Aplicación desarrollada en Java con interfaz gráfica para la administración de misiones asignadas a los Caballeros del Zodiaco. El sistema permite registrar, modificar, buscar y listar caballeros, además de calcular automáticamente el aporte al Fondo del Santuario y los impuestos correspondientes según la recompensa obtenida.

## Características

✔ Registro de caballeros  
✔ Modificación de información  
✔ Búsqueda por ID mediante búsqueda binaria  
✔ Listado de caballeros registrados  
✔ Cálculo automático del aporte al Fondo del Santuario  
✔ Cálculo automático de impuestos del Reino de Atena  
✔ Cálculo de recompensa neta  
✔ Validación de datos mediante componentes `JSpinner`  
✔ Interfaz gráfica desarrollada con Java Swing  

---

## Tecnologías utilizadas

- Java
- Java Swing
- Programación Orientada a Objetos (POO)
- ArrayList
- Búsqueda Binaria
- HashMap (alternativa analizada)
- UML

---

## Estructura del proyecto

```plaintext
ProyectoCaballeros/
│
├── src/
│   ├── modelo/
│   │      Caballero.java
│   │
│   ├── controlador/
│   │      ControladorCaballero.java
│   │
│   ├── util/
│   │      Calculo.java
│   │
│   ├── vista/
│   │      Ventana.java
│   │
│   └── Main.java
│
├── docs/
│      Diagramas UML
│      Informe.pdf
│
└── README.md
```

---

## Modelo de datos

### Caballero

Atributos:

- ID del caballero
- Nombre
- Rango
- Constelación
- Nivel de poder
- Misión asignada
- Nivel de dificultad
- Recompensa
- Aporte al Fondo del Santuario
- Impuesto del Reino de Atena
- Recompensa neta

Métodos principales:

```java
registrarCaballero()
modificarCaballero()
listarCaballeros()
buscarPorId()
calcularAporte()
calcularImpuesto()
calcularRecompensaNeta()
```

---

## Funcionalidades implementadas

### Registro de caballeros
Permite ingresar nuevos registros evitando IDs duplicados.

### Búsqueda por ID
Utiliza búsqueda binaria para localizar registros de forma eficiente.

Complejidad:

```plaintext
O(log n)
```

### Modificación
Permite actualizar la información de caballeros existentes.

### Cálculos automáticos

El sistema calcula:

**Aporte al Fondo del Santuario**

```plaintext
Aporte = Recompensa × 10%
```

**Impuesto del Reino**

Se calcula según los tramos establecidos.

**Recompensa neta**

```plaintext
Recompensa Neta = Recompensa − Aporte − Impuesto
```

---

## Capturas del sistema

### Registro


<img width="675" height="343" alt="image" src="https://github.com/user-attachments/assets/e7e7fefc-18b1-41e7-af94-d3f02c362d3f" />


### Búsqueda

<img width="886" height="359" alt="image" src="https://github.com/user-attachments/assets/77f532b7-1d2f-4cff-bb7b-1cdaf4164278" />

### Modificación

<img width="886" height="402" alt="image" src="https://github.com/user-attachments/assets/d1124037-f67f-4473-8ddc-11ee6be4ebb2" />

### Lista

<img width="886" height="325" alt="image" src="https://github.com/user-attachments/assets/3e48c71b-805f-4f00-8d38-3bfde7ae6b6e" />

### Cálculos

<img width="886" height="342" alt="image" src="https://github.com/user-attachments/assets/cbe8495b-b8bc-4e77-8d9e-3811596b5ae0" />

---

## Cómo ejecutar el proyecto

### Clonar repositorio

```bash
git clone URL_DEL_REPOSITORIO
```

### Abrir el proyecto

Abrir en:

- NetBeans
- IntelliJ IDEA
- Eclipse

### Ejecutar

Ejecutar:

```plaintext
Main.java
```

---
