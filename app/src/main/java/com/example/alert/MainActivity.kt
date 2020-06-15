package com.example.alert

import android.graphics.Color
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity(), ExampleDialog.ExampleDialogListener  {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun showDialog(view: View){
        val builder = AlertDialog.Builder(this@MainActivity)
        // Вывод заголовка
        builder.setTitle("App background color")

        // Вывод сообщения
        builder.setMessage("Вы хотите поменять фон на зеленый?")

        //Обработка кнопок
        builder.setPositiveButton("Да") { dialog, which ->
            Toast.makeText(applicationContext, "Фон изменился.", Toast.LENGTH_SHORT).show()
            // Смена фона
            fon.setBackgroundColor(Color.GREEN)
        }
        builder.setNegativeButton("Нет") { dialog, which ->
            Toast.makeText(applicationContext, "Фон не поменялся", Toast.LENGTH_SHORT).show()
        }
        builder.setNeutralButton("Отмена") { _, _ ->
            Toast.makeText(applicationContext, "Отмена операции", Toast.LENGTH_SHORT).show()
        }

        // Создание диалогового окна
        val dialog: AlertDialog = builder.create()
        dialog.show()
    }

    fun showDialogRadioButton(view: View) {
        val namesArray =
            arrayOf("Первый", "Второй", "Третий")
        val builder =
            AlertDialog.Builder(this@MainActivity)
        builder.setTitle("Выберите поле из списка: ") // добавляем переключатели
            .setSingleChoiceItems(
                namesArray, -1
            ) { dialog, item ->
                Toast.makeText(
                    this@MainActivity, "Вы выбрали: " + namesArray[item],
                    Toast.LENGTH_SHORT
                ).show()
            }
            .setPositiveButton("OK") { dialog, id ->
                //Логика, срабатвающая при клике на OK
            }
            .setNegativeButton(
                "Отмена"
            ) { dialog, id -> }
        // Создание диалогового окна
        val dialog: AlertDialog = builder.create()
        dialog.show()
    }

    fun showAlertTextFields(view: View) {
        val exampleDialog = ExampleDialog()
        exampleDialog.show(supportFragmentManager, "example dialog")
    }

    override fun applyTexts(address: String?, city: String?, comment: String?) {
        Toast.makeText(
            this@MainActivity, "Вы ввели: $address, $city, $comment",
            Toast.LENGTH_SHORT
        ).show()
    }
}
