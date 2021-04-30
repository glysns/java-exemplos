package digytal.java.infra.converter;

import digytal.java.model.cadastro.marca.Marca;
import digytal.java.model.cadastro.marca.MarcaEntity;

public class Teste {
	public static void main(String[] args) {
		Marca src = new Marca();
		src.nome="FORD";
		src.id=780;
		try {
			MarcaEntity other = (MarcaEntity) ModelConveter.getInstance(src).newInstance();
			System.out.println(other.getNome() + " " + other.getId());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
