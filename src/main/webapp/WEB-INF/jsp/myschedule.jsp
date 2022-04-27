<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %><!-- 使用JSTL,此處使用FOR-EACH -->
<!DOCTYPE html>
<html lang="en">

<head>
  <meta charset="utf-8">
  <meta content="width=device-width, initial-scale=1.0" name="viewport">

  <title>Together Learning - My Schedule</title>

  <meta content="" name="description">
  <meta content="" name="keywords">


  <!-- Favicons -->
  <link href="assets/img/TL2.png" rel="icon">
  <link href="assets/img/apple-touch-icon.png" rel="apple-touch-icon">
  
  <!-- Google Fonts -->
  <link href="https://fonts.googleapis.com/css?family=Open+Sans:300,300i,400,400i,600,600i,700,700i|Raleway:300,300i,400,400i,500,500i,600,600i,700,700i|Poppins:300,300i,400,400i,500,500i,600,600i,700,700i" rel="stylesheet">

  <!-- Vendor CSS Files -->
  <link href="assets/vendor/animate.css/animate.min.css" rel="stylesheet">
  <link href="assets/vendor/aos/aos.css" rel="stylesheet">
  <link href="assets/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
  <link href="assets/vendor/bootstrap-icons/bootstrap-icons.css" rel="stylesheet">
  <link href="assets/vendor/boxicons/css/boxicons.min.css" rel="stylesheet">
  <link href="assets/vendor/remixicon/remixicon.css" rel="stylesheet">
  <link href="assets/vendor/swiper/swiper-bundle.min.css" rel="stylesheet">

  <!-- Template Main CSS File -->
  <link href="assets/css/style.css" rel="stylesheet">

  <script src="assets/js/jquery.min.js"></script>
  <script type="text/javascript">

        $(function () {

            //以上課按鈕為例 //先隱藏按鈕
            $(".scheduleBtn").hide();
            $(".scheduleBtn2").hide();

            $(".courseDate").each(function () {

                //取得目前時間
                let currentTime = new Date();
                let courseDateInput = this;

                //取得上課時間(字串)
                let classTimeStr = $(courseDateInput).val();

                //從上課時間(字串)擷取年、月、日、時、分、秒的值(字串)
                let found = classTimeStr.match(/(\d{4})-(\d{2})-(\d{2}) (\d{2}):(\d{2}):(\d{2})\.0/);                
                console.log(JSON.stringify(found));
                //例如["2022-04-06 20:52:10.0","2022","04","06","20","52","10"]

                var year = found[1], month = found[2], day = found[3],hour = found[4],minutes = found[5],seconds = found[6];
                console.log(year,month,day,hour,minutes,seconds); 
                //例如2022 04 06 20 52 10

                //建立一個對應我們所取得的上課時間(字串)的Date物件
                let classTime = new Date(year, parseInt(month) - 1, day, hour, minutes, seconds);
                console.log(classTime);
                //new Date(year, month[, day[, hour[, minutes[, seconds[, milliseconds]]]]]);
                
                //計算開始上課(前10分鐘)到目前的毫秒數
                
                let milliseconds = classTime.getTime() - currentTime.getTime();
                console.log(milliseconds);

//----------------------- 上課按鈕_時間判斷-------------------------------
                if(milliseconds > 10 * 60 * 1000 && milliseconds < 7 * 24 * 60 * 60 * 1000 ){
                    setTimeout(function () {
                        $(courseDateInput).next().show();
                    }, milliseconds-10 * 60 * 1000);
                    //延遲執行function的時間：milliseconds減10分鐘 ==>等於提前10分鐘顯示上課按鈕
                }


                if(milliseconds <= 10 * 60 * 1000 && milliseconds >= 50*-60*1000){
					//上課前10分鐘及開始上課的50分鐘內
					
                	$(courseDateInput).next().show();
                }

//----------------------- 取消按鈕_時間判斷-------------------------------

                if(milliseconds > 24*60*60*1000){
                     $("#scheduleCancelBtn"+$(courseDateInput).prev().val()).show();

                }
            });
        });

    </script>

  <!-- =======================================================
  * Template Name: Mentor - v4.7.0
  * Template URL: https://bootstrapmade.com/mentor-free-education-bootstrap-theme/
  * Author: BootstrapMade.com
  * License: https://bootstrapmade.com/license/
  ======================================================== -->
</head>

