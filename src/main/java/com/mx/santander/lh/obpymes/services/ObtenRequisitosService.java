package com.mx.santander.lh.obpymes.services;
import org.springframework.retry.annotation.Backoff;
import org.springframework.retry.annotation.Retryable;

import com.mx.santander.lh.obpymes.entities.Requirements;
import com.mx.santander.lh.obpymes.excepciones.ObPymeServiceException;

public interface ObtenRequisitosService {
	@Retryable(maxAttempts=3,backoff = @Backoff(delay = 2000))
	Requirements getRequisitos() throws ObPymeServiceException;

}
