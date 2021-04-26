package com.jojoldu.book.springboot.domain.service;

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
public class Service extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long svc_mgmt_num;

    @Column(length = 20, nullable = false)
    private String svc_num;

    @Column(length = 10, nullable = false)
    private String fee_prod_id;

    @Column(length = 15, nullable = false)
    private String audit_id;

    @Builder
    public Service(String svc_num, String fee_prod_id, String audit_id) {
        this.svc_num = svc_num;
        this.fee_prod_id = fee_prod_id;
        this.audit_id = audit_id;
    }

    public void update(String svc_num, String fee_prod_id) {
        this.svc_num = svc_num;
        this.fee_prod_id = fee_prod_id;
    }
}
