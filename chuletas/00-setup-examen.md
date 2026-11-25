# 00 · Setup del examen (hazlo en este orden)

## 1. Antes del examen (en casa): bajar el repo a la VM

En la terminal de la VM de IsardVDI:

```bash
cd ~
git clone https://github.com/aitormera/estudio-fitas
```

Si no hay git: Firefox dentro de la VM → github.com/aitormera/estudio-fitas → **Code → Download ZIP** → descomprimir en `~`.

Para actualizar después: `cd ~/estudio-fitas && git pull`

Abre los `.md` con el editor de texto (o arrastra los `.kt`/`.xml` a Android Studio).

---

## 2. Arrancar Appium (lo pide el enunciado)

Abre una terminal y deja Appium corriendo en segundo plano:

```bash
appium &
```

No cierres esa terminal.

---

## 3. Crear el proyecto

1. Android Studio → **New Project** → **Empty Views Activity** (la de Views, NO "Empty Activity", que es Compose).
2. Rellena:
   - **Name:** lo que quieras (p. ej. `FitaTest`)
   - **Package name:** el ID del enunciado, p. ej. `com.ieti.fitatest` ⚠️ (bórralo y escríbelo entero; Android Studio lo autogenera a partir del Name)
   - **Language:** Kotlin
   - **Minimum SDK:** el que venga por defecto
3. **Finish** y espera a que acabe el Gradle Sync (barra de abajo).

### Comprobar el ID

Abre `app/build.gradle.kts` (o `build.gradle`) y mira que ponga:

```kotlin
namespace = "com.ieti.fitatest"
...
applicationId = "com.ieti.fitatest"
```

Si te equivocaste en el Package name, cambia **las dos** líneas aquí y la primera línea (`package ...`) de `MainActivity.kt`, y luego **File → Sync Project with Gradle Files**. Más fácil: borrar el proyecto y crearlo otra vez (1 min).

---

## 4. Pegar el código (2 archivos)

| Archivo | Dónde está |
|---|---|
| `activity_main.xml` | `app/res/layout/activity_main.xml` → pestaña **Code** (arriba a la derecha) |
| `MainActivity.kt` | `app/kotlin+java/com.ieti.fitatest/MainActivity.kt` |

- **XML:** selecciona todo (Ctrl+A) y pega el del ejercicio.
- **Kotlin:** selecciona todo y pega. La primera línea `package com.ieti.fitatest` tiene que ser el ID del enunciado. Si es otro ID, cambia solo esa línea.

---

## 5. Ejecutar y pasar el test

1. Elige el emulador arriba y pulsa ▶ **Run**.
2. Prueba a mano que hace lo que pide el enunciado.
3. Lanza el IOC Tester como os haya dicho el profe.

---

## 6. Checklist final (30 segundos)

- [ ] ID correcto (`applicationId` y `package`)
- [ ] Textos EXACTOS del enunciado (botón, Toast): mayúsculas, espacios, acentos, signos
- [ ] NADA que no pida el enunciado (ni botones, ni TextView, ni hints)
- [ ] Appium encendido
- [ ] La app compila y se abre
