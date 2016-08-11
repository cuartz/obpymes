package com.mx.santander.lh.obpymes.services;

import com.mx.santander.lh.obpymes.entities.Requirements;
import com.mx.santander.lh.obpymes.excepciones.ObPymeServiceException;

public interface ObtenRequisitosService {

	Requirements getRequisitos() throws ObPymeServiceException;

}
