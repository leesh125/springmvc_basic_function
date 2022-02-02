package hello.springmvc_basic_function.basic;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

// @Controller : 반환 값이 String 이면 뷰 이름으로 인식된다. 그래서 뷰를 찾고 뷰가 랜더링 된다.
@Slf4j
@RestController // String을 반환하는 mapping 클래스가 있으면 반환되는 문자열 그대로를 화면에 띄움
public class LogTestController {

    // @Slf4j 을 사용하여 아래 코드가 자동 입력된다고 생각하면 된다.
    // private final Logger log = LoggerFactory.getLogger(getClass());


    @RequestMapping("/log-test")
    private String logTest() {
        String name = "Spring";

        System.out.println("name = " + name);

        /*
            로그 레벨 설정을 변경해서 출력 결과를 보자.
            LEVEL: TRACE > DEBUG > INFO > WARN > ERROR
            개발 서버는 debug 출력
            운영 서버는 info 출력
         */
        // 중괄호 안에 name이 치환되어서 들어감
        log.trace("trace log={}", name);
        log.debug("debug log={}", name);
        log.info("info log={}", name); // log.info("info log="+ name); 와 동일
        log.warn("warn log={}", name);
        log.error("error log={}", name);

        /*
            아래와 같이 사용하는 것은 좋지 않음. 이유는 이렇다.
            log 출력 루트가 debug일 때 trace는 출력이 되지않음.
            그런데 + 연산으로 log를 찍으면 + 연산은 수행하지만 log는 찍히지 않는다.
            결론 : 쓸모없는 연산을 줄이기 위해서
         */
        // log.trace("trace log="+ name);
        return "ok";
    }
}
