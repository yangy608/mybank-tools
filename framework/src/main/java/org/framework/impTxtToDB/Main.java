/********************************************************************
 * Copyright    :   Shanghai Mybank Information Technology Co., Ltd.
 * 
 * Filename     :   Main.java
 * Author       :   YY
 * Date         :   2013-9-12
 * Version      :   V1.00
 * Description  :   
 *
 * History      :   Modify Id  |  Date  |  Origin  |  Description
 *******************************************************************/


package org.framework.impTxtToDB;

import java.util.List;

import org.framework.common.IOUtil;
import org.framework.dadabase.BaseDao;

public class Main {

	/**
	 *  @Description: TODO
	 *  @param  @param args
	 *  @return void
	 *  @throws 
	 *  @author YY
	 *  @date   2013-9-12 下午3:55:26
	 */
	public static void main(String[] args) {
		try {
			List<?> l = IOUtil.readFileList("c:\\bssj.txt","gbk");
			System.err.println(l.size());
//			int i = 0;
//			for (Object object : l) {
//				String str = (String) object;
//				str=str.replace("	", "|").replace("    ", "|").replace("'", "");
//				System.err.println(i+++"==="+str);
//				String[] arrStr = str.split("\\|");
//				String sql = "insert into T_INF_BANK(bank_no,bank_name,bank_address,city_no) values('"+arrStr[0]+"','"+arrStr[4]+"','"+arrStr[5]+"','"+arrStr[3]+"')";
//				BaseDao.executeUpdate(sql);
//			}
			System.err.println("完成了。。。。。。");
			
			
		} catch (Exception e) {
			// TODO 自动生成 catch 块
			
			e.printStackTrace();
		}

	}
	
}
