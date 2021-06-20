package utils;

public class FileReaderUtilsTest {
	public static void main(String[] args) {
		readerFileToString();
	}
	
	private static void readerFileToString() {
		
		/*
		String filePath = "C:\\dev\\file.txt";
		List<Parcela> parcelas = new ArrayList<Parcela>();
		try {
			Double total = 0.0;
			Stream<String> stream = FileReaderUtils.stream(filePath) ;
			DecimalFormat nm = new DecimalFormat("#,##0.00");
            stream.forEach(l->{
            	String[] linha = l.split(" ");
            	if(linha[0].matches("\\d{1,3}")) {
            		Number valor;
					try {
						valor = nm.parse(linha[3]);
						parcelas.add(new Parcela(linha[0], linha[1], valor.doubleValue()));
					} catch (ParseException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
            		
            	}
            });
            
            for(Parcela p: parcelas) {
            	total  =total + p.getValor();
            }
            
            System.out.println(total);
        } catch (Exception e) {
            e.printStackTrace();
        }
        */
	}
}
