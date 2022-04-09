package hello.itemservice.message;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.MessageSource;
import org.springframework.context.NoSuchMessageException;

import java.util.Locale;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

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

    @Test
    public void notFoundMessageCode() {
        assertThatThrownBy(() -> ms.getMessage("no_code", null, null))
                .isInstanceOf(NoSuchMessageException.class);
    }

    @Test
    public void defaultMessage() {
        //given
        String message = ms.getMessage("no_code", null, "기본 메세지", null);
        //when

        //then
        assertThat(message).isEqualTo("기본 메세지");
    }

    @Test
    public void argumentMessage() {
        //given
        String message = ms.getMessage("hello.name", new Object[]{"Spring"}, null);
        //when

        //then
        assertThat(message).isEqualTo("이정기 Spring");
    }

    @Test
    public void defaultLang() {
        assertThat(ms.getMessage("hello", null, null)).isEqualTo("안녕");
        assertThat(ms.getMessage("hello", null, Locale.KOREA)).isEqualTo("안녕");
    }

    @Test
    public void enLang() {
        assertThat(ms.getMessage("hello", null, Locale.ENGLISH)).isEqualTo("hello");
    }


}
