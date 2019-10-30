package com.moneyhub.web.mappers;

import org.springframework.stereotype.Repository;

import com.moneyhub.web.domains.ClientDTO;

@Repository
public interface ClientMapper {
	public ClientDTO selectClientId(ClientDTO param);
	public void insertClientId(ClientDTO param);
}
