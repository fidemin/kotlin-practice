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
        val html = html {
            body {}
        }
        assertEquals("<html><body></body></html>", html.toString())
    }
}
