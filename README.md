# Anonnity
## 🌎프로젝트 소개
* 커뮤니티 애플리케이션을 위한 RESTful API 및 채팅 서버 개발

## 🚀주요 기능
* 회원 가입 및 로그인
* 회원 인증/인가 수행
* 회원이 게시글 작성/삭제 (수정 불가)
* 회원이 다른 회원의 게시글에 댓글 작성 (수정/삭제 불가)
* 회원이 다른 회원을 차단하기
  * 차단한 회원과 차단 당한 회원은 서로의 글, 댓글, 채팅 등을 볼 수 없음
* 회원이 다른 회원 차단 풀기
* 회원이 다른 회원과 1대1 채팅

## 📝깃 커밋 메시지 컨벤션
* Conventional Commits 적용
### 형식
```text
<emoji><type>(<scope>): <subject>

- <description 1>
- <description 2>
...
```
### 예시
```text
✨feat(auth): JWT 기반 사용자 로그인 및 인증/인가 기능 구현

- 로그인 API 엔드포인트 추가 "/auth/login"
- JWT 기반 액세스 토큰 생성/검증/파싱을 수행하는 JwtHandler 구현
- Roles Entity, MemberRoles Entity 생성
```
### 타입별 이모지
* ✨feat: 신규 기능 구현
* 🐛fix: 버그 수정
* 🔨refactor: 코드 개선
* 🚀perf: 성능 개선
* 🔧chore: 환경설정변경
* 📝docs: 문서 추가/수정/삭제
* ✅test: 테스트 코드 추가/수정/삭제