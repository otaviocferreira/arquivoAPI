package br.com.jeotsolutions.arquivo.enums;

/**
 * Enumerador responsável por representar as extensões  de Arquivos de texto.
 * 
 * @author otavio.ferreira
 * @version 1.0.0
 * @since 1.0.0
 */
public enum ExtensaoArquivoTexto {
	
	CSV("csv"),
	TXT("txt");
	
	private String extensao;
	
	ExtensaoArquivoTexto(String extensao) {
		this.extensao = extensao;
	}
	
	public String getExtensao() {
		return extensao;
	}
	
	/**
	 * Retorna uma instancia de {@link br.com.jeotsolutions.arquivo.enums.ExtensaoArquivoTexto ExtensaoArquivo}
	 *  correspondente a extensão informada.
	 * @param extensao Extensão do arquivo.
	 * @return A instância de {@link br.com.jeotsolutions.arquivo.enums.ExtensaoArquivoTexto ExtensaoArquivo} equivalente.
	 * @since 1.0.0
	 */
	public static ExtensaoArquivoTexto getByExtensao(String extensao){
		if (extensao == null) return null;
		
		for (ExtensaoArquivoTexto ext : ExtensaoArquivoTexto.values()) if (ext.getExtensao().equals(extensao)) return ext;
		
		return null;
	}
}
