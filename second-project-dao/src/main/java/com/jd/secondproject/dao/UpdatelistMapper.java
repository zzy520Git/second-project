package com.jd.secondproject.dao;

import com.jd.secondproject.domain.Updatelist;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Description：
 *
 * @author zhouzhongyi1
 * DATE： 2018/9/15 21:54
 */
public interface UpdatelistMapper {
    List<Updatelist> queryTest(@Param("list") List<String>list, @Param("bool") boolean bool) ;
}
