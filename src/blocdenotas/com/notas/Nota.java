package blocdenotas.com.notas;

import java.time.LocalDateTime;
import java.util.Objects;

public class Nota implements Comparable<Nota>{

	private static Integer codigoSiguiente = 0;
	private Integer codigo;
	private String texto;
	private LocalDateTime fechaCreacion;
	private LocalDateTime fechaUltimaModificacion;
	
	public Nota(String nota) {
		this.texto = nota;
		this.codigo = codigoSiguiente;
		this.fechaCreacion = LocalDateTime.now();
		codigoSiguiente++;
	}

	//Getters and setters
	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
		this.fechaUltimaModificacion = LocalDateTime.now();	
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
		boolean resultado = true;
		if(this.fechaCreacion.isBefore(otraNota.getFechaCreacion())) {
			resultado = false;
		}
		return resultado;
		
	}
	public boolean isModificadoAnterior(Nota otraNota) {
		boolean resultado = false;
		if(this.isModificado() && otraNota.isModificado()) {
			resultado = this.getFechaModificacion().isBefore(otraNota.fechaUltimaModificacion);
		}else if (this.isModificado()) {
			resultado = true;
		}
		return resultado;
	}

	@Override
	public int hashCode() {
		return Objects.hash(codigo);
	}

	@Override
	public boolean equals(Object obj) {
		boolean sonIguales = false;
		
		if(obj!=null) {
			if (this == obj) {
				sonIguales = true;
			}else {
				Nota other = (Nota) obj;
				sonIguales = this.texto.equals(other.getTexto())
				&& this.getFechaCreacion().equals(other.getFechaCreacion());
			}
		}
		return sonIguales;
	}
	
	@Override
	public String toString() {
		String texto = "Nota: \n" + getTexto() + "\n Fecha creacion: "+ getFechaCreacion() + "\n Fecha modificacion: "+ getFechaModificacion();
		return texto;
		
	}
	@Override
	public int compareTo(Nota otraNota) {
		return this.getFechaCreacion().compareTo(otraNota.getFechaCreacion());
	}
	
}
