package com.tuyoo.hqlcenter.entities;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;

@Data
@Table(name = "product_cloud")
@Entity
@NoArgsConstructor
@RequiredArgsConstructor
public class TuyooCloud {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NonNull
    @Column(name = "cloud_id")
    private Integer cloudId;
    @NonNull
    @Column(name = "cloud_name")
    private String name;
    @NonNull
    @Column(name = "cloud_ext", unique = true)
    private String ext;
    @NonNull
    @Column(name = "cloud_desc")
    private String desc;

}
