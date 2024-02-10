package com.github.kitoyaka.CursovaGame.screen

import com.badlogic.gdx.Game
import com.badlogic.gdx.graphics.Texture
import com.badlogic.gdx.graphics.g2d.Batch
import com.badlogic.gdx.graphics.g2d.SpriteBatch
import com.badlogic.gdx.scenes.scene2d.Stage
import com.badlogic.gdx.utils.Scaling
import com.badlogic.gdx.utils.viewport.ExtendViewport
import com.github.kitoyaka.CursovaGame.CursovaGame
import ktx.actors.setPosition
import ktx.actors.stage
import ktx.app.KtxScreen
import ktx.graphics.use
import java.awt.Image
class GameScreen : KtxScreen {
    private val stage: Stage = Stage(ExtendViewport(16f,9f))
    private val spriteBatch: Batch = SpriteBatch()
    private val texture: Texture = Texture("MAP.png")

    override fun show() {
        stage.addActor(com.badlogic.gdx.scenes.scene2d.ui.Image(texture).apply {
            setPosition(30f,30f)
            setSize(500f,500f)
            setScaling(Scaling.fill)
        })
    }

    override fun render(delta: Float) {
        with(stage){
            act(delta)
            draw()
        }

    }

    override fun resize(width: Int, height: Int) {
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
