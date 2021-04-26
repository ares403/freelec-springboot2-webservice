package com.jojoldu.book.springboot.domain.customer;

import com.jojoldu.book.springboot.domain.BaseTimeEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Getter
@NoArgsConstructor
@Entity

public class Customer extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long cust_num;

    @Column(length = 10, nullable = false)
    private Long svc_mgmt_num;

    @Column(length = 1, nullable = false)
    private String sex_cd;

    @Column(length = 15, nullable = false)
    private String audit_id;

    @Builder
    public Customer(Long svc_mgmt_num, String sex_cd, String audit_id) {
        this.svc_mgmt_num = svc_mgmt_num;
        this.sex_cd = sex_cd;
        this.audit_id = audit_id;
    }

    public void update(Long svc_mgmt_num, String sex_cd) {
        this.svc_mgmt_num = svc_mgmt_num;
        this.sex_cd = sex_cd;
    }
}
