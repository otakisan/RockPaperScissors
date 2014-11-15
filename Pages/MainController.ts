module Main {

    export class Value {
        Text: string;
    }

    export interface Scope {
        value: Value;
        newText: string;
        setValue: Function;
    }

    export class Controller {
        private httpService: any;
        constructor($scope: Scope, $http: any) {
            this.httpService = $http;
            var controller = this;
            $scope.setValue = function () {
                var value = new Main.Value();
                value.Text = $scope.newText;
                controller.postValue(value, function (data) {
                    controller.getValue(function (data) {
                        $scope.newText = "";
                        $scope.value = data;
                    });
                });
            }
        }

        getValue(successCallback: Function) {
            this.httpService.get("/api/values").success(function (data, status) {
                successCallback(data);
            });
        }

        postValue(value: Value, successCallback: Function) {
            this.httpService.post("/api/values", value).success(function (data, status) {
                successCallback(data);
            });
        }
    }
}

// Angular JS 1.3より下記の処理が必要
angular.module("MyAngularJs", []).controller("Controller", ["$scope", "$http", Main.Controller]);