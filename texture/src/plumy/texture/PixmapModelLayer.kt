package plumy.texture

import arc.files.Fi
import arc.graphics.Pixmap
import java.io.File

fun PixmapModelLayerForm(fi: Fi) = RawPixmapModelLayer(fi.toPixmap())
fun PixmapModelLayerForm(file: File) = RawPixmapModelLayer(file.toPixmap())
class RawPixmapModelLayer(pixmap: Pixmap) : IModelLayer {
    val processors = ArrayList<ILayerProcessor>()
    override val texture: ITexture = RawTexture(pixmap)
    override fun addProcess(processor: ILayerProcessor) {
        processors.add(processor)
    }

    override fun process(): ITexture {
        var cur = texture
        for (processor in processors) {
            val res = processor.process(cur)
            cur = res
        }
        return cur
    }
}