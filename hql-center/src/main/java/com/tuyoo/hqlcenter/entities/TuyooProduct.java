package com.tuyoo.hqlcenter.entities;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@RequiredArgsConstructor
@Entity
@Table(name = "product_id")
public class TuyooProduct {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NonNull
    @Column(name = "product_id")
    private Integer productId;
    @NonNull
    @Column(name = "product_name")
    private String name;
    @NonNull
    @Column(name = "product_ext")
    private String ext;

}
