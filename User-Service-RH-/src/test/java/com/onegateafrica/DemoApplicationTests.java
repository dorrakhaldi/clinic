package com.onegateafrica;



import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.sql.Timestamp;
import java.util.Date;

import org.junit.jupiter.api.Test;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;

import com.onegateafrica.dto.GradeDto;
import com.onegateafrica.entity.Grade;
import com.onegateafrica.service.ServiceGrade;

@SpringBootTest(classes = DemoApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class DemoApplicationTests {


    private ServiceGrade serviceGrade;
    private TestRestTemplate restTemplate;
    private String url="http://localhost:8080/rh-ms/api/grade";
    private ModelMapper mapper;


    @Autowired
    public DemoApplicationTests(ServiceGrade serviceGrade, TestRestTemplate restTemplate, ModelMapper mapper) {
        this.serviceGrade = serviceGrade;
        this.restTemplate = restTemplate;
        this.mapper = mapper;
    }

    @Test
    void contextLoads() {
    }


    @Test
    void updateGrade() {
        int id = 31;
        Date date = new Date();
        Timestamp ts=new Timestamp(date.getTime());
        Grade grade = restTemplate.getForObject(url + id, Grade.class);
        grade.setNom("spring test");
        grade.setDatePromotion(ts);
        restTemplate.put(url + id, grade);
        Grade updatedGrade = restTemplate.getForObject(url + id, Grade.class);
        assertNotNull(updatedGrade);
    }

    @Test
    void getAllGrade() {
        HttpHeaders headers = new HttpHeaders();
        HttpEntity<String> entity = new HttpEntity<>(null, headers);
        ResponseEntity<String> response = restTemplate.exchange(url ,
            HttpMethod.GET, entity, String.class);
        assertNotNull(response.getBody());
    }

    @Test
    void deleteGrade() {
        int id = 20;
        Grade grade = restTemplate.getForObject(url + id, Grade.class);
        assertNotNull(grade);
        restTemplate.delete(url + id);
    }



    @Test
    void createProduits(){
        Date date = new Date();
        Timestamp ts=new Timestamp(date.getTime());
        Grade grade = new Grade("test create",ts);
        var p =serviceGrade.create(mapper.map(grade, GradeDto.class));
        assertNotNull(p);
    }

}
