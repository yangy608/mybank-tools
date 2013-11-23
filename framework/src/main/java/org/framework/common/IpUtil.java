package org.framework.common;

import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.UnknownHostException;
import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;


 public class IpUtil {
	 
	/**
	 * @Description       获取客户端ip地址
	 * @return  salt      ip
	 * @author            YY
	 * @date	          2011-10-29/下午09:37:26
	 */
	public static String getIpAddress(HttpServletRequest request) {
		String ip = request.getHeader("x-forwarded-for");
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
		ip = request.getHeader("Proxy-Client-IP");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
		ip = request.getHeader("WL-Proxy-Client-IP");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
		ip = request.getRemoteAddr();
		}
		if("0:0:0:0:0:0:0:1".equals(ip)){
			ip = "127.0.0.1";
		}
		return ip;
	}
	
	/**
	 * @Description       获取客户端ip地址
	 * @return  salt      ip
	 * @author            YY
	 * @date	          2011-10-29/下午09:37:26
	 */
//	public static String getIpAddress() {
//		HttpSession session=SafeFilter.session.get();
//	    String IpAddress = (String) session.getAttribute(Constant.SESSION_IPADDRESS);
//		return IpAddress;
//	}
	
	/**
	 * @Description       获取本机ip地址
	 * @return  salt      ip
	 * @author            YY
	 * @date	          2011-10-29/下午09:37:26
	 */
	public static String getLocalIpAddress(){
		try {
			String localip = null;// 本地IP，如果没有配置外网IP则返回它
			String netip = null;// 外网IP
			Enumeration<NetworkInterface> netInterfaces = NetworkInterface.getNetworkInterfaces();
			InetAddress ip = null;
			boolean finded = false;// 是否找到外网IP
			while (netInterfaces.hasMoreElements() && !finded) {
				NetworkInterface ni = netInterfaces.nextElement();
				Enumeration<InetAddress> address = ni.getInetAddresses();
				while (address.hasMoreElements()) {
					ip = address.nextElement();
					if (!ip.isSiteLocalAddress() && !ip.isLoopbackAddress()
							&& ip.getHostAddress().indexOf(":") == -1) {// 外网IP
						netip = ip.getHostAddress();
						finded = true;
						break;
					} else if (ip.isSiteLocalAddress() && !ip.isLoopbackAddress()
							&& ip.getHostAddress().indexOf(":") == -1) {// 内网IP
						localip = ip.getHostAddress();
					}
				}
			}
			if (netip != null && !"".equals(netip)) {
				return netip;
			} else {
				return localip;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;	
	}
	
	
	public static String getIpAddr(HttpServletRequest request) {  
	     String ipAddress = null;  
	     //ipAddress = request.getRemoteAddr();  
	     ipAddress = request.getHeader("x-forwarded-for");  
	     if(ipAddress == null || ipAddress.length() == 0 || "unknown".equalsIgnoreCase(ipAddress)) {  
	      ipAddress = request.getHeader("Proxy-Client-IP");  
	     }  
	     if(ipAddress == null || ipAddress.length() == 0 || "unknown".equalsIgnoreCase(ipAddress)) {  
	         ipAddress = request.getHeader("WL-Proxy-Client-IP");  
	     }  
	     if(ipAddress == null || ipAddress.length() == 0 || "unknown".equalsIgnoreCase(ipAddress)) {  
	      ipAddress = request.getRemoteAddr();  
	      if(ipAddress.equals("127.0.0.1")){  
	       //根据网卡取本机配置的IP  
	       InetAddress inet=null;  
	    try {  
	     inet = InetAddress.getLocalHost();  
	    } catch (UnknownHostException e) {  
	     e.printStackTrace();  
	    }  
	    ipAddress= inet.getHostAddress();  
	      }  
	          
	     }  
	  
	     //对于通过多个代理的情况，第一个IP为客户端真实IP,多个IP按照','分割  
	     if(ipAddress!=null && ipAddress.length()>15){ //"***.***.***.***".length() = 15  
	         if(ipAddress.indexOf(",")>0){  
	             ipAddress = ipAddress.substring(0,ipAddress.indexOf(","));  
	         }  
	     }  
	     return ipAddress;  
	}  
}

