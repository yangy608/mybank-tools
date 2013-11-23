package org.framework.jNative;
import org.xvolks.jnative.JNative;
import org.xvolks.jnative.Type;
import org.xvolks.jnative.exceptions.NativeException;
import org.xvolks.jnative.pointers.Pointer;
public class JNativeTest {
    /**
    * JNativeCpp.dll Windows下用的，拷到windows / system32目录下；
	* libJNativeCpp.so Linux下的咚咚；
	* JNative.jar　这是一个扩展包，将其copy到C:\jdk\jre\lib\ext 下（我的目录结构），系统会自动加载。
	* 被调用的dll要放在windows下
    */
    static JNative Something = null;
    static Pointer pointer;
    public String getSomething(int a, int b) throws NativeException, IllegalAccessException{
     
       try{
           if(Something == null){
        	  //pTar = new Pointer(MemoryBlockFactory.createMemoryBlock(36));
              Something = new JNative("RR1036UDL", "Des");
              // 利用org.xvolks.jnative.JNative 来装载 test.dll，并利用其Add方法
              Something.setRetVal(Type.INT);
              // 指定返回参数的类型
           }
           

           
           int i=0;
           Something.setParameter(i++,a);
           Something.setParameter(i++,b);
           System.out.println("调用的DLL文件名为："+Something.getDLLName());
           System.out.println("调用的方法名为："+Something.getFunctionName());

           //传值
           Something.invoke();//调用方法
           return Something.getRetVal();
           
       }finally{
           if(Something!=null){
              Something.dispose();//释放
           }
       }
    }
//    public Pointer creatPointer() throws NativeException{
//       pointer = new Pointer(MemoryBlockFactory.createMemoryBlock(36));
//       pointer.setIntAt(0, 36);
//       return pointer;
//    }

    public static void main(String[] args) throws NativeException, IllegalAccessException {
    	JNativeTest uc = new JNativeTest();
       String result = uc.getSomething(1, 100);
       System.err.println("返回的结果："+result);
    }
}
