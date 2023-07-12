package com.digilinq.platform.users.web.swagger

import com.digilinq.platform.users.integration.IntegrationTest
import org.hamcrest.core.StringContains
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.security.test.context.support.WithMockUser
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.get

@IntegrationTest
class SwaggerUiTest @Autowired constructor(
    private val mockMvc: MockMvc
) {

    @WithMockUser
    @Test
    fun `bypass security configuration should redirect to swagger-ui index while heating swagger-ui endpoint`() {
        mockMvc.get(ENDPOINT_SWAGGER_UI).andExpect {
            status {
                isFound()
            }
            header {
                string("Location", "/swagger-ui/index.html")
            }
        }
    }

    @WithMockUser
    @Test
    fun `bypass security configuration should return 200 while heating swagger-ui index endpoint`() {
        mockMvc.get(ENDPOINT_SWAGGER_UI_INDEX).andExpect {
            status {
                isOk()
            }
            content {
                contentType("text/html")
                content {
                    string(StringContains.containsString("<html"))
                    string(StringContains.containsString("</html>"))
                }
            }
        }
    }

    @Test
    fun `with considering about the security configuration should get response 200 while heating swagger-ui endpoint`() {
        mockMvc.get(ENDPOINT_SWAGGER_UI).andExpect {
            status {
                isOk()
            }
        }
    }

    companion object {
        const val ENDPOINT_SWAGGER_UI = "/swagger-ui.html"
        const val ENDPOINT_SWAGGER_UI_INDEX = "/swagger-ui/index.html"
    }
}