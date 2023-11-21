package com.unistmo.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.sql.Date;
import java.sql.Timestamp;

@Entity
@Table(name = "product")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id_product", nullable = false)
    private Long idProduct;

    @Column(name = "product_name", nullable = false)
    private String productName;

    @Column(name = "created_date")
    @CreationTimestamp
    private Date createdDate;

    @Column(name = "created_timestamp")
    @CreationTimestamp
    private Timestamp createdTimestamp;
}
