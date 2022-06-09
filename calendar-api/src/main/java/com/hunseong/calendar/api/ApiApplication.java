package com.hunseong.calendar.api;

import com.hunseong.calendar.core.SimpleEntity;
import com.hunseong.calendar.core.SimpleEntityRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by Hunseong on 2022/06/09
 */
@RestController
@EntityScan("com.hunseong.calendar.core")
@EnableJpaRepositories("com.hunseong.calendar.core")
@RequiredArgsConstructor
@EnableJpaAuditing
@SpringBootApplication
public class ApiApplication {

    private final SimpleEntityRepository repository;

    @GetMapping
    public List<SimpleEntity> findAll() {
        return repository.findAll();
    }

    @PostMapping("/save")
    public SimpleEntity saveOne() {
        SimpleEntity simpleEntity = new SimpleEntity();
        simpleEntity.setName("hello");
        return repository.save(simpleEntity);
    }

    public static void main(String[] args) {
        SpringApplication.run(ApiApplication.class, args);
    }
}