<body>

  <!-- ======= Header ======= -->
  <header id="header" class="fixed-top">
    <div class="container d-flex align-items-center">

      <img class=img src="assets/img/TL2.png">
      <h1 class="logo me-auto"><a href="齊上首頁.html">Together Learning</a></h1>
      <!-- Uncomment below if you prefer to use an image logo -->
      <!-- <a href="index.html" class="logo me-auto"><img src="assets/img/logo.png" alt="" class="img-fluid"></a>-->

      <nav id="navbar" class="navbar order-last order-lg-0">
        <ul>
          <li><a href="齊上首頁.html">首頁</a></li>
          <li><a href="about.html">關於齊上</a></li>
          <li class="dropdown"><a href="/subjects"><span>線上真人家教</span> <i class="bi bi-chevron-down"></i></a>
            <ul>
              <li><a href="/courses?subjectId=3">國文</a></li>
              <li><a href="/courses?subjectId=1">英文</a></li>
              <li><a href="/courses?subjectId=2">數學</a></li>
            </ul>
          </li>
          <li><a href="trainers.html">測驗中心</a></li>
          <li><a href="events.html">點數購買</a></li>
          <li><a href="contact.html">聯絡我們</a></li>
          <li><a href="登入.html">登入</a></li>
          <a href="#" class=""><i class="bi bi-cart"></i></a>

        </ul>
        <i class="bi bi-list mobile-nav-toggle"></i>
      </nav><!-- .navbar -->



    </div>
  </header><!-- End Header -->

  <main id="main" data-aos="fade-in">

    <!-- ======= Breadcrumbs ======= -->
    <div class="breadcrumbs">
      <div class="container">
        <h2> 一起學習 Together Learning </h2>
        <p>不管你在找的是針對檢定考試的學測課程 、 指考課程 等等，
          還是以紮實腳步提升的實力，我們都可以為你一對一打造屬於你的課程！</p>
      </div>
    </div><!-- End Breadcrumbs -->

    <!-- ======= Schedule Section ======= -->

    <section id="events" class="events">
      <div class="container" data-aos="fade-up">

        <div class="row">
          <div class="col-md-12 d-flex align-items-stretch">
            <div class="card">
              <div class="card-body">
                <h5 class="card-title">我的課表</h5>
                <table class="card-table">
                    <tr class="row-title">
                      <td>上課日期</td>
                      <td>上課時間</td>
                      <td>授課老師</td>
                      <td>上課連結</td>
                      <td>取消選課</td>
                    </tr>

		<c:forEach  items="${courRecoList}"  var="data">                     
                    
                    <tr class="row-details">
                      <td>${data.stringDate }</td> 
                      <td>${data.stringTime }</td>
                      <td>${data.tutorName}</td>
                      <td>
                     	  <input type="hidden" value="${data.courseRecordId}">
                     	  <input type="hidden" class = "courseDate" value="${data.courseDate}">
                      	  <input type="button" value="上課" onclick="window.open('${data.courses.tutors.meetingUrl}')" class="scheduleBtn">
                      </td>
        			  <td>
        		<form action="deleteCourseRecord" method="post">
                      	<input type="submit" value="取消"  class="scheduleBtn2" id="scheduleCancelBtn${data.courseRecordId}" onclick="if(confirm('您確定取消此課程嗎? 要確定餒～')) return true;else return false">
                      	<input type="hidden" value="${data.courseRecordId}" name="courseRecordId" class="scheduleBtn2">                      
                      	<input type="hidden" value="${data.studentId}" name="studentId">                      
       			</form>            
                      </td>
                    </tr>
                    
 		</c:forEach>                   

 
                    
                </table>
              </div>
            </div>
          </div>
        </div>
      </div>
    </section><!-- End Events Section -->

  </main><!-- End #main -->


  <!-- ======= Footer ======= -->
  <footer id="footer">

    <div class="footer-top">
      <div class="container">
        <div class="row">

          <div class="col-lg-3 col-md-6 footer-contact">
            <h3>Together Learning</h3>
              <strong>Phone:</strong> +1 5589 55488 55<br>
              <strong>Email:</strong> info@example.com<br>
          </div>

          <div class="col-lg-2 col-md-6 footer-links">
            <h4>Together Learning</h4>
            <ul>
              <li><i class="bx bx-chevron-right"></i> <a href="#">首頁</a></li>
              <li><i class="bx bx-chevron-right"></i> <a href="#">關於齊上</a></li>
              <li><i class="bx bx-chevron-right"></i> <a href="#">聯絡我們</a></li>
              <li><i class="bx bx-chevron-right"></i> <a href="#">服務條款隱私聲明</a></li>
            </ul>
          </div>

          <div class="col-lg-3 col-md-6 footer-links">
            <h4>學生回饋</h4>
            <ul>
              <li><i class="bx bx-chevron-right"></i> <a href="#">學生心路歷程</a></li>
              <li><i class="bx bx-chevron-right"></i> <a href="#">老師課程評價</a></li>
            </ul>
          </div>

          <div class="col-lg-4 col-md-6 footer-newsletter">
            <h4>獲取最新資訊</h4>
            <p>訂閱我們獲取最新資訊</p>
            <form action="" method="post">
              <input type="email" name="email"><input type="submit" value="訂閱">
            </form>
          </div>

        </div>
      </div>
    </div>

    <div class="container d-md-flex py-4">

      <div class="me-md-auto text-center text-md-start">
        <div class="copyright">
          &copy; Copyright <strong><span>Mentor</span></strong>. All Rights Reserved
        </div>
        <div class="credits">
          <!-- All the links in the footer should remain intact. -->
          <!-- You can delete the links only if you purchased the pro version. -->
          <!-- Licensing information: https://bootstrapmade.com/license/ -->
          <!-- Purchase the pro version with working PHP/AJAX contact form: https://bootstrapmade.com/mentor-free-education-bootstrap-theme/ -->
          Designed by <a href="https://bootstrapmade.com/">BootstrapMade</a>
        </div>
      </div>
      <div class="social-links text-center text-md-right pt-3 pt-md-0">
        <a href="#" class="twitter"><i class="bx bxl-twitter"></i></a>
        <a href="#" class="facebook"><i class="bx bxl-facebook"></i></a>
        <a href="#" class="instagram"><i class="bx bxl-instagram"></i></a>
        <a href="#" class="google-plus"><i class="bx bxl-skype"></i></a>
        <a href="#" class="linkedin"><i class="bx bxl-linkedin"></i></a>
      </div>
    </div>
  </footer><!-- End Footer -->

  <div id="preloader"></div>
  <a href="#" class="back-to-top d-flex align-items-center justify-content-center"><i class="bi bi-arrow-up-short"></i></a>

  <!-- Vendor JS Files -->
  <script src="assets/vendor/purecounter/purecounter.js"></script>
  <script src="assets/vendor/aos/aos.js"></script>
  <script src="assets/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
  <script src="assets/vendor/swiper/swiper-bundle.min.js"></script>
  <script src="assets/vendor/php-email-form/validate.js"></script>

  <!-- Template Main JS File -->
  <script src="assets/js/main.js"></script>

  

</body>
</html>