<template>
    <div>
        <el-row>
            <el-button>Default</el-button>
            <el-button type="primary">Primary</el-button>
            <el-button type="success">Success</el-button>
            <el-button type="info">Info</el-button>
            <el-button type="warning">Warning</el-button>
            <el-button type="danger">Danger</el-button>
        </el-row>

        <el-table :key="tableKey" :data="tableData"  style="width: 100%;" height="auto">
            <el-table-column prop="date" label="Date" width="180"></el-table-column>
            <el-table-column prop="name" label="Name" width="180"></el-table-column>
            <el-table-column prop="address" label="Address"></el-table-column>
        </el-table>
          <!-- pagination -->
        <el-pagination
          background
          layout="total, sizes, prev, pager, next, jumper"
          @size-change="handleSizeChange"
          @current-change="handleCurrentChange" 
          :total="1000">
      </el-pagination>
      <!-- @ is function so in script you need to call function -->
<br> 
                <!-- Dialog -->
        <el-button type="text" @click="dialogTableVisible = true">open a Table nested Dialog</el-button>

        <el-dialog title="Shipping address" :visible.sync="dialogTableVisible" append-to-body>
          <el-table v-if="dialogTableVisible" :data="gridData" style="width: 100%">
            <el-table-column property="date" label="Date" width="150"></el-table-column>
            <el-table-column property="name" label="Name" width="200"></el-table-column>
            <el-table-column property="address" label="Address"></el-table-column>
          </el-table>
        </el-dialog>
        <!-- 有时候 el-table 在 el-dialog 尚未完全渲染时就尝试计算尺寸，导致 ResizeObserver 报错。使用 v-if 让 el-table 只在 dialogTableVisible 为 true 时渲染： -->

<br>
    <!-- dialog + form, label 前端的 value存在后端的 -->
        <el-button type="text" @click="dialogFormVisible = true">open Form Dialog</el-button>
        <el-dialog title="This is Form" :visible.sync="dialogFormVisible" append-to-body>
          <el-form ref="form" :model="form" label-width="120px">
            <el-form-item label="Activity name">
              <el-input v-model="form.name"></el-input>
            </el-form-item>

            <el-form-item label="Activity zone">
              <el-select v-model="form.region" placeholder="please select your zone">
                <el-option label="Zone one" value="shanghai"></el-option>
                <el-option label="Zone two" value="beijing"></el-option>
              </el-select>
            </el-form-item>

            <el-form-item label="Activity time">
              <el-col :span="11">
                <el-date-picker type="date" placeholder="Pick a date" v-model="form.date1" style="width: 100%;"></el-date-picker>
              </el-col>
              <el-col class="line" :span="2">-</el-col>
              <el-col :span="11">
                <el-time-picker placeholder="Pick a time" v-model="form.date2" style="width: 100%;"></el-time-picker>
              </el-col>
            </el-form-item>

            <el-form-item>
              <el-button type="primary" @click="onSubmit">Submits</el-button>
              <el-button>Cancel</el-button>
            </el-form-item>
          </el-form>
        </el-dialog>
    </div>

</template>

<script>
export default {
  data() {
    return {
      form: {
          name: '',
          region: '',
          date1: '',
          date2: '',
      },
      tableData: [
        {
          date: "2016-05-03",
          name: "Tom",
          address: "No. 189, Grove St, Los Angeles",
        },
        {
          date: "2016-05-02",
          name: "Tom",
          address: "No. 189, Grove St, Los Angeles",
        },
        {
          date: "2016-05-04",
          name: "Tom",
          address: "No. 189, Grove St, Los Angeles",
        },
        {
          date: "2016-05-01",
          name: "Tom",
          address: "No. 189, Grove St, Los Angeles",
        },
      ],
      gridData: [{
          date: '2016-05-02',
          name: 'John Smith',
          address: 'No.1518,  Jinshajiang Road, Putuo District'
        }, {
          date: '2016-05-04',
          name: 'John Smith',
          address: 'No.1518,  Jinshajiang Road, Putuo District'
        }, {
          date: '2016-05-01',
          name: 'John Smith',
          address: 'No.1518,  Jinshajiang Road, Putuo District'
        }, {
          date: '2016-05-03',
          name: 'John Smith',
          address: 'No.1518,  Jinshajiang Road, Putuo District'
        }],
        dialogTableVisible: false,
        dialogFormVisible: false,
    };
  },
  methods: {
    handleSizeChange: function(val){
      alert('size change' + val)
    },
    handleCurrentChange: function(val){
      alert('current page change' + val)
    },
    onSubmit: function(){
    alert(JSON.stringify(this.form))
  }
  },
}; 

</script>

<style>

</style>