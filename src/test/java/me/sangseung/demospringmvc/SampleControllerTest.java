package me.sangseung.demospringmvc;

import com.gargoylesoftware.htmlunit.Page;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlHeading1;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@WebMvcTest(SampleController.class)
public class SampleControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Autowired
    WebClient webClient;

    @Test
    public void hello() throws Exception {
        // 요청 : "/hello2"
        //응답시 모델에 name : sangseung 담겨서 옴
        //뷰이름은 hello2

        //얘는 HtmlUnit을 사용하지 않은 그냥 목업방식
        /*mockMvc.perform(get("/hello2"))
               .andExpect(status().isOk())
               .andExpect(view().name("hello2"))
               .andExpect(model().attribute("name",is("sangseung")))
                .andExpect(content().string(containsString("sangseung")))
                .andDo(print());*/

        //이건 HtmlUnit 사용한 방식
        HtmlPage page = webClient.getPage("/hello2");
        HtmlHeading1 h1 = page.getFirstByXPath("//h1");
        assertThat(h1.getTextContent()).isEqualTo("sangseung");
    }
}