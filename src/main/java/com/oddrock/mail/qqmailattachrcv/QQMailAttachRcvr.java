package com.oddrock.mail.qqmailattachrcv;

import com.oddrock.common.mail.ImapMailRcvr;

public class QQMailAttachRcvr {
	public static void main(String[] args) throws Exception{
		ImapMailRcvr iqmr = new ImapMailRcvr(); 
		iqmr.rcvMail(Prop.get("qqmail.imapserver"),
				Prop.get("qqmail.accout"), Prop.get("qqmail.passwd"), 
				Prop.get("qqmail.foldername"), Prop.getBool("qqmail.readwriteflag"), 
				Prop.getBool("qqmail.downloadlocalflag"), Prop.get("qqmail.localdirpath"));
	}
}
