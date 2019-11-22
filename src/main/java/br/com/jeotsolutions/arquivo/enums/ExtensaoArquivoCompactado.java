package br.com.jeotsolutions.arquivo.enums;

/**
 * Enumerador responsável por representar as extensões de Arquivos compactados.
 * 
 * @author otavio.ferreira
 * @version 1.0.0
 * @since 1.0.0
 */
public enum ExtensaoArquivoCompactado {
	
	GZIP("gzip"),
	ZIP("zip");
	
	private String extensao;
	
	ExtensaoArquivoCompactado(String extensao) {
		this.extensao = extensao;
	}
	
	public String getExtensao() {
		return extensao;
	}
	
	/**
	 * Retorna uma instancia de {@link br.com.jeotsolutions.arquivo.enums.ExtensaoArquivoCompactado ExtensaoArquivo}
	 *  correspondente a extensão informada.
	 * @param extensao Extensão do arquivo.
	 * @return A instância de {@link br.com.jeotsolutions.arquivo.enums.ExtensaoArquivoCompactado ExtensaoArquivo} equivalente.
	 * @since 1.0.0
	 */
	public static ExtensaoArquivoCompactado getByExtensao(String extensao){
		if (extensao == null) return null;
		
		for (ExtensaoArquivoCompactado ext : ExtensaoArquivoCompactado.values()) if (ext.getExtensao().equals(extensao)) return ext;
		
		return null;
	}
}
