package com.macro.cloud.mapper;

import com.macro.cloud.model.OmsOrder;
import com.macro.cloud.model.OmsOrderExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface OmsOrderMapper {
    long countByExample(OmsOrderExample example);

    int deleteByExample(OmsOrderExample example);

    int deleteByPrimaryKey(Long id);

    int insert(OmsOrder row);

    int insertSelective(OmsOrder row);

    List<OmsOrder> selectByExample(OmsOrderExample example);

    OmsOrder selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("row") OmsOrder row, @Param("example") OmsOrderExample example);

    int updateByExample(@Param("row") OmsOrder row, @Param("example") OmsOrderExample example);

    int updateByPrimaryKeySelective(OmsOrder row);

    int updateByPrimaryKey(OmsOrder row);
}