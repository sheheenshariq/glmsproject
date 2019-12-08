<!DOCTYPE html>
<%@page import="glms.dto.*" %>
<%@page import="glms.bl.*" %>
<%@page import="glms.dl.*" %>
<%@page import="java.util.*" %>
<html lang="en">

<head>

  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
  <script src='https://kit.fontawesome.com/a076d05399.js'></script>
  <meta name="description" content="">
  <meta name="author" content="">
  <meta name='viewport' content='width=device-width, initial-scale=1'>
<script src='https://kit.fontawesome.com/a076d05399.js'></script>


<title>Customer Table</title>

  <!-- Custom fonts for this template-->
  <link href="../styles/vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">
  <link href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i" rel="stylesheet">

  <!-- Custom styles for this template-->
  <link href="../styles/css/sb-admin-2.min.css" rel="stylesheet">

</head>
<%
if(session.getAttribute("user_name")==null)
{

   response.sendRedirect("../styles/Login.jsp");
}

%>
   

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

      <!-- Divider -->
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
          <span><h4>Gold Loan Management System</h4></span>
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

          <!-- Topbar Navbar
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
              <span style="float:right;margin-left:200px" class="mr-2 d-none d-lg-inline text-gray-600 small">ADMIN</span>
               <!-- <img class="img-profile rounded-circle" src="https://source.unsplash.com/QAB-WJcbgJk/60x60"> --!>
              </a>
              <!-- Dropdown - User Information -->
              <div class="dropdown-menu dropdown-menu-right shadow animated--grow-in" aria-labelledby="userDropdown">
               
                <div class="dropdown-divider"></div>
                <a class="dropdown-item" href="#" data-toggle="modal" data-target="#logoutModal">
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

         <div class="container-fluid">

          <!-- Page Heading -->
          <div class="d-sm-flex align-items-center justify-content-between mb-4">
            <h1 class="h3 mb-0 text-gray-800">Payment Details</h1>
            <div align="right">
            <a href="#" class="d-none d-sm-inline-block btn btn-sm btn-primary shadow-sm" onclick="javascript:window.print();">Generate Report</a>
         
      </div>
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
		 
 <%!
    
	 String accountNo;
	 String Emidate;
	 int PaymentNo=0;
	 PaymentDTO payment=null;
   
 %>
 <%
 
	 /*accountNo=request.getParameter("txtAccountNumber");
	 Emidate=request.getParameter("EMIdate");
	 PaymentNo=Integer.parseInt(request.getParameter("paymentNo"));
	 System.out.println("****acnt in process"+ accountNo);*/
	
	 String accountNo=(String)session.getAttribute("ACCOUNT_NUMBER");
	
		

     payment=PaymentBL.getPayment(accountNo);
     if(payment!=null)
     {
 
%>
<table width="80%"  align="center" class="table table-striped table-hover">
                <thead>
                    <tr>

                      
                        <th>Account Number</th>
                        <th>Emi Amount</th>
                        <th>Emi Date</th>   
                        <th>Payment Remaining</th>
                        <th>Repayment Amount</th>
                         <th>Status</th>                    
                        </tr>
                </thead>
          <tr>
          <td><%=payment.getAccountNo()%>&nbsp;</td>
	      <td><%=payment.getEmiAmount()%>&nbsp;</td>
	      <td><%=payment.getEmiDate()%>&nbsp;</td>
	      <td><%=payment.getPaymentRemaining()%>&nbsp;</td>
	      <td><%=payment.getRepaymentAmount()%>&nbsp;</td>
	      <td><%=payment.getStatus()%>&nbsp;</td>
         </tr>
          </tbody>
            </table>
 <%
  }
  else
  {
  %>
  <table width="100%" border="0">
     <tbody>
       <tr><td>There is no such record</td>
       </tr>
       </tbody>
       </table>
 
  <%
 
  }
  %>     
            
   <!-- Bootstrap core JavaScript-->
  <script src="../styles/vendor/jquery/jquery.min.js"></script>
  <script src="../styles/vendor/boo
  tstrap/js/bootstrap.bundle.min.js"></script>

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
