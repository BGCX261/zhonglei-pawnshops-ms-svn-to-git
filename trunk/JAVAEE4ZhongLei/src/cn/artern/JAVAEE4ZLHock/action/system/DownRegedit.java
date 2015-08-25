package cn.artern.JAVAEE4ZLHock.action.system;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.Action;

public class DownRegedit implements Action {

	public InputStream getTargetFile() throws Exception {
		HttpServletRequest request = ServletActionContext.getRequest();
		String iptemp = request.getServerName();
		int port = request.getServerPort();
		String downString = "Windows Registry Editor Version 5.00\n"
				+ "[HKEY_CURRENT_USER\\Software\\Microsoft\\Internet Explorer\\New Windows\\Allow]\n"
				+ "\""
				+ iptemp
				+ "\"=hex:\n"
				+ "[HKEY_CURRENT_USER\\Software\\Microsoft\\Windows\\CurrentVersion\\Internet Settings\\ZoneMap\\Ranges\\Range0]\n"
				+ "\"http\"=dword:00000002\n"
				+ "\":Range\"=\""
				+ iptemp
				+ "\"\n"
				+ "[HKEY_CURRENT_USER\\Software\\Microsoft\\Internet Explorer\\pageSetup]\n"
				+ "\"footer\"=\"\"\n"
				+ "\"header\"=\"\"\n"
				+ "\"margin_bottom\"=\"0.19685\"\n"
				+ "\"margin_left\"=\"0.19685\"\n"
				+ "\"margin_right\"=\"0.19685\"\n"
				+ "\"margin_top\"=\"0.19685\"\n"
				+ "[HKEY_CURRENT_USER\\Software\\Microsoft\\Internet Explorer\\Main]\n"
				+ "\"Print_Background\"=\"yes\"\n"
				+ "[HKEY_CURRENT_USER\\Software\\Microsoft\\Internet Explorer\\MenuExt\\众磊典当系统]\n"
				+ "@=\"http://"
				+ iptemp
				+ ":"
				+ port
				+ "\"\n"
				+ "\"Contexts\"=dword:00000001\n";
		return new ByteArrayInputStream(downString.getBytes());
	}

	public String execute() throws Exception {
		// TODO Auto-generated method stub
		return SUCCESS;
	}

	public String getDownloadFileName() {

		String downFileName = "免疫升级文件.reg";

		try {

			downFileName = new String(downFileName.getBytes(), "ISO8859-1");

		} catch (UnsupportedEncodingException e) {

			e.printStackTrace();

		}

		return downFileName;

	}

}
