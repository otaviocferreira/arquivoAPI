package br.com.jeotsolutions.arquivoapi;

import java.io.File;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;

import org.junit.Assert;
import org.junit.Test;

public class ArquivoUtilTestaIgualdadeArquivoTest extends ArquivoUtilTest {
	
	@Test
	public void testaGetTamanhoArquivoTextoArquivoOK() throws NoSuchAlgorithmException {
		try {
			File arquivo1 = new File("C:\\Users\\otavio.ferreira\\workspace_jeot\\arquivoAPI\\src\\test\\resources\\pastaTeste\\teste.txt");
			File arquivo2 = new File("C:\\Users\\otavio.ferreira\\workspace_jeot\\arquivoAPI\\src\\test\\resources\\pastaTeste2\\teste.txt");
			
			System.out.println(arquivo1.lastModified());
			System.out.println(arquivo2.lastModified());
			
			String hash1 = ArquivoUtil.criaHashParaArquivo(arquivo1);
			String hash2 = ArquivoUtil.criaHashParaArquivo(arquivo2);
			
			System.out.println(hash1);
			System.out.println(hash2);
			
			Assert.assertTrue(ArquivoUtil.ehArquivoComMesmoConteudo(hash1, hash2));
		} catch (IOException e) {
			Assert.assertTrue(false);
		}
	}
}
