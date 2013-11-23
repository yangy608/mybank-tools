package org.framework.jNative;

import org.xvolks.jnative.JNative;
import org.xvolks.jnative.Type;
import org.xvolks.jnative.pointers.Pointer;
import org.xvolks.jnative.pointers.memory.MemoryBlockFactory;

public class JNativeGetVal {

	static JNativeGetVal Something = null;
	static Pointer pointer;

	public static String encryptDll(String key,String str) throws Exception {
//		System.setProperty("jnative.loadNative", "/home/gaojh/so/libJNativeCpp.so");
//		System.loadLibrary("rr1036uad");//需要去掉lib和.so
		
		JNative jnative = new JNative("RR1036UDL", "Des");
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
		return JNativeHex.Bytes2HexString(bytes).substring(0, 32);

	}
	
	public static String decryptDll(String key,byte[] str) throws Exception {
//		System.setProperty("jnative.loadNative", "/home/gaojh/so/libJNativeCpp.so");
//		System.loadLibrary("/home/gaojh/so/RR1036UDL.dll");

		JNative jnative = new JNative("RR1036UDL", "Des");
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
		byte[] bytes = pszWinIoDriverPath.getMemory();
		return new String(bytes).trim();

	}

	public static void main(String[] args) {

		try {
			System.err.println(JNativeGetVal.encryptDll("19730510EEEEFFFF","1698881800000001"));
			System.err.println(JNativeGetVal.decryptDll("19730510EEEEFFFF",JNativeHex.HexString2Bytes("B87FEB359E575F0118C309B63367A1EE")));
		} catch (Exception e) {
			e.printStackTrace();
		}

	}



}
