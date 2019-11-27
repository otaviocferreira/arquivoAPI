package br.com.jeotsolutions.arquivoapi;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.math.BigInteger;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import br.com.jeotsolutions.arquivo.enums.ExtensaoArquivoCompactado;
import br.com.jeotsolutions.arquivo.enums.ExtensaoArquivoImagem;
import br.com.jeotsolutions.arquivo.enums.ExtensaoArquivoTexto;

/**
 * Classe utilitária para manipular arquivos.
 * 
 * @see java.io.File
 * @author otavio.ferreira
 * @version 1.0.0
 * @since 1.0.0
 */
public class ArquivoUtil {

	private static final String ERRO_CAMINHO_INVALIDO = "O caminho do arquivo não é válido.";
	private static final String ERRO_TIPO_ARQUIVO_INVALIDO = "Esse arquivo não é de um tipo permitido nesse método.";

	/**
	 * Informa a extensão do arquivo.
	 * 
	 * @param caminhoArquivo O caminho completo para o arquivo.
	 * @return A {@link br.com.jeotsolutions.arquivo.enums.ExtensaoArquivo
	 *         ExtensaoArquivo} equivalente a do arquivo informado.
	 * @throws IOException O caminho do arquivo não é válido.
	 * @since 1.0.0
	 */
	public static String getExtensao(String caminhoArquivo) throws IOException {
		if (null == caminhoArquivo)
			throw new IOException(ERRO_CAMINHO_INVALIDO);

		File arquivo = new File(caminhoArquivo);

		if (arquivo.isDirectory() || !arquivo.exists())
			throw new IOException(ERRO_CAMINHO_INVALIDO);

		return caminhoArquivo.substring(caminhoArquivo.lastIndexOf(".") + 1, caminhoArquivo.length());
	}

	/**
	 * Informa a extensão do arquivo.
	 * 
	 * @see java.io.File
	 * @param arquivo Arquivo para buscar a extensão.
	 * @return A {@link br.com.jeotsolutions.arquivo.enums.ExtensaoArquivo
	 *         ExtensaoArquivo} equivalente a do arquivo informado.
	 * @throws IOException O caminho do arquivo não é válido.
	 * @since 1.0.0
	 */
	public static String getExtensao(File arquivo) throws IOException {
		if (null == arquivo)
			throw new IOException(ERRO_CAMINHO_INVALIDO);
		if (arquivo.isDirectory() || !arquivo.exists())
			throw new IOException(ERRO_CAMINHO_INVALIDO);
		return arquivo.getName().substring(arquivo.getName().lastIndexOf(".") + 1, arquivo.getName().length());
	}

	/**
	 * Informa o tamanho do arquivo.
	 * 
	 * @see java.io.File
	 * @param arquivo O arquivo que será utilizado.
	 * @return Tamanho do arquivo.
	 * @throws IOException O caminho do arquivo não é válido.
	 * @since 1.0.0
	 */
	public static Long getTamanhoArquivo(File arquivo) throws IOException {
		if (null == arquivo)
			throw new IOException(ERRO_CAMINHO_INVALIDO);
		if (arquivo.isDirectory() || !arquivo.exists())
			throw new IOException(ERRO_CAMINHO_INVALIDO);
		return arquivo.length();
	}

	/**
	 * Informa o tamanho do arquivo.
	 * 
	 * @param caminhoCompletoArquivo O caminho completo para o arquivo que será
	 *                               utilizado.
	 * @return Tamanho do arquivo.
	 * @throws IOException O caminho do arquivo não é válido.
	 * @since 1.0.0
	 */
	public static Long getTamanhoArquivo(String caminhoCompletoArquivo) throws IOException {
		if (null == caminhoCompletoArquivo)
			throw new IOException(ERRO_CAMINHO_INVALIDO);

		File arquivo = new File(caminhoCompletoArquivo);

		if (arquivo.isDirectory() || !arquivo.exists())
			throw new IOException(ERRO_CAMINHO_INVALIDO);

		return arquivo.length();
	}

