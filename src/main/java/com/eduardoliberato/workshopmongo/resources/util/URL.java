package com.eduardoliberato.workshopmongo.resources.util;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

//to decode the string in URL parameter 
public class URL {

	public static String decodeParam(String text) {
		try {
			return URLDecoder.decode(text, "UTF-8"); //return the string decoded
		} catch (UnsupportedEncodingException e) {
			return "";
		}
	}
}
