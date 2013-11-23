package org.framework.ftp;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import sun.net.TelnetInputStream;
import sun.net.TelnetOutputStream;
import sun.net.ftp.FtpClient;

/**
 * FTP工具类
 * 
 * @author yangy
 * @date 2012-06-08
 */

public class FtpUtil extends FtpClient{

	private Logger logger = Logger.getLogger(FtpUtil.class);
	private FtpClient ftpClient;
	private String server;
	private int port;
	private String userName;
	private String userPassword;

	public FtpUtil(String server, int port, String userName, String userPassword) {
		this.server = server;
		this.port = port;
		this.userName = userName;
		this.userPassword = userPassword;
	}

	/**
	 * 临时文件读取大小（此参数决定ftp速度）
	 */
	private final int TEMP_SIZE = 204800;

	/**
	 * 链接到服务器
	 * 
	 * @return
	 */
	public boolean open() {
		if (ftpClient != null && ftpClient.serverIsOpen())
			return true;
		try {
			ftpClient = new FtpClient();
			ftpClient.openServer(server, port);
			ftpClient.login(userName, userPassword);
			ftpClient.binary();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			ftpClient = null;
			return false;
		}
	}

	public void cd(String dir) {
		try {
			ftpClient.cd(dir);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 上传文件到FTP服务器
	 * 
	 * @param localPathAndFileName
	 *            本地文件目录和文件名
	 * @param ftpFileName
	 *            上传后的文件名
	 * @param ftpDirectory
	 *            FTP目录如:/path1/pathb2/,如果目录不存在回自动创建目录
	 * @throws Exception
	 */
	public boolean upload(String localFilePath, String ftpFileName, String ftpDirectory) {
		if (!open())
			return false;
		FileInputStream is = null;
		TelnetOutputStream os = null;
		try {
			char ch = ' ';
			if (ftpDirectory.length() > 0)
				ch = ftpDirectory.charAt(ftpDirectory.length() - 1);
			for (; ch == '/' || ch == '\\'; ch = ftpDirectory.charAt(ftpDirectory.length() - 1))
				ftpDirectory = ftpDirectory.substring(0, ftpDirectory.length() - 1);

			int slashIndex = ftpDirectory.indexOf(47);
			int backslashIndex = ftpDirectory.indexOf(92);
			int index = slashIndex;
			String dirall = ftpDirectory;
			if (backslashIndex != -1 && (index == -1 || index > backslashIndex))
				index = backslashIndex;
			String directory = "";
			while (index != -1) {
				if (index > 0) {
					String dir = dirall.substring(0, index);
					directory = directory + "/" + dir;
					ftpClient.sendServer("XMKD " + directory + "\r\n");
					ftpClient.readServerResponse();
				}
				dirall = dirall.substring(index + 1);
				slashIndex = dirall.indexOf(47);
				backslashIndex = dirall.indexOf(92);
				index = slashIndex;
				if (backslashIndex != -1 && (index == -1 || index > backslashIndex))
					index = backslashIndex;
			}
			ftpClient.sendServer("XMKD " + ftpDirectory + "\r\n");
			ftpClient.readServerResponse();

			os = ftpClient.put(ftpDirectory + "/" + ftpFileName);
			File file_in = new File(localFilePath);
			is = new FileInputStream(file_in);
			byte bytes[] = new byte[TEMP_SIZE];
			int i;
			while ((i = is.read(bytes)) != -1) {
				os.write(bytes, 0, i);
			}
			os.flush();
			logger.debug("upload file [" + localFilePath + "] to [" + ftpDirectory + "] successfully.");
			return true;
		} catch (Exception e) {
			logger.error("upload file [" + localFilePath + "] to [" + ftpDirectory + "] error:" + e.toString());
			return false;
		} finally {
			try {
				is.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			try {
				os.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	/**
	 * FTP上传
	 * 
	 * @param localFilePath：本地文件路径
	 * @param remoteFilePath：目标地址
	 * @throws Exception
	 */
	public boolean upload(String localFilePath,String remoteFilePath) {
		if (!open())
			return false;
		FileInputStream is = null;
		TelnetOutputStream os = null;
		try {
			is = new FileInputStream(new File(localFilePath));
			os = ftpClient.put(remoteFilePath);
			byte[] bytes = new byte[TEMP_SIZE];
			int ch;
			while ((ch = is.read(bytes)) != -1) {
				os.write(bytes, 0, ch);
			}
			os.flush();
			logger.debug("upload file [" + localFilePath + "] to [" + remoteFilePath + "] successfully.");
			return true;
		} catch (Exception e) {
			logger.error("upload file [" + localFilePath + "] to [" + remoteFilePath + "] error:" + e.toString());
			return false;
		} finally {
			try {
				os.close();
			} catch (Exception e) {
			}
			try {
				is.close();
			} catch (Exception e) {
			}
		}
	}

	/**
	 * 从FTP服务器上下载文件并返回下载文件长度
	 * 
	 * @param ftpDirectoryAndFileName
	 * @param localDirectoryAndFileName
	 * @return
	 * @throws Exception
	 */
	public long download(String localFilePath,String remoteFilePath) throws Exception {
		long result = 0;
		if (!open())
			return result;
		TelnetInputStream is = null;
		FileOutputStream os = null;
		try {
			is = ftpClient.get(remoteFilePath);
			java.io.File outfile = new java.io.File(localFilePath);
			os = new FileOutputStream(outfile);
			byte[] bytes = new byte[TEMP_SIZE];
			int c;
			while ((c = is.read(bytes)) != -1) {
				os.write(bytes, 0, c);
				result = result + c;
			}
		} catch (Exception e) {
			logger.error("download file [" + localFilePath + "] from [" + remoteFilePath + "] error:" + e.toString());
			throw e;
		} finally {
			try {
				is.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			try {
				os.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		logger.debug("download file [" + localFilePath + "] from [" + remoteFilePath + "] successfully.");
		return result;
	}

	/**
	 * FTP下载
	 * 
	 * @param localFilePath：本地文件路径
	 * @param remoteFilePath：目标地址
	 * @throws Exception
	 */
	public void download2(String localFilePath, String remoteFilePath) throws Exception {
		TelnetInputStream is = null;
		FileOutputStream os = null;
		try {
			is = ftpClient.get(remoteFilePath);
			os = new FileOutputStream(new File(localFilePath));
			byte[] bytes = new byte[TEMP_SIZE];
			int ch;
			while ((ch = is.read(bytes)) != -1) {
				os.write(bytes, 0, ch);
			}
			os.flush();
			logger.debug("download file [" + localFilePath + "] from [" + remoteFilePath + "] successfully.");
		}catch (Exception e) {
			logger.error("download file [" + localFilePath + "] from [" + remoteFilePath + "] error:" + e.toString());
			throw e;
		} finally {
			try {
				os.close();
			} catch (Exception e) {
			}
			try {
				is.close();
			} catch (Exception e) {
			}
		}
	}
	
	/**
	 * 返回FTP目录下的文件列表
	 * 
	 * @param ftpDirectory
	 * @return
	 */
	@SuppressWarnings("deprecation")
	public List<String> getFileNameList(String ftpDirectory) {
		List<String> list = new ArrayList<String>();
		if (!open())
			return list;
		try {
			BufferedReader dis = new BufferedReader(new InputStreamReader(ftpClient.nameList(ftpDirectory)));
			String filename = "";
			while ((filename = dis.readLine()) != null) {
				list.add(filename);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	/**
	 * 删除FTP上的文件
	 * 
	 * @param ftpDirAndFileName
	 */
	public boolean deleteFile(String ftpDirAndFileName) {
		if (!open())
			return false;
		ftpClient.sendServer("DELE " + ftpDirAndFileName + "\r\n");
		return true;
	}

	/**
	 * 删除FTP目录
	 * 
	 * @param ftpDirectory
	 */
	public boolean deleteDirectory(String ftpDirectory) {
		if (!open())
			return false;
		ftpClient.sendServer("XRMD " + ftpDirectory + "\r\n");
		return true;
	}

	/**
	 * 关闭链接
	 */
	public void close() {
		try {
			if (ftpClient != null && ftpClient.serverIsOpen())
				ftpClient.closeServer();
		} catch (Exception e) {

		}
	}
	
	/**
	 * 执行命令
	 * 
	 * @param command
	 *            建立目录为：MKD（目录前不能有/） 删除目录为：RMD（目录前不能有/） 删除文件为：DELE（目录前不能有/）
	 * @return int （返回1表示成功）
	 * @throws Exception
	 */
	public int sendCommand(String command) throws Exception {
		int i = issueCommand(command);
		logger.debug("执行命令[" + command + "]。返回结果：" + i);
		return i;
	}

	public static void main(String[] args) {}

}