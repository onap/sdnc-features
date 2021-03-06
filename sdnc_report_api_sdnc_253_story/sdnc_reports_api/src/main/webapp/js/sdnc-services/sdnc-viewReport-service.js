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

myApp.service('viewReportService', ['$http', function($http) {
    this.getData = function(startDate, endDate, deviceName) {

        var data = {};
        if (startDate != null && endDate != null && deviceName != null) {

            data.startdate = startDate;
            data.enddate = endDate;
            data.devicename = deviceName;

        }
        var config = {
            params: '',
            headers: {
                'Accept': 'application/json'
            }
        };

        var sdate = new Date(startDate);
        var edate = new Date(endDate);
        
        var objTestList = {};
       // return $http.get('sdnc-stubs/getAllReports.json', config)
        return $http.get('/findReportByDeviceName/'+sdate+'/'+edate+'/'+deviceName,config)
            .then(function(result) {
                console.log("--viewReportService::getdata::Testresponse--", JSON.stringify(result));
                objTestList = result.data;
                console.log("--viewReportService::getdata::Testresponse--", +JSON.stringify(objTestList));
                return result;
            });

    };


    this.getAllDevices = function() {
        var deviceResponse = {};
        return $http.get('sdnc-stubs/getAllDevices.json')
            .then(function(response) {
                console.log("--getAlldevices" + JSON.stringify(response));
                deviceResponse = response.data;
                console.log("----viewReportService::getAlldevices::deviceResponse--" + JSON.stringify(deviceResponse));
                return deviceResponse;
            });

    };


    this.getAllTest = function() {
        var testlist = {};
        return $http.get('sdnc-stubs/getAllTest.json')
            .then(function(response) {
                console.log("---viewReportService::getAllTest::TestResponse---" + JSON.stringify(response));
                testlist = response.data;
                return testlist;
            });

    };
}]);