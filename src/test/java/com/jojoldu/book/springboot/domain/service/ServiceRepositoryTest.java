package com.jojoldu.book.springboot.domain.service;

import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDateTime;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ServiceRepositoryTest {

    @Autowired
    ServiceRepository serviceRepository;

    @After
    public void cleanup() {
        serviceRepository.deleteAll();
    }

    @Test
    public void test1() {
        //given
        String svc_num = "테스트 게시글";
        String fee_prod_id = "테스트 본문";


        serviceRepository.save(Service.builder()
                .svc_num(svc_num)
                .fee_prod_id(fee_prod_id)
                .audit_id("jojoldu")
                .build());

        //when
        List<Service> serviceList = serviceRepository.findAll();

        //then
        Service service = serviceList.get(0);
        assertThat(service.getSvc_num()).isEqualTo(svc_num);
        assertThat(service.getFee_prod_id()).isEqualTo(fee_prod_id);
    }

    @Test
    public void test2() {
        //given
        LocalDateTime now = LocalDateTime.of(2019, 6, 4, 0, 0, 0);
        serviceRepository.save(Service.builder()
                .svc_num("svc_num")
                .fee_prod_id("fee_prod_id")
                .audit_id("audit_id")
                .build());
        //when
        List<Service> serviceList = serviceRepository.findAll();

        //then
        Service service = serviceList.get(0);

        System.out.println(">>>>>>>>> createDate=" + service.getCreatedDate() + ", modifiedDate=" + service.getModifiedDate());

        assertThat(service.getCreatedDate()).isAfter(now);
        assertThat(service.getModifiedDate()).isAfter(now);
    }
}
