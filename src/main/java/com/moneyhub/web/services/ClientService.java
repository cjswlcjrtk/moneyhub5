package com.moneyhub.web.services;

import org.springframework.stereotype.Component;

import com.moneyhub.web.domains.ClientDTO;

@Component
public interface ClientService {
	public ClientDTO login(ClientDTO param);
	public void join(ClientDTO param);
}
