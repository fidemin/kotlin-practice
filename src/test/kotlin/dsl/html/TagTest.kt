package dsl.html

import com.tschuchort.compiletesting.KotlinCompilation
import com.tschuchort.compiletesting.SourceFile
import org.jetbrains.kotlin.compiler.plugin.ExperimentalCompilerApi
import com.yunhongmin.dsl.html.Html
import com.yunhongmin.dsl.html.html
import kotlin.test.Test
import kotlin.test.assertEquals

class TagTest {
    @Test
    fun `render empty html`() {
        assertEquals("<html></html>", Html().toString())

    }

    @Test
    fun `render html with body`() {
        val node = html {
            body {}
        }
        assertEquals("<html><body></body></html>", node.toString())
    }

    @Test
    fun `render html with body string`() {
        val node = html {
            body {
                +"Hello"
                +" World"
            }
        }

        assertEquals("<html><body>Hello World</body></html>", node.toString())
    }

    @OptIn(ExperimentalCompilerApi::class)
    @Test
    fun `compile error for violation of HtmlDslMark annotatation`() {
        val result = KotlinCompilation().apply {
            sources = listOf(
                SourceFile.kotlin(
                    "Invalid.kt",
                    """
                    import com.yunhongmin.dsl.html.html

                    fun invalid() {
                        html {
                            body {
                                body {}
                            }
                        }
                    }
                    """.trimIndent()
                )
            )
            inheritClassPath = true
        }.compile()

        assertEquals(KotlinCompilation.ExitCode.COMPILATION_ERROR, result.exitCode)
    }
}
