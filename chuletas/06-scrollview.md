# 06 · ScrollView (historial con scroll)

Solo puede tener UN hijo (normalmente un TextView).

## XML (debajo del botón)
    <ScrollView
        android:id="@+id/scrollView"
        android:layout_width="match_parent"
        android:layout_height="200dp">

        <TextView
            android:id="@+id/textHistorial"
            android:layout_width="match_parent"
            android:layout_height="wrap_content"
            android:textSize="18sp" />

    </ScrollView>

## Imports extra
import android.view.View
import android.widget.ScrollView

## Kotlin (dentro de onCreate)
val scrollView: ScrollView = findViewById(R.id.scrollView)
val textHistorial: TextView = findViewById(R.id.textHistorial)

button.setOnClickListener {
    val texto: String = editText.text.toString()
    textHistorial.text = textHistorial.text.toString() + texto + "\n"
    editText.setText("")
    scrollView.post { scrollView.fullScroll(View.FOCUS_DOWN) }
}

## Cambios
- Lo nuevo arriba: textHistorial.text = texto + "\n" + textHistorial.text.toString()
- Sin bajar solo: quita la línea scrollView.post
- Altura de la ventana: layout_height (200dp o match_parent)
