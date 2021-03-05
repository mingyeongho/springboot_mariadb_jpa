# springboot_mariadb_jpa
springboot_mariadb_jpa로 게시판 만들기

# @RestController와 @Controller의 차이
* 전통적인 Spring MVC의 컨트롤러인 @Controller는 주로 View를 반환하기 위해 사용한다.
* 하지만, Spring MVC의 컨트롤러에서도 Data를 반환해야 하는 경우가 존재한다.
* 이 경우, @ResponseBody를 사용해주어 Json 형태로 데이터를 반환할 수 있었다.
* @RestController는 @Controller와 @ResponseBody를 합한 것으로 주 용도는 Json형태로 객체 데이터를 반환하는 것이다.
* 여기서 Json이란 key와 value 쌍으로 이루어진 데이터를 말한다.
