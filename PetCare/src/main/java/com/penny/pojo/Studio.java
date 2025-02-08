package com.penny.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class Studio {
    private Integer id; //ID
    private String name;
    private LocalDateTime createTime;
    private LocalDateTime updateTime;
}
