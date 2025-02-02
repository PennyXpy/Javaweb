<template>
    <div>
      <!-- Header -->
      <el-header style="font-size: 40px; background-color: rgb(238, 241, 246);">
        CatCare - Do all for Cats
      </el-header>
  
      <!-- Container -->
      <el-container>
        <!-- Sidebar (Aside) -->
        <el-aside width="250px" style="border: 1px solid #eee">
          <el-menu :default-openeds="['1', '3']">
            <el-submenu index="1">
              <template slot="title">
                <i class="el-icon-message"></i>Information Management
              </template>
              <el-menu-item index="1-1">
                <router-link to="/dept">Department Management</router-link>
              </el-menu-item>
              <el-menu-item index="1-2">
                <router-link to="/cat">Cat Management</router-link>
              </el-menu-item>
            </el-submenu>
          </el-menu>
        </el-aside>
  
        <!-- Main Content (必须要有) -->
        <el-main>
            <el-table :data="tableData" border>
                <el-table-column prop="name" label="DeptName" width="250"></el-table-column>
                    <el-table-column prop="updatetime" label="Last cat come here time" width="250"></el-table-column>
                    <el-table-column label="Manipulate">
                        <el-button type="primary" size="mini">Edit</el-button>
                        <el-button type="danger" size="mini">Delete</el-button>
                    </el-table-column>
            </el-table>
        </el-main>
      </el-container>
    </div>
  </template>
  
  <script>
  export default {
    data() {
        return {
            tableData: [{
                id:1,
                name:"学工部",
                updatetime:"2010-01-01 12:00:00"
            },{
                id:2,
                name:"教研部",
                updatetime:"2010-01-01 12:00:00"
            },{
                id:3,
                name:"就业部",
                updatetime:"2010-01-01 12:00:00"
            },{
                id:4,
                name:"人事部",
                updatetime:"2010-01-01 12:00:00"
            },{
                id:5,
                name:"行政部",
                updatetime:"2010-01-01 12:00:00"
            }]
        }
    },
    methods: {
        
    }
  };
  </script>
  
  <style>
  /* 这里可以添加全局样式 */
  </style>
  