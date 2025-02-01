<template>
    <div>
        <el-container style="height: 900px; border: 1px solid #eee">
            <el-header style = "font-size: 40px; background-color: rgb(238, 241, 246);">CatCare - Do all for Cats</el-header>

            <el-container>
                <el-aside width="250px" style="border: 1px solid #eee">
                    <el-menu :default-openeds="['1', '3']">
                        <el-submenu index="1">
                            <template slot="title"><i class="el-icon-message"></i>Information Management</template>
                            <el-menu-item index="1-1">Department Management</el-menu-item>
                            <el-menu-item index="1-2">Cat Management</el-menu-item>
                        </el-submenu>
                    </el-menu>
                </el-aside>


                <el-main>
                    <el-table :data="tableData">
                        <el-table-column prop="name" label="Name" width="140">
                        </el-table-column>
                        <el-table-column prop="image" label="Image" width="180">
                        </el-table-column>
                        <el-table-column prop="gender" label="Gender" width="140">
                        </el-table-column>
                        <el-table-column prop="age" label="Age" width="120"> </el-table-column>
                        <el-table-column prop="comeintime" label="ComeInTime" width="180"> </el-table-column>
                        <el-table-column label="操作" >
                            <el-button type="primary" size="mini">Update</el-button>
                            <el-button type="danger" size="mini">Delete</el-button>
                        </el-table-column>
                    </el-table>
                </el-main>
            </el-container>
        </el-container>
    </div>
</template>

<script>
export default{
    data(){
        return{
            tableData: [
                {name: 'Tom', image: "sss", gender: 'Male', age: 2, comeintime: '2019-12-12'},
                {name: 'Tom', image: "sss", gender: 'Male', age: 2, comeintime: '2019-12-12'},
                {name: 'Tom', image: "sss", gender: 'Male', age: 2, comeintime: '2019-12-12'},
                {name: 'Tom', image: "sss", gender: 'Male', age: 2, comeintime: '2019-12-12'},
                {name: 'Tom', image: "sss", gender: 'Male', age: 2, comeintime: '2019-12-12'},
            ]
        }
    }
}
</script>

<style>
</style>