package com.mnlsolution.chime;

import java.util.Date;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.filter.CharacterEncodingFilter;

import javax.servlet.Filter;
import java.nio.charset.Charset;


import com.mnlsolution.chime.domain.Account;
import com.mnlsolution.chime.repository.AccountRepository;

// @SpringBootApplication
@Configuration
@EnableAutoConfiguration
@ComponentScan
public class SpringBootTestApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootTestApplication.class, args);
    }
    

    
    // 한글 처리용 필터 
    @Bean
    public HttpMessageConverter<String> responseBodyConverter() {
        return new StringHttpMessageConverter(Charset.forName("UTF-8"));
    }
 
    @Bean
    public Filter characterEncodingFilter() {
        CharacterEncodingFilter characterEncodingFilter = new CharacterEncodingFilter();
        characterEncodingFilter.setEncoding("UTF-8");
        characterEncodingFilter.setForceEncoding(true);
        return characterEncodingFilter;
    }
    
    
    
    // 초기 데이터 입력 처리 
    @Autowired
    AccountRepository accountRepository;
    
    @Autowired
    PasswordEncoder passwordEncoder;
    
    @Bean
    InitializingBean insertFixtureUsers(){
        return ()->{
            Account admin = new Account();
            admin.setUserid("admin");
            admin.setPassword(passwordEncoder.encode("1234"));
            admin.setRole("ROLE_ADMIN");
            admin.setRegitime(new Date());            
            admin.setDept("MNLSOLUTion");
            admin.setNick("관리자");
            accountRepository.save(admin);

            Account user = new Account();
            user.setUserid("chime");
            user.setPassword(passwordEncoder.encode("1234"));
            user.setRole("ROLE_USER");
            user.setDept("MNLSOLUTion"); 
            user.setRegitime(new Date());            
            user.setNick("곽선생");
            accountRepository.save(user);

        };
    }
    
}
