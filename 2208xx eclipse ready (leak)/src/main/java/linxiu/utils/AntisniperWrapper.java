package linxiu.utils;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

import javax.net.ssl.HttpsURLConnection;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.URL;
import java.nio.charset.StandardCharsets;

public class AntisniperWrapper {

	// no limit key given to me from the owner FOR RISE! DON'T DELETE/USE ELSEWHERE!
	private final static String antisniperKey = "6bec0062-e811-45b7-9c21-d3b633ca85bc";
	private final static String antisniper = "http://api.antisniper.net";

	public static String denick(String name) {
		try {
			URL denickEndpoint = new URL(antisniper + "/denick?key=" + getAntisniperKey() + "&nick=" + name);
			InputStream stream = denickEndpoint.openStream();
			BufferedReader reader = new BufferedReader(new InputStreamReader(stream, StandardCharsets.UTF_8));

			JsonObject jsonObject = new Gson().fromJson(readAllFromHTTP(reader), JsonObject.class);

			if (jsonObject.get("player") != null) {
				return jsonObject.getAsJsonObject("player").get("ign").getAsString();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		if (MojangWrapper.isRealName(name)) {
			return name;
		}

		return null;
	}

	public static String findnick(String name) {
		try {
			URL findnickEndpoint = new URL(antisniper + "/findnick?key=" + getAntisniperKey() + "&name=" + name);
			InputStream stream = findnickEndpoint.openStream();
			BufferedReader reader = new BufferedReader(new InputStreamReader(stream, StandardCharsets.UTF_8));

			JsonObject jsonObject = new Gson().fromJson(readAllFromHTTP(reader), JsonObject.class);

			if (jsonObject.get("player") != null) {
				return jsonObject.getAsJsonObject("player").get("nick").getAsString();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		if (!MojangWrapper.isRealName(name)) {
			return name;
		}

		return null;
	}

	public static String getAntisniperKey() {
		return antisniperKey;
	}

	private static String readAllFromHTTP(Reader reader) throws Exception {
		StringBuilder stringBuilder = new StringBuilder();
		int nextChar;

		while ((nextChar = reader.read()) != -1) {
			stringBuilder.append((char) nextChar);
		}

		return stringBuilder.toString();
	}
}
