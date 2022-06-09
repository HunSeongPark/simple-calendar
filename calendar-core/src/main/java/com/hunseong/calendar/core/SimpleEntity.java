package com.hunseong.calendar.core;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Created by Hunseong on 2022/06/09
 */
@Getter
@Setter
@ToString
@NoArgsConstructor
@Entity
public class SimpleEntity {

    @Id
    @GeneratedValue
    private Long id;

    private String name;
}
