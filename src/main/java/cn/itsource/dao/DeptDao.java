package cn.itsource.dao;

import cn.itsource.model.Dept;
import java.util.List;

public interface DeptDao {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_dept
     *
     * @mbg.generated Fri Jun 21 15:57:31 CST 2019
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_dept
     *
     * @mbg.generated Fri Jun 21 15:57:31 CST 2019
     */
    int insert(Dept record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_dept
     *
     * @mbg.generated Fri Jun 21 15:57:31 CST 2019
     */
    Dept selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_dept
     *
     * @mbg.generated Fri Jun 21 15:57:31 CST 2019
     */
    List<Dept> selectAll();

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_dept
     *
     * @mbg.generated Fri Jun 21 15:57:31 CST 2019
     */
    int updateByPrimaryKey(Dept record);
}