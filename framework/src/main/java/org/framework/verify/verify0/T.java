package org.framework.verify.verify0;

public class T {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			String a = "aaa";
			String b = CertUtil.SignMsg(a);
			System.err.println(b);
			System.err.println(CertUtil.VerifyMsg(b, a));

		
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
