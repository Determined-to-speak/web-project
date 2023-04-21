package dao.testtable;

import java.util.List;
import model.testtable.TestTable;
import model.testtable.TestTableExample;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface TestTableMapper {
    long countByExample(TestTableExample example);

    int deleteByExample(TestTableExample example);

    int deleteByPrimaryKey(Long id);

    int insert(TestTable record);

    int insertSelective(TestTable record);

    List<TestTable> selectByExampleWithBLOBs(TestTableExample example);

    List<TestTable> selectByExample(TestTableExample example);

    TestTable selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") TestTable record, @Param("example") TestTableExample example);

    int updateByExampleWithBLOBs(@Param("record") TestTable record, @Param("example") TestTableExample example);

    int updateByExample(@Param("record") TestTable record, @Param("example") TestTableExample example);

    int updateByPrimaryKeySelective(TestTable record);

    int updateByPrimaryKeyWithBLOBs(TestTable record);

    int updateByPrimaryKey(TestTable record);
}