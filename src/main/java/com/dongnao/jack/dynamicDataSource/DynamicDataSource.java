package com.dongnao.jack.dynamicDataSource;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

/** 
 * @Description 这个类必须要继承 AbstractRoutingDataSource，这个类的determineCurrentLookupKey，是我们spring调用的，
 * 这个方法的作用就是告诉spring我们到底是用那一个数据源
 * @ClassName   DynamicDataSource 
 * @Date        2017年10月14日 下午9:19:44 
 * @Author      动脑学院-jack
 */
public class DynamicDataSource extends AbstractRoutingDataSource {
    
    /* 
     * 告诉spring到底是用哪一个数据源,read  write
     */
    @Override
    protected Object determineCurrentLookupKey() {
        return HandleDataSource.getDataSource();
    }
}
