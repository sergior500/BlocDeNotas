package blocdenotas.com;

import java.time.LocalDateTime;

public class Nota {

	private static Integer codigoSiguiente = 0;
	private Integer codigo;
	private String texto;
	private LocalDateTime fechaCreacion;
	private LocalDateTime fechaUltimaModificacion;
	
	public Nota(String nota) {
		this.texto = nota;
		this.codigo = codigoSiguiente;
		codigoSiguiente++;
	}

	//Getters and setters
	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}

	public Integer getCodigo() {
		return codigo;
	}

	public LocalDateTime getFechaCreacion() {
		return fechaCreacion;
	}

	public LocalDateTime getFechaModificacion() {
		return fechaUltimaModificacion;
	}
	
	//metodos
	
	public boolean isModificado() {
		boolean resultado = false;
		if(this.fechaUltimaModificacion != null) {
			resultado = true;
		}
		return resultado;
	}
	public boolean isEmpty() {
		boolean resultado = false;
		if(this.texto != null || this.texto.trim().isEmpty()) {
			resultado = true;
		}
		return resultado;
	}
	public boolean isCreadoAnterior(Nota otraNota) {
		boolean resultado = false;
		if(this.fechaCreacion.isBefore(otraNota.getFechaCreacion())) {
			
		}else if(this.fechaCreacion.isAfter(otraNota.getFechaCreacion())) {
			
		}
		return resultado;
		
	}
	
	
}
