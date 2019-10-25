package com.moneyhub5.web.client;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@Component
@AllArgsConstructor
@NoArgsConstructor//디폴트 생성자
public class Client{
	private String cid,
	pwd;
}
