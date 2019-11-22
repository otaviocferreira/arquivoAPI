package br.com.jeotsolutions.arquivo.enums;

/**
 * Enumerador responsável por representar as extensões  de Arquivos de Imagem.
 * 
 * @author otavio.ferreira
 * @version 1.0.0
 * @since 1.0.0
 */
public enum ExtensaoArquivoImagem {
	
	GIF("gif"),
	JPEG("jpeg"),
	JPG("jpg"),
	PNG("png");
	
	private String extensao;
	
	ExtensaoArquivoImagem(String extensao) {
		this.extensao = extensao;
	}
	
	public String getExtensao() {
		return extensao;
	}
	
	/**
	 * Retorna uma instancia de {@link br.com.jeotsolutions.arquivo.enums.ExtensaoArquivoImagem ExtensaoArquivo}
	 *  correspondente a extensão informada.
	 * @param extensao Extensão do arquivo.
	 * @return A instância de {@link br.com.jeotsolutions.arquivo.enums.ExtensaoArquivoImagem ExtensaoArquivo} equivalente.
	 * @since 1.0.0
	 */
	public static ExtensaoArquivoImagem getByExtensao(String extensao){
		if (extensao == null) return null;
		
		for (ExtensaoArquivoImagem ext : ExtensaoArquivoImagem.values()) if (ext.getExtensao().equals(extensao)) return ext;
		
		return null;
	}
}
