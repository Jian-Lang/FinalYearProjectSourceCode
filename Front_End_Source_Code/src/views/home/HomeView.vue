<!--
  * @Author: Lang Jian
  * @Date: 2023/2/9
  * @Version 1.0
-->
<template>
  <div >
    <div>
      <!--1-->
<!--      <div class="item" style="display: inline-block">{{ job }} <span style="color: red;">{{ name }}</span> 你好！欢迎使用虚拟现实实验云服务平台</div>-->
      <div class="item">
         <span class="job">{{ job }}</span> &nbsp;<span class="name">{{ name }}&nbsp;</span> 您好！欢迎使用【虚拟现实实验云服务平台】,&nbsp; 祝您有个愉快的体验！如有问题,&nbsp; 可联系&nbsp; <span style="color: crimson">至尊管理员</span>,&nbsp; 联系方式为: 13838983567
      </div>
    </div>
    <div class="container" style="text-align: center;margin-top: 30px">
      <div class="slide active"><img :src="require('@/assets/image1.jpg')"></div>
      <div class="slide"><img :src="require('@/assets/image2.jpg')"></div>
      <div class="slide"><img :src="require('@/assets/image3.jpg')"></div>
      <div class="slide"><img :src="require('@/assets/image4.jpg')"></div>
      <div class="slide"><img :src="require('@/assets/image5.jpg')"></div>
      <div class="prev" @click="plusSlides(-1)">&#10094;</div>
      <div class="next" @click="plusSlides(1)">&#10095;</div>
      <div class="dots">
        <span class="dot active" onclick="currentSlide(1)"></span>
        <span class="dot" onclick="currentSlide(2)"></span>
        <span class="dot" onclick="currentSlide(3)"></span>
        <span class="dot" onclick="currentSlide(4)"></span>
        <span class="dot" onclick="currentSlide(5)"></span>
      </div>
    </div>
  </div>

</template>
<style>
.item {
  background-color: #f5f5f5;
  border-radius: 5px;
  padding: 10px;
  font-size: 18px;
  font-weight: bold;
  text-align: center;
}

.job {
  color: #008080;
  font-weight: bold;
}

.name {
  color: #ff6347;
  font-weight: bold;
}
/*.item {*/
/*  background-color: #F2F2F2;*/
/*  color: #333;*/
/*  font-size: 20px;*/
/*  font-weight: bold;*/
/*  text-align: center;*/
/*  padding: 20px;*/
/*  border-radius: 5px;*/
/*  box-shadow: 0 2px 4px rgba(0,0,0,0.2);*/
/*  margin: 20px auto;*/
/*  width: 60%;*/
/*  max-width: 600px;*/
/*}*/
.container {
  width: 100%;
  height: 500px;
  position: relative;
  overflow: hidden;
}

.slide {
  position: absolute;
  top: 0;
  left: 0;
  width: 100%;
  height: 100%;
  opacity: 0;
  transition: opacity 1s ease-in-out;
}

.slide.active {
  opacity: 1;
}

.prev,
.next {
  position: absolute;
  top: 50%;
  transform: translateY(-50%);
  font-size: 30px;
  cursor: pointer;
  z-index: 1;
  color: #fff;
  background-color: rgba(0, 0, 0, 0.5);
  padding: 10px;
}

.prev {
  left: 203px;
}

.next {
  right: 203px;
}

.dots {
  position: absolute;
  bottom: 20px;
  left: 50%;
  transform: translateX(-50%);
  display: flex;
  align-items: center;
  justify-content: center;
}

.dot {
  width: 10px;
  height: 10px;
  border-radius: 50%;
  background-color: #ccc;
  margin: 0 5px;
  cursor: pointer;
}

.dot.active {
  background-color: #000;
}
</style>
<script>
import Cookies from "js-cookie";
import request from "@/utils/request";

export default {
  created(){
    request.get('/admin/' + this.admin.id).then(res => {
        this.admin = res.data
    })
    if(this.identifier == 1){
      this.name = this.admin.username
      this.job = "管理员"
    }
    else if(this.identifier == 2){
      this.name = this.teacher.teacher_name
      this.job = "教师"
    }
    else if(this.identifier == 3){
      this.name = this.student.student_name
      this.job = "学生"
    }
  },
  data(){
    return {
      slideIndex: 1,
      admin: Cookies.get('admin') ? JSON.parse(Cookies.get('admin')) : {},
      student: Cookies.get('student') ? JSON.parse(Cookies.get('student')) : {},
      teacher: Cookies.get('teacher') ? JSON.parse(Cookies.get('teacher')) : {},
      identifier: Cookies.get('identifier'),
      name: "",
      job: ""
    }
  },
  mounted() {
    this.showSlides(this.slideIndex);
    this.slideInterval = setInterval(() => {
      this.plusSlides(1);
    }, 2000);
  },

  methods: {
    plusSlides(n) {
      this.showSlides(this.slideIndex += n);
    },

    currentSlide(n) {
      this.showSlides(this.slideIndex = n);
    },

    showSlides(n) {
      let i;
      let slides = document.getElementsByClassName("slide");
      let dots = document.getElementsByClassName("dot");

      if (n > slides.length) {
        this.slideIndex = 1;
      }

      if (n < 1) {
        this.slideIndex = slides.length;
      }

      for (i = 0; i < slides.length; i++) {
        slides[i].className = "slide";
      }

      for (i = 0; i < dots.length; i++) {
        dots[i].className = "dot";
      }

      slides[this.slideIndex - 1].className = "slide active";
      dots[this.slideIndex - 1].className = "dot active";
    }
  }
}



</script>

<style>
.item{
  margin: 10px 0;
}
</style>
