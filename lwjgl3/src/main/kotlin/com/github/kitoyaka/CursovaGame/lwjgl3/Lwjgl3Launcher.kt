@file:JvmName("Lwjgl3Launcher")

package com.github.kitoyaka.CursovaGame.lwjgl3

import com.badlogic.gdx.Game
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3Application
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3ApplicationConfiguration
import com.badlogic.gdx.graphics.Texture
import com.badlogic.gdx.graphics.g2d.Batch
import com.badlogic.gdx.graphics.g2d.SpriteBatch
import com.badlogic.gdx.utils.viewport.ExtendViewport
import com.github.kitoyaka.CursovaGame.CursovaGame
import ktx.app.KtxScreen
import ktx.graphics.use

class GameScreen : KtxScreen {
    private val spriteBatch: Batch = SpriteBatch()
    private val texture: Texture = Texture("FON.jpg")
    private val viewport: ExtendViewport = ExtendViewport(texture.width.toFloat(), texture.height.toFloat())

    override fun show() {
    }

    override fun render(delta: Float) {
        spriteBatch.use {
            it.draw(texture, 0f, 0f, viewport.worldWidth, viewport.worldHeight)
        }
    }

    override fun resize(width: Int, height: Int) {
        viewport.update(width, height, true)
    }

    override fun dispose() {
        spriteBatch.dispose()
        texture.dispose()
    }
}

class MyGame : Game() {
    override fun create() {
        // ініціалізація гри
        setScreen(GameScreen())
    }
}
/** Launches the desktop (LWJGL3) application. */
fun main() {
    // This handles macOS support and helps on Windows.
    if (StartupHelper.startNewJvmIfRequired())
      return
    Lwjgl3Application(CursovaGame(), Lwjgl3ApplicationConfiguration().apply {
        setTitle("Vampire")
        setWindowedMode(1920, 1080)
        setWindowIcon(*(arrayOf(128, 64, 32, 16).map { "libgdx$it.png" }.toTypedArray()))
    })
}
