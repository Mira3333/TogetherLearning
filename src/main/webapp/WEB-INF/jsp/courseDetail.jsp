<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html lang="en">

<head>
  <meta charset="utf-8">
  <meta content="width=device-width, initial-scale=1.0" name="viewport">

  <title>Together Learning - Tutor</title>
  <style type="text/css">
  
  .reminder{
  	color: red ;
  	margin:8px 0px ;

  
  }
  
  </style>
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

  
  
	$(document).ready(function(){
	
	  $('#chooseCourse').click(function(){
	
			
		if(document.form1.courseDate.value==''){
		   alert('請選擇日期');
		   document.form1.courseDate.focus();
		   return false;
		}
		if(document.form1.courseTime.value==''){
		   alert('請選擇時間');
		   document.form1.courseTime.focus();
		   return false;
		}

		  
	    var course_id = parseInt($("#courseId").val());
		var subject_id = parseInt($("#subjectId").val());
		var required_points = parseInt($("#requiredPoints").val());
		var tutor_name = $("#tutorName").val();
		var student_id = parseInt($("#studentId").val());
		var course_date = $("#courseDate").val();
		var course_time = $("#courseTime").val();

		var data = {"courseId": 13,
		           "studentId":student_id,
		           "subjectId":subject_id,
		           "courseDate":course_date,
		           "courseTime":course_time,
		           "requiredPoints":required_points,
		           "tutorName":tutor_name};

	    $.ajax
	    ({ 
	        url: '/addCourseRecord',
	        data: JSON.stringify(data),
	        type: 'post',
	        dataType : "text", // 網頁預期從Server接收的資料型態 //
	        contentType:'application/json',// 網頁要送到Server的資料型態 //
	        success: function(result)
	        {
		        alert(result);
	        },
	        
			error:function(xhr)
	        {
		        console.log(xhr);
	        }
	    });
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
    <div class="breadcrumbs" data-aos="fade-in">
      <div class="container">
        <h2> 一起學習 Together Learning </h2>
        <p>不管你在找的是針對檢定考試的學測課程 、 指考課程 等等，
          還是以紮實腳步提升的實力，我們都可以為你一對一打造屬於你的課程！</p>
      </div>
    </div><!-- End Breadcrumbs -->

    <!-- ======= Cource Details Section ======= -->
    <section id="course-details" class="course-details">
      <div class="container" data-aos="fade-up">

        <div class="row">
          <div class="col-lg-8">
            <!-- <img src="assets/img/course-details.jpg" class="img-fluid" alt=""> -->
            <iframe width="600" height="350" src="https://www.youtube.com/embed/R8LK2pUyovM" title="YouTube video player" frameborder="0" 
            allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture" allowfullscreen></iframe>
            <h3>${courses.introTitle}</h3>
            <p>
              ${courses.introContents}
            </p>
          </div>
          <div class="col-lg-4">

            <div class="course-info d-flex justify-content-between align-items-center">
              <h5>教師</h5>
              <p>${tutors.tutorName}</p>
            </div>

            <div class="course-info d-flex justify-content-between align-items-center">
              <h5>課程點數</h5>
              <p>${courses.requiredPoints}P/H</p>
            </div>
<!-- ============================選課表單===================================== -->
            <form id="form1" name="form1">
              <input type="hidden" value = "${ courses.courseId }" name="courseId" id="courseId">
              <input type="hidden" value = "${ courses.subjectId }" name="subjectId" id="subjectId">
              <input type="hidden" value = "${ courses.requiredPoints }" name="requiredPoints" id="requiredPoints">
              <input type="hidden" value = "${ tutors.tutorName }" name="tutorName" id="tutorName">
              <input type="hidden" value = "3" name="studentId" id="studentId"> <!-- studentId之後要改成從session裡抓取，而非寫死 -->
              <div id="datepicker">
                <p>
                  選擇日期：
                  <input type="date" class="datepicker" name = "courseDate" id="courseDate" value="請選擇日期">
                </p>
                <p>
                  選擇時段：
                  <select name="courseTime" class="time" id="courseTime" >
                    <option value="">請選擇時間</option>
                    <option value="08:00">8:00-8:50</option>
                    <option value="09:00">9:00-9:50</option>
                    <option value="10:00">10:00-10:50</option>
                    <option value="11:00">11:00-11:50</option>
                    <option value="12:00">12:00-12:50</option>
                    <option value="13:00">13:00-13:50</option>
                    <option value="14:00">14:00-14:50</option>
                    <option value="15:00">15:00-15:50</option>
                    <option value="16:00">16:00-16:50</option>
                    <option value="17:00">17:00-17:50</option>
                    <option value="18:00">18:00-18:50</option>
                    <option value="19:00">19:00-19:50</option>
                    <option value="20:00">20:00-20:50</option>
                    <option value="21:00">21:00-21:50</option>
                    <option value="23:00">22:00-22:50</option>
                    <option value="23:00">23:00-23:50</option>
                </select>
                </p>
                <div>
                  <input type="button" class="send" id="chooseCourse" value="送出"><br>
                </div>
              </div>
            </form>
            
            
<!-- ============================選課表單===================================== -->            
              
            </div>
          </div>

      </div>
    </section><!-- End Cource Details Section -->

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
            </p>
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