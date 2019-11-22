package br.com.jeotsolutions.arquivoapi;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

public class ArquivoUtilGetLinhasArquivoTest extends ArquivoUtilTest {
	
	@Test
	public void testaGetLinhasArquivoTextoArquivoOK() {
		try {
			List<String> lista = ArquivoUtil.getLinhasArquivo(CAMINHO_ARQUIVO_OK, StandardCharsets.UTF_8);
			System.out.print("testaGetTamanhoArquivoTextoArquivoOK - ");
			lista.stream().forEach(item -> System.out.print(item + " "));
			System.out.println();
			Assert.assertTrue(true);
		} catch (IOException e) {
			Assert.assertTrue(false);
		}
	}
	
	@Test
	public void testaGetLinhasArquivoTextoArquivoImagemOK() {
		try {
			ArquivoUtil.getLinhasArquivo(CAMINHO_IMAGEM_OK, StandardCharsets.UTF_8);
			Assert.assertTrue(false);
		} catch (IOException e) {
			Assert.assertTrue(false);
		} catch (IllegalArgumentException e) {
			System.out.println("testaGetLinhasArquivoTextoArquivoImagemOK - " + e.getMessage());
			Assert.assertTrue(true);
		}
	}
	
	@Test
	public void testaGetLinhasArquivoTextoPastaOK() {
		try {
			ArquivoUtil.getLinhasArquivo(CAMINHO_PASTA_OK, StandardCharsets.UTF_8);
			Assert.assertTrue(false);
		} catch (IOException e) {
			System.out.println("testaGetLinhasArquivoTextoPastaOK - " + e.getMessage());
			Assert.assertTrue(true);
		}
	}
	
	@Test
	public void testaGetLinhasArquivoTextoArquivoNOK() {
		try {
			ArquivoUtil.getLinhasArquivo(CAMINHO_ARQUIVO_NOK, StandardCharsets.UTF_8);
			Assert.assertTrue(false);
		} catch (IOException e) {
			System.out.println("testaGetLinhasArquivoTextoArquivoNOK - " + e.getMessage());
			Assert.assertTrue(true);
		}
	}
	
	@Test
	public void testaGetLinhasArquivoTextoArquivoImagemNOK() {
		try {
			ArquivoUtil.getLinhasArquivo(CAMINHO_IMAGEM_NOK, StandardCharsets.UTF_8);
			Assert.assertTrue(false);
		} catch (IOException e) {
			System.out.println("testaGetLinhasArquivoTextoArquivoImagemNOK - " + e.getMessage());
			Assert.assertTrue(true);
		} catch (IllegalArgumentException e) {
			Assert.assertTrue(false);
		}
	}
	
	@Test
	public void testaGetLinhasArquivoTextoPastaNOK() {
		try {
			ArquivoUtil.getLinhasArquivo(CAMINHO_PASTA_NOK, StandardCharsets.UTF_8);
			Assert.assertTrue(false);
		} catch (IOException e) {
			System.out.println("testaGetLinhasArquivoTextoPastaNOK - " + e.getMessage());
			Assert.assertTrue(true);
		}
	}
	
	@Test
	public void testaGetLinhasArquivoFileArquivoOK() {
		try {
			List<String> lista = ArquivoUtil.getLinhasArquivo(new File(CAMINHO_ARQUIVO_OK), StandardCharsets.UTF_8);
			System.out.print("testaGetLinhasArquivoFileArquivoOK - ");
			lista.stream().forEach(item -> System.out.print(item + " "));
			System.out.println();
			Assert.assertTrue(true);
		} catch (IOException e) {
			Assert.assertTrue(false);
		}
	}
	
	@Test
	public void testaGetLinhasArquivoFileArquivoImagemOK() {
		try {
			ArquivoUtil.getLinhasArquivo(new File(CAMINHO_IMAGEM_OK), StandardCharsets.UTF_8);
			Assert.assertTrue(false);
		} catch (IOException e) {
			Assert.assertTrue(false);
		} catch (IllegalArgumentException e) {
			System.out.println("testaGetLinhasArquivoFileArquivoImagemOK - " + e.getMessage());
			Assert.assertTrue(true);
		}
	}
	
	@Test
	public void testaGetLinhasArquivoFilePastaOK() {
		try {
			ArquivoUtil.getLinhasArquivo(new File(CAMINHO_PASTA_OK), StandardCharsets.UTF_8);
			Assert.assertTrue(false);
		} catch (IOException e) {
			System.out.println("testaGetLinhasArquivoFilePastaOK - " + e.getMessage());
			Assert.assertTrue(true);
		}
	}
	
	@Test
	public void testaGetLinhasArquivoFileArquivoNOK() {
		try {
			ArquivoUtil.getLinhasArquivo(new File(CAMINHO_ARQUIVO_NOK), StandardCharsets.UTF_8);
			Assert.assertTrue(false);
		} catch (IOException e) {
			System.out.println("testaGetLinhasArquivoFileArquivoNOK - " + e.getMessage());
			Assert.assertTrue(true);
		}
	}
	
	@Test
	public void testaGetLinhasArquivoFileArquivoImagemNOK() {
		try {
			ArquivoUtil.getLinhasArquivo(new File(CAMINHO_IMAGEM_NOK), StandardCharsets.UTF_8);
			Assert.assertTrue(false);
		} catch (IOException e) {
			System.out.println("testaGetLinhasArquivoFileArquivoImagemNOK - " + e.getMessage());
			Assert.assertTrue(true);
		} catch (IllegalArgumentException e) {
			Assert.assertTrue(false);
		}
	}
	
	@Test
	public void testaGetLinhasArquivoFilePastaNOK() {
		try {
			ArquivoUtil.getLinhasArquivo(new File(CAMINHO_PASTA_NOK), StandardCharsets.UTF_8);
			Assert.assertTrue(false);
		} catch (IOException e) {
			System.out.println("testaGetLinhasArquivoFilePastaNOK - " + e.getMessage());
			Assert.assertTrue(true);
		}
	}
}
