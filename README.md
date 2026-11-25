# estudio-fitas

Chuletas de Kotlin + Android (Views/XML) para las fites de Aplicacions Mòbils.

## Cómo usarlo en el examen (10 min)

1. `chuletas/00-setup-examen.md` → crear proyecto con el ID correcto y arrancar `appium &`.
2. Busca en la tabla de abajo el ejercicio que más se parece al enunciado.
3. Copia `activity_main.xml` y `MainActivity.kt` de su carpeta en `proyectos/`.
4. Cambia textos e ids según el enunciado (cada ejercicio tiene "Si te piden otra cosa").
5. Checklist final del setup.

¿No encuentras algo? `TODO-EN-UNO.md` + **Ctrl+F**, o monta el ejercicio con `chuletas/01-piezas-sueltas.md`.

## Archivos

- `chuletas/00-setup-examen.md` — crear proyecto, ID, appium, checklist
- `chuletas/01-piezas-sueltas.md` — plantillas, XML, Kotlin básico, Strings, números, tabla "si piden X"
- `chuletas/02-ejercicios-texto.md`
- `chuletas/03-ejercicios-numeros.md`
- `chuletas/04-ejercicios-botones.md`
- `chuletas/05-errores-tipicos.md`
- `TODO-EN-UNO.md` — todo junto para Ctrl+F
- `proyectos/NN-nombre/` — `MainActivity.kt` + `activity_main.xml` listos para pegar

## Índice de ejercicios

| # | Ejercicio | Chuleta | Archivos para copiar |
|---|---|---|---|
| 01 | Fita 0: Toast "Has escrit ..." (EL EXAMEN REAL) | `chuletas/02-ejercicios-texto.md` | `proyectos/01-fita0-toast-has-escrit/` |
| 02 | Toast con texto fijo (sin EditText) | `chuletas/02-ejercicios-texto.md` | `proyectos/02-toast-texto-fijo/` |
| 03 | Avisar si el EditText está vacío | `chuletas/02-ejercicios-texto.md` | `proyectos/03-campo-vacio/` |
| 04 | Toast en MAYÚSCULAS / minúsculas | `chuletas/02-ejercicios-texto.md` | `proyectos/04-mayusculas-minusculas/` |
| 05 | Contar caracteres | `chuletas/02-ejercicios-texto.md` | `proyectos/05-longitud-texto/` |
| 06 | Texto al revés | `chuletas/02-ejercicios-texto.md` | `proyectos/06-texto-al-reves/` |
| 07 | Saludo con el nombre | `chuletas/02-ejercicios-texto.md` | `proyectos/07-saludo-nombre/` |
| 08 | Toast y vaciar el EditText | `chuletas/02-ejercicios-texto.md` | `proyectos/08-borrar-tras-pulsar/` |
| 09 | Mostrar en un TextView (en vez de Toast) | `chuletas/02-ejercicios-texto.md` | `proyectos/09-mostrar-en-textview/` |
| 10 | Dos EditText: nombre y apellido | `chuletas/02-ejercicios-texto.md` | `proyectos/10-nombre-y-apellido/` |
| 11 | Comprobar contraseña | `chuletas/02-ejercicios-texto.md` | `proyectos/11-contrasena/` |
| 12 | Contiene / empieza por / acaba en | `chuletas/02-ejercicios-texto.md` | `proyectos/12-contiene-palabra/` |
| 13 | Contar vocales | `chuletas/02-ejercicios-texto.md` | `proyectos/13-contar-vocales/` |
| 14 | ¿Es palíndromo? | `chuletas/02-ejercicios-texto.md` | `proyectos/14-palindromo/` |
| 15 | Contar palabras | `chuletas/02-ejercicios-texto.md` | `proyectos/15-contar-palabras/` |
| 16 | Par o impar | `chuletas/03-ejercicios-numeros.md` | `proyectos/16-par-impar/` |
| 17 | Positivo, negativo o cero | `chuletas/03-ejercicios-numeros.md` | `proyectos/17-positivo-negativo-cero/` |
| 18 | Sumar dos números | `chuletas/03-ejercicios-numeros.md` | `proyectos/18-suma-dos-numeros/` |
| 19 | Calculadora con 4 botones | `chuletas/03-ejercicios-numeros.md` | `proyectos/19-calculadora/` |
| 20 | Doble / cuadrado de un número | `chuletas/03-ejercicios-numeros.md` | `proyectos/20-doble-y-cuadrado/` |
| 21 | Mayor de edad | `chuletas/03-ejercicios-numeros.md` | `proyectos/21-mayor-de-edad/` |
| 22 | El mayor de dos números | `chuletas/03-ejercicios-numeros.md` | `proyectos/22-mayor-de-dos/` |
| 23 | Número dentro de un rango | `chuletas/03-ejercicios-numeros.md` | `proyectos/23-rango-1-10/` |
| 24 | Nota → Suspès / Aprovat / Notable / Excel·lent | `chuletas/03-ejercicios-numeros.md` | `proyectos/24-nota-calificacion/` |
| 25 | ¿Es múltiplo? | `chuletas/03-ejercicios-numeros.md` | `proyectos/25-multiplo/` |
| 26 | Tabla de multiplicar en un TextView | `chuletas/03-ejercicios-numeros.md` | `proyectos/26-tabla-multiplicar/` |
| 27 | Adivina el número (aleatorio) | `chuletas/03-ejercicios-numeros.md` | `proyectos/27-endevina-numero/` |
| 28 | Conversor (ºC → ºF, € → $...) | `chuletas/03-ejercicios-numeros.md` | `proyectos/28-celsius-fahrenheit/` |
| 29 | ¿Es primo? | `chuletas/03-ejercicios-numeros.md` | `proyectos/29-numero-primo/` |
| 30 | Factorial | `chuletas/03-ejercicios-numeros.md` | `proyectos/30-factorial/` |
| 31 | Año bisiesto | `chuletas/03-ejercicios-numeros.md` | `proyectos/31-any-traspas/` |
| 32 | Contador de clics | `chuletas/04-ejercicios-botones.md` | `proyectos/32-contador-clics/` |
| 33 | Botones + y − con un TextView | `chuletas/04-ejercicios-botones.md` | `proyectos/33-sumar-restar-textview/` |
| 34 | Dos botones: Mostrar y Borrar | `chuletas/04-ejercicios-botones.md` | `proyectos/34-dos-botones-mostrar-borrar/` |
| 35 | Cambiar el texto del botón / alternar | `chuletas/04-ejercicios-botones.md` | `proyectos/35-cambiar-texto-boton/` |
