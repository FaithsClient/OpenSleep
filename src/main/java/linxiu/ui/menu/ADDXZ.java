package linxiu.ui.menu;

import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.Socket;
import java.security.MessageDigest;
import java.util.Objects;
import java.util.Random;

import net.minecraft.util.EnumChatFormatting;
import oh.yalan.NativeClass;

@NativeClass
public class ADDXZ {
	public static final String Serverip = "src.sleepsense.cc";// 服务器IP
	public static final int ServerPort = 8016;// 服务器端口
	public static final char END_CHAR = '#';
	public static boolean logincheck = false;
	public static boolean registercheck = false;
	static String Key = Decrypt("74E320196D7716481A7D186A7246375F4831344C35284F3D4329",
			"SleepClientNC8ACEYAPCO982NMTHCA");
	static String Key_md5 = Decrypt("F2FF591D131273486E6F1B697D2B464645583A475A22666A127851", "SleepClient9MAPRMDLR");
	static String Key_check = "SLEEP@DANCIA91PC";
	static String Key_Register = Decrypt("706F303A3C2423302D5D3643353548263F2247413B422F4E3831534E",
			"DAKCANWU101P3SLEEP");

	public ADDXZ() {
		logincheck = false;
		registercheck = false;
	}

    public static String Encrypt(String Data,String Password) { //加密数据
        Random rand = new Random();
        int ra=rand.nextInt();
        int rb=rand.nextInt();
        String mod= Integer.toHexString( ra^rb).toUpperCase();
        mod=mod+"00000";
        mod=mod.substring(0, 4);
        int aLen=Data.getBytes().length;
        int bLen=Password.getBytes().length;
        int clen=mod.getBytes().length;
        StringBuilder result= new StringBuilder();
        String temp;
        for(int i=0,j=0,k=0;i<aLen;i++){
            int a=Data.getBytes()[i];
            int b=Password.codePointAt(j);
            int c=mod.codePointAt(k);
            temp = Integer.toHexString(a^b^c).toUpperCase();
            temp="00000"+temp;
            temp=temp.substring(temp.length()-2);
            result.append(temp);
            j+=1;
            k+=1;
            if(j+1==bLen)j=0;
            if(k+1==clen)k=0;
        }
        return mod+result;
    }
    public static String Decrypt(String Data,String Password) { // 解密数据
        if(Data.length()<4)return Data;
        String resultString;
        String mod;
        mod=Data.substring(0, 4);
        Data=Data.substring(4);
        int aLen=Data.length();
        int bLen=Password.length();
        int cLen=mod.length();
        int j=0;
        int k=0;
        byte[] data=new byte[aLen/2];
        for(int i=0;i<aLen;i+=2){
            data[i/2]=(byte) (HexToFirstInt( Data.substring(i, i+2))^Password.codePointAt(j)^mod.codePointAt(k));
            j = j + 1;
            k = k + 1;
            if (j == bLen-1)j = 0;
            if (k == cLen-1)k = 0;
        }
        resultString = new String(data);
        return resultString;
    }

