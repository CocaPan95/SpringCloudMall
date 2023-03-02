package com.macro.cloud.mapper;

import com.macro.cloud.model.Orderss;
import com.macro.cloud.model.OrderssExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface OrderssMapper {
    long countByExample(OrderssExample example);

    int deleteByExample(OrderssExample example);

    int deleteByPrimaryKey(Long orderid);

    int insert(Orderss row);

    int insertSelective(Orderss row);

    List<Orderss> selectByExample(OrderssExample example);

    Orderss selectByPrimaryKey(Long orderid);

    int updateByExampleSelective(@Param("row") Orderss row, @Param("example") OrderssExample example);

    int updateByExample(@Param("row") Orderss row, @Param("example") OrderssExample example);

    int updateByPrimaryKeySelective(Orderss row);

    int updateByPrimaryKey(Orderss row);
}