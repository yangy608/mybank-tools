package org.framework.redis.jedis;

import org.apache.log4j.Logger;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class SerializeUtil {
	/**
	 * Logger for this class
	 */
	private static final Logger logger = Logger.getLogger(SerializeUtil.class);

	public static byte[] serialize(Object object) {

		ObjectOutputStream oos = null;
		ByteArrayOutputStream baos = null;
		try {
			// 序列化
			baos = new ByteArrayOutputStream();
			oos = new ObjectOutputStream(baos);
			oos.writeObject(object);
			byte[] bytes = baos.toByteArray();
			return bytes;
			
		} catch (Exception e) {
			logger.error("serialize(Object)", e); //$NON-NLS-1$
		}
		finally{
			try {
				oos.close();
				baos.close();
			} catch (IOException e) {
				logger.error("serialize(Object)", e); //$NON-NLS-1$
			}
			
		}
		return null;
	}

	public static Object unserialize(byte[] bytes) {
		ByteArrayInputStream bais = null;
		ObjectInputStream ois = null;
		try {
			// 反序列化
			bais = new ByteArrayInputStream(bytes);
			ois = new ObjectInputStream(bais);
			Object returnObject = ois.readObject();
			return returnObject;
		} catch (Exception e) {
			logger.error("unserialize(byte[])", e); //$NON-NLS-1$
		}
		finally{
			try {
				ois.close();
				bais.close();
				logger.info("释放。。。。。");
			} catch (IOException e) {
				logger.error("unserialize(byte[])", e); //$NON-NLS-1$
			}
			
		}
		return null;
	}
}