	public static Person Client_Login(String name, String passwd, String hwid, String ip) throws Exception { // 登录
		// 验证服务器
		String time = Encrypt(String.valueOf(System.currentTimeMillis()), Key);
		String md5_1 = getMd5(time + Key);
		EncrypDES des2 = new EncrypDES(Key_check);
		String Data = des2.encrypt(time + md5_1);
		String md5_2 = getMd5(time + Data);
		String data_2 = Encrypt(time + "/" + md5_2, Key_md5) + END_CHAR;
		StringBuilder receiveMsg = new StringBuilder();
		// 开启一个链接，需要指定地址和端口
		try (Socket client = new Socket(Serverip, ServerPort)) {
			// 向输出流中写入数据，传向服务端
			OutputStream out = client.getOutputStream();
			out.write(data_2.getBytes());
			// 从输入流中解析数据，输入流来自服务端的响应
			InputStream in = client.getInputStream();
			for (int c = in.read(); c != END_CHAR; c = in.read()) {
				if (c == -1)
					break;
				receiveMsg.append((char) c);
			}
			Data = des2.decrypt(String.valueOf(receiveMsg));
			boolean Check_server = Data.contains("sleep");
			if (!Check_server) {
				client.close();
				return new Person(false, "Authentication failed 0");
			}
			;
			String[] data = Data.split("sleep");
			if (Objects.equals(Decrypt(data[0], Key), "false")) {
				if (Decrypt(data[1], Key).equals("MD5 failed")) {
					client.close();
					return new Person(false, "Authentication failed 1");
				}
				;
				if (Decrypt(data[1], Key).equals("time out")) {
					client.close();
					return new Person(false, "login timeout");
				}
				;
				client.close();
				return new Person(false, "unknown error");
			}
			;
			String Data_md5 = des2.decrypt(Decrypt(data[0], Key));
			Check_server = Data_md5.contains("/");
			if (!Check_server) {
				client.close();
				return new Person(false, "Authentication failed 2");
			}
			String[] Data_md5s = Data_md5.split("/");
			if (!Objects.equals(Data_md5s[0], md5_2) && !Objects.equals(Data_md5s[1], md5_1)) {
				client.close();
				return new Person(false, "Authentication failed 3");
			}
			;
			long Check_client_time = System.currentTimeMillis() - Long.parseLong(Decrypt(data[2], Key));
			if (Check_client_time > 1000000) {
				client.close();
				return new Person(false, "login timeout");
			}
			;
			if (!Objects.equals(data[1], getMd5(des2.decrypt(Decrypt(data[0], Key)) + Key_md5))) {
				client.close();
				return new Person(false, "Authentication failed 4");
			}
			;

			// 开始登录
			String md5_data = passwd + name + hwid + Key_md5 + ip;
			String md5 = getMd5(md5_data);
			name = Encrypt(name, Key);
			passwd = Encrypt(passwd, Key);
			hwid = Encrypt(hwid, Key);
			ip = Encrypt(ip, Key);
			time = Encrypt(String.valueOf(System.currentTimeMillis()), Key);
			String msg = Encrypt(name + "/" + passwd + "/" + hwid + "/" + ip + "/" + md5 + "/" + time, Key_md5)
					+ END_CHAR;
			out.write(msg.getBytes());

			receiveMsg = new StringBuilder();
			in = client.getInputStream();
			for (int c = in.read(); c != END_CHAR; c = in.read()) {
				if (c == -1)
					break;
				receiveMsg.append((char) c);
			}
		} catch (Exception e) {
			return new Person(false, e.toString());
		}
		String[] data = des2.decrypt(String.valueOf(receiveMsg)).split("/");
		if (!getMd5(data[0] + Key_md5).equals(data[1])) {// md5校验
			return new Person(false, "md5error");
		}
		data = Decrypt(data[0], Key_md5).split("/");
		String check = Decrypt(data[0], Key);
		String code = Decrypt(data[1], Key);
		long times = System.currentTimeMillis() - Long.parseLong(Decrypt(data[2], Key));
		if (times > 1000000) { // 登录超时检测
			return new Person(false, code);
		}
		if (!check.equals("true")) {// 登录状态检测
			return new Person(false, code);
		}
		;
		if (check.equals("true")) {// 登录状态检测
			logincheck = true;
		}
		;
		return new Person(true, code);// 登录成功

	}

