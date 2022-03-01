package com.springboot.springbootprabegin;

import com.springboot.springbootprabegin.repository.JdbcMemberRepository;
import com.springboot.springbootprabegin.repository.JpaMemberRepository;
import com.springboot.springbootprabegin.repository.MemberRepository;
import com.springboot.springbootprabegin.repository.MemoryMemberRepository;
import com.springboot.springbootprabegin.service.MemberService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.sql.DataSource;

@Configuration
public class SpringConfig {

    @PersistenceContext
    private EntityManager em;

    @Bean
    public MemberService memberService() {
        return new MemberService(memberRepository());
    }

    @Bean
    public MemberRepository memberRepository() {
        //return new MemoryMemberRepository();
        //return new JdbcMemberRepository(dataSource);
        return new JpaMemberRepository(em);
    }

}
