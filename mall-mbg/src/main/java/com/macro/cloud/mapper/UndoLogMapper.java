package com.macro.cloud.mapper;

import com.macro.cloud.model.UndoLog;
import com.macro.cloud.model.UndoLogExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UndoLogMapper {
    long countByExample(UndoLogExample example);

    int deleteByExample(UndoLogExample example);

    int deleteByPrimaryKey(Long id);

    int insert(UndoLog row);

    int insertSelective(UndoLog row);

    List<UndoLog> selectByExampleWithBLOBs(UndoLogExample example);

    List<UndoLog> selectByExample(UndoLogExample example);

    UndoLog selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("row") UndoLog row, @Param("example") UndoLogExample example);

    int updateByExampleWithBLOBs(@Param("row") UndoLog row, @Param("example") UndoLogExample example);

    int updateByExample(@Param("row") UndoLog row, @Param("example") UndoLogExample example);

    int updateByPrimaryKeySelective(UndoLog row);

    int updateByPrimaryKeyWithBLOBs(UndoLog row);

    int updateByPrimaryKey(UndoLog row);
}