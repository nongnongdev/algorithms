# algorithms (Java)

알고리즘 공부를 위한 저장소입니다.  
**Do it! 알고리즘 코딩 테스트 — 자바편(김종관)**을 기본 진도로 삼고, 추가 복습 코드도 함께 커밋합니다.

## 구조 규칙 (src 기준)
- Depth 1: **문제 사이트** (예: `boj`, `programmers` …)
- Depth 2: **문제 번호(문제명)** (예: `p1920`)
- 각 패키지에는 **Main.java** 하나를 둡니다.
  - 예시: `src/main/java/boj/p1920/Main.java`
  - 제출 시에는 **최상단 `package` 한 줄만 제거**하고 클래스명 `Main`은 유지합니다.

```text
src/
└─ main/
   └─ java/
      └─ boj/
         ├─ p1920/
         │  └─ Main.java
         └─ p07576/
            └─ Main.java
