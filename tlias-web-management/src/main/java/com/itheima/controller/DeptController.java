package com.itheima.controller;

import com.itheima.pojo.Dept;
import com.itheima.pojo.Result;
import com.itheima.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DeptController {

    @Autowired
    private DeptService deptService;

    /**
     * 查询部门列表
     */
//    @RequestMapping(value = "/depts", method = RequestMethod.GET)
    @GetMapping("/depts")
    public Result list(){
        List<Dept> deptList = deptService.findAll();
        return Result.success(deptList);
    }

    /**
     * 删除部门
     */
    //方式1
//    @DeleteMapping("depts")
//    public Result delete(HttpServletRequest request){
//        String idStr = request.getParameter("id");
//        int id = Integer.parseInt(idStr);
//        return Result.success();
//    }

    //方式2
//    @DeleteMapping("depts")
//    public Result delete(@RequestParam(value = "id", required = false) Integer deptId) {
//        return Result.success();
//    }

    //方式3 （要保证前端请求参数名与服务器端方法的参数名一致）
    @DeleteMapping("/depts")
    public Result delete(Integer id) {
        deptService.deleteById(id);
        return Result.success();
    }

    /**
     * 新增部门
     */
    @PostMapping("/depts")
    public Result add(@RequestBody Dept dept) {
        return Result.success();
    }

}
