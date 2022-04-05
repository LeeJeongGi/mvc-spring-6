package hello.itemservice.message;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.MessageSource;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class MessageSourceTest {

    @Autowired
    MessageSource ms;

    @Test
    public void helloMessage() {
        //given
        String result = ms.getMessage("hello", null, null);

        //when
            
        //then
        assertThat(result).isEqualTo("안녕");
    }
    
}
