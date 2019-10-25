package com.moneyhub5.web.adm;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import org.springframework.stereotype.Component;


@Data
@Component
@AllArgsConstructor
@NoArgsConstructor//디폴트 생성자
public class Admin{
	private String astate,
	pos,
	aid,
	pwd;
}
