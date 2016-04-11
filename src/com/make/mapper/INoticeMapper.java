/**  
 * @Title: INoticeMapper.java
 * @Package com.make.mapper
 * @Description: TODO
 * @author zhengjf
 * @date 2016-4-11
 */
package com.make.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import com.make.bean.NoticeBean;

/**
 * ClassName: INoticeMapper
 * 
 * @Description: TODO
 * @author zhengjf
 * @date 2016-4-11
 */
@Repository
public interface INoticeMapper {

	@Select("select * from ${dbName}.t_notice")
	List<NoticeBean> loadNoticeInfo(NoticeBean notice);

	// 添加公告信息
	@Insert("INSERT INTO ${dbName}.t_notice (title,content,creatTime,owner,status) VALUES (#{title},#{content},#{creatTime},#{owner},#{status});")
	int insertNoticeInfo(NoticeBean notice);
}