	/**
	 * Busca todas as linhas do arquivo e retorna como uma lista.
	 * 
	 * @see java.nio.charset.Charset
	 * @param caminhoCompletoArquivo O caminho completo para o arquivo que será
	 *                               utilizado.
	 * @param charset                Charset do arquivo informado. Ex.:
	 *                               StandardCharsets.ISO_8859_1,
	 *                               StandardCharsets.UTF_8, ...
	 * @return Uma lista onde cada item é uma linha do arquivo.
	 * @throws IOException              Caso o arquivo não possa ser lido de alguma
	 *                                  forma.
	 * @throws IllegalArgumentException Caso o tipo do arquivo não seja texto.
	 * @since 1.0.0
	 */
	public static List<String> getLinhasArquivo(String caminhoCompletoArquivo, Charset charset) throws IOException {
		List<String> linhas = new ArrayList<String>();

		try {
			if (null == caminhoCompletoArquivo)
				throw new IOException();
			if (!ehArquivoTexto(getExtensao(caminhoCompletoArquivo)))
				throw new IllegalArgumentException();
			linhas = Files.lines(Paths.get(caminhoCompletoArquivo)).collect(Collectors.toList());
		} catch (IOException e) {
			throw new IOException(ERRO_CAMINHO_INVALIDO);
		} catch (IllegalArgumentException e) {
			throw new IllegalArgumentException(ERRO_TIPO_ARQUIVO_INVALIDO);
		}

		return linhas;
	}

	/**
	 * Busca todas as linhas do arquivo e retorna como uma lista.
	 * 
	 * @see java.io.File
	 * @see java.nio.charset.Charset
	 * @param arquivo O arquivo que será utilizado.
	 * @param charset Charset do arquivo informado. Ex.:
	 *                StandardCharsets.ISO_8859_1, StandardCharsets.UTF_8, ...
	 * @return Uma lista onde cada item é uma linha do arquivo.
	 * @throws IOException              Caso o arquivo não possa ser lido de alguma
	 *                                  forma.
	 * @throws IllegalArgumentException Caso o tipo do arquivo não seja texto.
	 * @since 1.0.0
	 */
	public static List<String> getLinhasArquivo(File arquivo, Charset charset) throws IOException {
		List<String> linhas = new ArrayList<String>();

		try {
			if (null == arquivo)
				throw new IOException();
			if (!ehArquivoTexto(getExtensao(arquivo)))
				throw new IllegalArgumentException();
			linhas = Files.lines(Paths.get(arquivo.getAbsolutePath())).collect(Collectors.toList());
		} catch (IOException e) {
			throw new IOException(ERRO_CAMINHO_INVALIDO);
		} catch (IllegalArgumentException e) {
			throw new IllegalArgumentException(ERRO_TIPO_ARQUIVO_INVALIDO);
		}

		return linhas;
	}

	/**
	 * Verifica se o arquivo é do tipo texto
	 * 
	 * @param extensao Extensão do arquivo.
	 * @return
	 *         <p>
	 *         TRUE - É um arquivo texto
	 *         </p>
	 *         <p>
	 *         FALSE - Não é um arquivo texto.
	 *         </p>
	 * @since 1.0.0
	 */
	public static boolean ehArquivoTexto(String extensao) {
		return Arrays.asList(ExtensaoArquivoTexto.values()).stream().filter(ext -> ext.getExtensao().equals(extensao)).findFirst().isPresent();
	}

	/**
	 * Verifica se o arquivo é do tipo imagem.
	 * 
	 * @param extensao Extensão do arquivo.
	 * @return
	 *         <p>
	 *         TRUE - É um arquivo imagem
	 *         </p>
	 *         <p>
	 *         FALSE - Não é um arquivo imagem.
	 *         </p>
	 * @since 1.0.0
	 */
	public static boolean ehArquivoImagem(String extensao) {
		return Arrays.asList(ExtensaoArquivoImagem.values()).stream().filter(ext -> ext.getExtensao().equals(extensao)).findFirst().isPresent();
	}

