package com.github.kitoyaka.CursovaGame.android

import android.os.Bundle

import com.badlogic.gdx.backends.android.AndroidApplication
import com.badlogic.gdx.backends.android.AndroidApplicationConfiguration
import com.github.kitoyaka.CursovaGame.CursovaGame
import com.badlogic.gdx.Game
import com.badlogic.gdx.Screen
import com.badlogic.gdx.graphics.Texture
import com.badlogic.gdx.graphics.g2d.Batch
import com.badlogic.gdx.graphics.g2d.SpriteBatch
import com.badlogic.gdx.scenes.scene2d.Stage
import com.badlogic.gdx.utils.viewport.ExtendViewport
import ktx.app.KtxScreen
import ktx.graphics.use
import ktx.log.logger

class GameScreen : KtxScreen {
    private val spriteBatch: Batch = SpriteBatch()
    private val texture: Texture = Texture("FON 5.jpg")
    private val viewport: ExtendViewport = ExtendViewport(2000f, 1100f)

    override fun show() {
    }
    override fun render(delta: Float) {
        spriteBatch.use { it.draw(texture, 0f, 0f, viewport.worldWidth, viewport.worldHeight) }
    }
    override fun resize(width: Int, height: Int) {
        viewport.update(width, height)
    }
    override fun dispose() {
    }
}


class MyGame : Game() {
    override fun create() {
        // ініціалізація гри
        setScreen(GameScreen())
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
