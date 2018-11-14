package tk.mybatis.mapper;

import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

/**
* @author lihaibo
* @date 2018/11/13 7:18 PM
* @version v1.0.0
* @description
* 自己的 Mapper
* 特别注意，该接口不能被扫描到，否则会出错
*/
public interface MyMapper<T> extends Mapper<T>, MySqlMapper<T> {

}
