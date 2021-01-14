package com.ym.springbootdemo1.controller;

import cn.hutool.db.Db;
import cn.hutool.db.Entity;
import com.ym.springbootdemo1.pojo.Response;
import com.ym.springbootdemo1.pojo.User;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @PostMapping("/add")
    public Response addUser(@RequestBody User user) throws SQLException {
        int insert = Db.use().insert(Entity.create("user")
                .set("name", user.getName())
                .set("age", user.getAge()));
        if (insert>0){
            return Response.ok("新增成功");
        }else return Response.faild("新增失败");
    }

    @GetMapping("/query")
    public Response query(Integer id,String name) throws SQLException {
        Entity entity = Entity.create("user");
        if (id!=null){
            entity.set("id",id);
        }if(name!=null){
            entity.set("name",name);
        }
        List<Entity> all = Db.use().findAll(entity);
        ArrayList<User> userList = new ArrayList<>();
        for (int i = 0; i <all.size() ; i++) {
            User user = new User();
            user.setId(all.get(i).getLong("id"));
            user.setName(all.get(i).getStr("name"));
            user.setAge(all.get(i).getInt("age"));
            userList.add(user);
        }return Response.ok(userList);
    }

    @PostMapping("/delete")
    public Response deleteUser(Integer id) throws SQLException {
     int del = Db.use().del(
                Entity.create("user")
                        .set("id",id)
        );
        if (del>0){
            return Response.ok("删除成功");
        }else return Response.faild("删除失败");
    }

    @PostMapping("/update")
    public Response updateUser(@RequestBody User user) throws SQLException {
        Entity entity = Entity.create();
        if (user.getName()!=null){
            entity.set("name", user.getName());
        }if(user.getAge()!=null){
            entity.set("age", user.getAge());
        }
        int del = Db.use().update(entity, //修改的数据
                Entity.create("user").set("id", user.getId()) //where条件
        );
        if (del>0){
            return Response.ok("修改成功");
        }else return Response.faild("修改失败");
    }








}
