import android.animation.ObjectAnimator
import android.animation.PropertyValuesHolder
import android.os.Bundle
import android.view.View
import android.view.animation.AnimationUtils
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView
import com.example.animation.R

class MainActivity : AppCompatActivity() {
    lateinit var card: CardView
    lateinit var rotateButton: Button
    lateinit var scale: Button
    lateinit var translateButton: Button
    lateinit var SlideUp: Button
    lateinit var SlideDown: Button
    lateinit var SlideLeft: Button
    lateinit var SlideRight: Button
    lateinit var fadeIn: Button
    lateinit var fadeOut: Button
    lateinit var zoomIn: Button
    lateinit var zoomOut: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        card = findViewById(R.id.imgvw)
        rotateButton = findViewById<Button>(R.id.Rotate)
        translateButton = findViewById<Button>(R.id.translate)
        SlideUp = findViewById<Button>(R.id.SlideUp)
        SlideDown = findViewById<Button>(R.id.SlideDown)
        SlideLeft = findViewById<Button>(R.id.SlideLeft)
        SlideRight = findViewById<Button>(R.id.SlideRight)
        fadeIn = findViewById<Button>(R.id.btnFadeIn)
        fadeOut = findViewById<Button>(R.id.btnFadeOut)
        zoomIn = findViewById<Button>(R.id.zoomIn)
        zoomOut = findViewById<Button>(R.id.zoomOut)
        scale = findViewById<Button>(R.id.Scale)
        zoomOut.setOnClickListener{
            val animZoomOut = AnimationUtils.loadAnimation(this,
                R.anim.zoom_out)
            card.startAnimation(animZoomOut) }
        SlideUp.setOnClickListener{
            val slideUp = AnimationUtils.loadAnimation(this, R.anim.slide_right)
            card.startAnimation(slideUp
            )
        }
        SlideDown.setOnClickListener{
            val slide_down = AnimationUtils.loadAnimation(this, R.anim.slide_left)
            card.startAnimation(slide_down) }
        SlideLeft.setOnClickListener{
            val slide_left = AnimationUtils.loadAnimation(this, R.anim.slide_left)
            card.startAnimation(slide_left)
        }
        SlideRight.setOnClickListener{
            val slide_right = AnimationUtils.loadAnimation(this, R.anim.slide_right)
            card.startAnimation(slide_right
            )
        }
        fadeIn.setOnClickListener {
            val animZoomIn = AnimationUtils.loadAnimation(this,
                R.anim.zoom_in)
            card.startAnimation(animZoomIn)
        }
        fadeOut.setOnClickListener {
            val animZoomIn = AnimationUtils.loadAnimation(this,
                R.anim.zoom_out)
            card.startAnimation(animZoomIn)
        }
        zoomIn.setOnClickListener {
            val animZoomIn = AnimationUtils.loadAnimation(this,
                R.anim.zoom_in)
            card.startAnimation(animZoomIn)
        }
        rotateButton.setOnClickListener {
            rotater()
        }
        translateButton.setOnClickListener {
            translater()
        }
        scale.setOnClickListener {
            scaler()
        }
    }

    private fun rotater() {
        val animator = ObjectAnimator.ofFloat(card, View.ROTATION, -360f, 0f)
        animator.duration = 1000
        animator.start()
    }
    private fun translater() {
        val animator = ObjectAnimator.ofFloat(card, View.TRANSLATION_X, 200f)
        animator.repeatCount = 1
        animator.duration = 1500
        animator.repeatMode = ObjectAnimator.REVERSE
        animator.start()
    }
    private fun scaler() {
        val scaleX = PropertyValuesHolder.ofFloat(View.SCALE_X, 4f)
        val scaleY = PropertyValuesHolder.ofFloat(View.SCALE_Y, 4f)
        val animator = ObjectAnimator.ofPropertyValuesHolder(
            card, scaleX, scaleY)
        animator.repeatCount = 1
        animator.repeatMode = ObjectAnimator.REVERSE
        animator.start()
    }
}

