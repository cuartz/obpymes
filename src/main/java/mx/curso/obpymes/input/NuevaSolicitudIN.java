package mx.curso.obpymes.input;

import mx.curso.obpymes.entities.SolicitudCliente;

public class NuevaSolicitudIN extends BaseIN {

	private SolicitudCliente solicitud;

	public SolicitudCliente getSolicitud() {
		return solicitud;
	}

	public void setSolicitud(SolicitudCliente solicitud) {
		this.solicitud = solicitud;
	}
}
