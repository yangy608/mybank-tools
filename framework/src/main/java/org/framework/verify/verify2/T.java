package org.framework.verify.verify2;

public class T {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			String a = "妙购妙购妙购妙购妙购妙购123%%%%%1";
			String b = VerifyUtil.Sign(a);
			System.err.println(b);
			
			String c = "0CCD1841AFB194676E6E13CDCD4235B4";
			System.err.println(VerifyUtil.VerifySign(a, c));

			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
		}
	}

}
