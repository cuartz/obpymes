package com.mx.santander.lh.obpymes.services;
import org.springframework.retry.annotation.Backoff;
import org.springframework.retry.annotation.Retryable;

import com.mx.santander.lh.obpymes.entities.Requirements;
import com.mx.santander.lh.obpymes.excepciones.ObPymeServiceException;

public interface ObtenRequisitosService {
	@Retryable(maxAttempts=3,backoff = @Backoff(delay = 500))
	public Requirements getComditions() throws ObPymeServiceException;
	@Retryable(maxAttempts=3,backoff = @Backoff(delay = 500))
	public Requirements getDocumentos() throws ObPymeServiceException;
	@Retryable(maxAttempts=3,backoff = @Backoff(delay = 500))
	public Requirements getDays() throws ObPymeServiceException;
	@Retryable(maxAttempts=3,backoff = @Backoff(delay = 500))
	public Requirements getRequisitos() throws ObPymeServiceException;

}
