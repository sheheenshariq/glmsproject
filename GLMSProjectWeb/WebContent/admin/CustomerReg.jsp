<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
 pageEncoding="ISO-8859-1"  import="java.util.*,glms.dl.*,glms.bl.*,glms.dto.*" %>
 
<!DOCTYPE html>
<html lang="en">
<head>
<link href='http://fonts.googleapis.com/css?family=Open+Sans+Condensed:300' rel='stylesheet' type='text/css'>
<style type="text/css">
.form-style-8{
	font-family: 'Open Sans Condensed', arial, sans;
	width: 500px;
	padding: 30px;
	background: #FFFFFF;
	margin: 50px auto;
	box-shadow: 0px 0px 15px rgba(0, 0, 0, 0.22);
	-moz-box-shadow: 0px 0px 15px rgba(0, 0, 0, 0.22);
	-webkit-box-shadow:  0px 0px 15px rgba(0, 0, 0, 0.22);

}
.form-style-8 h2{
	background: #226df0;
	text-transform: uppercase;
	font-family: 'Open Sans Condensed', sans-serif;
	color: #ffffff;
	font-size: 18px;
	font-weight: 100;
	padding: 20px;
	margin: -30px -30px 30px -30px;
}
.form-style-8 input[type="text"],
.form-style-8 input[type="date"],
.form-style-8 input[type="datetime"],
.form-style-8 input[type="email"],
.form-style-8 input[type="number"],
.form-style-8 input[type="search"],
.form-style-8 input[type="time"],
.form-style-8 input[type="url"],
.form-style-8 input[type="password"],
.form-style-8 textarea,
.form-style-8 select 
{
	box-sizing: border-box;
	-webkit-box-sizing: border-box;
	-moz-box-sizing: border-box;
	outline: none;
	display: block;
	width: 100%;
	padding: 7px;
	border: none;
	border-bottom: 1px solid #ddd;
	background: transparent;
	margin-bottom: 10px;
	font: 16px Arial, Helvetica, sans-serif;
	height: 45px;
}
.form-style-8 textarea{
	resize:none;
	overflow: hidden;
}
.form-style-8 input[type="button"], 
.form-style-8 input[type="submit"]{
	-moz-box-shadow: inset 0px 1px 0px 0px #45D6D6;
	-webkit-box-shadow: inset 0px 1px 0px 0px #45D6D6;
	box-shadow: inset 0px 1px 0px 0px #45D6D6;
	background-color: #2CBBBB;
	border: 1px solid #27A0A0;
	display: inline-block;
	cursor: pointer;
	color: #FFFFFF;
	font-family: 'Open Sans Condensed', sans-serif;
	font-size: 14px;
	padding: 8px 18px;
	text-decoration: none;
	text-transform: uppercase;
}
.form-style-8 input[type="button"]:hover, 
.form-style-8 input[type="submit"]:hover {
	background:linear-gradient(to bottom, #34CACA 5%, #30C9C9 100%);
	background-color:#226df0;
}
</style>
<meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0, minimum-scale=1.0">
		<script type="text/javascript" src="../Validation/registrationValidation.js"></script>
		<link rel="stylesheet" href="../styles/demo.css">
		<link rel="stylesheet" href="../styles/sky-forms.css">
		<link rel="stylesheet" href="../styles/css/sky-forms-ie8.css">
		
		<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script>
		<script src="../styles/js/jquery.placeholder.min.js"></script>
		<script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script>
		<script src="../styles/js/sky-forms-ie8.js"></script>
		  
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        
         <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
        <script src='https://kit.fontawesome.com/a076d05399.js'></script>
		<meta name="description" content="">
	    <meta name="author" content="">
		<meta name='viewport' content='width=device-width, initial-scale=1'>
		<script src='https://kit.fontawesome.com/a076d05399.js'></script>

		<meta name="viewport" content="width=device-width, initial-scale=1">
		<!-- Add icon library -->
		<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">

	    <style>
		body{font-family: Arial, Helvetica, sans-serif;}
		*{box-sizing: border-box;}
		
		.input-container {
		  display: -ms-flexbox; /* IE10 */
		  display: flex;
		  width: 100%;
		  margin-bottom: 15px;
		}
		
		.icon {
		  padding: 10px;
		  background: dodgerblue;
		  color: white;
		  min-width: 50px;
		  text-align: center;
		}
		
		.input-field {
		  width: 100%;
		  padding: 10px;
		  outline: none;
		}
		
		.input-field:focus {
		  border: 2px solid dodgerblue;
		}
		
		/* Set a style for the submit button */
		.btn {
		  background-color: dodgerblue;
		  color: white;
		  padding: 15px 20px;
		  border: none;
		  cursor: pointer;
		  width: 100%;
		  opacity: 0.9;
		}
		
		.btn:hover {
		  opacity: 1;
		}
	   </style>

		  <title>Gold Loan Management System</title>
		
		  <!-- Custom fonts for this template-->
		  <link href="../styles/vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">
		  <link href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i" rel="stylesheet">
		
		  <!-- Custom styles for this template-->
		  <link href="../styles/css/sb-admin-2.min.css" rel="stylesheet">
	
	</head>

    <script src="../Validation/registrationValidation.js"> </script>
  <body id="page-top">
	
  <!-- Page Wrapper -->
  <div id="wrapper">
    <!-- Sidebar -->
     <ul class="navbar-nav bg-gradient-primary sidebar sidebar-dark accordion" id="accordionSidebar">
       <!-- Sidebar - Brand -->
        <a class="sidebar-brand d-flex align-items-center justify-content-center" href="#">
          <div class="sidebar-brand-icon rotate-n-15">
            <i class='fas fa-dice-d6' style='font-size:48px;color:red'></i>
          </div>
          <div class="sidebar-brand-text mx-3">GLMS</div>
       </a>

      <hr class="sidebar-divider my-0">

      <!-- Nav Item - Dashboard -->
      <li class="nav-item active">
        <a class="nav-link" href="Home.jsp">
        <i class='fas fa-home' style='font-size:20px'></i>
          <span>Home</span></a>
      </li>
      
     
      
      <li class="nav-item active">
        <a class="nav-link" href="../admin/CustomerDetails.jsp">
         <i class='far fa-file-alt' style='font-size:20px'></i>
          <span>Customer Details</span></a>
      </li>
      <li class="nav-item active">
        <a class="nav-link" href="../loan/LoanDetails.jsp">
        <i class='far fa-file-alt' style='font-size:20px'></i>
          <span>Loan Details</span></a>
      </li>
      <li class="nav-item active">
        <a class="nav-link" href="../emi/EmiCalInput.jsp">
    <i class='fas fa-calculator' style='font-size:20px'></i>
          <span>EMI Calculation</span></a>
      </li>
      <li class="nav-item active">
        <a class="nav-link" href="../payment/PaymentTable.jsp">
       <i class='fab fa-cc-amazon-pay' style='font-size:20px'></i>
          <span>Payment</span></a>
      </li>
      
      
         <li class="nav-item active">
        <a class="nav-link" href="../../GLMSProject/viewGoldRate">
         <i class="fas fa-fw fa-cog"></i>
          <span>Modify Gold Rate</span></a>
      </li>
      
      
         <li class="nav-item active">
        <a class="nav-link" href="../../GLMSProject/viewRoi">
          <i class="fas fa-fw fa-cog"></i>
          <span>Modify ROI</span></a>
      </li>
  </ul>



    <!-- End of Sidebar -->
    <!-- Content Wrapper -->
    <div id="content-wrapper" class="d-flex flex-column">
    <!-- Main Content -->
      <div id="content">

        <!-- Topbar -->
        <nav class="navbar navbar-expand navbar-light bg-white topbar mb-4 static-top shadow">

          <!-- Sidebar Toggle (Topbar) -->
	          <button id="sidebarToggleTop" class="btn btn-link d-md-none rounded-circle mr-3">
	              <i class="fa fa-bars"></i>
	          </button>
          <form>
	            <div>
	                <span><h3>Gold Loan Management System</h3></span>
	            </div>
          </form>

         <!-- Topbar Search 
          <form class="d-none d-sm-inline-block form-inline mr-auto ml-md-3 my-2 my-md-0 mw-100 navbar-search">
            <div class="input-group">
              <input type="text" class="form-control bg-light border-0 small" placeholder="Search for..." aria-label="Search" aria-describedby="basic-addon2">
              <div class="input-group-append">
                <button class="btn btn-primary" type="button">
                  <i class="fas fa-search fa-sm"></i>
                </button>
              </div>
            </div>
          </form> -->

          <!-- Topbar Navbar -->
          <ul class="navbar-nav ml-auto"> 

            <!-- Nav Item - Search Dropdown (Visible Only XS)
            <li class="nav-item dropdown no-arrow d-sm-none">
              <a class="nav-link dropdown-toggle" href="#" id="searchDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                <i class="fas fa-search fa-fw"></i>
              </a>  
           
            </li> -->

           <div class="topbar-divider d-none d-sm-block"></div>
            <!-- Nav Item - User Information -->
            <li class="nav-item dropdown no-arrow">
              <a class="nav-link dropdown-toggle" href="#" id="userDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                <span style="float:right;margin-left:350px" class="mr-2 d-none d-lg-inline text-gray-600 small">ADMIN</span> 
                   <!-- <img class="img-profile rounded-circle" src="https://source.unsplash.com/QAB-WJcbgJk/60x60"> --!>
               </a>
                     <!-- Dropdown - User Information -->
                <div class="dropdown-menu dropdown-menu-right shadow animated--grow-in" aria-labelledby="userDropdown">
                   <div class="dropdown-divider"></div>
                      <a class="dropdown-item" href="../styles/Login.jsp" data-toggle="modal" data-target="#logoutModal">
                         <i class="fas fa-sign-out-alt fa-sm fa-fw mr-2 text-gray-400"></i>
                           Logout
                      </a>
                </div>
              </li>
           </ul>
       </nav>
        <!-- End of Topbar -->

        <!-- Begin Page Content -->
        <div class="container-fluid">

        <!-- Begin Page Content -->
        <div class="container-fluid">

          <!-- Page Heading -->
           <div class="d-sm-flex align-items-center justify-content-between mb-4">
              <h1 class="h3 mb-0 text-gray-800"> New Customer Registration</h1>
           </div>
         
		  <!-- Scroll to Top Button-->
		  <a class="scroll-to-top rounded" href="#page-top">
		    <i class="fas fa-angle-up"></i>
		  </a>

		  <!-- Logout Modal-->
		   <div class="modal fade" id="logoutModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
		    <div class="modal-dialog" role="document">
		      <div class="modal-content">
		        <div class="modal-header">
		          <h5 class="modal-title" id="exampleModalLabel">Ready to Leave?</h5>
		            <button class="close" type="button" data-dismiss="modal" aria-label="Close">
		              <span aria-hidden="true">×</span>
		            </button>
		           </div>
		          <div class="modal-body">Select "Logout" below if you are ready to end your current session.</div>
		         <div class="modal-footer">
		            <button class="btn btn-secondary" type="button" data-dismiss="modal">Cancel</button>
		               <a class="btn btn-primary" href="../styles/Login.jsp">Logout</a>
		       </div>
		     </div>
		   </div>
		 </div>
		 

                  
         <div class="form-style-8">
         
		<form action="customer_add_process.jsp" method="post" onsubmit="return validate();" >
		
				     
							
							  <input type="text" name="txtcustomer_name" placeholder="Name" >
							     <b class="tooltip tooltip-bottom-right">Enter the Customer Name</b>
					
							<select  name="txtgender">
							    <option value="0"  selected disabled >Gender</option>
								<option  value="Male" >Male</option>
								<option value="Female" >Female</option>
							</select>
					
							<input type="text" name="txtaddress" placeholder="Address">
							  <b class="tooltip tooltip-bottom-right">Enter the Address</b>
						
							  <input type="text" name="txtaadhar"  placeholder="Aadhar Number"  >
							    <b class="tooltip tooltip-bottom-right">Enter the Aadhar number</b>
					
						    <input type="text" name="txtcontact_no"  placeholder="Contact Number" >
							  <b class="tooltip tooltip-bottom-right">Enter the contact number</b>
						
					
					
		<footer>
			<button type="submit" class="button">Submit</button>
		</footer>
		
		
	
		</form>
		</div>
          <!-- Bootstrap core JavaScript-->
		  <script src="../styles/vendor/jquery/jquery.min.js"></script>
		  <script src="../styles/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
		
		  <!-- Core plugin JavaScript-->
		  <script src="../styles/vendor/jquery-easing/jquery.easing.min.js"></script>
		
		  <!-- Custom scripts for all pages-->
		  <script src="../styles/js/sb-admin-2.min.js"></script>
		
		  <!-- Page level plugins -->
		  <script src="../styles/vendor/chart.js/Chart.min.js"></script>
		
		  <!-- Page level custom scripts -->
		  <script src="../styles/js/demo/chart-area-demo.js"></script>
		  <script src="../styles/js/demo/chart-pie-demo.js"></script>
    </body>
</html>
