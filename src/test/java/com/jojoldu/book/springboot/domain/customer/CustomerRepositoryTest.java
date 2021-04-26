package com.jojoldu.book.springboot.domain.customer;

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
public class CustomerRepositoryTest {

    @Autowired
    CustomerRepository customerRepository;

    @After
    public void cleanup() {
        customerRepository.deleteAll();
    }

    @Test
    public void test1() {
        //given
        Long svc_mgmt_num = 12345678l;
        String sex_cd = "M";


        customerRepository.save(Customer.builder()
                .svc_mgmt_num(svc_mgmt_num)
                .sex_cd(sex_cd)
                .audit_id("jojoldu")
                .build());

        //when
        List<Customer> serviceList = customerRepository.findAll();

        //then
        Customer service = serviceList.get(0);
        assertThat(service.getSvc_mgmt_num()).isEqualTo(svc_mgmt_num);
        assertThat(service.getSex_cd()).isEqualTo(sex_cd);
    }

    @Test
    public void test2() {
        //given
        LocalDateTime now = LocalDateTime.of(2019, 6, 4, 0, 0, 0);
        customerRepository.save(Customer.builder()
                .svc_mgmt_num(1234l)
                .sex_cd("M")
                .audit_id("audit_id")
                .build());
        //when
        List<Customer> customerList = customerRepository.findAll();

        //then
        Customer customer = customerList.get(0);

        System.out.println(">>>>>>>>> createDate=" + customer.getCreatedDate() + ", modifiedDate=" + customer.getModifiedDate());

        assertThat(customer.getCreatedDate()).isAfter(now);
        assertThat(customer.getModifiedDate()).isAfter(now);
    }
}
