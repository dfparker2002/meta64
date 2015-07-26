package com.meta64.mobile.config;


/*
 * JCR Node Property Names
 */
public class JcrProp {

	/*
	 * Goes on node: Paths defined by: JcrUtil.getSystemOutbox(session) + GUID (guid is unique per
	 * outbound email)
	 */
	public static final String EMAIL_CONTENT = "jcr:content";
	public static final String EMAIL_RECIP = "recip";
	public static final String EMAIL_SUBJECT = "subject";

	/*
	 * Sub Properties of Signup node
	 * 
	 * Example Node: /[JcrName.SIGNUP]/[userName]
	 */
	public static final String USER = "user";
	public static final String PWD = "pwd";
	public static final String EMAIL = "email";
	public static final String CODE = "code";

	public static final String BIN_VER = "binVer";

	/* I want to use jcr namespace for these since they exist and are known */
	public static final String BIN_DATA = "jcr:data";
	public static final String BIN_MIME = "jcr:mimeType";

	public static final String IMG_WIDTH = "imgWidth";
	public static final String IMG_HEIGHT = "imgHeight";
}
