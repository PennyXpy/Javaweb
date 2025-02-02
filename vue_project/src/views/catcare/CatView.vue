<template>
    <div>
        <el-container style="height: 900px; border: 1px solid #eee">
            <el-header style = "font-size: 40px; background-color: rgb(238, 241, 246);">CatCare - Do all for Cats</el-header>

            <el-container>
                <el-aside width="250px" style="border: 1px solid #eee">
                    <el-menu :default-openeds="['1', '3']">
                        <el-submenu index="1">
                            <template slot="title"><i class="el-icon-message"></i>Information Management</template>
                            <el-menu-item index="1-1">
                                <router-link to="/dept">Department Management</router-link>
                            </el-menu-item>
                            <el-menu-item index="1-2">
                                <router-link to="/cat">Cat Management</router-link>
                            </el-menu-item>
                        </el-submenu>
                    </el-menu>
                </el-aside>


                <el-main>
                    <!-- form -->
                    <el-form :inline="true" :model="searchForm" class="demo-form-inline">
                        <el-form-item label="Name">
                            <el-input v-model="searchForm.name" placeholder="Please enter cat name"></el-input>
                        </el-form-item>
                        <el-form-item label="Gender">
                            <el-select v-model="searchForm.gender" placeholder="Pleaser select gender">
                            <el-option label="Male" value="male"></el-option>
                            <el-option label="Female" value="female"></el-option>
                            </el-select>
                        </el-form-item>
                        <!-- time range select -->
                        <el-form-item label="Time">
                            <el-date-picker
                                v-model="searchForm.daterange"
                                type="daterange"
                                range-separator="To"
                                start-placeholder="Start date"
                                end-placeholder="End date">
                            </el-date-picker>
                        </el-form-item>
                        <el-form-item>
                            <el-button type="primary" @click="onSubmit">Search</el-button>
                        </el-form-item>
                    </el-form>
                     <!-- main -->
                    <el-table :data="tableData" border>
                        <el-table-column prop="name" label="Name" width="140">
                        </el-table-column>
                        <el-table-column prop="image" label="Image" width="180">
                            <template slot-scope="scope">
                                <img :src = "scope.row.image" width="100px" height="70px">
                            </template>
                        </el-table-column>
                        <el-table-column  label="Gender" width="140">
                            <template slot-scope="scope">
                                {{scope.row.gender == "1" ? "Male" : "Female"}}
                            </template>
                        </el-table-column>
                        <el-table-column prop="age" label="Age" width="120"> </el-table-column>
                        <el-table-column prop="comeintime" label="InTime" width="180"> </el-table-column>
                        <el-table-column prop="goouttime" label="OutTime" width="180"> </el-table-column>
                        <el-table-column label=" " >
                            <el-button type="primary" size="mini">Update</el-button>
                            <el-button type="danger" size="mini">Delete</el-button>
                        </el-table-column>
                    </el-table>
                    <!-- pagination -->
                    <el-pagination
                        background
                        layout="total, sizes, prev, pager, next, jumper"
                        @size-change="handleSizeChange"
                        @current-change="handleCurrentChange" 
                        :total="1000">
                    </el-pagination>
                </el-main>
            </el-container>
        </el-container>
    </div>
</template>

<script>
import axios from 'axios';
export default{
    data(){
        return{
            // form model
            searchForm: {
                name: '',
                gender: '',
                daterange: []
            },
            // main model
            tableData: [
            ]
        }
    },
    methods: {
        onSubmit() {
            alert('submit!');
        },
        handleSizeChange: function(val){
            alert('size change' + val)
        },
        handleCurrentChange: function(val){
            alert('current page change' + val)
        }
    },
    mounted(){
        axios.get("https://apifoxmock.com/m1/5809093-5494141-default/catlist").then((result) => {
            this.tableData = result.data;
        });
    }
}
</script>

<style>
</style>