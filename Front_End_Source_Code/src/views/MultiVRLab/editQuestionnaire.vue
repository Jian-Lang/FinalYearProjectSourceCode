<template>
  <div  style="width: 80%">

    <div style="display:inline-block;  padding: 10px;width: 100%;background-color: #f0f0f0;text-align: center">
      <div style="font-size: 18px; font-weight: bold">
        <span style="margin-right: 10px;; color: #42b983">{{form.course}}</span>
        <span style="margin-right: 10px;; color: #F44336;">&nbsp;{{form.lab}}</span>
        <span style="margin-right: 10px; color: #555;">&nbsp;编辑实验问卷</span>


      </div>
    </div>
    <div style="margin-top: 50px">
        <el-form :inline="true" :model="form" :rules="rules" ref="ruleForm" class="demo-form-inline" label-width="130px">
          <div style="text-align: center;margin-bottom: 20px">
            <el-form-item label="问卷名称" prop="questionnaire_name">
              <el-input v-model="form.questionnaire_name" disabled="true"></el-input>
            </el-form-item>
          </div>
          <el-divider></el-divider>

          <!--问题1-->
          <div style="margin-bottom: 15px">
            <el-form-item label="问题1" prop="question_1">
              <el-input v-model="form.question_1" placeholder="请输入问题1"></el-input>
            </el-form-item>
            <el-form-item label="答案1" prop="answer_1">
              <el-input v-model="form.answer_1" placeholder="请输入答案1"></el-input>
            </el-form-item>
          </div>
          <el-form-item label="选项1" prop="option_1_1">
            <el-input v-model="form.option_1_1" placeholder="请输入选项1"></el-input>
          </el-form-item>
          <el-form-item label="选项2" prop="option_1_2">
            <el-input v-model="form.option_1_2" placeholder="请输入选项2"></el-input>
          </el-form-item>
          <el-form-item label="选项3" prop="option_1_3">
            <el-input v-model="form.option_1_3" placeholder="请输入选项3"></el-input>
          </el-form-item>
          <el-form-item label="选项4" prop="option_1_4">
            <el-input v-model="form.option_1_4" placeholder="请输入选项4"></el-input>
          </el-form-item>
          <el-form-item label="选项5" prop="option_1_5">
            <el-input v-model="form.option_1_5" placeholder="请输入选项5"></el-input>
          </el-form-item>
          <el-form-item label="选项6" prop="option_1_6">
            <el-input v-model="form.option_1_6" placeholder="请输入选项6"></el-input>
          </el-form-item>
          <el-form-item label="选项7" prop="option_1_7">
            <el-input v-model="form.option_1_7" placeholder="请输入选项7"></el-input>
          </el-form-item>
          <el-divider></el-divider>

          <!--问题2-->
          <div style="margin-bottom: 15px">
            <el-form-item label="问题2" prop="question_2">
              <el-input v-model="form.question_2" placeholder="请输入问题2"></el-input>
            </el-form-item>
            <el-form-item label="答案2" prop="answer_2">
              <el-input v-model="form.answer_2" placeholder="请输入答案2"></el-input>
            </el-form-item>
          </div>
          <el-form-item label="选项1" prop="option_2_1">
            <el-input v-model="form.option_2_1" placeholder="请输入选项1"></el-input>
          </el-form-item>
          <el-form-item label="选项2" prop="option_2_2">
            <el-input v-model="form.option_2_2" placeholder="请输入选项2"></el-input>
          </el-form-item>
          <el-form-item label="选项3" prop="option_2_3">
            <el-input v-model="form.option_2_3" placeholder="请输入选项3"></el-input>
          </el-form-item>
          <el-form-item label="选项4" prop="option_2_4">
            <el-input v-model="form.option_2_4" placeholder="请输入选项4"></el-input>
          </el-form-item>
          <el-form-item label="选项5" prop="option_2_5">
            <el-input v-model="form.option_2_5" placeholder="请输入选项5"></el-input>
          </el-form-item>
          <el-form-item label="选项6" prop="option_2_6">
            <el-input v-model="form.option_2_6" placeholder="请输入选项6"></el-input>
          </el-form-item>
          <el-form-item label="选项7" prop="option_2_7">
            <el-input v-model="form.option_2_7" placeholder="请输入选项7"></el-input>
          </el-form-item>
          <el-divider></el-divider>

          <!--问题3-->
          <div style="margin-bottom: 15px">
            <el-form-item label="问题3" prop="question_3">
              <el-input v-model="form.question_3" placeholder="请输入问题3"></el-input>
            </el-form-item>
            <el-form-item label="答案3" prop="answer_3">
              <el-input v-model="form.answer_3" placeholder="请输入答案3"></el-input>
            </el-form-item>
          </div>
          <el-form-item label="选项1" prop="option_3_1">
            <el-input v-model="form.option_3_1" placeholder="请输入选项1"></el-input>
          </el-form-item>
          <el-form-item label="选项2" prop="option_3_2">
            <el-input v-model="form.option_3_2" placeholder="请输入选项2"></el-input>
          </el-form-item>
          <el-form-item label="选项3" prop="option_3_3">
            <el-input v-model="form.option_3_3" placeholder="请输入选项3"></el-input>
          </el-form-item>
          <el-form-item label="选项4" prop="option_3_4">
            <el-input v-model="form.option_3_4" placeholder="请输入选项4"></el-input>
          </el-form-item>
          <el-form-item label="选项5" prop="option_3_5">
            <el-input v-model="form.option_3_5" placeholder="请输入选项5"></el-input>
          </el-form-item>
          <el-form-item label="选项6" prop="option_3_6">
            <el-input v-model="form.option_3_6" placeholder="请输入选项6"></el-input>
          </el-form-item>
          <el-form-item label="选项7" prop="option_3_7">
            <el-input v-model="form.option_3_7" placeholder="请输入选项7"></el-input>
          </el-form-item>
          <el-divider></el-divider>

          <!--问题4-->
          <div style="margin-bottom: 15px">
            <el-form-item label="问题4" prop="question_4">
              <el-input v-model="form.question_4" placeholder="请输入问题4"></el-input>
            </el-form-item>
            <el-form-item label="答案4" prop="answer_4">
              <el-input v-model="form.answer_4" placeholder="请输入答案4"></el-input>
            </el-form-item>
          </div>
          <el-form-item label="选项1" prop="option_4_1">
            <el-input v-model="form.option_4_1" placeholder="请输入选项1"></el-input>
          </el-form-item>
          <el-form-item label="选项2" prop="option_4_2">
            <el-input v-model="form.option_4_2" placeholder="请输入选项2"></el-input>
          </el-form-item>
          <el-form-item label="选项3" prop="option_4_3">
            <el-input v-model="form.option_4_3" placeholder="请输入选项3"></el-input>
          </el-form-item>
          <el-form-item label="选项4" prop="option_4_4">
            <el-input v-model="form.option_4_4" placeholder="请输入选项4"></el-input>
          </el-form-item>
          <el-form-item label="选项5" prop="option_4_5">
            <el-input v-model="form.option_4_5" placeholder="请输入选项5"></el-input>
          </el-form-item>
          <el-form-item label="选项6" prop="option_4_6">
            <el-input v-model="form.option_4_6" placeholder="请输入选项6"></el-input>
          </el-form-item>
          <el-form-item label="选项7" prop="option_4_7">
            <el-input v-model="form.option_4_7" placeholder="请输入选项7"></el-input>
          </el-form-item>
          <el-divider></el-divider>

          <!--问题5-->
          <div style="margin-bottom: 15px">
            <el-form-item label="问题5" prop="question_5">
              <el-input v-model="form.question_5" placeholder="请输入问题5"></el-input>
            </el-form-item>
            <el-form-item label="答案5" prop="answer_5">
              <el-input v-model="form.answer_5" placeholder="请输入答案5"></el-input>
            </el-form-item>
          </div>
          <el-form-item label="选项1" prop="option_5_1">
            <el-input v-model="form.option_5_1" placeholder="请输入选项1"></el-input>
          </el-form-item>
          <el-form-item label="选项2" prop="option_5_2">
            <el-input v-model="form.option_5_2" placeholder="请输入选项2"></el-input>
          </el-form-item>
          <el-form-item label="选项3" prop="option_5_3">
            <el-input v-model="form.option_5_3" placeholder="请输入选项3"></el-input>
          </el-form-item>
          <el-form-item label="选项4" prop="option_5_4">
            <el-input v-model="form.option_5_4" placeholder="请输入选项4"></el-input>
          </el-form-item>
          <el-form-item label="选项5" prop="option_5_5">
            <el-input v-model="form.option_5_5" placeholder="请输入选项5"></el-input>
          </el-form-item>
          <el-form-item label="选项6" prop="option_5_6">
            <el-input v-model="form.option_5_6" placeholder="请输入选项6"></el-input>
          </el-form-item>
          <el-form-item label="选项7" prop="option_5_7">
            <el-input v-model="form.option_5_7" placeholder="请输入选项7"></el-input>
          </el-form-item>
          <el-divider></el-divider>

          <!--问题6-->
          <div style="margin-bottom: 15px">
            <el-form-item label="问题6" prop="question_6">
              <el-input v-model="form.question_6" placeholder="请输入问题6"></el-input>
            </el-form-item>
            <el-form-item label="答案6" prop="answer_6">
              <el-input v-model="form.answer_6" placeholder="请输入答案6"></el-input>
            </el-form-item>
          </div>
          <el-form-item label="选项1" prop="option_6_1">
            <el-input v-model="form.option_6_1" placeholder="请输入选项1"></el-input>
          </el-form-item>
          <el-form-item label="选项2" prop="option_6_2">
            <el-input v-model="form.option_6_2" placeholder="请输入选项2"></el-input>
          </el-form-item>
          <el-form-item label="选项3" prop="option_6_3">
            <el-input v-model="form.option_6_3" placeholder="请输入选项3"></el-input>
          </el-form-item>
          <el-form-item label="选项4" prop="option_6_4">
            <el-input v-model="form.option_6_4" placeholder="请输入选项4"></el-input>
          </el-form-item>
          <el-form-item label="选项5" prop="option_6_5">
            <el-input v-model="form.option_6_5" placeholder="请输入选项5"></el-input>
          </el-form-item>
          <el-form-item label="选项6" prop="option_6_6">
            <el-input v-model="form.option_6_6" placeholder="请输入选项6"></el-input>
          </el-form-item>
          <el-form-item label="选项7" prop="option_6_7">
            <el-input v-model="form.option_6_7" placeholder="请输入选项7"></el-input>
          </el-form-item>
          <el-divider></el-divider>

          <!--问题7-->
          <div style="margin-bottom: 15px">
            <el-form-item label="问题7" prop="question_7">
              <el-input v-model="form.question_7" placeholder="请输入问题7"></el-input>
            </el-form-item>
            <el-form-item label="答案7" prop="answer_7">
              <el-input v-model="form.answer_7" placeholder="请输入答案7"></el-input>
            </el-form-item>
          </div>
          <el-form-item label="选项1" prop="option_7_1">
            <el-input v-model="form.option_7_1" placeholder="请输入选项1"></el-input>
          </el-form-item>
          <el-form-item label="选项2" prop="option_7_2">
            <el-input v-model="form.option_7_2" placeholder="请输入选项2"></el-input>
          </el-form-item>
          <el-form-item label="选项3" prop="option_7_3">
            <el-input v-model="form.option_7_3" placeholder="请输入选项3"></el-input>
          </el-form-item>
          <el-form-item label="选项4" prop="option_7_4">
            <el-input v-model="form.option_7_4" placeholder="请输入选项4"></el-input>
          </el-form-item>
          <el-form-item label="选项5" prop="option_7_5">
            <el-input v-model="form.option_7_5" placeholder="请输入选项5"></el-input>
          </el-form-item>
          <el-form-item label="选项6" prop="option_7_6">
            <el-input v-model="form.option_7_6" placeholder="请输入选项6"></el-input>
          </el-form-item>
          <el-form-item label="选项7" prop="option_7_7">
            <el-input v-model="form.option_7_7" placeholder="请输入选项7"></el-input>
          </el-form-item>
          <el-divider></el-divider>

          <!--问题8-->
          <div style="margin-bottom: 15px">
            <el-form-item label="问题8" prop="question_8">
              <el-input v-model="form.question_8" placeholder="请输入问题8"></el-input>
            </el-form-item>
            <el-form-item label="答案8" prop="answer_8">
              <el-input v-model="form.answer_8" placeholder="请输入答案8"></el-input>
            </el-form-item>
          </div>
          <el-form-item label="选项1" prop="option_8_1">
            <el-input v-model="form.option_8_1" placeholder="请输入选项1"></el-input>
          </el-form-item>
          <el-form-item label="选项2" prop="option_8_2">
            <el-input v-model="form.option_8_2" placeholder="请输入选项2"></el-input>
          </el-form-item>
          <el-form-item label="选项3" prop="option_8_3">
            <el-input v-model="form.option_8_3" placeholder="请输入选项3"></el-input>
          </el-form-item>
          <el-form-item label="选项4" prop="option_8_4">
            <el-input v-model="form.option_8_4" placeholder="请输入选项4"></el-input>
          </el-form-item>
          <el-form-item label="选项5" prop="option_8_5">
            <el-input v-model="form.option_8_5" placeholder="请输入选项5"></el-input>
          </el-form-item>
          <el-form-item label="选项6" prop="option_8_6">
            <el-input v-model="form.option_8_6" placeholder="请输入选项6"></el-input>
          </el-form-item>
          <el-form-item label="选项7" prop="option_8_7">
            <el-input v-model="form.option_8_7" placeholder="请输入选项7"></el-input>
          </el-form-item>
          <el-divider></el-divider>

          <!--问题9-->
          <div style="margin-bottom: 15px">
            <el-form-item label="问题9" prop="question_9">
              <el-input v-model="form.question_9" placeholder="请输入问题9"></el-input>
            </el-form-item>
            <el-form-item label="答案9" prop="answer_9">
              <el-input v-model="form.answer_9" placeholder="请输入答案9"></el-input>
            </el-form-item>
          </div>
          <el-form-item label="选项1" prop="option_9_1">
            <el-input v-model="form.option_9_1" placeholder="请输入选项1"></el-input>
          </el-form-item>
          <el-form-item label="选项2" prop="option_9_2">
            <el-input v-model="form.option_9_2" placeholder="请输入选项2"></el-input>
          </el-form-item>
          <el-form-item label="选项3" prop="option_9_3">
            <el-input v-model="form.option_9_3" placeholder="请输入选项3"></el-input>
          </el-form-item>
          <el-form-item label="选项4" prop="option_9_4">
            <el-input v-model="form.option_9_4" placeholder="请输入选项4"></el-input>
          </el-form-item>
          <el-form-item label="选项5" prop="option_9_5">
            <el-input v-model="form.option_9_5" placeholder="请输入选项5"></el-input>
          </el-form-item>
          <el-form-item label="选项6" prop="option_9_6">
            <el-input v-model="form.option_9_6" placeholder="请输入选项6"></el-input>
          </el-form-item>
          <el-form-item label="选项7" prop="option_9_7">
            <el-input v-model="form.option_9_7" placeholder="请输入选项7"></el-input>
          </el-form-item>
          <el-divider></el-divider>

          <!--问题10-->
          <div style="margin-bottom: 15px">
            <el-form-item label="问题10" prop="question_10">
              <el-input v-model="form.question_10" placeholder="请输入问题10"></el-input>
            </el-form-item>
            <el-form-item label="答案10" prop="answer_10">
              <el-input v-model="form.answer_10" placeholder="请输入答案10"></el-input>
            </el-form-item>
          </div>
          <el-form-item label="选项1" prop="option_10_1">
            <el-input v-model="form.option_10_1" placeholder="请输入选项1"></el-input>
          </el-form-item>
          <el-form-item label="选项2" prop="option_10_2">
            <el-input v-model="form.option_10_2" placeholder="请输入选项2"></el-input>
          </el-form-item>
          <el-form-item label="选项3" prop="option_10_3">
            <el-input v-model="form.option_10_3" placeholder="请输入选项3"></el-input>
          </el-form-item>
          <el-form-item label="选项4" prop="option_10_4">
            <el-input v-model="form.option_10_4" placeholder="请输入选项4"></el-input>
          </el-form-item>
          <el-form-item label="选项5" prop="option_10_5">
            <el-input v-model="form.option_10_5" placeholder="请输入选项5"></el-input>
          </el-form-item>
          <el-form-item label="选项6" prop="option_10_6">
            <el-input v-model="form.option_10_6" placeholder="请输入选项6"></el-input>
          </el-form-item>
          <el-form-item label="选项7" prop="option_10_7">
            <el-input v-model="form.option_10_7" placeholder="请输入选项7"></el-input>
          </el-form-item>
          <el-divider></el-divider>

          <!--问题11-->
          <div style="margin-bottom: 15px">
            <el-form-item label="问题11" prop="question_11">
              <el-input v-model="form.question_11" placeholder="请输入问题11"></el-input>
            </el-form-item>
            <el-form-item label="答案11" prop="answer_11">
              <el-input v-model="form.answer_11" placeholder="请输入答案11"></el-input>
            </el-form-item>
          </div>
          <el-form-item label="选项1" prop="option_11_1">
            <el-input v-model="form.option_11_1" placeholder="请输入选项1"></el-input>
          </el-form-item>
          <el-form-item label="选项2" prop="option_11_2">
            <el-input v-model="form.option_11_2" placeholder="请输入选项2"></el-input>
          </el-form-item>
          <el-form-item label="选项3" prop="option_11_3">
            <el-input v-model="form.option_11_3" placeholder="请输入选项3"></el-input>
          </el-form-item>
          <el-form-item label="选项4" prop="option_11_4">
            <el-input v-model="form.option_11_4" placeholder="请输入选项4"></el-input>
          </el-form-item>
          <el-form-item label="选项5" prop="option_11_5">
            <el-input v-model="form.option_11_5" placeholder="请输入选项5"></el-input>
          </el-form-item>
          <el-form-item label="选项6" prop="option_11_6">
            <el-input v-model="form.option_11_6" placeholder="请输入选项6"></el-input>
          </el-form-item>
          <el-form-item label="选项7" prop="option_11_7">
            <el-input v-model="form.option_11_7" placeholder="请输入选项7"></el-input>
          </el-form-item>
          <el-divider></el-divider>

          <!--问题12-->
          <div style="margin-bottom: 15px">
            <el-form-item label="问题12" prop="question_12">
              <el-input v-model="form.question_12" placeholder="请输入问题12"></el-input>
            </el-form-item>
            <el-form-item label="答案12" prop="answer_12">
              <el-input v-model="form.answer_12" placeholder="请输入答案12"></el-input>
            </el-form-item>
          </div>
          <el-form-item label="选项1" prop="option_12_1">
            <el-input v-model="form.option_12_1" placeholder="请输入选项1"></el-input>
          </el-form-item>
          <el-form-item label="选项2" prop="option_12_2">
            <el-input v-model="form.option_12_2" placeholder="请输入选项2"></el-input>
          </el-form-item>
          <el-form-item label="选项3" prop="option_12_3">
            <el-input v-model="form.option_12_3" placeholder="请输入选项3"></el-input>
          </el-form-item>
          <el-form-item label="选项4" prop="option_12_4">
            <el-input v-model="form.option_12_4" placeholder="请输入选项4"></el-input>
          </el-form-item>
          <el-form-item label="选项5" prop="option_12_5">
            <el-input v-model="form.option_12_5" placeholder="请输入选项5"></el-input>
          </el-form-item>
          <el-form-item label="选项6" prop="option_12_6">
            <el-input v-model="form.option_12_6" placeholder="请输入选项6"></el-input>
          </el-form-item>
          <el-form-item label="选项7" prop="option_12_7">
            <el-input v-model="form.option_12_7" placeholder="请输入选项7"></el-input>
          </el-form-item>
          <el-divider></el-divider>

          <!--问题13-->
          <div style="margin-bottom: 15px">
            <el-form-item label="问题13" prop="question_13">
              <el-input v-model="form.question_13" placeholder="请输入问题13"></el-input>
            </el-form-item>
            <el-form-item label="答案13" prop="answer_13">
              <el-input v-model="form.answer_13" placeholder="请输入答案13"></el-input>
            </el-form-item>
          </div>
          <el-form-item label="选项1" prop="option_13_1">
            <el-input v-model="form.option_13_1" placeholder="请输入选项1"></el-input>
          </el-form-item>
          <el-form-item label="选项2" prop="option_13_2">
            <el-input v-model="form.option_13_2" placeholder="请输入选项2"></el-input>
          </el-form-item>
          <el-form-item label="选项3" prop="option_13_3">
            <el-input v-model="form.option_13_3" placeholder="请输入选项3"></el-input>
          </el-form-item>
          <el-form-item label="选项4" prop="option_13_4">
            <el-input v-model="form.option_13_4" placeholder="请输入选项4"></el-input>
          </el-form-item>
          <el-form-item label="选项5" prop="option_13_5">
            <el-input v-model="form.option_13_5" placeholder="请输入选项5"></el-input>
          </el-form-item>
          <el-form-item label="选项6" prop="option_13_6">
            <el-input v-model="form.option_13_6" placeholder="请输入选项6"></el-input>
          </el-form-item>
          <el-form-item label="选项7" prop="option_13_7">
            <el-input v-model="form.option_13_7" placeholder="请输入选项7"></el-input>
          </el-form-item>
          <el-divider></el-divider>

          <!--问题14-->
          <div style="margin-bottom: 15px">
            <el-form-item label="问题14" prop="question_14">
              <el-input v-model="form.question_14" placeholder="请输入问题14"></el-input>
            </el-form-item>
            <el-form-item label="答案14" prop="answer_14">
              <el-input v-model="form.answer_14" placeholder="请输入答案14"></el-input>
            </el-form-item>
          </div>
          <el-form-item label="选项1" prop="option_14_1">
            <el-input v-model="form.option_14_1" placeholder="请输入选项1"></el-input>
          </el-form-item>
          <el-form-item label="选项2" prop="option_14_2">
            <el-input v-model="form.option_14_2" placeholder="请输入选项2"></el-input>
          </el-form-item>
          <el-form-item label="选项3" prop="option_14_3">
            <el-input v-model="form.option_14_3" placeholder="请输入选项3"></el-input>
          </el-form-item>
          <el-form-item label="选项4" prop="option_14_4">
            <el-input v-model="form.option_14_4" placeholder="请输入选项4"></el-input>
          </el-form-item>
          <el-form-item label="选项5" prop="option_14_5">
            <el-input v-model="form.option_14_5" placeholder="请输入选项5"></el-input>
          </el-form-item>
          <el-form-item label="选项6" prop="option_14_6">
            <el-input v-model="form.option_14_6" placeholder="请输入选项6"></el-input>
          </el-form-item>
          <el-form-item label="选项7" prop="option_14_7">
            <el-input v-model="form.option_14_7" placeholder="请输入选项7"></el-input>
          </el-form-item>
          <el-divider></el-divider>


          <!--问题15-->
          <div style="margin-bottom: 15px">
            <el-form-item label="问题15" prop="question_15">
              <el-input v-model="form.question_15" placeholder="请输入问题15"></el-input>
            </el-form-item>
            <el-form-item label="答案15" prop="answer_15">
              <el-input v-model="form.answer_15" placeholder="请输入答案15"></el-input>
            </el-form-item>
          </div>
          <el-form-item label="选项1" prop="option_15_1">
            <el-input v-model="form.option_15_1" placeholder="请输入选项1"></el-input>
          </el-form-item>
          <el-form-item label="选项2" prop="option_15_2">
            <el-input v-model="form.option_15_2" placeholder="请输入选项2"></el-input>
          </el-form-item>
          <el-form-item label="选项3" prop="option_15_3">
            <el-input v-model="form.option_15_3" placeholder="请输入选项3"></el-input>
          </el-form-item>
          <el-form-item label="选项4" prop="option_15_4">
            <el-input v-model="form.option_15_4" placeholder="请输入选项4"></el-input>
          </el-form-item>
          <el-form-item label="选项5" prop="option_15_5">
            <el-input v-model="form.option_15_5" placeholder="请输入选项5"></el-input>
          </el-form-item>
          <el-form-item label="选项6" prop="option_15_6">
            <el-input v-model="form.option_15_6" placeholder="请输入选项6"></el-input>
          </el-form-item>
          <el-form-item label="选项7" prop="option_15_7">
            <el-input v-model="form.option_15_7" placeholder="请输入选项7"></el-input>
          </el-form-item>
          <el-divider></el-divider>


        </el-form>

      <div  style="text-align: center;margin-top: 40px">

        <el-button type="primary" @click="update" size="medium" style="margin-right: 10px;margin-top: 15px">更新问卷</el-button>
        <el-button type="warning" @click="goBack" size="medium">返回上步</el-button>

      </div>
    </div>
  </div>
