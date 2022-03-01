# 생성자와 new

---

### 객체

객체의 종류

- 내장 객체
    - String, Date, Array, Math ..
- 브라우저 객체모델(BOM)
    - window, screen, location, history, navigator ..
- 문서 객체모델(DOM)
- 사용자 정의 객체

객체는 서로 연관된 변수와 함수를 그룹핑한 그릇

객체의 구조를 재활용하기 위해 객체를 생성하는 것 ⇒ 객체 생성자 함수

<br>
<br>

### 객체를 재사용하기 위한 객체 생성자 함수

- new 키워드
    - 사용자 정의 객체 타입, 내장 객체 타입의 인스턴스를 생성

```jsx

// 내장 객체 생성
var 참조 변수 = new 생성 함수()

// 사용자 정의 객체 생성
function 함수명(매개변수1, 매개변수2 .. ){ // 객체 생성자 함수의 함수명은 대문자로 시작
	this.속성명 = 값;
	this.함수명 = function(){
		자바스크립트 코드;
	}
}

var 참조 변수 = new 함수명();

```

<br>
<br>

### 예시

```jsx
// 내장 객체
// 1
var arr = new Array();
arr[0] = 0;
arr[1] = 1;
arr[2] = 2;

// 2
var arr = new Array(0,1,2);

// 3
var arr = [0,1,2];
```

```jsx
// 사용자 정의 객체

function Info(name, age){
	this.name = name;
	this.age = age;
	this.printInfo = function(){
		console.log(this.name + " " + this.age);
	}
}

var jung = Info("jung", 26);
var kim = Info("kim", 25);

jung.printInfo();
kim.printInfo();
```

<br>
<br>

### Quiz

위의 내장 객체와 사용자 정의 객체의 생성자 함수 메모리 값, 접근 속도, 연산 속도, 기능 등이 같다 가정할 때  어느 것을 사용하는 것이 유리할 까? 이유?

- 답
    
    내장 객체가 유리 
    
    위의 사용자 정의 객체 생성자 함수는 인스턴스를 생성할 때 마다 내부의 메서드까지 생성하기 때문에 메모리가 낭비됨
    
    따라서 prototype 프로퍼티를 사용하여 원형 객체 생성자 함수에 내부 메서드를 “등록” 하면 생성된 객체에서 이를 사용할 수 있음
    
    내장 객체의 모든 생성자 함수는 prototype 프로퍼티를 사용한다
    
    [Object.prototype]
    
    ```jsx
    function Info(name, age){
    	this.name = name;
    	this.age = age;
    }
    
    Info.prototype.printInfo = function(){
    	console.log(this.name + " " + this.age);
    }
    
    var jung = Info("jung", 26);
    var kim = Info("kim", 25);
    
    jung.printInfo();
    kim.printInfo();
    ```
    

### 참고자료

[https://ko.javascript.info/native-prototypes](https://ko.javascript.info/native-prototypes)

[https://developer.mozilla.org/ko/docs/Learn/JavaScript/Objects/Basics](https://developer.mozilla.org/ko/docs/Learn/JavaScript/Objects/Basics)

[https://lts0606.tistory.com/448](https://lts0606.tistory.com/448)

[https://opentutorials.org/course/743/6570](https://opentutorials.org/course/743/6570)
