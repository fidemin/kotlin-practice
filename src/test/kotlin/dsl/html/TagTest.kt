package dsl.html

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
}
