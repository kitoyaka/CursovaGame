package com.github.kitoyaka.CursovaGame.screen

import com.badlogic.gdx.Game
import com.badlogic.gdx.graphics.Texture
import com.badlogic.gdx.graphics.g2d.Batch
import com.badlogic.gdx.graphics.g2d.SpriteBatch
import com.badlogic.gdx.scenes.scene2d.Stage
import com.badlogic.gdx.utils.Scaling
import com.badlogic.gdx.utils.viewport.ExtendViewport
import com.github.kitoyaka.CursovaGame.CursovaGame
import com.github.kitoyaka.CursovaGame.system.RenderSystem
import com.github.quillraven.fleks.World
import com.github.quillraven.fleks.WorldCfgMarker
import com.github.quillraven.fleks.WorldConfiguration
import com.github.quillraven.fleks.configureWorld
import ktx.actors.setPosition
import ktx.actors.stage
import ktx.app.KtxScreen
import ktx.assets.disposeSafely
import ktx.graphics.use
import java.awt.Image
import java.time.InstantSource.system

class GameScreen : KtxScreen {
    private val stage: Stage = Stage(ExtendViewport(16f,9f))
    private val texture: Texture = Texture("assets/MAIN BACKGROUND v2.png")
    val world = configureWorld {
        injectables {
            add(stage)
        }
        systems {
            add(RenderSystem())
        }
    }
    override fun show() {
        stage.addActor(com.badlogic.gdx.scenes.scene2d.ui.Image(texture).apply {
            setPosition(1f,1f)
            setSize(14f ,6f)
            setScaling(Scaling.fill)
        })
    }

    override fun render(delta: Float) {
       world.update(delta)

    }

    override fun resize(width: Int, height: Int) {
    }

    override fun dispose() {
        stage.disposeSafely()
        texture.disposeSafely()
    }
}

class MyGame : Game() {
    override fun create() {
        // ініціалізація гри
        setScreen(GameScreen())
    }
}
