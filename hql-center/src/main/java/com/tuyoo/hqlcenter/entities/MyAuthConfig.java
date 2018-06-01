package com.tuyoo.hqlcenter.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MyAuthConfig {

    private Integer id;
    private String name;
    private String url;
}
