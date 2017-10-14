package com.dongnao.jack.dynamicDataSource;

public class HandleDataSource {
    
    public static final ThreadLocal<String> holder = new ThreadLocal<String>();
    
    /** 
     * @Description 把当前请求的数据源塞入到我们的ThreadLocal中 
     * @param @param dataSource 参数 
     * @return void 返回类型  
     * @throws 
     */
    public static void pubDataSource(String dataSource) {
        System.out.println("dataSource : " + dataSource);
        holder.set(dataSource);
    }
    
    /** 
     * @Description 从我们的ThreadLocal里面拿出当前请求的数据源 
     * @param @return 参数 
     * @return String 返回类型  
     * @throws 
     */
    public static String getDataSource() {
        return holder.get();
    }
}
