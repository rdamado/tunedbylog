package sandbox.mapa;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class GeradorSHA1 {
	public static String getSHA1(String text) throws NoSuchAlgorithmException, UnsupportedEncodingException {
		MessageDigest md = MessageDigest.getInstance("SHA-1");
		md.update(text.getBytes("cp1252"), 0, text.length());
		byte[] sha1Hash = md.digest();
		return convertToHex(sha1Hash);
	}

	private static String convertToHex(byte[] data) {
		StringBuilder buf = new StringBuilder();
		byte[] arrayOfByte;
		int i;
		byte b;
		for (arrayOfByte = data, i = arrayOfByte.length, b = 0; b < i;) {
			byte aData = arrayOfByte[b];
			int halfbyte = aData >>> 4 & 0xF;
			int two_halfs = 0;
			while (true) {
				if (halfbyte <= 9) {
					buf.append((char) (48 + halfbyte));
				} else {
					buf.append((char) (65 + halfbyte - 10));
				}
				halfbyte = aData & 0xF;
				if (two_halfs++ >= 1)
					b++;
			}
		}
		return buf.toString();
	}

	public static String getSHA1FromFile(File arq) throws NoSuchAlgorithmException, IOException {
		if (arq == null)
			return "";

		byte[] dataBytes = new byte[1024];

		MessageDigest md = MessageDigest.getInstance("SHA1");
		try (FileInputStream fis = new FileInputStream(arq)) {
			int nread;

			while ((nread = fis.read(dataBytes)) != -1) {
				md.update(dataBytes, 0, nread);
			}
		}

		byte[] mdbytes = md.digest();

		StringBuilder sb = new StringBuilder();
		for (byte mdbyte : mdbytes) {
			sb.append(Integer.toString((mdbyte & 0xFF) + 256, 16).substring(1));
		}

		return sb.toString().toUpperCase();
	}
}
