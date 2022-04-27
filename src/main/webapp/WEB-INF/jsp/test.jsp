<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %><!-- 使用JSTL,此處使用FOR-EACH -->

<!DOCTYPE html>
<html lang="en">

<head>
  <meta charset="utf-8">
  <meta content="width=device-width, initial-scale=1.0" name="viewport">

  <title>Together Learning - Test Center</title>
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

  function formSubmit(){
  	document.getElementById("testForm").submit()
  }
  
  </script>

</head>

<body>


  <main id="main" data-aos="fade-in">
  <!-- ======= Header ======= -->
  
  
  <header id="header" class="fixed-top">
    <div class="container d-flex align-items-center">

      <h1 class="logo me-auto"><a >${ test.testName}</a></h1>
      <h1 class="logo me-auto"><a ></a></h1>

    </div>
  </header>

  <form action="/countAnswer" method="post" name="testForm" id="testForm">
   <input type="hidden" value = "${ test.testId }" name="testId" id="testId">
   <input type="hidden" value = "${ student.studentId }" name="studentId" id="studentId">
  
    <!-- ======= Courses Section ======= -->
    <section id="courses" class="courses">
      <div class="container" data-aos="fade-up">
          <div class="row" data-aos="zoom-in" data-aos-delay="100">
  	   
  	   		<c:forEach items="${testQuestionsList}"  var="data" varStatus="question">
  	   		
	          <div class="col-6">
	            <div class="course-item">
	              <div class="course-content">
		               <p>${ data.question }</p>
	               		 <div class="trainer d-flex justify-content-between align-items-center">
				   			<!-- ======================= 題目 ========================= -->		
				   		   <div class="col-6">
				   			<div>
					   			<div class="form-check">
									<input class="form-check-input" type="radio" name="q${ question.index }" id="${ data.testQuestionId }" value="${ data.testQuestionId }|a">
									<label class="form-check-label" for="${ data.testQuestionId }">(A)  ${ data.optionA }</label>
								</div>
					   			<div class="form-check">
									<input class="form-check-input" type="radio" name="q${ question.index }" id="${ data.testQuestionId }" value="${ data.testQuestionId }|b">
									<label class="form-check-label" for="${ data.testQuestionId }">(B)  ${ data.optionB }</label>
								</div>
					   			<div class="form-check">
									<input class="form-check-input" type="radio" name="q${ question.index }" id="${ data.testQuestionId }" value="${ data.testQuestionId }|c">
									<label class="form-check-label" for="${ data.testQuestionId }">(C)  ${ data.optionC }</label>
								</div>
					   			<div class="form-check">
									<input class="form-check-input" type="radio" name="q${ question.index }" id="${ data.testQuestionId }" value="${ data.testQuestionId }|d">
									<label class="form-check-label" for="${ data.testQuestionId }">(D)  ${ data.optionD }</label>
								</div>
						    </div>
	                      </div>
	                    </div>
	                 </div>
	              </div> 
	           </div>
	           
  	   		</c:forEach>
  	   		
  	   	 </div>
  	   	 
	  <nav id="navbar" class="navbar order-last order-lg-0">
	     <ul>
	       <li><input type="button" onclick="formSubmit()" value="完成測驗" class="testSubmit" id="testSubmit"></li>
	     </ul>
	     <i class="bi bi-list mobile-nav-toggle"></i>
	  </nav><!-- .navbar -->
	      
      </div>	
  </section><!-- End Courses Section -->
  </form>
  </main><!-- End #main -->

  <!-- ======= Footer ======= -->
  <footer id="footer">


    <div class="container d-md-flex py-4 ">

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