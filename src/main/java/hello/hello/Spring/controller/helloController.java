package hello.hello.Spring.controller;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class helloController {
    @GetMapping("hello")
    public String hello1(Model model){//메소드 이름은 막지어도 상관 없음
        model.addAttribute("data","hello!");
        return "hello";

    }
    @GetMapping("hello-mvc")
    public String mvc1(@RequestParam("name1")String name,Model model) {
        // name1= 쿼리 파라미터로 url에 name1=1이런식으로 기입
        //String name은 파라미터로 값을 받아서 addAttribute의 value값에 들어감!
        model.addAttribute("k",name);
        return "hello-template";
    }
    @GetMapping("api1")
    @ResponseBody
    public String helloString(@RequestParam("name12")String name){
        return"hello" + name;
        //api방식 view가 필요없음 html 안띄워줌(viewResorver에 안주고 http 바디부에 직접 데이터 넣어줌.)
        //사실 이걸로 문자를 출력하는건 잘 안씀(string converter방식)

    }
    @GetMapping("api2")
    @ResponseBody
    public color helloapi(@RequestParam("getName")String name){
        color color1 = new color();
        color1.setName(name);
        return color1;
        //이렇게 객체 데이터를 보내주는게 진짜 api 활용방법!!(제이슨 방식(객체 출력))

    }
    static class color{
        String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }

}
