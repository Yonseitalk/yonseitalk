# Yonsei Talk

## Backend

AWS로 배포된 서비스 링크입니다.

[연세톡 링크](http://ec2-3-15-24-68.us-east-2.compute.amazonaws.com:3000/)

### Maria DB 로컬 실행 (도커 사용 시)
Spring 어플리케이션을 실행하기 위해서는 DB가 실행중이어야 한다. Maria DB는 도커를 사용해서 다음과 같이 실행시킬 수 있다.

```bash
$ docker pull mariadb
# MariaDB 이미지 가져오기

$ docker container run -d -p 3306:3306 	\
-e MYSQL_ROOT_PASSWORD=secret 		\
-v <DB 폴더 위치>:/var/lib/mysql 	\
--name mariadb mariadb
# MariaDB 컨테이너 만들고 실행하기
# 자동으로 username "root", password "secret"인 계정 생성
```

