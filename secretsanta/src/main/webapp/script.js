/*        //        var a = "Hello"
 //        alert(a)
 //        a += 1
 //        alert(a)
 //        var b = false
 //        var qwe = null;
 //        alert(qwe)

 var sum = function (a, b) {
 return a + b;
 }

 var divide = function (a, b) {
 return a / b;
 }

 var printResult = function (func, a, b) {
 alert("Result: " + func(a, b))
 }

 //        printResult(sum, "2", "3")
 //        printResult(divide, "2", "3")

 var array = []
 for (var i = 0; i < 10; i++) {
 array[i] = i;
 }
 var str = ""
 for (var i = 0; i < 10; i++) {
 str += array[i]
 if (i != array.length - 1) {
 str += " - "
 }
 }

 //        alert(str);

 var person = {
 name: "Vasya",
 age: 19,
 greeting: function () {
 alert("Hello, my name is " + this.name)
 }
 }

 //        person.greeting();

 var person2 = {}
 person2.__proto__ = person;
 person2.name = "Petya";

 //        person2.greeting();

 var Person = function (name, age) {
 this.name = name;
 this.age = age;

 var getAge = function () {
 return  "I am " + age + " years old";
 };

 this.greeting = function () {
 alert("Hello, my name is " + this.name + ". " + getAge())
 };

 return this;
 }

 var p = new Person("Vasya", 20);
 p.greeting();*/

$("body").ready(function () {
//    var pHidden = false;
//    $("#btn").click(function () {
//        if (pHidden) {
//            $("#paragraph").show();
//            pHidden = false;
//        } else {
//            $("#paragraph").hide();
//            pHidden = true;
//        }
//    })

//    var obj = {
//        "name": "Vasya",
//        "age": 18
//    };
//
//    var jsonString = JSON.stringify(obj);
//    var pers = JSON.parse(jsonString)
//
//    $("#btn").click(function () {
//        alert(jsonString)
//        alert("Name: " + pers.name + ", age: " + pers.age)
//    })


//    var a ={
//        "Vasya": "Masha",
//        "Masha": "Petya",
//        "Petya": "Vasya"
//    }
//    alert (JSON.stringify(a))
    $("#menu > li > a").click(function () {
        var aText = this.text
        var page;
        if (aText === "Add group") {
            page = "addgroup.html"
        } else if (aText === "Add user") {
            page = "adduser.html"
        } else if (aText === "Add present") {
            page = "addpresent.html"
        } else {
            page = "pairs.json"
        }

        $.get(page, function (data) {
            if (page.contains(".html")) {
                $("#main").html(data);
                $("#saveGroup").click(function (e) {
                    e.preventDefault();
                    $.post("/api/addgroup", {group: $("#group").val()}, function (msg) {
                        alert(msg);
                        $("#main").html("");
                    });
                });
            } else if (page.contains(".json")) {
                var str = ""
                for (var key in data) {
                    if (data.hasOwnProperty(key)) {
                        str += "<li>" + key + " make present for " + data[key] + "</li>"
                    }
                }
                $("#main").html("<ol>" + str + "</ol>")
            }
        })
    })

});