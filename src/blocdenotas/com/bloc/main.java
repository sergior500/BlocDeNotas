package blocdenotas.com.bloc;

import blocdenotas.com.notas.NotaAlarmaException;

public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		try {
			NotaAlarma notaAlarma = null;
			
			notaAlarma.activar();
			System.out.println(notaAlarma.toString);
			
		}catch(Exception excep){
			throw new NotaAlarmaException("Se ha producido un error inesperado", excep);
		}
	}

}
