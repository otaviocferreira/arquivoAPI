package br.com.jeotsolutions.arquivoapi;

import org.junit.Assert;
import org.junit.Test;

import junit.framework.TestCase;

public class ArquivoUtilTest extends TestCase {

	protected static String CAMINHO_PASTA_OK= "C:\\Users\\otavio.ferreira\\workspace_jeot\\arquivoAPI\\src\\test\\resources\\pastaTeste";
	protected static String CAMINHO_ARQUIVO_OK= "C:\\Users\\otavio.ferreira\\workspace_jeot\\arquivoAPI\\src\\test\\resources\\pastaTeste\\teste.txt";
	protected static String CAMINHO_IMAGEM_OK= "C:\\Users\\otavio.ferreira\\workspace_jeot\\arquivoAPI\\src\\test\\resources\\pastaTeste\\prova.png";

	protected static String CAMINHO_PASTA_NOK= "C:\\Users\\otavio.ferreira\\workspace_jeot\\arquivoAPI\\src\\test\\resources\\pastaTes";
	protected static String CAMINHO_ARQUIVO_NOK= "C:\\Users\\otavio.ferreira\\workspace_jeot\\arquivoAPI\\src\\test\\resources\\pastaTeste\\tete.txt";
	protected static String CAMINHO_IMAGEM_NOK= "C:\\Users\\otavio.ferreira\\workspace_jeot\\arquivoAPI\\src\\test\\resources\\pastaTeste\\pova.png";
	
	@Test
	public void teste() {
		Assert.assertTrue(true);
	}

}
