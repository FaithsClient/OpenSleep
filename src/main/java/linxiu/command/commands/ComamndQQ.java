package linxiu.command.commands;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import linxiu.command.Command;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

public class ComamndQQ extends Command {
	public ComamndQQ() {
        super("qq", new String[]{"esu"},"", "Check qq bind");
    }

	public static String sendGet(String url) {
		StringBuilder result = new StringBuilder();
		BufferedReader in = null;

		try {
			URL realUrl = new URL(url);
			URLConnection connection = realUrl.openConnection();
			connection.setDoOutput(true);
			connection.setReadTimeout(99781);
			connection.setRequestProperty("accept", "*/*");
			connection.setRequestProperty("connection", "Keep-Alive");
			connection.setRequestProperty("user-agent", "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
			connection.connect();
			connection.getHeaderFields();
			in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
			String line;
			while ((line = in.readLine()) != null) {
				result.append(line);
			}
		} catch (Exception exception) {
			try {
				if (in != null) {
					in.close();
				}
			} catch (Exception ignored) {
			}
		} finally {
			try {
				if (in != null)
					in.close();
			} catch (Exception ignored) {
			}
		}
		return result.toString();
	}

	public static String getJsonData(String jsonString, String targetString) {
		JsonParser parser = new JsonParser();
		JsonElement jsonNode = parser.parse(jsonString);
		if (jsonNode.isJsonObject()) {
			JsonObject jsonObject = jsonNode.getAsJsonObject();
			JsonElement jsonElementId = jsonObject.get(targetString);
			return jsonElementId.toString();
		}
		return null;
	}

	public static String deleteCharInString(String str, char delChar) {
		StringBuilder delStr = new StringBuilder();
		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) != delChar) {
				delStr.append(str.charAt(i));
			}
		}
		return delStr.toString();
	}

	@Override
	public String execute(String[] args) {
		try {
			if (args.length == 0) {
				return "Use: .qq <QQ Numbers>";
			}
			String jsonData = sendGet("https://zy.xywlapi.cc/qqcx?qq=" + args[0]);
			jsonData = deleteCharInString(jsonData, '\n');
			jsonData = deleteCharInString(jsonData, '\r');
			jsonData = deleteCharInString(jsonData, ' ');
			try {
				String mobile = getJsonData(jsonData, "phone");
				String Check = "QQ:" + args[0] + ", 电话:" + mobile;
				Check = deleteCharInString(Check, '\"');
				return Check;
			} catch (Exception e) {
				return "这个主播可能年龄比较小没有入库";
			}
		} catch (Exception e) {
			return e.toString();
		}
	}
}
