# Kotlin-get-answer
Kotlin XML-安卓问答程序
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:orientation="vertical"
    android:padding="16dp"
    tools:context=".MainActivity">
<LinearLayout>：线性布局，用于垂直排列子视图。
xmlns:android="http://schemas.android.com/apk/res/android"：声明了android命名空间。
xmlns:tools="http://schemas.android.com/tools"：声明了tools命名空间，用于在设计时辅助开发工具中显示预览效果。
android:layout_width="match_parent"：布局宽度设置为与父容器相匹配。
android:layout_height="match_parent"：布局高度设置为与父容器相匹配。
android:orientation="vertical"：子视图垂直排列。
android:padding="16dp"：设置边距为16dp。
tools:context=".MainActivity"：在设计时指定与该布局关联的上下文为MainActivity。
<TextView
    android:id="@+id/questionTextView"
    android:layout_width="match_parent"
    android:layout_height="wrap_content"
    android:text="问题：" />
<TextView>：文本视图，用于显示文本内容。
android:id="@+id/questionTextView"：设置视图的唯一标识符为questionTextView，以便在代码中引用它。
android:layout_width="match_parent"：视图宽度设置为与父容器相匹配。
android:layout_height="wrap_content"：视图高度根据内容自适应。
android:text="问题："：显示的文本内容为"问题："。
<EditText
    android:id="@+id/answerEditText"
    android:layout_width="match_parent"
    android:layout_height="wrap_content" />
<EditText>：编辑文本视图，用于接收用户输入的文本。
android:id="@+id/answerEditText"：设置视图的唯一标识符为answerEditText，以便在代码中引用它。
android:layout_width="match_parent"：视图宽度设置为与父容器相匹配。
android:layout_height="wrap_content"：视图高度根据内容自适应。
<Button
    android:id="@+id/submitButton"
    android:layout_width="wrap_content"
    android:layout_height="wrap_content"
    android:text="提交" />
<Button>：按钮视图，用于触发特定操作。
android:id="@+id/submitButton"：设置视图的唯一标识符为submitButton，以便在代码中引用它。
android:layout_width="wrap_content"：视图宽度根据内容自适应。
android:layout_height="wrap_content"：视图高度根据内容自适应。
android:text="提交"：按钮上显示的文本内容为"提交"。
<TextView
    android:id="@+id/responseTextView"
    android:layout_width="match_parent"
    android:layout_height="wrap_content"
    android:layout_marginTop="16dp"
    android:text="答案：" />
    <TextView>：文本视图，用于显示文本内容。
android:id="@+id/responseTextView"：设置视图的唯一标识符为responseTextView，以便在代码中引用它。
android:layout_width="match_parent"：视图宽度设置为与父容器相匹配。
android:layout_height="wrap_content"：视图高度根据内容自适应。
android:layout_marginTop="16dp"：顶部边距设置为16dp。
android:text="答案："：显示的文本内容为"答案："。
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
Bundle类是用于存储和传递数据的容器，通常在不同的组件之间传递数据时使用。
import android.view.View
View类是Android用户界面的基本构建块，用于创建UI元素。
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
Button类代表一个按钮控件，EditText类代表一个可编辑的文本框控件，TextView类代表一个文本显示控件。这些类用于创建和操作界面上的按钮、文本框和文本视图。
import androidx.appcompat.app.AppCompatActivity
AppCompatActivity类是一个支持库提供的基类，用于创建兼容性的Android活动。它提供了与最新的Android版本兼容的功能，并支持较旧版本的设备。
class MainActivity : AppCompatActivity() {
这定义了一个名为MainActivity的类，它是一个AppCompatActivity的子类。
private lateinit var questionTextView: TextView
private lateinit var answerEditText: EditText
private lateinit var submitButton: Button
private lateinit var responseTextView: TextView
这些代码声明了私有的可变属性用于保存对应的视图组件。
override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_main)
这是MainActivity的onCreate方法的重写。它在活动创建时被调用。super.onCreate(savedInstanceState)调用父类的onCreate方法。setContentView(R.layout.activity_main)设置布局文件为activity_main。
questionTextView = findViewById(R.id.questionTextView)
answerEditText = findViewById(R.id.answerEditText)
submitButton = findViewById(R.id.submitButton)
responseTextView = findViewById(R.id.responseTextView)
这些代码使用findViewById方法将布局文件中的视图组件与声明的属性关联起来
submitButton.setOnClickListener { submitAnswer() }
这行代码为submitButton按钮设置了点击监听器。当按钮被点击时，submitAnswer方法将被调用。
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
这是submitAnswer方法的实现。它获取用户在questionTextView和answerEditText中输入的问题和回答。然后，根据问题的不同，选择相应的回复。
responseTextView.text = "答案：$response"
这行代码将生成的答案文本设置给responseTextView，显示在界面上。
