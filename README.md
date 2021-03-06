# springboot_mariadb_jpa
springboot_mariadb_jpa로 게시판 만들기

# @RestController와 @Controller의 차이
* 전통적인 Spring MVC의 컨트롤러인 @Controller는 주로 View를 반환하기 위해 사용한다.
* 하지만, Spring MVC의 컨트롤러에서도 Data를 반환해야 하는 경우가 존재한다.
* 이 경우, @ResponseBody를 사용해주어 Json 형태로 데이터를 반환할 수 있었다.
* @RestController는 @Controller와 @ResponseBody를 합한 것으로 주 용도는 Json형태로 객체 데이터를 반환하는 것이다.
* 여기서 Json이란 key와 value 쌍으로 이루어진 데이터를 말한다.

# 20210305 문제점
- view의 form 태그에서 post방식으로 data를 받았는데 controller에서 확인을 해보면 DB에 null값이 들어가있음.
- RestController 등 여러 방식을 해보았지만 실패함.
- PostMapping에서 syso(requestDto.getAuthor())를 해봤는데 null이 나온 것으로 보아 requestDto가 잘못된 거 같음.
- requestDto 클래스를 보면 별 문제 없어보임...
-> 타임리프에서 data access하는 게 문제임. 근데 아무리 바꿔도 해결할 수가 없어서 httpServletRequest를 사용해서 데이터를 일일이 build해줌
