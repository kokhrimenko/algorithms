package com.study.kokhrimenko.algoriths.bool.xor;

/**
 * 
 * @author kostic
 *
 */
public class Encription {

	public static byte[] encode(String pText, String pKey) {
		byte[] txt = pText.getBytes();
		byte[] key = pKey.getBytes();
		byte[] res = new byte[pText.length()];

		for (int i = 0; i < txt.length; i++) {
			res[i] = (byte) (txt[i] ^ key[i % key.length]);
		}

		return res;
	}

	public static String decode(byte[] pText, String pKey) {
		byte[] res = new byte[pText.length];
		byte[] key = pKey.getBytes();

		for (int i = 0; i < pText.length; i++) {
			res[i] = (byte) (pText[i] ^ key[i % key.length]);
		}

		return new String(res);
	}

	public static void main(String[] args) {
		String inputString = "Kostya just for fun string for encription/decription!!!",
				key = "2019";
		
		System.out.println(String.format("Input String: '%s', key: '%s'", inputString, key));
		
		String encodedStr = new String(encode(inputString, key));
		System.out.println(String.format("Encoded String: '%s', key: '%s'", encodedStr, key));
		
		String decodedStr = new String(encode(encodedStr, key));
		System.out.println(String.format("Decoded String: '%s', key: '%s'", decodedStr, key));
	}
}
