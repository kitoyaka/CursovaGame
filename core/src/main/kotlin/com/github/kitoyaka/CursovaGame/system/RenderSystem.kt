package com.github.kitoyaka.CursovaGame.system

import com.badlogic.gdx.scenes.scene2d.Stage
import com.github.kitoyaka.CursovaGame.component.ImageComponent
import com.github.quillraven.fleks.Entity
import com.github.quillraven.fleks.Family
import com.github.quillraven.fleks.IntervalSystem
import com.github.quillraven.fleks.IteratingSystem
import com.github.quillraven.fleks.collection.compareEntity
import kotlin.reflect.KClass
annotation class AllOf(val components: Array<KClass<ImageComponent>>)
@AllOf(components = [ImageComponent::class])
class RenderSystem(private val stage:Stage): IteratingSystem() {
    override fun onTick() {
        super.onTick()

        with(stage){
            viewport.apply()
            act(deltaTime)
            draw()
        }
    }
    override fun onTickEntity(entity: Entity) {

    }


}




