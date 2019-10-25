package com.moneyhub5.web.client;

import org.springframework.stereotype.Repository;

@Repository
public interface ClientMapper {
	public void insertClient(Client client);
	public Client selecByIdPw(Client client);
	public int existId(String cid);
	
}
