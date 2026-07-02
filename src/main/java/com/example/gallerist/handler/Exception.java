package com.example.gallerist.handler;

import lombok.*;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Exception<E> {

    private String path;

    private Date createTime;

    private String hostName;

    private  E message;
}