	/**
	 * Verifica se o arquivo é do tipo compactado.
	 * 
	 * @param extensao Extensão do arquivo.
	 * @return
	 *         <p>
	 *         TRUE - É um arquivo compactado
	 *         </p>
	 *         <p>
	 *         FALSE - Não é um arquivo compactado.
	 *         </p>
	 * @since 1.0.0
	 */
	public static boolean ehArquivoCompactado(String extensao) {
		return Arrays.asList(ExtensaoArquivoCompactado.values()).stream().filter(ext -> ext.getExtensao().equals(extensao)).findFirst().isPresent();
	}

	/**
	 * Método responsável por listar todos os arquivos do diretório e de seus
	 * subdiretórios.
	 * 
	 * @see java.util.Set
	 * @see java.io.File
	 * @param diretorio Diretório a ter os arquivos listados.
	 * @param arquivos  Uma collection que receberá os arquivos do diretório
	 *                  informado.
	 * @throws IOException Caso o caminho para o arquivo seja invállido.
	 * @exception IllegalArgumentException Se o File informado não for um diretório.
	 * @since 1.0.0
	 */
	public static void listaArquivosPorDiretorio(File diretorio, Set<File> arquivos) throws IOException {
		if (null == diretorio)
			throw new IOException(ERRO_CAMINHO_INVALIDO);

		if (diretorio.isDirectory()) {
			File[] listagem = diretorio.listFiles();
			for (File arquivo : listagem) {
				if (arquivo.isDirectory() && !arquivo.getName().equals(".") && !arquivo.getName().equals("..")) {
					listaArquivosPorDiretorio(arquivo, arquivos);
				} else {
					arquivos.add(arquivo);
				}
			}
		} else {
			throw new IllegalArgumentException(ERRO_TIPO_ARQUIVO_INVALIDO);
		}
	}

	/**
	 * Método responsável por listar todos os arquivos do diretório e de seus
	 * subdiretórios.
	 * 
	 * @see java.util.Set
	 * @see java.io.File
	 * @param diretorio Diretório a ter os arquivos listados.
	 * @param arquivos  Uma collection que receberá os arquivos do diretório
	 *                  informado.
	 * @throws IOException Caso o caminho para o diretório seja inválido.
	 * @exception IllegalArgumentException Se o File informado não for um diretório.
	 * @since 1.0.0
	 */
	public static void listaArquivosPorDiretorio(String caminhoDiretorio, Set<File> arquivos) throws IOException {
		if (null == caminhoDiretorio)
			throw new IOException(ERRO_CAMINHO_INVALIDO);

		File diretorio = new File(caminhoDiretorio);

		if (diretorio.isDirectory()) {
			File[] listagem = diretorio.listFiles();
			for (File arquivo : listagem) {
				if (arquivo.isDirectory() && !arquivo.getName().equals(".") && !arquivo.getName().equals("..")) {
					listaArquivosPorDiretorio(arquivo, arquivos);
				} else {
					arquivos.add(arquivo);
				}
			}
		} else {
			throw new IllegalArgumentException(ERRO_TIPO_ARQUIVO_INVALIDO);
		}
	}

