package com.tuyoo.hqlcenter.entities;

import lombok.Data;

import javax.persistence.*;

//@Entity(name = "product_clientid")
//@Table
//@Data
public class TuyooClient {

//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

//    @ManyToOne
    private TuyooCloud cloud_id;

    private TuyooPlatform platform_id;

    private TuyooProduct product_id;

    private String name;

}
