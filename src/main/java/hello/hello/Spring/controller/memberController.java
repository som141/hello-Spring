package hello.hello.Spring.controller;

import hello.hello.Spring.domain.member;
import hello.hello.Spring.service.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class memberController {
    service service;
    @Autowired
    public memberController(hello.hello.Spring.service.service service)
    {
        this.service = service;
    }
    @GetMapping("/members/new")
    public String creatFomrm(){
        return "members/creatMemberForm";
    }
    @PostMapping(value = "/members/new")
    public String creat(MemberForm form){
        member member = new member();
        member. setName(form.getName());
        service.join(member);

        return "redirect:/";
    }
    @GetMapping("/members")
    public String list(Model model){
        List<member> members= service.findMembers();
        model.addAttribute("members",members);
        return "members/memberlist";
    }
}