	/**
	 * Método que cria um HashCode para comparação de equalidade entre arquivos
	 * 
	 * @param arquivo Utilizado como base para a criação do HashCode
	 * @return O HashCode do arquivo informado.
	 * @throws NoSuchAlgorithmException Caso não seja possível criar um HashCode
	 *                                  para o arquivo.
	 * @throws IOException              Caso não seja possível realizar a leitura do
	 *                                  arquivo.
	 * @throws IllegalArgumentException Caso o tipo do arquivo seja inválido.
	 * @since 1.0.0
	 */
	public static String criaHashParaArquivo(String caminhoArquivo) throws NoSuchAlgorithmException, IOException {
		String hash = "ERRO";

		if (null == caminhoArquivo)
			throw new IOException();

		File arquivo = new File(caminhoArquivo);

		if (arquivo.isDirectory())
			throw new IllegalArgumentException();

		try (FileInputStream input = new FileInputStream(arquivo)) {
			MessageDigest digest = MessageDigest.getInstance("SHA1");
			byte[] buffer = new byte[20480];
			int nBytes;
			digest.reset();

			while ((nBytes = input.read(buffer)) > 0) {
				digest.update(buffer, 0, nBytes);
			}

			byte[] bytes = digest.digest();
			hash = new BigInteger(bytes).toString(16);
		} catch (NoSuchAlgorithmException e) {
			throw new NoSuchAlgorithmException("Não foi possível criar um HASH SHA1 para o arquivo " + arquivo.getAbsolutePath());
		} catch (IOException e) {
			throw new IOException("Não foi possível realizar a leitura do arquivo " + arquivo.getAbsolutePath());
		} catch (IllegalArgumentException e) {
			throw new IllegalArgumentException(ERRO_TIPO_ARQUIVO_INVALIDO + " - " + arquivo.getAbsolutePath());
		}

		return hash;
	}

	/**
	 * Método que cria um HashCode para comparação de equalidade entre arquivos
	 * 
	 * @param arquivo Utilizado como base para a criação do HashCode
	 * @return O HashCode do arquivo informado.
	 * @throws NoSuchAlgorithmException Caso não seja possível criar um HashCode
	 *                                  para o arquivo.
	 * @throws IOException              Caso não seja possível realizar a leitura do
	 *                                  arquivo.
	 * @throws IllegalArgumentException Caso o tipo do arquivo seja inválido.
	 * @since 1.0.0
	 */
	public static String criaHashParaArquivo(File arquivo) throws NoSuchAlgorithmException, IOException {
		String hash = "ERRO";

		if (null == arquivo)
			throw new IOException();

		if (arquivo.isDirectory())
			throw new IllegalArgumentException();

		try (FileInputStream input = new FileInputStream(arquivo)) {
			MessageDigest digest = MessageDigest.getInstance("SHA1");
			byte[] buffer = new byte[20480];
			int nBytes;
			digest.reset();

			while ((nBytes = input.read(buffer)) > 0) {
				digest.update(buffer, 0, nBytes);
			}

			byte[] bytes = digest.digest();
			hash = new BigInteger(bytes).toString(16);
		} catch (NoSuchAlgorithmException e) {
			throw new NoSuchAlgorithmException("Não foi possível criar um HASH SHA1 para o arquivo " + arquivo.getAbsolutePath());
		} catch (IOException e) {
			throw new IOException("Não foi possível realizar a leitura do arquivo " + arquivo.getAbsolutePath());
		} catch (IllegalArgumentException e) {
			throw new IllegalArgumentException(ERRO_TIPO_ARQUIVO_INVALIDO + " - " + arquivo.getAbsolutePath());
		}

		return hash;
	}

	/**
	 * Verifica, através do HashCode informado, se os arquivos são iguais, ou seja, com o mesmo conteúdo.
	 * 
	 * @param hashPrimeiroArquivo HashCode do primeiro arquivo.
	 * @param hashSegundoArquivo HashCode do segundo arquivo.
	 * @return
	 *         <p>
	 *         TRUE - São arquivos iguais, com o mesmo conteúdo.
	 *         </p>
	 *         <p>
	 *         FALSE - Não são arquivos iguais, não tem o mesmo conteúdo.
	 *         </p>
	 * @since 1.0.0
	 */
	public static boolean ehArquivoComMesmoConteudo(String hashPrimeiroArquivo, String hashSegundoArquivo) {
		return hashPrimeiroArquivo.equals(hashSegundoArquivo);
	}
}
