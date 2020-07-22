# 지뢰찾기

* 사각형은 가로 10줄, 세로 10줄
* 지뢰는 10개이며 랜덤
* 각 사각형에 표시될 숫자는, 자신을 제외한 주변 8개 사각형에 포함된 폭탄의 갯수
* 모든 사각형(100개)에 대한 숫자를 구해야함 (지뢰를 별도 flag로 표기 X)

## 개발 환경
* java 1.8
* Intellij 2020.1
* gradle 6.1.1

## 빌드 & 실행
1. `./gradlew clean build`
2. `java -jar build/libs/MineSweeper-1.0-SNAPSHOT.jar`