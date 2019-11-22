package br.com.jeotsolutions.arquivoapi;

import java.io.File;
import java.io.IOException;

import org.junit.Assert;
import org.junit.Test;

public class ArquivoUtilGetTamanhoArquivoTest extends ArquivoUtilTest {
	
	@Test
	public void testaGetTamanhoArquivoTextoArquivoOK() {
		try {
			Long tamanho = ArquivoUtil.getTamanhoArquivo(CAMINHO_ARQUIVO_OK);
			System.out.println("testaGetTamanhoArquivoTextoArquivoOK - " + tamanho);
			Assert.assertTrue(true);
		} catch (IOException e) {
			Assert.assertTrue(false);
		}
	}
	
	@Test
	public void testaGetTamanhoArquivoTextoPastaOK() {
		try {
			ArquivoUtil.getTamanhoArquivo(CAMINHO_PASTA_OK);
			Assert.assertTrue(false);
		} catch (IOException e) {
			System.out.println("testaGetTamanhoArquivoTextoPastaOK - " + e.getMessage());
			Assert.assertTrue(true);
		}
	}
	
	@Test
	public void testaGetTamanhoArquivoTextoArquivoNOK() {
		try {
			ArquivoUtil.getTamanhoArquivo(CAMINHO_ARQUIVO_NOK);
			Assert.assertTrue(false);
		} catch (IOException e) {
			System.out.println("testaGetTamanhoArquivoTextoArquivoNOK - " + e.getMessage());
			Assert.assertTrue(true);
		}
	}
	
	@Test
	public void testaGetTamanhoArquivoTextoPastaNOK() {
		try {
			ArquivoUtil.getTamanhoArquivo(CAMINHO_PASTA_NOK);
			Assert.assertTrue(false);
		} catch (IOException e) {
			System.out.println("testaGetTamanhoArquivoTextoPastaNOK - " + e.getMessage());
			Assert.assertTrue(true);
		}
	}
	
	@Test
	public void testaGetTamanhoArquivoFileArquivoOK() {
		try {
			Long tamanho = ArquivoUtil.getTamanhoArquivo(new File(CAMINHO_ARQUIVO_OK));
			System.out.println("testaGetTamanhoArquivoFileArquivoOK - " + tamanho);
			Assert.assertTrue(true);
		} catch (IOException e) {
			Assert.assertTrue(false);
		}
	}
	
	@Test
	public void testaGetTamanhoArquivoFilePastaOK() {
		try {
			ArquivoUtil.getTamanhoArquivo(new File(CAMINHO_PASTA_OK));
			Assert.assertTrue(false);
		} catch (IOException e) {
			System.out.println("testaGetTamanhoArquivoFilePastaOK - " + e.getMessage());
			Assert.assertTrue(true);
		}
	}
	
	@Test
	public void testaGetTamanhoArquivoFileArquivoNOK() {
		try {
			ArquivoUtil.getTamanhoArquivo(new File(CAMINHO_ARQUIVO_NOK));
			Assert.assertTrue(false);
		} catch (IOException e) {
			System.out.println("testaGetTamanhoArquivoFileArquivoNOK - " + e.getMessage());
			Assert.assertTrue(true);
		}
	}
	
	@Test
	public void testaGetTamanhoArquivoFilePastaNOK() {
		try {
			ArquivoUtil.getTamanhoArquivo(new File(CAMINHO_PASTA_NOK));
			Assert.assertTrue(false);
		} catch (IOException e) {
			System.out.println("testaGetTamanhoArquivoFilePastaNOK - " + e.getMessage());
			Assert.assertTrue(true);
		}
	}
}
