package com.tuyoo.hqlcenter.entities;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@Table(name = "product_platform")
@NoArgsConstructor
@RequiredArgsConstructor
public class TuyooPlatform {

    @Id
    @GeneratedValue
    private Integer id;
    @NonNull
    @Column(name = "platform_name")
    private String name;
    @NonNull
    @Column(name = "platform_ext", unique = true)
    private String ext;
}
