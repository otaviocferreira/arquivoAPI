package br.com.jeotsolutions.arquivoapi;

import java.io.File;
import java.io.IOException;

import org.junit.Assert;
import org.junit.Test;

public class ArquivoUtilGetExtensaoTest extends ArquivoUtilTest {
	
	@Test
	public void testaGetExtensaoTextoArquivoOK() {
		try {
			String ext = ArquivoUtil.getExtensao(CAMINHO_ARQUIVO_OK);
			System.out.println("testaGetExtensaoArquivoOK - " + ext);
			Assert.assertTrue(true);
		} catch (IOException e) {
			Assert.assertTrue(false);
		}
	}
	
	@Test
	public void testaGetExtensaoTextoPastaOK() {
		try {
			ArquivoUtil.getExtensao(CAMINHO_PASTA_OK);
			Assert.assertTrue(false);
		} catch (IOException e) {
			System.out.println("testaGetExtensaoPastaOK - " + e.getMessage());
			Assert.assertTrue(true);
		}
	}
	
	@Test
	public void testaGetExtensaoTextoArquivoNOK() {
		try {
			ArquivoUtil.getExtensao(CAMINHO_ARQUIVO_NOK);
			Assert.assertTrue(false);
		} catch (IOException e) {
			System.out.println("testaGetExtensaoArquivoNOK - " + e.getMessage());
			Assert.assertTrue(true);
		}
	}
	
	@Test
	public void testaGetExtensaoTextoPastaNOK() {
		try {
			ArquivoUtil.getExtensao(CAMINHO_PASTA_NOK);
			Assert.assertTrue(false);
		} catch (IOException e) {
			System.out.println("testaGetExtensaoPastaNOK - " + e.getMessage());
			Assert.assertTrue(true);
		}
	}
	
	@Test
	public void testaGetExtensaoFileArquivoOK() {
		try {
			String ext = ArquivoUtil.getExtensao(new File(CAMINHO_ARQUIVO_OK));
			System.out.println("testaGetExtensaoArquivoOK - " + ext);
			Assert.assertTrue(true);
		} catch (IOException e) {
			Assert.assertTrue(false);
		}
	}
	
	@Test
	public void testaGetExtensaoFilePastaOK() {
		try {
			ArquivoUtil.getExtensao(new File(CAMINHO_PASTA_OK));
			Assert.assertTrue(false);
		} catch (IOException e) {
			System.out.println("testaGetExtensaoPastaOK - " + e.getMessage());
			Assert.assertTrue(true);
		}
	}
	
	@Test
	public void testaGetExtensaoFileArquivoNOK() {
		try {
			ArquivoUtil.getExtensao(new File(CAMINHO_ARQUIVO_NOK));
			Assert.assertTrue(false);
		} catch (IOException e) {
			System.out.println("testaGetExtensaoArquivoNOK - " + e.getMessage());
			Assert.assertTrue(true);
		}
	}
	
	@Test
	public void testaGetExtensaoFilePastaNOK() {
		try {
			ArquivoUtil.getExtensao(new File(CAMINHO_PASTA_NOK));
			Assert.assertTrue(false);
		} catch (IOException e) {
			System.out.println("testaGetExtensaoPastaNOK - " + e.getMessage());
			Assert.assertTrue(true);
		}
	}
}
