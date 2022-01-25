
public class Principal {
	
	public static void main(String[] args) {
		
	chamaSalvar();
	//chamaPegarUm();
	//chamaUpdade();
	//chamaPegarUm();
		//chamaPegarUm();

		
	}
	
	static void chamaSalvar() {
		
		Contato contato = new Contato();
		contato.setNome("Marcus");
		contato.setEmail("marcus@hotmail.com");
		contato.setCelular("9932-8868");	
		
		new DaoContato().salvar(contato);
		
	}
	
	static void chamaPegarUm() {
		Contato contato = new DaoContato().pegaarUm(1L);
		System.out.println("nome :"+contato.getNome());
		System.out.println("E-mail :"+contato.getEmail());
		System.out.println("Telefone :"+contato.getCelular());
	}
	
	static void chamaUpdade() {
		Contato contato = new DaoContato().pegaarUm(1L);
		contato.setCelular("999191919");
		if(new DaoContato().update(contato)) {
			System.out.println("alterado");
		}
				
					
	}
	
}
