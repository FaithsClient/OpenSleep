package linxiu.ui.menu;

import javax.crypto.*;
import javax.crypto.spec.SecretKeySpec;
import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Base64;

public class EncodeUtil {
	private static final String KEY_ALGORITHM = "AES";
	private static final String DEFAULT_CIPHER_ALGORITHM = "AES/ECB/PKCS5Padding";

	public static String MD5encode(String source) throws Exception {
		MessageDigest digest = MessageDigest.getInstance("MD5");
		byte[] bytes = source.getBytes();
		byte[] targetBytes = digest.digest(bytes);
		char[] characters = new char[] { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E',
				'F' };
		StringBuilder builder = new StringBuilder();
		for (byte b : targetBytes) {
			int high = (b >> 4) & 15;
			int low = b & 15;
			char highChar = characters[high];
			char lowChar = characters[low];

			builder.append(highChar).append(lowChar);
		}

		return builder.toString();
	}

	public static String SHA256encode(String source) throws Exception {
		MessageDigest digest = MessageDigest.getInstance("SHA-384");
		StringBuilder builder = new StringBuilder();
		digest.update(source.getBytes("UTF-8"));
		return byte2Hex(digest.digest());
	}

	public static String byte2Hex(byte[] bytes) {
		StringBuffer stringBuffer = new StringBuffer();
		String temp = null;
		for (int i = 0; i < bytes.length; i++) {
			temp = Integer.toHexString(bytes[i] & 0xFF);
			if (temp.length() == 1) {
				stringBuffer.append("0");
			}
			stringBuffer.append(temp);
		}
		return stringBuffer.toString();
	}

	/**
	 * AES�����ַ���
	 *
	 * @param content ��Ҫ�����ܵ��ַ���
	 * @param key     ������Ҫ������
	 * @return ����
	 */
	public static String AESencrypt(String content, String key) {
		try {
			Cipher cipher = Cipher.getInstance(DEFAULT_CIPHER_ALGORITHM);// ����������

			byte[] byteContent = content.getBytes("UTF-8");

			cipher.init(Cipher.ENCRYPT_MODE, getSecretKey(key));// ��ʼ��Ϊ����ģʽ��������

			byte[] result = cipher.doFinal(byteContent);// ����

			return Base64.getEncoder().encodeToString(result);// ͨ��Base64ת�뷵��

		} catch (Exception ignored) {

		}

		return null;
	}

	/**
	 * ���ɼ�����Կ
	 *
	 * @return
	 */
	private static SecretKeySpec getSecretKey(final String key) {
		// ��������ָ���㷨��Կ�������� KeyGenerator ����
		KeyGenerator kg = null;

		try {
			kg = KeyGenerator.getInstance(KEY_ALGORITHM);

			// AES Ҫ����Կ����Ϊ 128
			kg.init(128, new SecureRandom(key.getBytes()));

			// ����һ����Կ
			SecretKey secretKey = kg.generateKey();

			return new SecretKeySpec(secretKey.getEncoded(), KEY_ALGORITHM);// ת��ΪAESר����Կ
		} catch (NoSuchAlgorithmException ignored) {

		}

		return null;
	}

	/**
	 * ����AES���ܹ����ַ���
	 *
	 * @param content AES���ܹ���������
	 * @param key     ����ʱ������
	 * @return ����
	 */
	public static String AESdecrypt(String content, String key) {
		try {
			// ʵ����
			Cipher cipher = Cipher.getInstance(DEFAULT_CIPHER_ALGORITHM);

			// ʹ����Կ��ʼ��������Ϊ����ģʽ
			cipher.init(Cipher.DECRYPT_MODE, getSecretKey(key));

			// ִ�в���
			byte[] result = cipher.doFinal(Base64.getDecoder().decode(content));

			return new String(result, "UTF-8");
		} catch (Exception ignored) {

		}

		return null;
	}
}
