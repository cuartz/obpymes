package com.mx.santander.lh.obpymes.services;
import java.util.List;

import org.springframework.retry.annotation.Backoff;
import org.springframework.retry.annotation.Retryable;

import com.mx.santander.lh.obpymes.entities.Conditions;
import com.mx.santander.lh.obpymes.entities.Documents;
import com.mx.santander.lh.obpymes.entities.Requirements;
import com.mx.santander.lh.obpymes.excepciones.ObPymeServiceException;

public interface ObtenRequisitosService {
	@Retryable(maxAttempts=3,backoff = @Backoff(delay = 500))
	public List<Conditions> getConditions() throws ObPymeServiceException;
	@Retryable(maxAttempts=3,backoff = @Backoff(delay = 500))
	public List<Documents> getDocuments() throws ObPymeServiceException;
	@Retryable(maxAttempts=3,backoff = @Backoff(delay = 500))
	public String getDays() throws ObPymeServiceException;
	@Retryable(maxAttempts=3,backoff = @Backoff(delay = 500))
	public Requirements getRequirements() throws ObPymeServiceException;

}
