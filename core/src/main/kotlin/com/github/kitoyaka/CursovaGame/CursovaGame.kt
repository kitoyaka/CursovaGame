package com.github.kitoyaka.CursovaGame

import com.badlogic.gdx.ApplicationAdapter
import com.github.kitoyaka.CursovaGame.screen.GameScreen
import ktx.app.KtxGame
import ktx.app.KtxScreen

/** [com.badlogic.gdx.ApplicationListener] implementation shared by all platforms. */
class CursovaGame : KtxGame<KtxScreen>(){
    override fun create() {
        addScreen(GameScreen())
        setScreen<GameScreen>()
    }
}
