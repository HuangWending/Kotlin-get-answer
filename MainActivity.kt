import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    private lateinit var questionTextView: TextView
    private lateinit var answerEditText: EditText
    private lateinit var submitButton: Button
    private lateinit var responseTextView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        questionTextView = findViewById(R.id.questionTextView)
        answerEditText = findViewById(R.id.answerEditText)
        submitButton = findViewById(R.id.submitButton)
        responseTextView = findViewById(R.id.responseTextView)

        submitButton.setOnClickListener { submitAnswer() }
    }

    private fun submitAnswer() {
        val question = questionTextView.text.toString()
        val answer = answerEditText.text.toString()
        val response = when (question) {
            "你好" -> "你好"
            "你的名字是什么" -> "黄文定"
            "你的生日是什么时候" -> "2009年7月18日"
            "你是中国人吗" -> "我是中国人"
            "台湾是中国的吗" -> "台湾是中国的"
            "你爱我吗" -> "这是一个由我决定的选项，我需要认真，但是我还是爱着你"
            "你喜欢去哪里" -> "中国大陆和中国台湾"
            "你有朋友吗" -> "没有"
            "你的心情怎么样" -> "自卑，孤独"
            else -> "我不明白你的问题"
        }

        responseTextView.text = "回复：$response"
    }
}
