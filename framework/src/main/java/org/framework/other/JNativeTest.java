package org.framework.other;

import org.xvolks.jnative.JNative;
import org.xvolks.jnative.Type;
import org.xvolks.jnative.pointers.Pointer;
import org.xvolks.jnative.pointers.memory.MemoryBlockFactory;

public class JNativeTest {

	static JNativeTest Something = null;
	static Pointer pointer;

	public static Integer encryptDll(String key,String str) throws Exception {
		System.setProperty("jnative.loadNative", "/home/gaojh/so/libJNativeCpp.so");
//		System.loadLibrary("/home/gaojh/so/librr1036uad");
		JNative jnative = new JNative("/home/gaojh/so/librr1036uad", "Des");
		Pointer pszWinIoDriverPath = new Pointer(MemoryBlockFactory.createMemoryBlock(100));
		jnative.setParameter(0, Type.STRING, key);
		jnative.setParameter(1, Type.INT, String.valueOf(key.length()));
		jnative.setParameter(2, Type.STRING, str);
		jnative.setParameter(3, Type.INT, String.valueOf(str.length()));
		jnative.setParameter(4, pszWinIoDriverPath);
		jnative.setParameter(5, Type.INT, "0");
		jnative.setParameter(6, Type.INT, "0");
		jnative.invoke();
		byte[] bytes = pszWinIoDriverPath.getMemory();
		System.out.println(Hex.Bytes2HexString(bytes));
		return null;

	}
	
	public static Integer decryptDll(String key,byte[] str) throws Exception {
		System.setProperty("jnative.loadNative", "/home/gaojh/so/libJNativeCpp.so");
//		System.loadLibrary("/home/gaojh/so/librr1036uad");
		Integer ret = new Integer(0);
		JNative jnative = new JNative("/home/gaojh/so/librr1036uad", "Des");
		jnative.setRetVal(Type.INT);
		Pointer pszWinIoDriverPath = new Pointer(MemoryBlockFactory.createMemoryBlock(100));

		jnative.setParameter(0, Type.STRING, key);
		jnative.setParameter(1, Type.INT, String.valueOf(key.length()));
		jnative.setParameter(2, Type.STRING, str);
		jnative.setParameter(3, Type.INT, "16");
		jnative.setParameter(4, pszWinIoDriverPath);
		jnative.setParameter(5, Type.INT, "1");
		jnative.setParameter(6, Type.INT, "1");
		jnative.invoke();
		ret = Integer.parseInt(jnative.getRetVal());
		byte[] bytes = pszWinIoDriverPath.getMemory();

		System.out.println(new String(bytes,"gbk"));

		return ret;

	}

	public static void main(String[] args) {
		JNativeTest uc = new JNativeTest();
		try {
			uc.encryptDll("19730510EEEEFFFF","1698881800000001");
			uc.decryptDll("19730510EEEEFFFF",Hex.HexString2Bytes("B87FEB359E575F0118C309B63367A1EE"));
		} catch (Exception e) {
			e.printStackTrace();
		}

	}



}
