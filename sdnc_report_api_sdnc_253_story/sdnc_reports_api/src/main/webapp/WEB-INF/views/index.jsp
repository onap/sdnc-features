<!-- /*
* ============LICENSE_START=======================================================
* ONAP : SDNC-FEATURES
* ================================================================================
* Copyright 2018 TechMahindra
*=================================================================================
* Licensed under the Apache License, Version 2.0 (the "License");
* you may not use this file except in compliance with the License.
* You may obtain a copy of the License at
*
*     http://www.apache.org/licenses/LICENSE-2.0
*
* Unless required by applicable law or agreed to in writing, software
* distributed under the License is distributed on an "AS IS" BASIS,
* WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
* See the License for the specific language governing permissions and
* limitations under the License.
* ============LICENSE_END=========================================================
*/
 -->
<!-- index.html -->
<!DOCTYPE html>
<html ng-app="myApp">
   <head>
      <meta charset="utf-8">
      <!-- CSS -->
      <script src="./node_modules/jquery.min.js"></script>
      <script src="./node_modules/tether.min.js" ></script>
      <link rel="stylesheet" href="./node_modules/bootstrap-3.3.7/dist/css/bootstrap.min.css">
      <script src="./node_modules/bootstrap-3.3.7/dist/js/bootstrap.min.js"></script>
      <link rel="stylesheet" href="/style/sdnc-style.css">
      <!-- JS -->
      <!-- load angular,date-time picker,pagination,growl and ui-router -->
       <script src = "./node_modules/angular.min.js"></script>
   	  <script src = "./node_modules/angular-route.min.js"></script>
      <script src="./node_modules/angular-utils-pagination/dirPagination.js"></script>
      <script src="./node_modules/ng-csv/build/ng-csv.min.js"></script>     
     <script src="./node_modules/angular-sanitize.min.js"></script>
      <link rel="stylesheet" href="./node_modules/angularjs-datetime-picker/angularjs-datetime-picker.css" />
      <script src="./node_modules/angularjs-datetime-picker/angularjs-datetime-picker.js"></script>
      <script data-require="jquery@*" data-semver="2.1.4" src="https://code.jquery.com/jquery-2.1.4.js"></script>
      <script src="./node_modules/angular-utils-pagination/dirPagination.js"></script>
      <script src="./js/app.js"></script>
     <script src="./js/sdnc-controller/sdnc-viewreport-controller.js"></script>
      <script src="./js/sdnc-controller/sdnc-validationTest-controller.js"></script>
      <script src="./js/sdnc-services/sdnc-viewReport-service.js"></script>
      <script src="./js/sdnc-services/sdnc-validationTest-service.js"></script>
      <script src="./node_modules/angular-growl.min.js" ></script>
        <script src="./node_modules/ng-ip-address/ngIpAddress.min.js" ></script>
       
      <link rel="stylesheet" type="text/css" href="./node_modules/angular-growl.min.css">
      <link rel="stylesheet" href="/style/w3.css">
   </head>
   <!-- apply our angular app -->
   <body>
      <div class="container">
         <nav role="navigation" class="navbar navbar-default">
         <div class="navbar-header" style="background-color:#DCDCDC;font-size: 15px;font-weight: bold;">
            <ul class="nav navbar-nav">
            <li ng-class='active'><a href="#testValidation">CERTIFICATION TEST</a></li>
            <li><a href="#testReports">VIEW ALL REPORTS</a></li>
            <ul>
         </div>
         <nav>
         <!-- views will be injected here -->
         <div ng-view></div>
      </div>
   </body>
</html>