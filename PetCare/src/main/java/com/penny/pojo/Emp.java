package com.penny.pojo;
//Emp 实体类

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Emp {
    private Integer id; //ID
    private String username;
    private String password;
    private String name;
    private Short gender;
    private String image;
    private Short job; // 1职业宠物管家- 小猫， 2初级宠物管家 -大猫，  3宠物大师 小狗， 4实习宠物管家 大狗， 5极品宠物管家 other，
    private LocalDateTime entrydate;
    private Integer studioId;
    private LocalDateTime createTime;
    private LocalDateTime updateTime;;
}
