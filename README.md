# Simple Blog

Spring Boot로 만든 간단한 블로그 입니다. 
<img src="/docs/blogMain.gif" width="500">
<br></br>


## 운영 환경
<pre>
- Spring Boot      v2.6.1
- MySQL        v8.0.27
- Thymeleaf      v3.0.12
</pre>
<br></br>

## 필요 설정
application.properties - MySQL url, 계정 설정
<br></br>

## 기능
1. 메인 페이지 (글 목록)
2. 글 작성, 수정, 삭제
3. 댓글 작성
4. +) 글 paging 
<br></br>

## API

|           기능            |               URL               | 메소드 | 요청값 |
| :-----------------------: | :-----------------------------: | :----: | :----: |
|         메인 페이지         |          /                       |  GET   |  params |
|         글 작성 페이지       |         /write                   |  GET   | X |
|         글 작성하기         |         /write                   |  POST  |  body  |
|         글 수정 페이지       |        /edit/{postId}            |  GET   |  X  |
|         글 수정하기         |        /edit/{postId}            |  POST  |   body    |
|         글 상세보기         |          /posts/{postId}         |  GET   |  X  |
|         글 삭제하기         |        /posts/{postId}           |  DELETE|  X  |
|         댓글 작성하기        |          /{postId}/comment       |  POST  |   body    |
