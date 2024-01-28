package com.github.kitoyaka.CursovaGame.android

import android.os.Bundle

import com.badlogic.gdx.backends.android.AndroidApplication
import com.badlogic.gdx.backends.android.AndroidApplicationConfiguration
import com.github.kitoyaka.CursovaGame.CursovaGame
import com.badlogic.gdx.Game
import com.badlogic.gdx.Screen

class MyEmptyScreen(private val game: Game) : Screen {
    override fun show() {
        // це метот який викликається коли є екран
    }

    override fun render(delta: Float) {
        // метод який малює графіку (кадри render)
    }

    override fun resize(width: Int, height: Int) {
        // це для зміни екрана
    }

    override fun pause() {
        // Метод який викликається коли звертаєш додаток
    }

    override fun resume() {
        // Метод який возобновляє коли вертаєшся в додаток
    }

    override fun hide() {
        // Метод який викликається коли скриваєш екран
    }

    override fun dispose() {
        // Метод для того аби виключити екран
    }
}
class MyGame : Game() {
    override fun create() {
        // Инициализация вашей игры
        setScreen(MyEmptyScreen(this))
    }
}
/** Launches the Android application. */
class AndroidLauncher : AndroidApplication() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val config = AndroidApplicationConfiguration()
        initialize(MyGame(), config)
    }
}
