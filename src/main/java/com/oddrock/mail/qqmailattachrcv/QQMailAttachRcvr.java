package com.oddrock.mail.qqmailattachrcv;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Arrays;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.methods.GetMethod;

import com.oddrock.common.mail.qqmail.ImapQQMailRcvr;
import com.oddrock.common.net.HttpDownload;
import com.oddrock.common.net.UrlFileDownloader;
import com.oddrock.common.net.WebUtils;
import com.oddrock.common.net.nouse.HttpRequestor;

public class QQMailAttachRcvr {
	public static void main(String[] args) throws Exception{
		/*ImapQQMailRcvr iqmr = new ImapQQMailRcvr(); 
		iqmr.rcvMail(Prop.get("qqmail.imapserver"),
				Prop.get("qqmail.accout"), Prop.get("qqmail.passwd"), 
				Prop.get("qqmail.foldername"), Prop.getBool("qqmail.readwriteflag"), 
				Prop.getBool("qqmail.downloadlocalflag"), Prop.get("qqmail.localdirpath"));*/
		
		String qqfileUrl = "https://mail.qq.com/cgi-bin/ftnExs_download?t=exs_ftn_download&k=3039616497f5a6ce76e2577c4034571d550f575255520053480f035407195151035a4c5d5004071f0608510754020457040d54016614657145ea8eb5b28096e3c284add7aa97cde4b5f7a5d1bcf59c82839ac84a1650033213&code=e9adf4e2";
		String downloadUrl = "http://sh-ctfs.ftn.qq.com/ftn_handler/a23e55ea0c822ab371ccf41cb2098b833f9358bdd02e0903dd9475aebd7d95a07f8dc6a84b2e60540cf20a431b4e7b6ac0b7c8539e3a8d9a584b2f9c117da196/?fname=C%20%E8%AF%AD%E8%A8%80%E5%A4%A7%E5%AD%A6%E6%95%99%E7%A8%8B%EF%BC%88%E4%B8%AD%E6%96%87%E7%AC%AC%E5%85%AD%E7%89%88%EF%BC%89.pdf&k=3039616497f5a6ce76e2577c4034571d550f575255520053480f035407195151035a4c5d5004071f0608510754020457040d54016614657145ea8eb5b28096e3c284add7aa97cde4b5f7a5d1bcf59c82839ac84a1650033213&fr=00&&txf_fid=15a6568794b4d6f6f06e8053668f6a8cfbd875d6";
		String downloadUrl1 = "http://sh-ctfs.ftn.qq.com/ftn_handler/a23e55ea0c822ab371ccf41cb2098b833f9358bdd02e0903dd9475aebd7d95a07f8dc6a84b2e60540cf20a431b4e7b6ac0b7c8539e3a8d9a584b2f9c117da196/";
		String dirPath = "C:\\Users\\oddro\\Desktop\\qqmail";
		String fileName = "test.pdf";
		//UrlFileDownloader.downLoadFromUrl(downloadUrl, fileName, dirPath);
		HttpClient client = new HttpClient();
		GetMethod httpGet = new GetMethod(qqfileUrl);
		client.executeMethod(httpGet);
		httpGet.releaseConnection();
		httpGet = new GetMethod(downloadUrl1);
		client.executeMethod(httpGet); 
		System.out.println(Arrays.asList(httpGet.getResponseHeaders()));
		InputStream inputStream = httpGet.getResponseBodyAsStream();
		byte[] getData = UrlFileDownloader.readInputStream(inputStream);
		File saveDir = new File(dirPath);
		if (!saveDir.exists()) {
			saveDir.mkdir();
		}
		File file = new File(saveDir + File.separator + fileName);
		FileOutputStream fos = new FileOutputStream(file);
		fos.write(getData);
		if (fos != null) {
			fos.close();
		}
		if (inputStream != null) {
			inputStream.close();
		}
		httpGet.releaseConnection();
	}
	
	
}
