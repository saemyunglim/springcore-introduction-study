package hello.core;

import hello.core.member.Grade;
import hello.core.member.Member;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MemberApp {
    public static void main(String[] args) {
//        AppConfig appConfig = new AppConfig();
//        MemberService memberService = appConfig.memberService();

        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class); //ApplicaiontContext가 스프링 컨테이너라고 보면 됨. AnnotationConfigApplicationContext를 통해 AppConfig를 등록하면 AppConfig 내부의 @Bean이 붙은 것들을 스프링 컨테이너에 등록해줌
        MemberService memberService = applicationContext.getBean("memberService", MemberService.class);//AppConfig내부의 메서드 이름과 클래스 종류로 해당 Bean을 가져옴

        Member member = new Member(1L, "memberA", Grade.VIP);
        memberService.join(member);

        Member foundMember = memberService.findMember(1L);
        System.out.println("new member = " + member.getName());
        System.out.println("foundMember = " + foundMember.getName());
    }
}