</template>

<script>
import request from "@/utils/request";
import Cookies from "js-cookie"; // 导入封装好的axios请求函数

export default {
  name: "createLab",
  created() {

    this.form.course = this.$route.query.course
    this.form.lab = this.$route.query.lab
    // this.load()
    this.form.teacher_number = this.teacher.teacher_number
    this.form.questionnaire_name = this.$route.query.questionnaire_name
    request.get("questionnaire/" + this.form.teacher_number + "/" + this.form.course + "/" + this.form.lab + "/" + this.form.questionnaire_name).then(res=>{
      this.form = res.data
    })
  },

  data(){

    return{

      teacher: Cookies.get('teacher') ? JSON.parse(Cookies.get('teacher')) : {},
      form:{
        questionnaire_name:'',
        course :'',
        lab:'',
        teacher_number:'',
        question_1:'',
        question_2:'',
        question_3:'',
        question_4:'',
        question_5:'',
        question_6:'',
        question_7:'',
        question_8:'',
        question_9:'',
        question_10:'',
        question_11:'',
        question_12:'',
        question_13:'',
        question_14:'',
        question_15:'',
        answer_1:'',
        answer_2:'',
        answer_3:'',
        answer_4:'',
        answer_5:'',
        answer_6:'',
        answer_7:'',
        answer_8:'',
        answer_9:'',
        answer_10:'',
        answer_11:'',
        answer_12:'',
        answer_13:'',
        answer_14:'',
        answer_15:'',
        option_1_1:'',
        option_1_2:'',
        option_1_3:'',
        option_1_4:'',
        option_1_5:'',
        option_1_6:'',
        option_1_7:'',

        option_2_1:'',
        option_2_2:'',
        option_2_3:'',
        option_2_4:'',
        option_2_5:'',
        option_2_6:'',
        option_2_7:'',

        option_3_1:'',
        option_3_2:'',
        option_3_3:'',
        option_3_4:'',
        option_3_5:'',
        option_3_6:'',
        option_3_7:'',

        option_4_1:'',
        option_4_2:'',
        option_4_3:'',
        option_4_4:'',
        option_4_5:'',
        option_4_6:'',
        option_4_7:'',

        option_5_1:'',
        option_5_2:'',
        option_5_3:'',
        option_5_4:'',
        option_5_5:'',
        option_5_6:'',
        option_5_7:'',

        option_6_1:'',
        option_6_2:'',
        option_6_3:'',
        option_6_4:'',
        option_6_5:'',
        option_6_6:'',
        option_6_7:'',

        option_7_1:'',
        option_7_2:'',
        option_7_3:'',
        option_7_4:'',
        option_7_5:'',
        option_7_6:'',
        option_7_7:'',

        option_8_1:'',
        option_8_2:'',
        option_8_3:'',
        option_8_4:'',
        option_8_5:'',
        option_8_6:'',
        option_8_7:'',

        option_9_1:'',
        option_9_2:'',
        option_9_3:'',
        option_9_4:'',
        option_9_5:'',
        option_9_6:'',
        option_9_7:'',

        option_10_1:'',
        option_10_2:'',
        option_10_3:'',
        option_10_4:'',
        option_10_5:'',
        option_10_6:'',
        option_10_7:'',

        option_11_1:'',
        option_11_2:'',
        option_11_3:'',
        option_11_4:'',
        option_11_5:'',
        option_11_6:'',
        option_11_7:'',

        option_12_1:'',
        option_12_2:'',
        option_12_3:'',
        option_12_4:'',
        option_12_5:'',
        option_12_6:'',
        option_12_7:'',

        option_13_1:'',
        option_13_2:'',
        option_13_3:'',
        option_13_4:'',
        option_13_5:'',
        option_13_6:'',
        option_13_7:'',

        option_14_1:'',
        option_14_2:'',
        option_14_3:'',
        option_14_4:'',
        option_14_5:'',
        option_14_6:'',
        option_14_7:'',

        option_15_1:'',
        option_15_2:'',
        option_15_3:'',
        option_15_4:'',
        option_15_5:'',
        option_15_6:'',
        option_15_7:'',

      },
      rules: {
        questionnaire_name: [
          {required: true, message: '请输入实验名称', trigger: 'blur'},
        ],
      }
    }
  },
  methods:{
    load(){

    },
    update(){
      this.$refs["ruleForm"].validate((valid)=>{
        if(valid){
          request.put('/questionnaire/update',this.form).then(res =>{
            if(res.code === '200'){
              this.$notify({
                title: "操作提示",
                message: "更新问卷成功",
                dangerouslyUseHTMLString: true,
                duration: 2000,

              });
            }else{
              this.$notify({
                title: "操作提示",
                message: res.msg,
                dangerouslyUseHTMLString: true,
                duration: 2000,

              });
            }
          })
        }else{
          this.$notify({
            title: "操作提示",
            message: "请输入问卷名称",
            dangerouslyUseHTMLString: true,
            duration: 2000,
          });
        }
      })

    },
    goBack(){
      this.$router.push("/startEditQuestionnaire")
    }
  },
}
</script>

<style scoped>

</style>