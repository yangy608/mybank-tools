package org.framework.ftp;

import java.util.List;


public class T {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		//初始化ftp
		FtpUtil ftp_from = new FtpUtil("222.68.184.181", 22, "MGDSSC", "123456");	
		ftp_from.open();
				
				//下载ftp文件到本地ftp文件夹
				boolean isExist = false; //是否存在对账文件标识
				try {
					try {
						//判断ftp文件夹中是否存在对账文件
						//获取6次对账文件
						int i = 0;		
						while(i<6){
							i++;
							//每10秒读取一次
							Thread.sleep(10000);

							
							//存在对账文件，继续后续操作
							List<?> l = ftp_from.getFileNameList("对账文件所在的文件夹");
							for (Object object : l) {
								String filename = new String(String.valueOf(object).getBytes("GBK"), "UTF-8");
								//存在对账文件
								if(filename.indexOf("20120202")!=-1){
									isExist = true;
								}
							}
							if(isExist){
								break;
							}
						}
						
						//读取到对账文件，进行后续操作
						if(isExist){
							//ftp_from.download(filePath+ParamInFile.separator+verfyFileName,ParamInFile.from_ftp_dir+"/"+verfyFileName);
						}
						
					} catch (Exception e) {
						ftp_from.close();
						ftp_from.open();
						//ftp_from.download(filePath+ParamInFile.separator+verfyFileName,ParamInFile.from_ftp_dir+"/"+verfyFileName);
					}
				} catch (Exception e) {
					e.printStackTrace();
				}finally{
					ftp_from.close();
				}

	}

}