	public static Person Client_Register(String name, String passwd, String activation_key, String hwid)
			throws Exception {// 注册
		// 验证服务器
		String time = Encrypt(String.valueOf(System.currentTimeMillis()), Key);
		String md5_1 = getMd5(time + Key);
		EncrypDES des2 = new EncrypDES(Key_check);
		String Data = des2.encrypt(time + md5_1);
		String md5_2 = getMd5(time + Data);
		String data_2 = Encrypt(time + "/" + md5_2, Key_md5) + END_CHAR;
		StringBuilder receiveMsg = new StringBuilder();
		// 开启一个链接，需要指定地址和端口
		try (Socket client = new Socket(Serverip, ServerPort)) {
			// 向输出流中写入数据，传向服务端
			OutputStream out = client.getOutputStream();
			out.write(data_2.getBytes());
			// 从输入流中解析数据，输入流来自服务端的响应
			InputStream in = client.getInputStream();
			for (int c = in.read(); c != END_CHAR; c = in.read()) {
				if (c == -1)
					break;
				receiveMsg.append((char) c);
			}
			Data = des2.decrypt(String.valueOf(receiveMsg));
			boolean Check_server = Data.contains("sleep");
			if (!Check_server) {
				client.close();
				GuiRegister.state = EnumChatFormatting.RED + (EnumChatFormatting.BOLD + "Authentication failed 0");
				return new Person(false, "Authentication failed 0");
			}
			;
			String[] data = Data.split("sleep");
			if (Objects.equals(Decrypt(data[0], Key), "false")) {
				if (Decrypt(data[1], Key).equals("MD5 failed")) {
					client.close();
					GuiRegister.state = EnumChatFormatting.RED + (EnumChatFormatting.BOLD + "Authentication failed 1");
					return new Person(false, "Authentication failed 1");
				}
				;
				if (Decrypt(data[1], Key).equals("time out")) {
					client.close();
					GuiRegister.state = EnumChatFormatting.RED + (EnumChatFormatting.BOLD + "time out");
					return new Person(false, "Register timeout");
				}
				;
				client.close();
				GuiRegister.state = EnumChatFormatting.RED + (EnumChatFormatting.BOLD + "unknown error");
				return new Person(false, "unknown error");
			}
			;
			String Data_md5 = des2.decrypt(Decrypt(data[0], Key));
			Check_server = Data_md5.contains("/");
			if (!Check_server) {
				client.close();
				GuiRegister.state = EnumChatFormatting.RED + (EnumChatFormatting.BOLD + "Authentication failed 2");
				return new Person(false, "Authentication failed 2");
			}
			;
			String[] Data_md5s = Data_md5.split("/");
			if (!Objects.equals(Data_md5s[0], md5_2) && !Objects.equals(Data_md5s[1], md5_1)) {
				client.close();
				GuiRegister.state = EnumChatFormatting.RED + (EnumChatFormatting.BOLD + "Authentication failed 3");
				return new Person(false, "Authentication failed 3");
			}
			;
			long Check_client_time = System.currentTimeMillis() - Long.parseLong(Decrypt(data[2], Key));
			if (Check_client_time > 1000000) {
				client.close();
				GuiRegister.state = EnumChatFormatting.RED + (EnumChatFormatting.BOLD + "Register timeout");
				return new Person(false, "Register timeout");
			}
			;
			if (!Objects.equals(data[1], getMd5(des2.decrypt(Decrypt(data[0], Key)) + Key_md5))) {
				client.close();
				GuiRegister.state = EnumChatFormatting.RED + (EnumChatFormatting.BOLD + "Authentication failed 4");
				return new Person(false, "Authentication failed 4");
			}
			;

			// 进行注册
			name = Encrypt(name, Key_md5);
			passwd = Encrypt(passwd, Key_md5);
			activation_key = Encrypt(activation_key, Key_md5);
			hwid = Encrypt(hwid, Key);
			EncrypDES des = new EncrypDES(Key_Register);
			String key_1 = des.encrypt(passwd + "/" + name + "/" + activation_key + "/" + hwid);
			String key_1_md5 = getMd5(key_1);
			String key_2 = Encrypt(key_1, key_1_md5);
			time = String.valueOf(System.currentTimeMillis());
			String datas = des.encrypt(key_2 + "/" + Encrypt(time + "/" + key_1_md5, Key_Register)) + END_CHAR;
			datas = "Sleep" + datas;
			out.write(datas.getBytes());
			receiveMsg = new StringBuilder();
			in = client.getInputStream();
			for (int c = in.read(); c != END_CHAR; c = in.read()) {
				if (c == -1)
					break;
				receiveMsg.append((char) c);
			}
		} catch (Exception e) {
			return new Person(false, e.toString());
		}
		EncrypDES des = new EncrypDES(Key_Register);
		String[] data = des.decrypt(String.valueOf(receiveMsg)).split("/");
		if (!getMd5(data[0] + Key_Register).equals(data[1])) {
			GuiRegister.state = EnumChatFormatting.RED + (EnumChatFormatting.BOLD + "Authentication failed 5");
			return new Person(false, "Authentication failed 5");
		}
		;
		if (Decrypt(data[0], Key_Register).equals("add success")) {
			registercheck = true;
			GuiRegister.state = EnumChatFormatting.GREEN + (EnumChatFormatting.BOLD + "Registration succeeded.");
			return new Person(true, "add success");
		}
		;
		if (Decrypt(data[0], Key_Register).equals("This username is already in use")) {
			registercheck = false;
			GuiRegister.state = EnumChatFormatting.RED + (EnumChatFormatting.BOLD + "This username is already in use");
			return new Person(false, "This username is already in use");
		}
		return new Person(false, Decrypt(data[0], Key_Register));
	};

	private static MessageDigest md5;
	static {
		try {
			md5 = MessageDigest.getInstance("MD5");
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	public static String getMd5(String string) {
		try {
			byte[] bs = md5.digest(string.getBytes("UTF-8"));
			StringBuilder sb = new StringBuilder(40);
			for (byte x : bs) {
				if ((x & 0xff) >> 4 == 0) {
					sb.append("0").append(Integer.toHexString(x & 0xff));
				} else {
					sb.append(Integer.toHexString(x & 0xff));
				}
			}
			return sb.toString();
		} catch (UnsupportedEncodingException e) {
			throw new RuntimeException(e);
		}
	}

	private static int HexToFirstInt(String HexStr) {
		if (HexStr.length() == 0) {
			HexStr = "0";
		}
		if (HexStr.length() % 2 == 1) {
			HexStr = "0" + HexStr;
		}
		int tempa;
		int tempb;
		byte[] bytes = HexStr.getBytes();
		int i = 0;
		if (bytes[i] < 58) {
			tempa = bytes[i] - 48;
		} else {
			tempa = bytes[i] - 55;
		}
		if (bytes[i + 1] < 58) {
			tempb = bytes[i + 1] - 48;
		} else {
			tempb = bytes[i + 1] - 55;
		}
		return ((tempa * 16) + tempb);
	}
}
