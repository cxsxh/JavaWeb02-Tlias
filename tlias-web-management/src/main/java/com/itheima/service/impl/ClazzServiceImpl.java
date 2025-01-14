package com.itheima.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.itheima.mapper.ClazzMapper;
import com.itheima.pojo.Clazz;
import com.itheima.pojo.ClazzQueryParam;
import com.itheima.pojo.PageResult;
import com.itheima.service.ClazzService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class ClazzServiceImpl implements ClazzService {

    @Autowired
    private ClazzMapper clazzMapper;

    /*
     *  查询所有班级信息
     */
    @Override
    public PageResult<Clazz> findAll(ClazzQueryParam clazzQueryParam) {
        //1.设置分页参数
        PageHelper.startPage(clazzQueryParam.getPage(), clazzQueryParam.getPageSize());

        //2.执行查询
        List<Clazz> clazzList = clazzMapper.list(clazzQueryParam);

        //封装结果
        LocalDate now = LocalDate.now();
        for (Clazz clazz : clazzList) {
            if (now.isBefore(clazz.getBeginDate())) {
                clazz.setStatus("未开班");
            } else if (now.isAfter(clazz.getEndDate())){
                clazz.setStatus("已结课");
            } else {
                clazz.setStatus("在读中");
            }
        }
        Page<Clazz> p = (Page<Clazz>) clazzList;
        return new PageResult<Clazz>(p.getTotal(), p.getResult());
    }

    /*
     * 根据ID删除班级
     */
    @Override
    public void deleteById(Integer id) {
        clazzMapper.deleteById(id);
    }

    /*
     * 新增班级
     */
    @Override
    public void add(Clazz clazz) {
        clazz.setCreateTime(LocalDateTime.now());
        clazz.setUpdateTime(LocalDateTime.now());
        clazzMapper.insert(clazz);
    }

    /*
     * 根据ID查询班级
     */
    @Override
    public Clazz getById(Integer id) {
        return clazzMapper.getById(id);
    }

    /*
     * 修改班级
     */
    @Override
    public void update(Clazz clazz) {
        clazz.setUpdateTime(LocalDateTime.now());
        clazzMapper.update(clazz);
    }

    /*
     * 查询所有班级
     */
    @Override
    public List<Clazz> listAll() {
        return clazzMapper.listAll();
    }
}
