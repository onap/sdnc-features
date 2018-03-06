/*
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

myApp.controller('TestController', ['$scope', '$http', 'growl', 'viewReportService', 'validationTestService', function($scope, $http, growl, viewReportService, validationTestService) {

    $scope.showTestReport = false;

    //Input data for validation test dropdwon
    var validationTestList = [{
            "typeId": 1,
            "validationType": "Network Layer",
            "Selected": false
        },
        {
            "typeId": 2,
            "validationType": "Protocol Layer",
            "Selected": false
        }
    ];

    $scope.validationTestList = validationTestList;


    $scope.getselectval = function() {
        $scope.selectedvalues = 'Name: ' + $scope.selitem.validationType + ' Id: ' + $scope.selitem.typeId;
    }

    $scope.showError = false;
    $scope.errorMessage = "";
    $scope.showSuccess = false;
    $scope.successMessage = "";
    $scope.showWarning = false;
    $scope.warningMessage = "";
    $scope.showInfo = false;
    $scope.infoMessage = "";
    $scope.ShowResult = false;
    $scope.allowTestSelection = false;
    $scope.hostNamePattern = /([a-z0-9](.[a-z0-9-]*[a-z0-9]))/;


    //service call to fetch the all the test name
    $scope.getAllVNF = function() {

        validationTestService.getAllVNF().then(function(data) {
            if (data != null) {
                console.log(data);
                $scope.objvnfList = data.vnfList;
                console.log("--TestController:getAllVNF called--" + $scope.objvnfList);
                $scope.allowTestSelection = true;
            } else {
                $scope.showWarninf = true;
                $scope.warningMessage = "No VNF is eligible for confirgruation!!!";
                growl.error($scope.warningMessage, {
                    title: 'Warning!'
                });
            }
        });
    };
    $scope.getAllVNF();

    //Called when user selects a test type
    $scope.updateSelection = function(position, items, valType) {
        angular.forEach(items, function(val, index) {
            if (position != index)
                val.checked = false;
            $scope.selectedTest = valType;
            console.log("--TestController::updateSelection--", $scope.selectedTest);
        });

        if ($scope.IPAddress != null && $scope.HostName != null && valType != null) {
            $scope.showError = false;
        }
    }


    //Called when user clicks on runtest
    $scope.runTest = function() {

        $scope.showError = false;
        $scope.vnfSelected = [];
        $scope.testSelected = [];

        var message = "";
        for (var i = 0; i < $scope.validationTestList.length; i++) {
            if ($scope.validationTestList[i].Selected) {
                var typeId = $scope.validationTestList[i].typeId;
                var validationType = $scope.validationTestList[i].validationType;
                message += "typeId: " + typeId + " validationType: " + validationType + "\n";
                console.log("--TestController::Runtest--", message);
                var testDetails = {};
                testDetails.typeId = typeId;
                testDetails.validationType = validationType;
                $scope.testSelected.push(testDetails);
            }
        }
        console.log("--TestController::Runtest--", JSON.stringify($scope.testSelected));

        var vnfDetails = {};
        if ($scope.IPAddress != null && $scope.HostName != null && $scope.testSelected.length >= 1) {
            vnfDetails.ipAddress = $scope.IPAddress;
            vnfDetails.hostName = $scope.HostName;
            $scope.vnfSelected.push(vnfDetails);
            console.log("--TestController::Runtest--", JSON.stringify($scope.vnfSelected));

            //Call the validation test service with json file and testType as the parameter

            validationTestService.runPretest($scope.vnfSelected, $scope.testSelected).then(function(response) {
                    console.log("--TestController::runTest--", JSON.stringify(response));
                    //in case of success, build the model object to store the service output here
                    if (response.status === 200) {
                        if (response.preTestResponse != null && response.preTestResponse.length >= 1) {
                            $scope.ShowResult = true;
                            $scope.createTestModel(response.preTestResponse);
                            $scope.showMessage(response.preTestResponse);
                         
                        } else {
                            console.log(response);
                            $scope.showError = true;
                            $scope.errorMessage = "Something went wrong!!!";
                            growl.error($scope.errorMessage, {
                                title: 'Error!'
                            });
                        }
                    } else {
                        console.log(response);
                        $scope.showError = true;
                        $scope.errorMessage = "Pre test validation failed!!! Check the report for more details";
                        growl.error($scope.errorMessage, {
                            title: 'Error!'
                        });
                    }
                },
                function(response) {
                    console.log("--TestController--", response);
                });
        } else {
            $scope.showError = true;
            $scope.errorMessage = "Please provide the inputs for VNF and test to be performed!!";
            growl.error($scope.errorMessage, {
                title: 'Error!'
            });
        }

    };
    
    $scope.showMessage=function(data){
    	
    	if(angular.isDefined(data) && data.length>=1){
    		
    		 angular.forEach(data, function(value, key){
    	         if(value.status == "unreachable"){
    	           console.log("--TestController::showMessage--",value.status);
    	           $scope.showError = true;
                   $scope.errorMessage = "PreTest validation Failed, Please check logs for further details!!!";
                   growl.error($scope.errorMessage, {
                     title: 'Error!'
                   });
                 }
    	         else
    	        	 {
    	        	  $scope.showSuccess = true;
                      $scope.successMessage = "Pre test validation completed!!";
                      growl.success($scope.successMessage, {
                          title: 'Success!'
                      });
    	        	 }
    	         
    		 });
    		
    	}   	
    }

    //Function to build the UI model to be shown
    $scope.createTestModel = function(result) {

        $scope.showError = false;
        $scope.showWarning = false;
        $scope.objPreTestModel = result;
        $scope.objPreTest = [];


        if ($scope.objPreTestModel.length > 1) {
            for (var i = 0; i < $scope.objPreTestModel.length; i++) {
                var objTestReport = {};
                objTestReport.ipaddress = $scope.objPreTestModel[i].ipaddress;
                objTestReport.status = $scope.objPreTestModel[i].status;
                objTestReport.testtype = $scope.objPreTestModel[i].testtype;
                objTestReport.statistics = $scope.objPreTestModel[i].statistics;
                objTestReport.avgTime = $scope.objPreTestModel[i].avgTime;


                if ($scope.objPreTestModel[i].testtype === "Network Layer") {
                    if (objTestReport.statistics != null) {
                        //fetching the statistics to show in progress bar
                        var statistics = objTestReport.statistics;
                        statistics = statistics.split("%");
                        objTestReport.statistics = statistics[0];
                        if (objTestReport.statistics == 0) {
                            objTestReport.statisticPer = parseInt(objTestReport.statistics) + 50;
                        } else
                            objTestReport.statisticPer = objTestReport.statistics;
                    }

                    //fetching the avg time to show in progress bar
                    if (objTestReport.avgTime != null) {
                        var avgTime = objTestReport.avgTime;
                        avgTime = avgTime.split("=");
                        var Testtime = avgTime[1];
                        objTestReport.avgTime = Testtime.slice(0, -2).trim();
                        console.log("--TestController::createTestModel--", objTestReport.avgTime);
                        if (objTestReport.avgTime < 50) {
                            objTestReport.avgTimePer = parseInt(objTestReport.avgTime) + 10;
                        } else
                            objTestReport.avgTimePer = objTestReport.avgTime;

                    }
                }
                $scope.objPreTest.push(objTestReport);
                console.log("--TestController::createTestModel--", JSON.stringify($scope.objPreTest));
            }
        }
       console.log("--TestController::createTestModel::final PreTestModel--" + JSON.stringify($scope.objPreTest));

    }

}]);